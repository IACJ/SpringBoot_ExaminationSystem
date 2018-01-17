package examination.dao;

import examination.ExaminationApplication;
import examination.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Test
    public void findByLogin() throws Exception {
        Student student = studentDao.findByLogin("201536550000", "0000");
        System.out.println(student);
    }

    @Test
    public void add() throws Exception {
        Student student=new Student("233","233","男","1");
        System.out.println(studentDao.add(student));
    }

    @Test
    public void findById() throws Exception {
        Student student = studentDao.findById(2);
        System.out.println(student);
    }

    @Test
    public void update() throws Exception {
        Student student = studentDao.findById(10);
        student.setName("大吉大利");
        studentDao.update(student);
    }

    @Test
    public void addByList() throws Exception {
        Student student=new Student("1","1","1","1");
        Student student2=new Student("w","w","w","1");
        List<Student> students=new ArrayList<Student>();
        students.add(student);
        students.add(student2);
        System.out.println(studentDao.addByList(students));
    }

    @Test
    public void queryAll() throws Exception {
        List<Student> student = studentDao.queryAll();
        student.forEach(System.out::println);
    }

    @Test
    public void md5_123456() throws Exception {
        Student student = studentDao.findById(5);
        System.out.println(student);
    }
}