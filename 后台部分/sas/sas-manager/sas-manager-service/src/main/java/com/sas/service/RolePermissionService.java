package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.Role;
import com.sas.pojo.RolePermission;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface RolePermissionService {
	List<RolePermission> selectAllRolePermission(Integer schoolid);//根据机构id查找所有角色名称
	List<RolePermission> selectAllRolePermissionByRid(Integer roleid);//根据机构id查找所有角色名称
	int insert(RolePermission rolePermission);//添加角色
	int update(RolePermission rolePermission);//更新角色
	int delete(Integer roleId);//删除角色
	Role selectTeacherById(int rolePermissionId);//根据id查找角色
}
