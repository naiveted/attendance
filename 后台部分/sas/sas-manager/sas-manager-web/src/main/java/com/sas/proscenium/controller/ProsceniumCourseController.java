package com.sas.proscenium.controller;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
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
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.AbsenteeismService;
import com.sas.service.AttendanceService;
import com.sas.service.ClassRoomService;
import com.sas.service.CourseAdminService;
import com.sas.service.CourseService;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.service.impl.CourseServiceImpl;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/prosceniumCourseController")
public class ProsceniumCourseController  {

	@Resource
	private CourseAdminService courseAdminService;
	@Resource
	private CourseService courseService;
	@Resource
	private AttendanceService attendanceService;
	@Resource
	private AbsenteeismService absenteeismService;
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
		* @Title: selectAllcourse 
		* @Description: TODO(教室点击开课返回可以开的课程) 
		* @param @param organizationid
		* @param @param request
		* @param @return    入参
		* @return String    返回类型
		* @author xieweipeng
		* @throws
		* @date 2018年6月12日 下午8:18:37 
		* @version V1.0
		 */
		@ResponseBody
		@RequestMapping(value = "/selectByOid", produces = "text/html;charset=UTF-8")
		public String selectAllcourseAdmin(Integer organizationid,HttpServletRequest request ) {
					
			List<CourseAdmin> list = courseAdminService.selectAllCourseAdminByOid(organizationid);								
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
		
		/*------------------------------------以下是教师端的对课程的操作接口-----------------------------*/
		@ResponseBody
		@RequestMapping(value = "/selectByTeacher", produces = "text/html;charset=UTF-8")
		public String selectAllcourse(Integer teacherid,HttpServletRequest request ) {
					
			List<Course> list = courseService.selectAllCourseByTeacherId(teacherid);								
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
		@ResponseBody
		@RequestMapping(value = "/selectById", produces = "text/html;charset=UTF-8")
		public String selectCourseById(Integer courseid,HttpServletRequest request ) {
					
			Course list = courseService.selectCourseById(courseid);							
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
		@ResponseBody
		@RequestMapping(value = "/deleteById", produces = "text/html;charset=UTF-8")
		public String deleteCourseById(Integer courseid,HttpServletRequest request ) {
					
			int result = courseService.delete(courseid);
			absenteeismService.deleteByCourse(courseid);
			attendanceService.deleteByCourseId(courseid);
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (result==0) {
				map.put("code", 404);
				map.put("msg", "删除失败");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}else {
				map.put("code", 200);
				map.put("msg", "删除成功");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}
			
			return data;
		}
		@ResponseBody
		@RequestMapping(value = "/updateById", produces = "text/html;charset=UTF-8")
		public String updateCourseById(Integer courseid ,Integer organizationid ,Integer classroomid,Integer teacherid,String coursename,
				String schooltime,String starttime,String endtime,Integer studentnum,String teachername,
				Integer courseadminid,String studentidlist,String dayofweek,HttpServletRequest request ) throws java.text.ParseException, UnsupportedEncodingException {
			/*coursename= new String(request.getParameter("coursename").getBytes("ISO8859-1"),"UTF-8");
			teachername= new String(request.getParameter("teachername").getBytes("ISO8859-1"),"UTF-8");
			dayofweek= new String(request.getParameter("dayofweek").getBytes("ISO8859-1"),"UTF-8");*/
			Course course = new Course();
			 //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  		      
	        //使用SimpleDateFormat的parse()方法生成Date  
	        Date datestart = sf.parse(starttime); 
	        Date dateend = sf.parse(endtime);
	        course.setCourseid(courseid);
	        course.setClassroomid(classroomid);
	        course.setCourseadminid(courseadminid);
	        course.setCoursename(coursename);
	        course.setDayofweek(dayofweek);
	        course.setEndtime(dateend);
	        course.setIsattendance(0);
	        course.setSchooltime(schooltime);
	        course.setOrganizationid(organizationid);
	        course.setStarttime(datestart);
	        course.setStudentidlist(studentidlist);
	        course.setStudentnum(studentnum);
	        course.setTeacherid(teacherid);
	        course.setCreatedate(new Date());		
			int result = courseService.update(course);							
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (result==0) {
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
		//插入一条课程信息
		@ResponseBody
		@RequestMapping(value = "/insert", produces = "text/html;charset=UTF-8")
		public String insert(Integer organizationid ,Integer classroomid,String classroomname,Integer classroomsize,Integer teacherid,String coursename,
				String schooltime,String starttime,String endtime,Integer studentnum,String teachername,
				Integer courseadminid,String studentidlist,String dayofweek,
				HttpServletRequest request ) throws java.text.ParseException, UnsupportedEncodingException {
			/*coursename= new String(request.getParameter("coursename").getBytes("ISO8859-1"),"UTF-8");
			teachername= new String(request.getParameter("teachername").getBytes("ISO8859-1"),"UTF-8");
			dayofweek= new String(request.getParameter("dayofweek").getBytes("ISO8859-1"),"UTF-8");*/
			Course course = new Course();
			 //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  		      
	        //使用SimpleDateFormat的parse()方法生成Date  
	        Date datestart = sf.parse(starttime); 
	        Date dateend = sf.parse(endtime);
	        course.setClassroomid(classroomid);
	        course.setCourseadminid(courseadminid);
	        course.setCoursename(coursename);
	        course.setDayofweek(dayofweek);
	        course.setEndtime(dateend);
	        course.setIsattendance(0);
	        course.setSchooltime(schooltime);
	        course.setOrganizationid(organizationid);
	        course.setStarttime(datestart);
	        course.setStudentidlist(studentidlist);
	        course.setStudentnum(studentnum);
	        course.setTeacherid(teacherid);
	        course.setCreatedate(new Date());
	        course.setClassroomname(classroomname);
	        course.setClassroomsize(classroomsize);
	        course.setTeachername(teachername);
			int result = courseService.insert(course);							
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (result==0) {
				map.put("code", 404);
				map.put("msg", "添加失败");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}else {
				map.put("code", 200);
				map.put("msg", "添加成功");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}
			
			return data;
		}
		//教师对课程进行开始签到
		@ResponseBody
		@RequestMapping(value = "/updateFlagById", produces = "text/html;charset=UTF-8")
		public String updateCourseByFalg(Integer Flag,Integer courseid,HttpServletRequest request ) {
			List<Absenteeism> list = absenteeismService.selectallByCourseIdAndTime(courseid, new Date());
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (list!=null && !list.isEmpty()) {
				map.put("code", 404);
				map.put("msg", "今天该课程已经进行签到，如果需要重新签到，请删除该条签到统计信息!");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				
				
			}else {
				
				Course  course = new Course();
				course.setCourseid(courseid);
				course.setIsattendance(Flag);
				int result = courseService.updateSelect(course);							
				
				if (result==0) {
					map.put("code", 404);
					map.put("msg", "更新失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "更新成功");
					map.put("data", list);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			}
			
			return data;
		}
		//教师对课程进行关闭签到
				@ResponseBody
				@RequestMapping(value = "/updateFlagClose", produces = "text/html;charset=UTF-8")
				public String updateFlagClose(Integer Flag,Integer courseid,HttpServletRequest request ) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					String data  = null;
					
						Course  course = new Course();
						course.setCourseid(courseid);
						course.setIsattendance(Flag);
						int result = courseService.updateSelect(course);							
						
						if (result==0) {
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
		//教师对课程签到信息进行整体删除
				@ResponseBody
				@RequestMapping(value = "/deleteAbsenteeism", produces = "text/html;charset=UTF-8")
				public String deleteAbsenteeism(Integer courseid,HttpServletRequest request ) {
					int result = absenteeismService.delete(courseid, new Date());
					HashMap<String, Object> map = new HashMap<String, Object>();
					String data  = null;
					if (result==0) {
						map.put("code", 404);
						map.put("msg", "删除失败");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}else {
						map.put("code", 200);
						map.put("msg", "删除成功");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}
					
					return data;
				}
		//关闭签到是，对签到信息进行汇总统计
		@ResponseBody
		@RequestMapping(value = "/insertAbsenteeism", produces = "text/html;charset=UTF-8")
		public String insertAbsenteeism(Integer courseid,String coursename,HttpServletRequest request ) throws java.text.ParseException {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nowdayTime = dateFormat.format(date);
			Date nowDate = dateFormat.parse(nowdayTime);
			
			Absenteeism absenteeism = new Absenteeism();
			
			absenteeism.setCreatetime(nowDate);
			//找到课程信息
			Course course = courseService.selectCourseById(courseid);
			//根据上课信息中的学生名单list来找签到表中的学生
			String[] str = course.getStudentidlist().split(",");
			//初始化签到人数，请假人数...；
			Integer AtteanceNum = 0;//签到
			Integer LeaveNum = 0;//请假
			Integer absenteeismnum = 0;//旷课
			String AbsenteeismList =",";//旷课名单
			ArrayList<Integer> studentList1 = new ArrayList<Integer>();//初始化学生列表
			ArrayList<Integer> studentList2 = new ArrayList<Integer>();//初始化学生列表
			ArrayList<Integer> studentList3 = new ArrayList<Integer>();//初始化学生列表
			//将学生id int化
			for (int i = 0; i < str.length-1; i++) {
				System.out.println("for--找到学生id信息--："+str[i+1]);
				studentList1.add( Integer.parseInt(str[i+1]));//根据课程拿到这门课的学生id
				studentList2.add(Integer.parseInt(str[i+1]));//根据课程拿到这门课的学生id
			}
			//得到缺课名单
			List<Attendance> attendances = attendanceService.selectAttendanceList(studentList1, nowDate, courseid);//所有进行签到、请假操作的
			
			System.out.println("签到和请假总人数"+attendances.size());
			
			for (int i = 0; i < attendances.size(); i++) {
				for (int j = 0; j < studentList1.size(); j++) {
					if (attendances.get(i).getStudentid()==studentList1.get(j)) {
						//如果签到名单里面有在学生名单里，则在学生名单删除这个学生
						studentList1.remove(j);
						break;
					}
				}
			}//最终就得到缺课名单
			absenteeismnum = studentList1.size();//得到缺课人数
			for (int i = 0; i < studentList1.size(); i++) {
				AbsenteeismList = AbsenteeismList+studentList1.get(i).toString()+",";
			}
			//得到正常签到人数
			AtteanceNum = attendanceService.deleteList(studentList2, nowDate, courseid);
			//得到请假人数
			LeaveNum = attendanceService.selectLeaveAttendance(studentList2, nowDate, courseid).size();
			
			//上需信息准备完毕，封装实体
			absenteeism.setAbsenteeismlist(AbsenteeismList);
			absenteeism.setAtteancenum(AtteanceNum);
			absenteeism.setLeavenum(LeaveNum);
			absenteeism.setCourseid(courseid);
			absenteeism.setAbsenteeismnum(absenteeismnum);
			absenteeism.setCoursename(coursename);
			//插入数据
			int result = absenteeismService.insert(absenteeism);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (result==0) {
				map.put("code", 404);
				map.put("msg", "添加失败");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}else {
				map.put("code", 200);
				map.put("msg", "添加成功");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}
			
			return data;
		}
		//查看座位号被签到了
		@ResponseBody
		@RequestMapping(value = "/selectAttendanceByState", produces = "text/html;charset=UTF-8")
		public String selectAttendanceByState(Integer courseid,Integer state,HttpServletRequest request ) throws java.text.ParseException {
			
			List<Attendance> attendances = attendanceService.selectAttendanceByCourseIdAndTimeAndState(courseid, state, new Date());					
			HashMap<String, Object> map = new HashMap<String, Object>();
			String data  = null;
			if (attendances==null) {
				map.put("code", 404);
				map.put("msg", "获取失败");
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}else {
				map.put("code", 200);
				map.put("msg", "获取成功");
				map.put("data", attendances);
				data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
			}
			
			return data;
		}
		//老师删除座位号被假冒签到
				@ResponseBody
				@RequestMapping(value = "/deleteAttendance", produces = "text/html;charset=UTF-8")
				public String deleteAttendance(Integer aid) throws java.text.ParseException {
					int result = attendanceService.delete(aid);
					HashMap<String, Object> map = new HashMap<String, Object>();
					String data  = null;
					if (result==0) {
						map.put("code", 404);
						map.put("msg", "删除失败");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}else {
						map.put("code", 200);
						map.put("msg", "删除成功");
						data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
					}
					
					return data;
				}
		

}
