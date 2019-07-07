package com.sas.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sas.pojo.Permission;
import com.sas.pojo.Personnel;
import com.sas.pojo.Role;
import com.sas.pojo.RolePermission;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.PermissionService;
import com.sas.service.PersonnelService;
import com.sas.service.RolePermissionService;
import com.sas.service.RoleService;
import com.sas.service.TestService;

/**
 * @ClassName: AdminController
 * @Description: TODO(管理员的功能控制器)
 * @author xieweipeng
 * @date 2018年4月15日 上午9:49:28
 * @version V1.0
 */

@Controller
public class TestController {

	@Resource
	private TestService testService;
	@Resource
	private RoleService roleService;
	@Resource
	private PersonnelService personnelService;
	@Resource
	private  RolePermissionService rolePermissionService;
	@Resource
	private  PermissionService permissionService;
	

	/**
	 * @Title: adminLogin
	 * @Description: TODO(管理员登录)
	 * @param @param request
	 * @param @param admin
	 * @param @param modelAndView
	 * @param @return 入参
	 * @return ModelAndView 返回类型
	 * @author xieweipeng
	 * @throws
	 * @date 2018年4月15日 上午9:55:11
	 * @version V1.0
	 */
	
	@RequestMapping(value = "login")
	@ResponseBody
	public String mobilLogin(String username,String password,HttpServletRequest request) {
		System.out.println("进入移动登录方法");
		UserLoginInfo userLoginInfo = testService.findByloginname(username,password);
		if (userLoginInfo!=null) {
			int userid =  userLoginInfo.getUserid();
			request.getSession().setAttribute("user", userLoginInfo);
			//得到个人信息
			System.out.println("登录者id---------"+userid);
			Personnel personnel = personnelService.selectPersonelById(userid);
			//得到角色
			System.out.println("登录者角色id---------"+personnel.getRoleid());
			Role role = roleService.selectRoleById(personnel.getRoleid());
			
			
				//得到权限列表对应关系
				List<RolePermission> rolePermissions = rolePermissionService.selectAllRolePermissionByRid(personnel.getRoleid());
				//得到权限
				List<Permission> pemissionlList  = new ArrayList<>();
				for (int i = 0; i < rolePermissions.size(); i++) {
					pemissionlList.add(permissionService.selectpPermissionByKey(rolePermissions.get(i).getPermissionid()));
				}
				List list2 = new ArrayList<>();
				list2.add("success");
				list2.add(personnel);
				list2.add(pemissionlList);
				String data = JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd");
				return data;
			
			
		}
		
		else {
			List list2 = new ArrayList<>();
			list2.add("fail");
			String data = JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd");
			return data;
		}
		
	}
	@RequestMapping(value = "adminlogin")
	public String adminLogin(String username,String password,HttpServletRequest request) {
		System.out.println("进入管理员登录方法");
		UserLoginInfo userLoginInfo = testService.findByloginname(username,password);
     if(userLoginInfo!=null){
		 request.getSession().setAttribute("user", userLoginInfo);
		 System.out.println(userLoginInfo.getLoginname()+"----"+userLoginInfo.getLoginpassword());
		 return "/login_main/main"; 
	 }else{
		 
		 request.setAttribute("tishi", "用户名或密码错误");
		 System.out.println("查无此人");
		 return "/login_main/login";
	 }
	}
	
}
