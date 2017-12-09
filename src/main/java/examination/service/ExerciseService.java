package examination.service;

import examination.dao.QuestionDao;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Evadba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    QuestionDao questionDao;

    public Choicedba getChoicedbaById_Ans (Long id){
        return questionDao.findChoicedbaById_Ans(id);
    }

    public Choicedba getChoicedbaById_noAns (Long id){
        return questionDao.findChoicedbaById_noAns(id);
    }

    public Judgedba getJudgedbaById_Ans (Long id){
        return questionDao.findJudgedbaById_Ans(id);
    }

    public Judgedba getJudgedbaById_noAns (Long id){
        return questionDao.findJudgedbaById_noAns(id);
    }

    public Subdba getSubdbaById_Ans (Long id){
        return questionDao.findSubdbaById_Ans(id);
    }

    public Subdba getSubdbaById_noAns (Long id){
        return questionDao.findSubdbaById_noAns(id);
    }

    public Evadba getEvadbaById_Ans (Long id){
        return questionDao.findEvadbaById_Ans(id);
    }

    public Evadba getEvadbaById_noAns (Long id){
        return questionDao.findEvadbaById_noAns(id);
    }

    public List<Evadba>  getEvadbaByType (String type){
        return questionDao.findEvadbaByType(type);
    }

}
