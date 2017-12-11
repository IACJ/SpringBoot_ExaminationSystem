package examination.service;

import examination.dao.ExamDao;
import examination.dao.QuestionDao;
import examination.dao.StudentDao;
import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
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

    public void submitPapre (Long uid, Long eid,String ans){
        System.out.println("执行交卷服务");
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
