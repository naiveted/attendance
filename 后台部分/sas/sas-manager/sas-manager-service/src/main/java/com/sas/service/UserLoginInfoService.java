package com.sas.service;

import java.util.List;

import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;

//管理员
public interface UserLoginInfoService {
  int insert(UserLoginInfo userLoginInfo);//管理员登录
  int updateByUserid(UserLoginInfo userLoginInfo);//更新
  int deleteByUserid(int id);//删除
  List<UserLoginInfo> selectByUidAndPassword(Integer uid,String password);
}
