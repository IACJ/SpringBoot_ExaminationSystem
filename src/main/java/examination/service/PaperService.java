package examination.service;

import examination.dao.ChoiceDao;
import examination.entity.ChoiceQuestion;
import examination.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    ChoiceDao choiceDao;
    Page page;

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
}
