package examination.service;

import examination.ExaminationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class PaperServiceTest {
    @Autowired
    PaperService paperService;
    @Test
    public void getChoiceQuestion() throws Exception {
        System.out.println(paperService.getChoiceQuestion());
    }

    @Test
    public void getJudgeQuestion() throws Exception {
        System.out.println(paperService.getJudgeQuestion());
    }

    @Test
    public void getSubjectQuestion() throws Exception {
        System.out.println(paperService.getSubjectQuestion());
    }

}