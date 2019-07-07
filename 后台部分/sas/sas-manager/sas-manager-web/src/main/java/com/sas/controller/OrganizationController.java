package com.sas.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.OrganizationService;

@Controller
@RequestMapping("/setDeparment")
public class OrganizationController  {

	@Resource
	private OrganizationService organizationService;

	@RequestMapping("/main")
	public String selectAll( HttpServletRequest request) {
		System.out.println("连接成功------------------------------连接成功");
		UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
		System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
		if (userLoginInfo.getOrganizationid()==0) {
			List<OrganizationDictionary> departments = organizationService.selectAll();
			request.getSession().setAttribute("departments", departments);
		}
		else {
			List<OrganizationDictionary> departments = organizationService.selectAllByOId(userLoginInfo.getOrganizationid());
			request.getSession().setAttribute("departments", departments);
		}
		
		return "/renshiguanli/jigoushezhi/main";
	}

	// 修改机构
	 @ResponseBody
	@RequestMapping("/update")
	public String update(Integer fatherid, String name,Integer departmentid) {
		 OrganizationDictionary t = new OrganizationDictionary();
			t.setOrganizationname(name);
			t.setOrganizationid(departmentid);
			if (fatherid!=null) {
				t.setParentid(fatherid);
			}
			
			return "" + organizationService.update(t);
	}

	
	// 新增机构
	 
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(Integer fatherid, String name) {
		OrganizationDictionary t = new OrganizationDictionary();
		t.setOrganizationname(name);
		if (fatherid!=null) {
			t.setParentid(fatherid);
		}
		
		return "" + organizationService.insert(t);
	}
	
	// 删除机构
		@ResponseBody
		@RequestMapping("/delete")
		public String delete(Integer departmentid) {
			 OrganizationDictionary t = new OrganizationDictionary();
				
				t.setOrganizationid(departmentid);
				
				return "" + organizationService.delete(t);
		}

	
}
