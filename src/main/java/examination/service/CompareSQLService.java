package examination.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.sql.*;

import static java.sql.Connection.TRANSACTION_READ_COMMITTED;
import static java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;


/**
 * 功能1： 判断两个 查询语句 是否返回相等的结果集。
 * 步骤：        比较结果集行数、列数，然后再逐行逐字段进行对比。若完全相同则返回 True
 *
 * 功能2： 判断两个 增删改 语句是否效果相同。
 * 步骤：       先把涉及到的表复制两份，分别后缀名为_test1、_test2
 *              将两个 增删改 语句中涉及到的表名全部加上后缀_test1、_test2
 *              执行两个 增删改 语句
 *              对比每一对_test1、_test2表 （利用功能1），若全部相同则返回 True
 *
 *  Future Works：  由于本程序接收两条sql语句并执行的过程中没有防止SQL注入，则数据库有可能被用户破坏。
 *                  接下来要做的是创建一个权限较低的用户，使其不能查询练习题以外的表，且只能修改临时生成的test表。
 *
 */
@Service
public class CompareSQLService {


    private void showTransactionIsolation(Connection conn) throws SQLException {

        int level = conn.getTransactionIsolation();
        if(level == Connection.TRANSACTION_NONE)
            System.out.println("TRANSACTION_NONE");
        else if(level == TRANSACTION_READ_UNCOMMITTED)
            System.out.println("TRANSACTION_READ_UNCOMMITTED");
        else if(level == TRANSACTION_READ_COMMITTED)
            System.out.println("TRANSACTION_READ_COMMITTED");
        else if(level == Connection.TRANSACTION_REPEATABLE_READ)
            System.out.println("TRANSACTION_REPEATABLE_READ");
        else if(level == Connection.TRANSACTION_SERIALIZABLE)
            System.out.println("TRANSACTION_SERIALIZABLE");
    }

    protected Connection GetConnection(String DBName)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn ;
            final String DB_URL = "jdbc:mysql://localhost:3306/"+DBName+"?useUnicode=true&characterEncoding=UTF-8";
            final String USER = "root";
            final String PASS = "";
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);  //将自动提交设置为false
            System.out.print("获得一个conn :");
            System.out.println(DBName);
            showTransactionIsolation(conn);

            return conn;
        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized boolean compareRS(String sql1, String sql2) throws SQLException{

        Connection conn1 = GetConnection("dbtest1");
        Connection conn2 = GetConnection("dbtest2");

        try {
            Boolean result = compareRS(sql1, sql2, conn1, conn2);
            conn1.rollback();
            conn2.rollback();
            conn1.close();
            conn2.close();
            System.out.println("关闭两个connn");
            return result;
        }catch (SQLException e ){
            System.out.println(e.getMessage());
            System.out.println("关闭两个connn");
            conn1.rollback();
            conn2.rollback();
            conn1.close();
            conn2.close();
            throw e;
        }

    }


    private synchronized boolean compareRS(String sql1, String sql2,Connection conn1, Connection conn2) throws SQLException {


        Statement statement1 = conn1.createStatement();
        Statement statement2 = conn2.createStatement();
        System.out.println(sql1);
        System.out.println(sql2);
        ResultSet rs1 = statement1.executeQuery(sql1);
        ResultSet rs2 = statement2.executeQuery(sql2);

        final ResultSetMetaData metaData1 = rs1.getMetaData();
        final ResultSetMetaData metaData2 = rs2.getMetaData();

        int columnCount = metaData1.getColumnCount();
        System.out.println(metaData1.getColumnCount());
        System.out.println(metaData2.getColumnCount());
        if (metaData1.getColumnCount() != metaData2.getColumnCount() ) {
            System.out.println("列数不等");
            return false;
        }


        rs1.last();
        rs2.last();
        System.out.println(rs1.getRow());
        System.out.println(rs2.getRow());
        if (rs1.getRow() != rs2.getRow()) {
            System.out.println("记录数目不等");
            return false;
        }


        rs1.first();
        rs2.first();
        while (rs1.next() && rs2.next()) {
            for (int i = 1; i <= columnCount; i++) {

                if(rs1.getString(i)==null && rs1.getString(i)==null){
                    continue;
                }else if (rs1.getString(i)==null && rs1.getString(i)!=null){
                    System.out.println("值不相等");
                    return false;
                }else if ( !rs1.getString(i) .equals(rs2.getString(i)) ){
                    System.out.println("值不相等");
                    return false;
                }
            }
        }
        rs1.close();
        rs2.close();
        System.out.println("相等");
        return true;
    }
    public synchronized boolean compareChange(String[]tables,String sql1, String sql2) throws SQLException {
        sql1 = sql1.toLowerCase();
        sql2 = sql2.toLowerCase();

        Connection conn1 = this.GetConnection("dbtest1");
        Connection conn2 = this.GetConnection("dbtest2");


        try{
            Statement statement1 = conn1.createStatement();
            Statement statement2 = conn2.createStatement();



            statement1.execute(sql1);
            System.out.println(sql1);

            statement2.execute(sql2);
            System.out.println(sql2);

            for (String i:tables) {
                String test_sql1 = "SELECT * FROM " + i ;
                String test_sql2 = "SELECT * FROM " + i ;
                if (!compareRS(test_sql1,test_sql2,conn1,conn2)){
                    System.out.println("更改语句不相等");
                    conn1.rollback();
                    conn2.rollback();
                    conn1.close();
                    conn2.close();
                    System.out.println("关闭两个conn");

                    return false;
                }
            }
            System.out.println("更改语句相等");
            conn1.rollback();
            conn2.rollback();
            conn1.close();
            conn2.close();
            System.out.println("关闭两个conn");
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            conn1.rollback();
            conn2.rollback();
            System.out.println("关闭两个conn");
            conn1.close();
            conn2.close();
            System.out.println(e.getMessage());
            throw e;

        }

    }
    public static void main(String[] args) {
        String sql1;
        String sql2;
        sql1 =  "SELECT DISTINCT SNAME FROM students,Courses,SC\n" +
                "WHERE students.SNO = SC.SNO AND Courses.CNO = SC.CNO\n" +
                "AND GRADE >= 90";
        sql2 =  "SELECT DISTINCT SNAME FROM students,Courses,SC\n" +
                "WHERE   Courses.CNO = SC.CNO AND students.SNO = SC.SNO\n" +
                "AND GRADE = 90";
//        sql1 = "SELECT SNAME FROM `students` WHERE 1";
//        sql2 = "SELECT SNAME FROM `students` WHERE 1"

//        sql1 = "DELETE  FROM SC WHERE 1";
//        sql2 = "DELETE  FROM SC WHERE 0";

//        sql1 = "DELETE SC,Students FROM SC JOIN Students ON SC.SNO = Students.SNO\n" +
//                "WHERE SC.SNO LIKE '20153031%';";
//        sql2 = "delete sc,students from sc join students on sc.sno = students.sno\n" +
//                "where sc.sno like '20153031%'";

        sql1 = "DELETE FROM SC WHERE 1";
        sql2 = "DELETE FROM SC WHERE 1";


        try {
//            new CompareSQLService().compareRS(sql1,sql2);
            CompareSQLService compareSQLService = new CompareSQLService();
            compareSQLService.compareChange(new String[]{"students","sc"},sql1,sql2);
            compareSQLService.compareChange(new String[]{"students","sc"},sql1,sql2);
            compareSQLService.compareChange(new String[]{"students","sc"},sql1,sql2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
