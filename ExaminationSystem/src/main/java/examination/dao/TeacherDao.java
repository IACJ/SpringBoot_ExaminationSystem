package examination.dao;

import examination.entity.Student;
import examination.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherDao {
    Teacher findByLogin(@Param("account") String account, @Param("password") String password);
}
