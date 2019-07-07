package com.sas.mapper;

import com.sas.pojo.Absenteeism;
import com.sas.pojo.AbsenteeismExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbsenteeismMapper {
    int countByExample(AbsenteeismExample example);

    int deleteByExample(AbsenteeismExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Absenteeism record);

    int insertSelective(Absenteeism record);

    List<Absenteeism> selectByExample(AbsenteeismExample example);

    Absenteeism selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Absenteeism record, @Param("example") AbsenteeismExample example);

    int updateByExample(@Param("record") Absenteeism record, @Param("example") AbsenteeismExample example);

    int updateByPrimaryKeySelective(Absenteeism record);

    int updateByPrimaryKey(Absenteeism record);
}