package examination.service;

import examination.dao.ExamDao;
import examination.dao.QuestionDao;
import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    ExamDao examDao;

    public Paper getPaperById (Long id){
        return examDao.findPaperById(id);
    }

}
