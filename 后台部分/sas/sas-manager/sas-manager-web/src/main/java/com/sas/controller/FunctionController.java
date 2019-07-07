package com.sas.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Permission;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.OrganizationService;
import com.sas.service.PermissionService;

@Controller
@RequestMapping("/setFunction")
public class FunctionController  {

	@Resource
	private PermissionService permissionService;

	@RequestMapping("/main")
	public String selectAll( HttpServletRequest request) {
		UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
		System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
		if (userLoginInfo.getOrganizationid()==0) {
			List<Permission> permissions = permissionService.selectAll();
			request.getSession().setAttribute("departments", permissions);
		}
		else {
			List<Permission> permissions = permissionService.selectAllByOId(userLoginInfo.getId());
			request.getSession().setAttribute("departments", permissions);
		}
		
		return "/renshiguanli/gongnengguanli/main";
	}

	// 修改功能
	 @ResponseBody
	@RequestMapping("/update")
	public String update(Integer fatherid, String name,Integer departmentid,String url) {
		 Permission t = new Permission();
			t.setName(name);
			t.setId(departmentid);
			t.setUrl(url);
			if (fatherid!=null) {
				t.setParentid(fatherid);
			}
			
			return "" + permissionService.update(t);
	}

	
	// 新增功能
	 
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(Integer fatherid, String name,String url) {
		Permission t = new Permission();
		t.setParentid(fatherid);
		t.setName(name);
		t.setUrl(url);
		if (fatherid!=null) {
			t.setParentid(fatherid);
		}
		
		return "" + permissionService.insert(t);
	}
	
	// 删除功能
		@ResponseBody
		@RequestMapping("/delete")
		public String delete(Integer departmentid) {
			Permission t = new Permission();
				
				t.setId(departmentid);
				
				return "" + permissionService.delete(t);
		}
		 /**
		  * list转json
		  * */
		public <T> String listToJson(List<T> t) {
			JSONArray sjArray = JSONArray.fromObject(t);
			String str = sjArray.toString();
			return str;
		}
		/** 获取所有功能 绑定ztree
		  * */
		@ResponseBody
		@RequestMapping(value = "/selectFunction", produces = "text/html;charset=UTF-8")
		public String selectFunction(HttpServletRequest request) {
			UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
			System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
			String str = null;
			if (userLoginInfo.getOrganizationid()==0) {
					List<Permission> departments = permissionService.selectAll();
					str = listToJson(departments);
				}
			else {
					List<Permission> departments = permissionService.selectAllByOId(userLoginInfo.getOrganizationid());
					 str = listToJson(departments);
				}
				
			return str;
			}

	
}
