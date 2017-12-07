package examination.service;

import examination.ExaminationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class ChartServiceTest {
    @Autowired
    ChartService chartService;

    @Test
    public void studentGetChart() throws Exception {
        List<String> name = Arrays.asList("第一章", "第二章", "第三章", "第四章", "第五章", "第六章");
        List<String> name1 = new ArrayList<>();

        //List<Integer> data = Arrays.asList(80, 90, 80, 90, 80, 90);
//        name.forEach(item -> {
//            name1.add(String.join("\n", item.split("")));
//        });
        name1.forEach(System.out::println);System.out.println(chartService.studentGetChart(2));
    }

}