package examination.dao;

import examination.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDao {
    Admin findByLogin(@Param("account") String account, @Param("password") String password);

    void updateInfo( @Param("id")long id, @Param("name") String name,@Param("pw") String pw);
}
