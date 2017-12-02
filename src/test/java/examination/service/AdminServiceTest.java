package examination.service;

import examination.ExaminationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExaminationApplication.class)
public class AdminServiceTest {

    @Autowired
    AdminService service;

    @Test
    public void addStudentByExcel() throws Exception {
        service.addStudentByExcel(new FileInputStream("src/main/resources/templates/excel/student_template.xlsx"));
    }

    @Test
    public void addTeacherByExcel() throws Exception {
        service.addTeacherByExcel(new FileInputStream("src/main/resources/templates/excel/teacher_template.xlsx"));
    }
}