package examination.service;

import examination.dao.AdminDao;
import examination.dao.StudentDao;
import examination.dao.TeacherDao;
import examination.entity.Admin;
import examination.entity.Student;
import examination.entity.Teacher;
import examination.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    AdminDao adminDao;

    public User doLogin(String account, String password){

        Student student=studentDao.findByLogin(account,password);
        if (student != null){
            return student;
        }
        Teacher teacher=teacherDao.findByLogin(account,password);
        if (teacher != null){
            return teacher;
        }
        Admin admin=adminDao.findByLogin(account,password);
        if (admin != null){
            return admin;
        }

        return null;
    }

}
