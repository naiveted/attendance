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
import com.sas.pojo.ClassRoom;
import com.sas.pojo.Course;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.AbsenteeismService;
import com.sas.service.AttendanceService;
import com.sas.service.ClassRoomService;
import com.sas.service.CourseService;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;
import com.sas.util.MapUtils;
import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy.Result;

@Controller
@RequestMapping("/prosceniumStudentController")
public class ProsceniumStudentController  {

	
	@Resource
	private AttendanceService attendanceService;
	@Resource
	private AbsenteeismService absenteeismService;
	@Resource
	private CourseService courseService;
	@Resource
	private ClassRoomService classRoomService;
	
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

	
		//获取所有开启签到的课程信息
			@ResponseBody
			@RequestMapping(value = "/selectAllOpenAttendanceCourse", produces = "text/html;charset=UTF-8")
			public String selectAllOpenAttendanceCourse(Integer studentid,Integer isattendance) {		
				
				List<Course> list = courseService.selectAllOpenAttendanceCourse(studentid, new Date(), isattendance);
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
			//判断是否已经签到
			@ResponseBody
			@RequestMapping(value = "/selectIsAttendance", produces = "text/html;charset=UTF-8")
			public String selectIsAttendance(Integer courseid,Integer studentid) {
				int result = attendanceService.selectIsAttendance(new Date(), courseid, studentid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				
				if (result!=0) {
					map.put("code", 404);
					map.put("msg", "您本课程已签到");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "可进入签到");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//位置判断String longitude,String latitude,
			@ResponseBody
			@RequestMapping(value = "/selectInfo", produces = "text/html;charset=UTF-8")
			public String selectInfo(Integer classroomid,String longitude,String latitude) {
				ClassRoom classRoom = classRoomService.selectClassRoomById(classroomid);
				Double range = MapUtils.GetDistance(Double.valueOf(classRoom.getLatitude()).doubleValue(), Double.valueOf(classRoom.getLongitude()).doubleValue(), Double.valueOf(latitude).doubleValue(), Double.valueOf(longitude).doubleValue());
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				
				if (range>=200.0) {
					map.put("code", 404);
					map.put("msg", "距离签到位置太远，无法签到");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "可进入签到");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//查询可以选择的座位号
			@ResponseBody
			@RequestMapping(value = "/selectOkToSeatNum", produces = "text/html;charset=UTF-8")
			public String selectOkToSeatNum(Integer courseid) {
				List<Attendance> list = attendanceService.selectOkToSeatNum(courseid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				for (int i = 0; i < list.size(); i++) {
					list2.add(list.get(i).getSeatnumber());
				}
				
				
					map.put("code", 200);
					map.put("msg", "已经被签到位置");
					map.put("data", list2);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				
			
			return data;
			}
			
			//对某门课进行签到操作
			@ResponseBody
			@RequestMapping(value = "/insertAttendance", produces = "text/html;charset=UTF-8")
			public String insertAttendance(Integer courseid,Integer studentid,String studentname,Integer seatnumber,String coursename) {
				Attendance attendance = new Attendance();			
				attendance.setCourseid(courseid);
				attendance.setCreatedate(new Date());
				attendance.setSeatnumber(seatnumber);
				attendance.setState(0);
				attendance.setCoursename(coursename);
				attendance.setStudentid(studentid);
				attendance.setStudentname(studentname);
				int result = attendanceService.insert(attendance);				
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (result==0) {
					map.put("code", 404);
					map.put("msg", "签到/请假失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "签到/请假成功");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//获取学生所有课程
			@ResponseBody
			@RequestMapping(value = "/selectAllCourseByStudent", produces = "text/html;charset=UTF-8")
			public String selectAllCourseByStudent(Integer studentid) throws java.text.ParseException {
				List<Course> list = courseService.selectCourseByStudentId(studentid);

				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (list==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", list);//课程信息
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//对某门课进行请假操作
			@ResponseBody
			@RequestMapping(value = "/insertAttendanceByLeave", produces = "text/html;charset=UTF-8")
			public String insertAttendanceByLeave(Integer courseid,Integer studentid,String studentname,String coursename,String date) throws java.text.ParseException {
				 //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  		      
		        //使用SimpleDateFormat的parse()方法生成Date  
		        Date time = sf.parse(date); 
				Attendance attendance = new Attendance();
				
				attendance.setCourseid(courseid);
				attendance.setCreatedate(time);
				attendance.setState(1);
				attendance.setCoursename(coursename);
				attendance.setStudentid(studentid);
				attendance.setStudentname(studentname);
				
				int result = attendanceService.insert(attendance);
				List<Absenteeism> absenteeisms = absenteeismService.selectallByCourseId(courseid);				
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (result==0) {
					map.put("code", 404);
					map.put("msg", "签到/请假失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "签到/请假成功");
					map.put("data", absenteeisms);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			
			//我的请假信息
			@ResponseBody
			@RequestMapping(value = "/selectAllLeave", produces = "text/html;charset=UTF-8")
			public String selectAllLeave(Integer studentid) {
				List<Attendance> result = attendanceService.selectAllLeave(studentid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				
				if (result==null) {
					map.put("code", 404);
					map.put("msg", "无请假信息");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", result);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//我的旷课信息
			@ResponseBody
			@RequestMapping(value = "/selectAllKuangKe", produces = "text/html;charset=UTF-8")
			public String selectAllKuangKe(Integer studentid) {
				List<Absenteeism> result = absenteeismService.selectallByStudent(studentid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				
				if (result==null) {
					map.put("code", 404);
					map.put("msg", "无旷课信息");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", result);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			//某个旷课课程详情
			@ResponseBody
			@RequestMapping(value = "/selectKuangKeByCourse", produces = "text/html;charset=UTF-8")
			public String selectKuangKeByCourse(Integer courseid) {
				Course course = courseService.selectCourseById(courseid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;			
				
				if (course==null) {
					map.put("code", 404);
					map.put("msg", "无旷课信息");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", course);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
			
			
			
}
