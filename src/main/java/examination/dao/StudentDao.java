package examination.dao;

import examination.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentDao {
    Student findByLogin(@Param("account") String account, @Param("password") String password);
}
