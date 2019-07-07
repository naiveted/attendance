package com.sas.mapper;

import com.sas.pojo.Attendance;
import com.sas.pojo.AttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceMapper {
    int countByExample(AttendanceExample example);

    int deleteByExample(AttendanceExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    List<Attendance> selectByExample(AttendanceExample example);

    Attendance selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByExample(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}