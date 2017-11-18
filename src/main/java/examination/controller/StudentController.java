package examination.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "")
    String adminpage(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return "student/studentpage";
    }
}