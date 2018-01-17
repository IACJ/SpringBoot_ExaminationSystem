package examination.dao;


import examination.entity.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperDao {
    int add(Paper paper);

}
