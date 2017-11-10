package examination.controller;

import examination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    String login(Model model, String name, String password) {
        if (userService.isExist(name, password)) {
            model.addAttribute("name", name);
            model.addAttribute("password", password);
            return "success";
        }
        return "index";
    }

    @RequestMapping(value = "/")
    String index() {
        return "index";
    }
}
