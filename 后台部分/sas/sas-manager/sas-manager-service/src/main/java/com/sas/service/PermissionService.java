package com.sas.service;

import java.util.List;

import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Permission;


public interface PermissionService {
	List<Permission> selectAll();//所有机构名称遍历
	List<Permission> selectAllByOId(int oid);//所有机构名称遍历
	int insert(Permission permission);//添加机构
	int update(Permission permission);//添加机构
	int delete(Permission permission);//添加机构
	Permission selectpPermissionByKey(Integer pid);//根据id查找
}
