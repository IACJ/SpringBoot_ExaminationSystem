package examination.dao;

import examination.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherDao {
    Teacher findByLogin(@Param("account") String account, @Param("password") String password);

    void add(@Param("account") String account, @Param("name") String name);

    Teacher findById(@Param("id") long id);

    void update(Teacher teacher);

    int addByList(List<Teacher> teachers);
}
