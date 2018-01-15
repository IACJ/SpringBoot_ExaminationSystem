package examination.service;

import examination.dao.*;
import examination.entity.ChoiceQuestion;
import examination.entity.Student;
import examination.entity.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    ChoiceDao choiceDao;

    @Autowired
    JudgeDao judgeDao;

    @Autowired
    SubjectDao subjectDao;


    public int deleteChoiceQuestion(long id){
        return choiceDao.delete(id);
    }

    public int deleteChoiceQuestionBatch(List<Long>list){
        return choiceDao.deleteByList(list);
    }

    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion){
        return choiceDao.update(choiceQuestion);
    }
}
