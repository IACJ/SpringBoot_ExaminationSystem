package examination.controller;


import examination.entity.Paper;
import examination.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    final static String path = "teacher/";

    @Autowired
    PaperService paperService;

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

        model.addAttribute("page", paperService.getPage(request.getParameter("currentPage")));
        model.addAttribute("choiceQuestuon", paperService.getChoiceQuestion());
        return path + "question_list";
    }

    @RequestMapping(value = "get_paper")
    String getPaper() {
        return path + "choice_combine";
    }

    @RequestMapping(value = "/{type}/combine")
    public String question(@PathVariable String type, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if ("choice".equals(type)) {
            session.setAttribute("choi", request.getParameter("choice"));
            return path + "judge_combine";
        } else if ("judge".equals(type)) {
            session.setAttribute("judg", request.getParameter("judge"));
            return path + "sub_combine";
        } else if ("sub".equals(type)) {
            session.setAttribute("sub", request.getParameter("sub"));
            return path + "other_config";
        }
        return "error";
    }

    @RequestMapping(value = "paper_finish")
    @ResponseBody
    boolean finishPaper(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String begintime = request.getParameter("begintime");
        String finishtime = request.getParameter("finishtime");
        String choi = (String) session.getAttribute("choi");
        String judg = (String) session.getAttribute("judg");
        String sub = (String) session.getAttribute("sub");
        long tid = (long) session.getAttribute("userid");
        String classid = request.getParameter("classid");


        System.out.println("name:" + name);
        System.out.println("begintime:" + begintime);
        System.out.println("finishtime:" + finishtime);
        System.out.println("choi:" + choi);
        System.out.println("judg:" + judg);
        System.out.println("sub:" + sub);
        System.out.println("tid:" + tid);
        System.out.println("classid:" + classid);

        return paperService.addPaper(new Paper(name, begintime, finishtime, choi,
                judg, sub, tid, classid)) != 0;
    }
}
