package examination.dao;

import examination.entity.Status;
import examination.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluateDao {

    long submit(Status status);

    long update(Status status);

    List<Map>  getList(@Param("off") long off, @Param("n") long n);

}
