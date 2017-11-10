package examination.dao;

import examination.ExaminationApplication;
import examination.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void find() throws Exception {
        User user=userDao.find("root","root");
        System.out.println(user);
    }

}