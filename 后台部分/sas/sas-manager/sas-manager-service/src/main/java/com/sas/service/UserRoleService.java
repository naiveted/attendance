package com.sas.service;

import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;

//管理员
public interface UserRoleService {
  int insert(UserRole userRole);//管理员登录
  int updateByUserid(UserRole userRole);//更新
  int deleteByUserid(int id);//删除
}
