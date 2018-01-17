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
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

@Service
public class LoginService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    AdminDao adminDao;

    public User doLogin(String account, String password){
        password = EncoderByMd5(password);
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

    public void chageInfo(long uid, String s, String name, String pw) {
        pw = EncoderByMd5(pw);
        if (s.equals("Teacher")){
            teacherDao.updateInfo(uid,name,pw);
        }else if(s.equals("Admin")){
            adminDao.updateInfo();
        }else {
            studentDao.updateInfo(uid,name,pw);
        }
    }
    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     */
    public String EncoderByMd5(String str)  {
        //确定计算方法
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newstr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
