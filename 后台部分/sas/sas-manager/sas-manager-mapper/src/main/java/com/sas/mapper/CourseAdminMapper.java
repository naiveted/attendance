package com.sas.mapper;

import com.sas.pojo.CourseAdmin;
import com.sas.pojo.CourseAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseAdminMapper {
    int countByExample(CourseAdminExample example);

    int deleteByExample(CourseAdminExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(CourseAdmin record);

    int insertSelective(CourseAdmin record);

    List<CourseAdmin> selectByExample(CourseAdminExample example);

    CourseAdmin selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") CourseAdmin record, @Param("example") CourseAdminExample example);

    int updateByExample(@Param("record") CourseAdmin record, @Param("example") CourseAdminExample example);

    int updateByPrimaryKeySelective(CourseAdmin record);

    int updateByPrimaryKey(CourseAdmin record);
}