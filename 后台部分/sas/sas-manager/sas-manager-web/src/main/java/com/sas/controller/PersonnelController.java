package com.sas.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.UserInfoMapper;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/personnelController")
public class PersonnelController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private PersonnelService personnelService;
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private UserLoginInfoService userLoginInfoService;
	@Resource
	private UserInfoService userInfoService;
	/** 员工管理 **/
	@RequestMapping("/selectStaff")
	public String redirect() {
		return "/renshiguanli/renyuanluru/staff";
	}
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

	/** 获取部门 绑定ztree
	  * */
		@ResponseBody
		@RequestMapping(value = "/selectDepartment", produces = "text/html;charset=UTF-8")
		public String selectDepartment(HttpServletRequest request) {
			UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
			System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
			String str = null;
			if (userLoginInfo.getOrganizationid()==0) {
				List<OrganizationDictionary> departments = organizationService.selectAll();
				 str = listToJson(departments);
			}
			else {
				List<OrganizationDictionary> departments = organizationService.selectAllByOId(userLoginInfo.getOrganizationid());
				 str = listToJson(departments);
			}
			
			return str;
		}
		/**
		 * 
		* @Title: selectAllStaff 
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param departmentid
		* @param @param pageNum
		* @param @param pageSize
		* @param @param request
		* @param @return    入参
		* @return String    返回类型
		 */
		@ResponseBody
		@RequestMapping(value = "/selectAllTeacher", produces = "text/html;charset=UTF-8")
		public String selectAllStaff(Integer departmentid,@RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "5") Integer pageSize,HttpServletRequest request,Integer jobnum,String peoplenum,String teachername,Integer roleid) {
			System.out.println("进入方法"+departmentid);
			ArrayList<Integer> oidList = new ArrayList<Integer>();
			if (departmentid==null) {
				System.out.println("查询的时候没有选oid默认为最大机构");
				
				departmentid=0;
			}
			if (departmentid==0) {
				List<OrganizationDictionary> departments = organizationService.selectAll();
				for (int i = 0; i < departments.size(); i++) {
					oidList.add(departments.get(i).getOrganizationid());
				}
			}
			else {
				List<OrganizationDictionary> departments = organizationService.selectAllByOId(departmentid);
				for (int i = 0; i < departments.size(); i++) {
					oidList.add(departments.get(i).getOrganizationid());
				}
			}			
			
			PageInfo<Personnel> pageInfo = personnelService.selectAllPersonnel(pageNum, pageSize,oidList,jobnum,peoplenum,teachername,roleid);
			List<Personnel> list = pageInfo.getList();
			//String teachers = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
			List list2 = new ArrayList<>();
			list2.add(list);
			list2.add(pageInfo);
			if (pageNum!=1) {
				request.getSession().removeAttribute("pageInfo");
				request.getSession().setAttribute("pageInfo", pageInfo);			
				
			}
			request.getSession().setAttribute("pageInfo", pageInfo);
			//System.out.println(pageInfo.getPages()+"------"+list.get(0).getTeachername());
			String data = JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd");
			return data;
		}
		
		/**
		 * 
		* @Title: insertTeacher 
		* @Description: TODO(新增教师信息) 
		* @param @param teacher
		* @param @param entrytimes
		* @param @param file_img
		* @param @return
		* @param @throws Exception    入参
		* @return String    返回类型
		 */
		
			@ResponseBody
			@RequestMapping(value = "/insertTeacher", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String insertTeacher(Personnel personnel,String entrytimes, MultipartFile file_img,String username,String password,HttpServletRequest request,HttpServletResponse response)
					throws Exception {	
				System.out.println("权限id为"+personnel.getRoleid());
				/*String name =request.getParameter("name");
				name = new String(name.getBytes("ISO-8859-1"),"UTF-8");		
				personnel.setName(name);*/
				personnel.setId(null);
		        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
		        try {  
		            //使用SimpleDateFormat的parse()方法生成Date  
		            Date date = sf.parse(entrytimes);  
		            personnel.setEntrytime(date);
		             
		        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
				if (file_img.getSize() > 0) {
					personnel.setImage(CommonMethod.saveFile(file_img, "headImg/"));
				}
				
				System.out.println("进入老师控制器方法"+personnel.getName());
				System.out.println(personnel.getOrganizationid());
				System.out.println(entrytimes);
				int uid= personnelService.insert(personnel);
				//添加登录信息
				UserLoginInfo userLoginInfo = new UserLoginInfo();
				userLoginInfo.setLoginname(username);
				userLoginInfo.setOrganizationid(personnel.getOrganizationid());
				userLoginInfo.setLoginpassword(password);
				userLoginInfo.setUserid(uid);
				//添加账户信息
				UserInfo userInfo = new UserInfo();
				userInfo.setAccountname(username);
				userInfo.setId(uid);
				//添加用户角色对应关系
				UserRole userRole = new UserRole();
				userRole.setRolId(personnel.getRoleid());
				userRole.setUserid(uid);				
				int flag1 = userInfoService.insert(userInfo);
				int flag2 = userLoginInfoService.insert(userLoginInfo);
				String result =  Integer.toString(userRoleService.insert(userRole)*flag1*flag2);
				
				return result;
			}
			/**
			 * 
			* @Title: updateStaff 
			* @Description: TODO(修改教师信息) 
			* @param @param teacher
			* @param @param entrytimes
			* @param @param file_img
			* @param @return
			* @param @throws Exception    入参
			* @return String    返回类型
			 */
			
		    
			@ResponseBody
			@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String updateStaff(Personnel personnel,String entrytimes,Integer id,String username,String password, MultipartFile file_img,HttpServletRequest request,HttpServletResponse response)
					throws Exception {
				System.out.println("当前更新的用户id为:"+personnel.getId()+"-------"+id+"-----"+personnel.getName());
				System.out.println("当前更新的用户id为:"+personnel.getId()+"-------"+id+"-----"+personnel.getName());
				System.out.println("当前更新的用户id为:"+personnel.getId()+"-------"+id+"-----"+personnel.getName());
				System.out.println("当前更新的用户id为:"+personnel.getId()+"-------"+id+"-----"+personnel.getName());
				System.out.println("当前更新的用户id为:"+personnel.getId()+"-------"+id+"-----"+personnel.getName());
				
				/*String name=request.getParameter("username");
				System.out.println("假设拿到的中文是乱码"+name);
				username = new String( request.getParameter( "username" ).getBytes( "ISO8859-1" ), "utf-8" );
				System.out.println("重新编码得到的是"+username);
				System.out.println("重新编码得到的是"+username);
				System.out.println("重新编码得到的是"+username);
				System.out.println("重新编码得到的是"+username);
				personnel.setName(username);*/
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
			        try {  
			            //使用SimpleDateFormat的parse()方法生成Date  
			            Date date = sf.parse(entrytimes);  
			            personnel.setEntrytime(date);
			             
			        } catch (ParseException e) {  
			            e.printStackTrace();  
			        }
				if (file_img.getSize() > 0) {
					CommonMethod.deleteFile("C:\\xwp\\upload\\pic\\"
							+ personnel.getImage());
					personnel.setImage(CommonMethod.saveFile(file_img, "headImg/"));
				}
				
				//更新登录信息
				UserLoginInfo userLoginInfo = new  UserLoginInfo();
				//userLoginInfo.setLoginname(username);
				//userLoginInfo.setLoginpassword(password);
				userLoginInfo.setOrganizationid(personnel.getOrganizationid());
				userLoginInfo.setUserid(personnel.getId());			
				userLoginInfoService.updateByUserid(userLoginInfo);
				//更新用户角色信息
				UserRole userRole = new UserRole();
				userRole.setUserid(id);
				userRole.setRolId(personnel.getRoleid());
				userRoleService.updateByUserid(userRole);
				
				
				
				String i = Integer.toString(personnelService.update(personnel));
				return i;
			}

			/**
			 * 
			* @Title: selectById 
			* @Description: TODO(根据ID查询要修改教师的数据) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			 */
			 
			@ResponseBody
			@RequestMapping(value = "/selectByTeacherid", produces = "text/html;charset=UTF-8")
			public String selectById(Integer teacherid) {
				Personnel personnel =  personnelService.selectPersonelById(teacherid);
				String data = JSON.toJSONStringWithDateFormat(personnel, "yyyy-MM-dd");
				return data;
			}
			/**
			 * 
			* @Title: delete 
			* @Description: TODO(根据教师id删除老师) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			 */
			@ResponseBody
			@RequestMapping(value = "/deleteTeacher", produces = "text/html;charset=UTF-8")
			public String delete(int teacherid) {	
				int flag1 = userInfoService.deleteByUserid(teacherid);
				int flag2 = userLoginInfoService.deleteByUserid(teacherid);
				int flag3 = userRoleService.deleteByUserid(teacherid);
				int flag4 = personnelService.delete(teacherid);
				System.out.println(flag4+"---"+flag1+"---"+flag2+"---"+flag3);
				return Integer.toString(flag4*flag1);
			}

	
}
