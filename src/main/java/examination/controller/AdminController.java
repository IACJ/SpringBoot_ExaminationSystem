package examination.controller;


import examination.entity.Student;
import examination.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;

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

    @RequestMapping(value = "/teacher_manage")
    String teacherManage() {
        return path + "teacher_manage";
    }

    @RequestMapping(value = "/add_student")
    String addStudent() {
        return path + "add_student";
    }

    @RequestMapping(value = "/add_teacher")
    String addTeacher() {
        return path + "add_teacher";
    }

    @RequestMapping(value = "/student/add")
    @ResponseBody
    boolean addStudent(Student student) {

        return adminservice.addStudent(student) != 0;
    }

    @RequestMapping(value = "/find_student_by_id")
    @ResponseBody
    Student findStudentById(long id) {
        return adminservice.findStudentById(id);
    }

    @RequestMapping(value = "student/update")
    @ResponseBody()
    boolean updateStudent(Student student) {
        return adminservice.updateStudent(student) != 0;
    }

    @RequestMapping(value = "/{type}/download")
    public void download(@PathVariable String type, HttpServletResponse res) {
        res.setHeader("Content-Disposition", "attachment; filename=" + type + "_template.xlsx");
        res.setContentType("application/octet-stream; charset=utf-8");
        try {
            String path = "src/main/resources/templates/excel/" + type + "_template.xlsx";
            System.out.println(path);
            FileCopyUtils.copy(new FileInputStream(path), res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{type}/upload")
    @ResponseBody
    public boolean upload(@PathVariable String type, @RequestParam(value = "file") MultipartFile file) {
        try {
            if ("student".equals(type))
                return adminservice.addStudentByExcel(file.getInputStream()) != 0;
            return adminservice.addTeacherByExcel(file.getInputStream()) != 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
