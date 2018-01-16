package examination.dao;

import examination.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {
    Student findByLogin(@Param("account") String account, @Param("password") String password);

    int add(Student student);

    Student findById(@Param("id") long id);

    int update(Student student);

    int delete(long id);

    int deleteByList(List<Long> ids);

    int addByList(List<Student> students);

    List<Student> queryAll();

    int resetPassword(long id);
}
