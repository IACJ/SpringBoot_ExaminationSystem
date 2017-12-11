package examination.dao;

import examination.ExaminationApplication;
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
    ChartDao chartDao;

    @Test
    public void getPaperName() throws Exception {
        List<String> paperName = chartDao.getPaperName(2);

        paperName.forEach(System.out::println);

    }

    @Test
    public void getScore() throws Exception {
        List<Byte> score = chartDao.getScore(2);

        score.forEach(System.out::println);
    }
}