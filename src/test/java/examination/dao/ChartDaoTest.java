package examination.dao;

import examination.ExaminationApplication;
import examination.entity.ChoiceQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class ChartDaoTest {
    @Autowired
    ChoiceDao choiceDao;

    @Test
    public void getCount() throws Exception {
        System.out.println(choiceDao.getCount());
    }

    @Test
    public void getChoiceQuestion() throws Exception {
        List<ChoiceQuestion> choiceQuestions = choiceDao.getChoiceQuestion(0,5);

        choiceQuestions.forEach(System.out::println);
    }
}