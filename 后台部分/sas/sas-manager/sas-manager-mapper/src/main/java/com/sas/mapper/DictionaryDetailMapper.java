package com.sas.mapper;

import com.sas.pojo.DictionaryDetail;
import com.sas.pojo.DictionaryDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictionaryDetailMapper {
    int countByExample(DictionaryDetailExample example);

    int deleteByExample(DictionaryDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryDetail record);

    int insertSelective(DictionaryDetail record);

    List<DictionaryDetail> selectByExample(DictionaryDetailExample example);

    DictionaryDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictionaryDetail record, @Param("example") DictionaryDetailExample example);

    int updateByExample(@Param("record") DictionaryDetail record, @Param("example") DictionaryDetailExample example);

    int updateByPrimaryKeySelective(DictionaryDetail record);

    int updateByPrimaryKey(DictionaryDetail record);
}