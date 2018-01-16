package examination.service;

import examination.dao.ChoiceDao;
import examination.dao.ExamDao;
import examination.dao.JudgeDao;
import examination.dao.SubjectDao;
import examination.entity.ChoiceQuestion;
import examination.entity.Paper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    ChoiceDao choiceDao;

    @Autowired
    JudgeDao judgeDao;

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    ExamDao examDao;

    public int deleteChoiceQuestion(long id){
        return choiceDao.delete(id);
    }

    public int deleteChoiceQuestionBatch(List<Long>list){
        return choiceDao.deleteByList(list);
    }

    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion){
        return choiceDao.update(choiceQuestion);
    }

    public List<Paper> listExamById(long id){
        return examDao.listExamByTid(id);
    }

    public List<Map> listStudentGrade(long pid){
        return examDao.listStudentGrade(pid);
    }
}
