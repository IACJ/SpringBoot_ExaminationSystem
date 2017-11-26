package examination.dao;


import examination.entity.Question.Choicedba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionDao {
    Choicedba findChoicedbaById_Ans(@Param("id") Long id);
    Choicedba findChoicedbaById_noAns( @Param("id") Long id);


    Judgedba findJudgedbaById_Ans(@Param("id") Long id);
    Judgedba findJudgedbaById_noAns( @Param("id") Long id);

    Subdba findSubdbaById_Ans(@Param("id") Long id);
    Subdba findSubdbaById_noAns( @Param("id") Long id);
}
