package examination.dao;

import examination.ExaminationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class ClassDaoTest {

    @Autowired
    ClassDao classDao;

    @Test
    public void getIdByName() throws Exception {
        System.out.println(classDao.getIdByName("15网工"));
    }

    @Test
    public void getNameById() throws Exception {
        String s="3,3,3,3";
        String s1="";
        for (int i = 0; i < s.split(",").length; i++) {
            s1+="4,";
        }
        System.out.println(s1.substring(0,s1.length()-1));
    }
}