package examination.service;

import examination.dao.EvaluateDao;
import examination.dao.ExamDao;
import examination.dao.QuestionDao;
import examination.entity.Paper;
import examination.entity.Question.Evadba;
import examination.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class EvaluatingService {

    @Autowired
    EvaluateDao evaluateDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    CompareSQLService compareSQLService;


    public void EvaluateSQL (Long uid, Long eid,String sql2){
        System.out.println("执行评测服务");

        Status status = new Status();
        status.setUid(uid);
        status.setEid(eid);
        status.setSql2(sql2);
        evaluateDao.submit(status);

        Evadba evadba = questionDao.findEvadbaById_Ans(eid);
        String sql1 = evadba.getRightanswer();
        String type = evadba.getType();
        String[] tables = evadba.getIntable().split(",");
        String result ;

        System.out.println(type);
        try{
            Boolean bool;
            if (type.equals("查找题")){
                bool = compareSQLService.compareRS(sql1,sql2);
            }else{
                bool = compareSQLService.compareChange(tables,sql1,sql2);
            }
            result = bool ? "答案正确，你真棒！": "答案错误，你真笨!";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = "SQL语句出错："+e.getMessage();
        }
        status.setStatus(result);
        evaluateDao.update(status);
    }

    public List<Map> get_Status(long off, long n){
        return evaluateDao.getList(off, n);
    }
}
