package examination.service;

import examination.dao.EvaluateDao;
import examination.dao.ExamDao;
import examination.dao.QuestionDao;
import examination.entity.Paper;
import examination.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EvaluatingService {

    @Autowired
    EvaluateDao evaluateDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    CompareSQLService compareSQLService;


    public void EvaluateSQL (Long uid, Long eid,String sql2, String type){
        System.out.println("执行评测服务");

        Status status = new Status();
        status.setUid(uid);
        status.setEid(eid);
        status.setSql2(sql2);
        evaluateDao.submit(status);

        String sql1 = questionDao.findEvadbaById_Ans(eid).getRightanswer();
        String result = "评测异常";

        try{
            Boolean bool;
            if (type.equals("select")){
                bool = compareSQLService.compareRS(sql1,sql2);
            }else{
                bool = compareSQLService.compareRS(sql1,sql2);
            }
            result = bool ? "答案正确，你真棒！": "答案错误，你真笨!";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = "SQL语句出错："+e.getMessage();
        }
        status.setStatus(result);

        evaluateDao.update(status);
    }
}
