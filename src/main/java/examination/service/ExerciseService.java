package examination.service;

import examination.dao.QuestionDao;
import examination.entity.Question.Choicedba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
