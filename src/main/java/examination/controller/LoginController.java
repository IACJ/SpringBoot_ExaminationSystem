package examination.controller;

import examination.entity.User;
import examination.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    String doLogin(Model model, String account, String password,HttpSession httpSession) {
        User user;
        user = loginService.doLogin(account, password);
        if (null != user) {

            httpSession.setAttribute("userid", user.getId());
            httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("permission", user.getPermission());

            String pageName = user.getPermission().toLowerCase() + "page";
            return "redirect:/"+pageName;
        }
        return "wrongpassward";
    }

    @RequestMapping(value = "/")
    String index() {
        return "index";
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
        return "adminpage";
    }

    @RequestMapping(value = "/teacherpage")
    String teacherpage(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Teacher" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return "teacherpage";
    }

    @RequestMapping(value = "/studentpage")
    String studentpage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("permission")==null){
            return "redirect:/notlogin";
        }
        if ( "Student" != httpSession.getAttribute("permission") ){
            return "notpermission";
        }

        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return "studentpage";
    }

    @RequestMapping(value = "/session")
    String session(Model model,HttpSession httpSession) {

        model.addAttribute("permission", httpSession);
        return "session";
    }
    @RequestMapping(value = "/logout")
    String logout(Model model,HttpSession httpSession) {

        httpSession.removeAttribute("userid");
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("permission");

        return "logout";
    }
    @RequestMapping(value = "/notlogin")
    String notlogin(Model model,HttpSession httpSession) {
        return "notlogin";
    }
}
