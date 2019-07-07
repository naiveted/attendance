package com.sas.mapper;

import com.sas.pojo.Dictionarys;
import com.sas.pojo.DictionarysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionarysMapper {
    int countByExample(DictionarysExample example);

    int deleteByExample(DictionarysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dictionarys record);

    int insertSelective(Dictionarys record);

    List<Dictionarys> selectByExample(DictionarysExample example);

    Dictionarys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dictionarys record, @Param("example") DictionarysExample example);

    int updateByExample(@Param("record") Dictionarys record, @Param("example") DictionarysExample example);

    int updateByPrimaryKeySelective(Dictionarys record);

    int updateByPrimaryKey(Dictionarys record);
}