package examination.dao;

import examination.entity.Status;
import examination.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EvaluateDao {

    long submit(Status status);

    long update(Status status);

    List<Status>  getList(@Param("off") long off, @Param("n") long n);

}
