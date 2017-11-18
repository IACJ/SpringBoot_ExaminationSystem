package examination.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    final static String path = "teacher/";

    @RequestMapping(value = "")
    String index(Model model,HttpSession httpSession) {
        return "redirect:"+path+"teacherpage";
    }

    @RequestMapping(value = "teacherpage")
    String adminpage(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Teacher" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"teacherpage";
    }
}
