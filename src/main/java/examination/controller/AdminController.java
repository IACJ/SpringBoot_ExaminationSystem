package examination.controller;


import examination.entity.Student;
import examination.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    final static String path = "admin/";
    @Autowired
    AdminService adminservice;

    @RequestMapping(value = "")
    String index(Model model, HttpSession httpSession) {
        return "redirect:" + path + "adminpage";
    }

    @RequestMapping(value = {"/adminpage"})
    String adminpage(Model model, HttpSession httpSession) {
        model.addAttribute("name", httpSession.getAttribute("name"));
        model.addAttribute("permission", httpSession.getAttribute("permission"));
        return path + "adminpage";
    }

    @RequestMapping(value = "/student_manage")
    String studentManage() {
        return path + "student_manage";
    }

    @RequestMapping(value = "/student/add")
    @ResponseBody
    boolean addStudent(Student student) {
        if(adminservice.addStudent(student)!=0)
            return true;
        return false;
    }

    @RequestMapping(value = "/find_student_by_id")
    @ResponseBody
    Student findStudentById(long id) {
       return adminservice.findStudentById(id);
    }

    @RequestMapping(value = "student/update")
    @ResponseBody()
    boolean updateStudent(Student student){
        if(adminservice.updateStudent(student)!=0)
            return true;
        return false;
    }

}
