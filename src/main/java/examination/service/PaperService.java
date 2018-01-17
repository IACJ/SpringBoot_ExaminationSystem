package examination.service;

import examination.dao.*;
import examination.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    ChoiceDao choiceDao;
    @Autowired
    JudgeDao judgeDao;
    @Autowired
    SubjectDao subjectDao;
    @Autowired
    PaperDao paperDao;

    @Autowired
    ClassDao classDao;

    Page page = new Page();

    public Page getPage(String cp, String type) {
        page = new Page();
        int pageNumber = page.getPageNumber();
        int currentPage = cp != null ? Integer.parseInt(cp) : 1;
        int count=0;
        if ("choice".equals(type))
            count = choiceDao.getCount();
        else if ("judge".equals(type))
            count = judgeDao.getCount();
        else if ("sub".equals(type))
            count = subjectDao.getCount();
        int totalPage = count % pageNumber == 0 ? count / pageNumber : count / pageNumber + 1;

        page.setCount(count);
        page.setCurrentPage(currentPage);
        page.setTotalPage(totalPage);
        return page;
    }

    public List<ChoiceQuestion> getChoiceQuestion() {
        int currentPage = page.getCurrentPage();
        int pageNumber = page.getPageNumber();
        return choiceDao.getChoiceQuestion((currentPage - 1) * pageNumber, pageNumber);
    }

    public List<JudgeQuestion> getJudgeQuestion() {
        int currentPage = page.getCurrentPage();
        int pageNumber = page.getPageNumber();
        return judgeDao.getJudgeQuestion((currentPage - 1) * pageNumber, pageNumber);
    }

    public List<SubjectQuestion> getSubjectQuestion() {
        int currentPage = page.getCurrentPage();
        int pageNumber = page.getPageNumber();
        return subjectDao.getSubjectQuestion((currentPage - 1) * pageNumber, pageNumber);
    }

    public int addPaper(Paper paper) {
        String classId = "[|"+classDao.getIdByName(paper.getClassid())+"|]";
        paper.setClassid(classId);
        return paperDao.add(paper);
    }

    public List<SubjectQuestion> getAllSubjectQuestion() {
        return subjectDao.queryAll();
    }

    public List<ChoiceQuestion> getAllChoiceQuestion() {
        return choiceDao.queryAll();
    }

    public List<JudgeQuestion> getAllJudgeQuestion() {
        return judgeDao.queryAll();
    }
}
