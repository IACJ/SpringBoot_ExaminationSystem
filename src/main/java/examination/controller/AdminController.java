package examination.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    final static String path = "admin/";

    @RequestMapping(value = "")
    String index(Model model,HttpSession httpSession) {
        return "redirect:"+path+"adminpage";
    }

    @RequestMapping(value = "/adminpage")
    String adminpage(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Admin" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path+"adminpage";
    }
}
