package examination.controller;


import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import examination.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
    final static String path = "student/";

    @Autowired
    ExerciseService exerciseService;

    @RequestMapping(value = "")
    String index(Model model, HttpSession httpSession) {
        return "redirect:" + path + "studentpage";
    }

    @RequestMapping(value = "studentpage")
    String studentpage(Model model, HttpSession httpSession) {

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "studentpage";
    }

    @RequestMapping(value = "student_exercise")
    String student_exercise(Model model, HttpSession httpSession) {
        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "student_exercise";
    }

    @RequestMapping(value = "student_grade")
    String student_grade(Model model, HttpSession httpSession) {

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "student_grade";
    }

    @RequestMapping(value = "student_status")
    String student_status(Model model, HttpSession httpSession) {


        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "student_status";
    }

    @RequestMapping(value = "student_test")
    String student_test(Model model, HttpSession httpSession) {

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "student_test";
    }

    @RequestMapping(value = "student_exercise_choice")
    String student_exercise_choice(Model model,HttpSession httpSession) {

        return path+"student_exercise_choice";
    }

    @RequestMapping(value = "student_exercise_choice_get_question")
    @ResponseBody
    Choicedba student_exercise_choice_get_question(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getChoicedbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_choice_get_ans")
    @ResponseBody
    Choicedba student_exercise_choice_get_ans(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getChoicedbaById_Ans(id);
    }

    @RequestMapping(value = "student_exercise_truefalse")
    String student_exercise_truefalse(Model model,HttpSession httpSession) {

        return path+"student_exercise_truefalse";
    }

    @RequestMapping(value = "student_exercise_truefalse_get_question")
    @ResponseBody
    Judgedba student_exercise_truefalse_get_question(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getJudgedbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_truefalse_get_ans")
    @ResponseBody
    Judgedba student_exercise_truefalse_get_ans(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getJudgedbaById_Ans(id);
    }

    @RequestMapping(value = "student_exercise_sub")
    String student_exercise_sub(Model model,HttpSession httpSession) {

        return path+"student_exercise_sub";
    }

    @RequestMapping(value = "student_exercise_sub_get_question")
    @ResponseBody
    Subdba student_exercise_sub_get_question(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getSubdbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_sub_get_ans")
    @ResponseBody
    Subdba student_exercise_sub_get_ans(Model model, HttpSession httpSession, Long id) {
        return  exerciseService.getSubdbaById_Ans(id);
    }


    @RequestMapping(value = "student_test_ing")
    String student_test_ing(Model model,HttpSession httpSession) {
        return path+"student_test_ing";
    }
}