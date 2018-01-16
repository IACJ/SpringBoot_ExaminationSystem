package examination.controller;


import examination.entity.ChoiceQuestion;
import examination.entity.JudgeQuestion;
import examination.entity.Paper;
import examination.entity.SubjectQuestion;
import examination.service.ChartService;
import examination.service.PaperService;
import examination.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    final static String path = "teacher/";

    @Autowired
    TeacherService teacherService;

    @Autowired
    PaperService paperService;

    @Autowired
    ChartService chartService;

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

        model.addAttribute("page", paperService.getPage(request.getParameter("currentPage"),"choice"));
        model.addAttribute("choiceQuestuon", paperService.getChoiceQuestion());
        return path + "question_list";
    }

    @RequestMapping(value = "truefalse_list")
    String truefalseList(Model model, HttpServletRequest request) {

        model.addAttribute("page", paperService.getPage(request.getParameter("currentPage"),"judge"));
        model.addAttribute("judgeQuestuon", paperService.getJudgeQuestion());
        return path + "truefalse_list";
    }

    @RequestMapping(value = "sub_list")
    String subList(Model model, HttpServletRequest request) {

        model.addAttribute("page", paperService.getPage(request.getParameter("currentPage"),"sub"));
        model.addAttribute("subjectQuestuon", paperService.getSubjectQuestion());
        return path + "sub_list";
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
            return teacherService.deleteJudgeQuestion(id) != 0;
        } else if ("sub".equals(type)) {
            return teacherService.deleteSubjectQuestion(id) != 0;
        }
        return false;
    }

    @RequestMapping(value = "{type}/delete_batch")
    @ResponseBody()
    boolean deleteQuestionBatch(@PathVariable String type, @RequestParam("list[]") List<Long> list) {
        if ("choice".equals(type)) {
            return teacherService.deleteChoiceQuestionBatch(list) != 0;
        } else if ("judge".equals(type)) {
            return teacherService.deleteJudgeQuestionBatch(list) != 0;
        } else if ("sub".equals(type)) {
            return teacherService.deleteSubjectQuestionBatch(list) != 0;
        }

        return false;
    }

    //update之所以不按照上面套路写作{type}/update,是因为springmvc需要把传入的参数映射为
    // ChoiceQuestion等对象，分开写才能对于不同的对象映射。
    @RequestMapping(value = "choice/update")
    @ResponseBody()
    boolean updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return teacherService.updateChoiceQuestion(choiceQuestion) != 0;
    }

    @RequestMapping(value = "judge/update")
    @ResponseBody()
    boolean updateJudgeQuestion(JudgeQuestion judgeQuestion) {
        return teacherService.updateJudgeQuestion(judgeQuestion) != 0;
    }

    @RequestMapping(value = "sub/update")
    @ResponseBody()
    boolean updateSubjectQuestion(SubjectQuestion subjectQuestion) {
        return teacherService.updateSubjectQuestion(subjectQuestion) != 0;
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

    @RequestMapping(value = "student_grade")
    String student_grade(Model model, HttpSession session) {
        long tid = (long) session.getAttribute("userid");
        model.addAttribute("paper", teacherService.listExamById(tid));
        return path + "student_grade";
    }

    @RequestMapping(value = "student_grade_list")
    String studentGradeList(Model model, HttpSession session, HttpServletRequest request) {

        long pid = Long.parseLong(request.getParameter("pid"));
        model.addAttribute("gradeList", teacherService.listStudentGrade(pid));
        model.addAttribute("name", request.getParameter("name"));
        return path + "student_grade_list";
    }

    @RequestMapping(value = "get/chart")
    String getChart(HttpServletRequest request, Model model) {
        long pid = Long.parseLong(request.getParameter("pid"));
        model.addAttribute("data", chartService.teacherGetChart(pid, request.getParameter("name")));
        return path + "student_chart";
    }

    @RequestMapping(value = "/{type}/download")
    public void download(@PathVariable String type, HttpServletResponse res) {
        res.setHeader("Content-Disposition", "attachment; filename=" + type + "_template.xlsx");
        res.setContentType("application/octet-stream; charset=utf-8");
        try {
            String path = "src/main/resources/templates/excel/" + type + "_template.xlsx";

            FileCopyUtils.copy(new FileInputStream(path), res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{type}/upload")
    @ResponseBody
    public boolean upload(@PathVariable String type, @RequestParam(value = "file") MultipartFile file) {
        try {
            if ("choice".equals(type))
                return teacherService.addChoiceQuestionByExcel(file.getInputStream()) != 0;
            else if ("judge".equals(type))
                return teacherService.addJudgeQuestionByExcel(file.getInputStream()) != 0;
            return teacherService.addSubjectQuestionByExcel(file.getInputStream()) != 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
