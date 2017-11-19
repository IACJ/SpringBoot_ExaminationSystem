package examination.dao;


import examination.entity.Question.Choicedba;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionDao {
    Choicedba findChoicedbaById_Ans(@Param("id") Long id);
    Choicedba findChoicedbaById_noAns( @Param("id") Long id);
}
