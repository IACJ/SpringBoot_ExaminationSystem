package examination.dao;

import examination.ExaminationApplication;
import examination.entity.Admin;
import examination.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class AdminDaoTest {
    @Autowired
    AdminDao adminDao;
    @Test
    public void findByLogin() throws Exception {
        Admin admin = adminDao.findByLogin("201536550000","0000");
        System.out.println(admin);
    }

}