package examination.service;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

@Service
public class ExamService {
    @Autowired
    ExamDao examDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    QuestionDao questionDao;


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

    public Boolean  paperTested (long sid, long pid){
        long result = examDao.paperTested(sid,pid);
        if (result == 0){
            return false;
        }else{
            return true;
        }
    }

    public String teacher_calc_grade(long sid, long pid, long ans) {
        Record r = examDao.getRecordBySidPid(sid,pid);
        Paper p = examDao.findPaperById(pid);



        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonObject json=(JsonObject) parse.parse(r.getRecord());  //创建jsonObject对象

            String[] chos = p.getChoi().split(",");
            String[] score = p.getChoiscore().split(",");

            for (int i =0;i<chos.length;i++) {
                if(json.get("cho_"+chos[i]) == null){
                    continue;
                }
                Choicedba c= questionDao.findChoicedbaById_Ans(Long.parseLong(chos[i]));
                if(json.get("cho_"+chos[i]).getAsString().equals(c.getRightanswer())){
                    ans += Long.parseLong(score[i]);
                    System.out.println("cho+"+score[i]);
                }
            }

            String[] judgs = p.getJudg().split(",");
            score = p.getJudgscore().split(",");

            for (int i =0;i<judgs.length;i++) {
                if(json.get("tf_"+judgs[i]) == null){
                    continue;
                }
                Judgedba j= questionDao.findJudgedbaById_Ans(Long.parseLong(judgs[i]));
                if(json.get("tf_"+judgs[i]).getAsString().equals(j.getRightanswer())){
                    ans += Long.parseLong(score[i]);
                    System.out.println("tf+"+score[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(ans);
//        System.out.println(r);
//        System.out.println(p);
        r.setScore(ans);
        r.setStatus("已批改");
        examDao.calcGrade(r);
        return "批改成功！";
    }
}
