package com.sas.mapper;

import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.OrganizationDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationDictionaryMapper {
    int countByExample(OrganizationDictionaryExample example);

    int deleteByExample(OrganizationDictionaryExample example);

    int deleteByPrimaryKey(Integer organizationid);

    int insert(OrganizationDictionary record);

    int insertSelective(OrganizationDictionary record);

    List<OrganizationDictionary> selectByExample(OrganizationDictionaryExample example);

    OrganizationDictionary selectByPrimaryKey(Integer organizationid);

    int updateByExampleSelective(@Param("record") OrganizationDictionary record, @Param("example") OrganizationDictionaryExample example);

    int updateByExample(@Param("record") OrganizationDictionary record, @Param("example") OrganizationDictionaryExample example);

    int updateByPrimaryKeySelective(OrganizationDictionary record);

    int updateByPrimaryKey(OrganizationDictionary record);
}