package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.Role;
import com.sas.pojo.RolePermission;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface RoleService {
	List<Role> selectAllRole(Integer schoolid);//根据机构id查找所有角色名称
	int insert(Role role);//添加角色
	int update(Role role);//更新角色
	int delete(Integer roleid);//删除角色
	Role selectRoleById(int roleid);//根据id查找角色
}
