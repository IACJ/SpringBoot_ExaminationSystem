package examination.controller;


import examination.entity.ChoiceQuestion;
import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import examination.service.ExamService;
import examination.service.ExerciseService;
import examination.service.PaperService;
import examination.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    final static String path = "teacher/";

    @Autowired
    TeacherService teacherService;

    @Autowired
    PaperService paperService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExamService examService;


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

    @RequestMapping(value = "{type}/delete")
    @ResponseBody()
    boolean deleteQuestion(@PathVariable String type, long id) {
        if ("choice".equals(type)) {
            return teacherService.deleteChoiceQuestion(id) != 0;
        } else if ("judge".equals(type)) {

        } else if ("sub".equals(type)) {

        }

        return false;
    }

    @RequestMapping(value = "{type}/delete_batch")
    @ResponseBody()
    boolean deleteQuestionBatch(@PathVariable String type, @RequestParam("list[]") List<Long> list) {
        if ("choice".equals(type)) {
            return teacherService.deleteChoiceQuestionBatch(list) != 0;
        } else if ("judge".equals(type)) {

        } else if ("sub".equals(type)) {

        }

        return false;
    }

    @RequestMapping(value = "{type}/update")
    @ResponseBody()
    boolean updateQuestion(@PathVariable String type, ChoiceQuestion choiceQuestion) {
        if ("choice".equals(type)) {
            return teacherService.updateChoiceQuestion(choiceQuestion) != 0;
        } else if ("judge".equals(type)) {

        } else if ("sub".equals(type)) {

        }

        return false;
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

    @RequestMapping(value = "teacher_test_list")
    String teacherTestList() {
        return  path + "teacher_test_list";
    }

    @RequestMapping(value = "pigai_test_ing")
    String pigaiTestIng() {
        return  path + "pigai_test_ing";
    }

    @RequestMapping(value = "see_test_ing")
    String seeTestIng() {
        return  path + "see_test_ing";
    }

    @RequestMapping(value = "teacher_see_paper")
    @ResponseBody()
    Paper teacherSeePaper(long pid){
        return teacherService.getPaper(pid);
    }

    @RequestMapping(value = "teacher_test_list_content")
    @ResponseBody()
    List<Map> teacherTestListContent(HttpSession httpSession){
        long tid = (long) httpSession.getAttribute("userid");
        return teacherService.listPaper(tid);
    }

    @RequestMapping(value = "teacher_test_get_paper")
    @ResponseBody()
    Map teacherTestGetPaper(long pid){
        return teacherService.getOnePaperRecord(pid);
    }
    @RequestMapping(value = "sub_get_questionByAns")
    @ResponseBody
    Subdba subGetQuestionByAns(Long id) {
        return  exerciseService.getSubdbaById_Ans(id);
    }

    @RequestMapping(value = "choice_get_questionByAns")
    @ResponseBody
    Choicedba choiceGetQuestionByAns(Long id) {
        return  exerciseService.getChoicedbaById_Ans(id);
    }

    @RequestMapping(value = "truefalse_get_questionByAns")
    @ResponseBody
    Judgedba truefalseGetQuestionByAns(Long id) {
        return  exerciseService.getJudgedbaById_Ans(id);
    }

    @RequestMapping(value = "teacher_calc_grade",method= RequestMethod.POST)
    @ResponseBody
    String teacher_calc_grade(long ans,long pid,long sid) {
        return examService.teacher_calc_grade(sid,pid,ans);
    }
}
