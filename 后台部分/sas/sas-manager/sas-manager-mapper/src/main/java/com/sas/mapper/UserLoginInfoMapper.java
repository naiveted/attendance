package com.sas.mapper;

import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserLoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginInfoMapper {
    int countByExample(UserLoginInfoExample example);

    int deleteByExample(UserLoginInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    List<UserLoginInfo> selectByExample(UserLoginInfoExample example);

    UserLoginInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByExample(@Param("record") UserLoginInfo record, @Param("example") UserLoginInfoExample example);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);
}