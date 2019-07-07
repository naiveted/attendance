package com.sas.service;

import com.sas.pojo.UserLoginInfo;

//管理员
public interface TestService {
  UserLoginInfo findByloginname(String adminName,String password);//管理员登录
}
