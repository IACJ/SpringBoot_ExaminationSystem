package examination.service;

import examination.dao.ChoiceDao;
import examination.dao.ExamDao;
import examination.dao.JudgeDao;
import examination.dao.SubjectDao;
import examination.entity.ChoiceQuestion;
import examination.entity.JudgeQuestion;
import examination.entity.Paper;
import examination.entity.SubjectQuestion;
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


    public int deleteJudgeQuestion(long id){
        return judgeDao.delete(id);
    }

    public int deleteJudgeQuestionBatch(List<Long>list){
        return judgeDao.deleteByList(list);
    }

    public int updateJudgeQuestion(JudgeQuestion judgeQuestion){
        return judgeDao.update(judgeQuestion);
    }


    public int deleteSubjectQuestion(long id){
        return subjectDao.delete(id);
    }

    public int deleteSubjectQuestionBatch(List<Long>list){
        return subjectDao.deleteByList(list);
    }

    public int updateSubjectQuestion(SubjectQuestion subjectQuestion){
        return subjectDao.update(subjectQuestion);
    }


}
