package examination.dao;

import examination.ExaminationApplication;
import examination.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Student student=new Student();
        student.setName("233");
        student.setAccount("233");
        student.setSex("男");
        student.setClassid("1");
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

}