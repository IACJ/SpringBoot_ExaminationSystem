package examination.controller;


import examination.entity.ChoiceQuestion;
import examination.entity.JudgeQuestion;
import examination.entity.Paper;
import examination.entity.SubjectQuestion;
import examination.service.ChartService;
import examination.entity.Question.Subdba;
import examination.service.ExamService;
import examination.service.ExerciseService;
import examination.service.PaperService;
import examination.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
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
    ChartService chartService;
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
    String getPaper(Model model) {
        model.addAttribute("choiceQuestuon", paperService.getAllChoiceQuestion());
        return path + "choice_combine";
    }

    @RequestMapping(value = "/{type}/combine")
    public String question(@PathVariable String type, HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        if ("choice".equals(type)) {
            session.setAttribute("choi", request.getParameter("choice"));
            model.addAttribute("judgeQuestuon", paperService.getAllJudgeQuestion());
            return path + "judge_combine";
        } else if ("judge".equals(type)) {
            session.setAttribute("judg", request.getParameter("judge"));
            model.addAttribute("subjectQuestuon", paperService.getAllSubjectQuestion());
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
        String choiscore="";
        for (int i = 0; i < choi.split(",").length; i++) {
            choiscore+="4,";
        }
        choiscore=choiscore.substring(0,choiscore.length()-1);

        String judgscore="";
        for (int i = 0; i < judg.split(",").length; i++) {
            judgscore +="4,";
        }
        judgscore=judgscore.substring(0,judgscore.length()-1);

        String subscore="";
        for (int i = 0; i < sub.split(",").length; i++) {
            subscore+="4,";
        }
        subscore=subscore.substring(0,subscore.length()-1);

        System.out.println("name:" + name);
        System.out.println("begintime:" + begintime);
        System.out.println("finishtime:" + finishtime);
        System.out.println("choi:" + choi);
        System.out.println("judg:" + judg);
        System.out.println("sub:" + sub);
        System.out.println("tid:" + tid);
        System.out.println("classid:" + classid);

        return paperService.addPaper(new Paper(name, begintime, finishtime, choi,
                judg, sub,choiscore,judgscore,subscore, tid, classid)) != 0;
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

    @RequestMapping(value = "get_chart")
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

    @RequestMapping(value = "teacher_test_list")
    String teacherTestList() {
        return  path + "teacher_test_list";
    }

    @RequestMapping(value = "pigai_test_ing")
    String pigaiTestIng() {
        return  path + "pigai_test_ing";
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

    @RequestMapping(value = "teacher_calc_grade",method= RequestMethod.POST)
    @ResponseBody
    String teacher_calc_grade(long ans,long pid,long sid) {
        return examService.teacher_calc_grade(sid,pid,ans);
    }
}
