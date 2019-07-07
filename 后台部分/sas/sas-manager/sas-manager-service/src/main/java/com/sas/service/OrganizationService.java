package com.sas.service;

import java.util.List;

import com.sas.pojo.OrganizationDictionary;


public interface OrganizationService {
	List<OrganizationDictionary> selectAll();//所有机构名称遍历
	List<OrganizationDictionary> selectAllByOId(int oid);//所有机构名称遍历
	int insert(OrganizationDictionary organizationDictionary);//添加机构
	int update(OrganizationDictionary organizationDictionary);//添加机构
	int delete(OrganizationDictionary organizationDictionary);//添加机构
}
