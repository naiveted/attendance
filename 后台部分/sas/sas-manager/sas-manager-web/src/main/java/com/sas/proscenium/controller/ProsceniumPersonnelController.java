package com.sas.proscenium.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sas.mapper.UserInfoMapper;
import com.sas.pojo.Absenteeism;
import com.sas.pojo.Attendance;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.AbsenteeismService;
import com.sas.service.AttendanceService;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;
import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy.Result;

@Controller
@RequestMapping("/prosceniumPersonnelController")
public class ProsceniumPersonnelController  {

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
	@Resource
	private AttendanceService attendanceService;
	@Resource
	private AbsenteeismService absenteeismService;
	
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
		//获取所有学生信息
			@ResponseBody
			@RequestMapping(value = "/selectAllStudent", produces = "text/html;charset=UTF-8")
			public String selectAllstudent(Integer organizationid,Integer roleid) {
				System.out.println("进入方法"+organizationid);
				ArrayList<Integer> oidList = new ArrayList<Integer>();
				if (organizationid==null) {
					System.out.println("查询的时候没有选oid默认为最大机构");
					
					organizationid=0;
				}
				if (organizationid==0) {
					List<OrganizationDictionary> departments = organizationService.selectAll();
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}
				else {
					List<OrganizationDictionary> departments = organizationService.selectAllByOId(organizationid);
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}			
				
				List<Personnel> list = personnelService.selectAllStudent(oidList, roleid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (list==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", list);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			/*//获取该课程学生请假信息汇总
			@ResponseBody
			@RequestMapping(value = "/selectAllLeaveStudent", produces = "text/html;charset=UTF-8")
			public String selectAllstudentQingJia(Integer courseid,Integer state) {
				List<Attendance> attendancesQingJia = attendanceService.selectAttendanceByCourseId(courseid, state);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (attendancesQingJia==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", attendancesQingJia);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}*/
			//获取该课程所有旷课统计信息
			@ResponseBody
			@RequestMapping(value = "/selectAllLeaveStudentTime", produces = "text/html;charset=UTF-8")
			public String selectAllstudentQingJia(Integer courseid) {
				List<Absenteeism> absenteeisms = absenteeismService.selectallByCourseId(courseid);				
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (absenteeisms==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", absenteeisms);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//获取该课程某天的旷课信息
			@ResponseBody
			@RequestMapping(value = "/selectAllLeaveStudentOnDay", produces = "text/html;charset=UTF-8")
			public String selectAllstudentQingJiaByTime(Integer courseid,String date,Integer state) throws java.text.ParseException {
				 //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  		      
		        //使用SimpleDateFormat的parse()方法生成Date  
		        Date time = sf.parse(date); 
				List<Absenteeism> absenteeisms = absenteeismService.selectallByCourseIdAndTime(courseid, time);			
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (absenteeisms!=null && !absenteeisms.isEmpty()) {
					List<Attendance> attendancesQingJia = attendanceService.selectAttendanceByCourseIdAndTimeAndState(courseid, state, time);					
					String[] str = absenteeisms.get(0).getAbsenteeismlist().split(",");		
					ArrayList<Integer> studentList1 = new ArrayList<Integer>();//初始化学生列表
					//将学生id int化;
					for (int i = 0; i < str.length-1; i++) {
						System.out.println("for--找到学生id信息--："+str[i+1]);
						studentList1.add( Integer.parseInt(str[i+1]));
					}
					List<Personnel> personnels =  personnelService.selectAllStudentByListIds(studentList1);//旷课人的信息
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", personnels);//旷课人信息
					map.put("absenteeisms", absenteeisms.get(0));//签到统计信息
					map.put("attendancesQingJia", attendancesQingJia);//请假人员信息
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 404);
					map.put("msg", "该日期下无考勤情况");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");					
					
				}
			
			return data;
			}
			//更改个人信息（学生和老师共同接口）
			@ResponseBody
			@RequestMapping(value = "/updatePersonInfo", produces = "text/html;charset=UTF-8")
			public String updatePersonInfo(Integer id, String email,Integer sex,String peoplenum,Integer age) throws java.text.ParseException {
				Personnel personnel =  new  Personnel();
				personnel.setId(id);
				personnel.setEmail(email);
				personnel.setPeoplenum(peoplenum);
				personnel.setAge(age);
				personnel.setSex(sex);
				int Result = personnelService.update(personnel);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (Result==0) {
					map.put("code", 404);
					map.put("msg", "更新失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "更新成功");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//修改密码（学生和老师共同接口）
			@ResponseBody
			@RequestMapping(value = "/updatePassword", produces = "text/html;charset=UTF-8")
			public String updatePersonInfo(Integer id, String password,String newpassword) throws java.text.ParseException {
				List<UserLoginInfo> lists = userLoginInfoService.selectByUidAndPassword(id, password);
				UserLoginInfo userLoginInfo = new UserLoginInfo();
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (lists!=null && !lists.isEmpty()) {
					userLoginInfo = lists.get(0);
					userLoginInfo.setLoginpassword(newpassword);
					int Result = userLoginInfoService.updateByUserid(userLoginInfo);
					if (Result==0) {
						map.put("code", 404);
						map.put("msg", "密码更新失败");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}else {
						map.put("code", 200);
						map.put("msg", "密码更新成功");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}
				}
				else {
					map.put("code", 405);
					map.put("msg", "原密码错误");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					
					
				}

			return data;
			}
			
			
}
