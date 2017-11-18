package examination.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
    final static String path = "student/";

    @RequestMapping(value = "")
    String index(Model model,HttpSession httpSession) {
        return "redirect:"+path+"studentpage";
    }

    @RequestMapping(value = "studentpage")
    String studentpage(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"studentpage";
    }

    @RequestMapping(value = "student_exercise")
    String student_exercise(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"student_exercise";
    }

    @RequestMapping(value = "student_grade")
    String student_grade(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"student_grade";
    }

    @RequestMapping(value = "student_status")
    String student_status(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"student_status";
    }
    @RequestMapping(value = "student_test")
    String student_test(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"student_test";
    }
}