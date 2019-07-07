package com.sas.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.RoleMapper;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Role;
import com.sas.pojo.RolePermission;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.OrganizationService;
import com.sas.service.RolePermissionService;
import com.sas.service.RoleService;
import com.sas.service.TeacherService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/roleController")
public class RoleController  {

	@Resource
	private RoleService roleService;
	@Resource
	private RolePermissionService rolePermissionService;

	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}
		/**
		 * 
		* @Title: selectAllRole 
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param request
		* @param @return    入参
		* @return String    返回类型
		 */
		@ResponseBody
		@RequestMapping(value = "/selectAllRole", produces = "text/html;charset=UTF-8")
		public String selectAllRoleBySchoolId(HttpServletRequest request) {
			UserLoginInfo userLoginInfo =  (UserLoginInfo)request.getSession().getAttribute("user");
			int schoolid = userLoginInfo.getOrganizationid();
			String data = JSON.toJSONStringWithDateFormat(roleService.selectAllRole(schoolid), "yyyy-MM-dd");
			return data;
		}
		
		
		//删除角色
		@ResponseBody
		@RequestMapping(value = "/deleteRole", produces = "text/html;charset=UTF-8")
		public String deleteRole(Integer roleid) {	
			int flag = rolePermissionService.delete(roleid)>0?1:0;
			return Integer.toString(roleService.delete(roleid)*flag);
		}
		//添加角色
		@ResponseBody
		@RequestMapping(value = "/addRole", produces = "text/html;charset=UTF-8")
		public String addRole(HttpServletRequest request,String list,String name) {
			int flag = 0;
			UserLoginInfo userLoginInfo =  (UserLoginInfo)request.getSession().getAttribute("user");
			int schoolid = userLoginInfo.getOrganizationid();
			Role role = new Role();
			role.setRolename(name);
			role.setSchoolid(schoolid);
			int key = roleService.insert(role);
			System.out.println("key--"+ key);
			System.out.println(list);
			List<String> list2 = new ArrayList<>();
			String str[] = list.split(",");
			list2 = Arrays.asList(str);
			for (int i = 0; i < list2.size(); i++) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleid(key);
				rolePermission.setPermissionid(Integer.parseInt(list2.get(i)));
				flag = rolePermissionService.insert(rolePermission);
			}
			
			
			return Integer.toString(flag);
		}
		//修改角色
		@ResponseBody
		@RequestMapping(value = "/updateRole", produces = "text/html;charset=UTF-8")
		public String updateRole(HttpServletRequest request,String list,String name,Integer rid) {
			int flag = rolePermissionService.delete(rid)>0?1:0;
			Role role = new Role();
			role.setRolename(name);
			role.setRoleid(rid);
			roleService.update(role);
			List<String> list2 = new ArrayList<>();
			String str[] = list.split(",");
			list2 = Arrays.asList(str);
			for (int i = 0; i < list2.size(); i++) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleid(rid);
				rolePermission.setPermissionid(Integer.parseInt(list2.get(i)));
				flag = rolePermissionService.insert(rolePermission);
			}
			return Integer.toString(flag);
		}
		//根据roleid查询
		@ResponseBody
		@RequestMapping(value = "/selectRoleById", produces = "text/html;charset=UTF-8")
		public String selectRoleById(HttpServletRequest request,Integer id) {
			
			
			List list2 = new ArrayList<>();
			list2.add(roleService.selectRoleById(id));
			list2.add(rolePermissionService.selectAllRolePermissionByRid(id));
			String data = JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd");
			return data;
		}
		
		
	
}
