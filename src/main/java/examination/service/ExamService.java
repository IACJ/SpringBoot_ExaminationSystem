package examination.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import examination.dao.ExamDao;
import examination.dao.QuestionDao;
import examination.dao.StudentDao;
import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import examination.entity.Record;
import examination.entity.Status;
import examination.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamService {
    @Autowired
    ExamDao examDao;
    @Autowired
    StudentDao studentDao;


    public Paper getPaperById (Long id){
        return examDao.findPaperById(id);
    }

    public String submitPapre (Long sid, Long pid,String record){

        System.out.println("执行交卷服务");
        Record r = new Record();
        r.setSid(sid);
        r.setPid(pid);
        r.setRecord(record);
        try{
            examDao.submit(r);
            return "提交成功。\n请携带随身物品离开考场。";
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "请勿重复提交试卷。\n以第一次提交为准。";
        }

    }

    public List<Map> listPaperBySid(long  sid){

        Student student = studentDao.findById(sid);
        long classid = Long.parseLong(student.getClassid());
        return examDao.listPaperByClass(classid);
    }

    public  List<Map> listGradeBySid(long sid){
        return examDao.listGradeBySid(sid);
    }

}
