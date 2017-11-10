package examination.service;

import examination.dao.UserDao;
import examination.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String name,String password){
        User user=userDao.find(name,password);
        if(null!=user)
            return true;
        return false;
    }
}
