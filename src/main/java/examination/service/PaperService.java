package examination.service;

import examination.dao.ChoiceDao;
import examination.dao.JudgeDao;
import examination.dao.PaperDao;
import examination.dao.SubjectDao;
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

    Page page = new Page();

    public Page getPage(String cp) {
        page = new Page();
        int pageNumber = page.getPageNumber();
        int currentPage = cp != null ? Integer.parseInt(cp) : 1;
        int count = choiceDao.getCount();
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
        return paperDao.add(paper);
    }

}
