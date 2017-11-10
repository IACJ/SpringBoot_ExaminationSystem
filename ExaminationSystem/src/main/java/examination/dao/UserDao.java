package examination.dao;

import examination.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User find(@Param("name") String name, @Param("password") String password);
}
