package examination.controller;


import examination.dao.ChoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    final static String path = "teacher/";
    @Autowired
    ChoiceDao choiceDao;

    @RequestMapping(value = "")
    String index(Model model, HttpSession httpSession) {
        return "redirect:" + path + "teacherpage";
    }

    @RequestMapping(value = "teacherpage")
    String adminpage(Model model, HttpSession httpSession) {
        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "teacherpage";
    }

    @RequestMapping(value = "question_list")
    String questionList(Model model, HttpServletRequest request) {
        int pageNumber = 7;
        int count = choiceDao.getCount();
        int currentPage = request.getParameter("currentPage") != null ?
                Integer.parseInt(request.getParameter("currentPage")) : 1;
        int totalPage = count % pageNumber == 0 ? count / pageNumber : count / pageNumber + 1;


        model.addAttribute("count", count);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("choiceQuestuon", choiceDao.getChoiceQuestion((currentPage - 1) * pageNumber, pageNumber));
        return path + "question_list";
    }

}
