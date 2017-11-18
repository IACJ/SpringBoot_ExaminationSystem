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

            String pageName = user.getPermission().toLowerCase();
            return "redirect:/"+pageName;
        }
        return "redirect:/wrongpassword";
    }


    @RequestMapping(value = "/")
    String index() {
        return "redirect:/login";
    }
    @RequestMapping(value = "/login")
    String login() {
        return "login";
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
    String notlogin(Model model) {
        return "notlogin";
    }

    @RequestMapping(value = "/wrongpassword")
    String wrongpassword(Model model) {
        return "wrongpassword";
    }
}
