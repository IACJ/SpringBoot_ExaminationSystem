package examination.service;

import examination.dao.ClassDao;
import examination.dao.StudentDao;
import examination.dao.TeacherDao;
import examination.entity.Student;
import examination.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    ClassDao classDao;

    public int addStudent(Student student) {
        String classId = classDao.getIdByName(student.getClassid());
        student.setClassid(classId);
        return studentDao.add(student);
    }

    public Student findStudentById(long id) {
        Student student = studentDao.findById(id);
        if (null == student)
            return null;
        student.setClassid(classDao.getNameById(student.getClassid()));
        return student;
    }

    public void addTeacher(String account, String name) {
        teacherDao.add(account, name);
    }

    public int updateStudent(Student student) {
        student.setClassid(classDao.getIdByName(student.getClassid()));
        return studentDao.update(student);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }
}
