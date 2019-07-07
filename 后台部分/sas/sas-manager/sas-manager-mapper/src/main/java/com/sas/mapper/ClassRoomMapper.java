package com.sas.mapper;

import com.sas.pojo.ClassRoom;
import com.sas.pojo.ClassRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassRoomMapper {
    int countByExample(ClassRoomExample example);

    int deleteByExample(ClassRoomExample example);

    int deleteByPrimaryKey(Integer classroomid);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);

    List<ClassRoom> selectByExample(ClassRoomExample example);

    ClassRoom selectByPrimaryKey(Integer classroomid);

    int updateByExampleSelective(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByExample(@Param("record") ClassRoom record, @Param("example") ClassRoomExample example);

    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);
}