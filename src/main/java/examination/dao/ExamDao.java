package examination.dao;


import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import examination.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamDao {
    Paper findPaperById(@Param("id") Long id);

    List<Map> listPaperByClass(@Param("classid") Long classid);

    List<Map> listGradeBySid(@Param("sid") Long sid);

    void submit(Record record);

}
