package com.sas.mapper;

import com.sas.pojo.Student;
import com.sas.pojo.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer studentnum);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer studentnum);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}