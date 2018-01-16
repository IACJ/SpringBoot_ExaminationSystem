package examination.dao;

import examination.entity.JudgeQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JudgeDao {
    int getCount();

    List<JudgeQuestion> getJudgeQuestion(@Param("offset") int offset, @Param("limit") int limit);

    int delete(long id);

    int deleteByList(List<Long> ids);

    int update(JudgeQuestion judgeQuestion);
}