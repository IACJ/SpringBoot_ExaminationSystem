package examination.controller;

import examination.entity.User;
import examination.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/doLogin")
    String doLogin(Model model, String account, String password) {
        User user;
        user = loginService.doLogin(account, password);
        if (null != user) {

            model.addAttribute("account", user.getAccount());
            model.addAttribute("name", user.getName());
            model.addAttribute("permission", user.getPermission());
            return "success";
        }
        return "index";
    }

    @RequestMapping(value = "/")
    String index() {
        return "index";
    }
}
