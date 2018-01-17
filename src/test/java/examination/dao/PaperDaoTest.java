package examination.dao;

import examination.ExaminationApplication;
import examination.entity.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class PaperDaoTest {
    @Autowired
    PaperDao paperDao;

    @Test
    public void add() throws Exception {



    }

}