package examination.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChoiceDao {
    List<String> getPaperName(long studentId);

    List<Byte> getScore(long studentId);
}