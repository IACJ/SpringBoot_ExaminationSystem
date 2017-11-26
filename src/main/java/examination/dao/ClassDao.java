package examination.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassDao {
    String getIdByName(String name);
    String getNameById(String id);
}
