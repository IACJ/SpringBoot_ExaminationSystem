package examination.dao;

import examination.entity.SubjectQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectDao {
    int getCount();

    List<SubjectQuestion> getSubjectQuestion(@Param("offset") int offset, @Param("limit") int limit);
}