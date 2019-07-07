package com.sas.proscenium.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sas.pojo.Absenteeism;
import com.sas.pojo.Attendance;
import com.sas.service.OrganizationService;
import com.sas.service.StudentService;
import com.sas.service.TeacherService;

@Controller
@RequestMapping("/studentController")
public class StudentController {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private TeacherService teacherService;

	@Resource
	private StudentService studentService;

	
	/** 
	 * 查询签到课程
	 * */
	@ResponseBody
	@RequestMapping( "/selectAttendanceCourse")
	public Integer selectAttendenceCourse(Integer studentId) throws Exception {
//	    studentId=49;
	    Integer result = studentService.selectAttendenceCourse(studentId);
		return result;
	}
	
	
	/** 
	 * 签到
	 * */
	@ResponseBody
	@RequestMapping( "/insertAttendance")
	public int insertAttence(Attendance attendance) throws Exception {
	
//		attendance.setAid(3);
		// attendance.setSigndesktime(signdesktime);

		System.out.println("进入签到控制器方法" + attendance.getAid());
//		System.out.println(attendance.getCourseid());

		int result = studentService.insert(attendance);
		return result;
	}
	
		/** 
		 * 签退.对attendance表修改
		 * */
		@ResponseBody
		@RequestMapping( "/updateAttendance")
		public int updateAttendance(Attendance attendance) throws Exception {
		
			attendance.setAid(3);
			attendance.setCourseid(1);
			int result = studentService.update(attendance);
			return result;
		}
		
		/** 
		 * 删除.对attendance表修改
		 * */
		@ResponseBody
		@RequestMapping( "/deleteAttendance")
		public int deleteAttendance(Integer aId) throws Exception {

			int result = studentService.delete(aId);
			return result;
		}
		
		
		/** 
		 * 新增学生旷课信息
		 * */
		@ResponseBody
		@RequestMapping( "/insertAbsenteeism")
		public int insertAbsenteeism(Absenteeism absenteeism) throws Exception {
			absenteeism.setAid(1);
			absenteeism.setCourseid(2);
			int result =0;
			result = studentService.insertAbsenteeism(absenteeism);
			return result;
		}
		/** 
		 * 查询学生旷课信息
		 * */
		@ResponseBody
		@RequestMapping( "/selectAbsenteeism")
		public List<Absenteeism>selectAbsenteeism(Integer aId,Integer courseId) throws Exception {
			aId=1;
			courseId=2;
			List<Absenteeism> result = studentService.selectAbsenteeism(aId, courseId);
//			result =  AbsenteeismServiceImpl.insert(absenteeism);
			return result;
		}
		/** 
		 * 修改学生旷课信息
		 * */
		@ResponseBody
		@RequestMapping( "/updataAbsenteeism")
		public int updataAbsenteeism(Absenteeism absenteeism) throws Exception {
			absenteeism.setAid(1);
			absenteeism.setCourseid(3);
			int result = studentService.updateAbsenteeism(absenteeism);
//			result =  AbsenteeismServiceImpl.insert(absenteeism);
			return result;
		}
		
		
//	*****************************
//		
//	****************************
		/** 
		 * 查询学生课程签到状态
		 * */
		@ResponseBody
		@RequestMapping( "/selectAttendance")
		public List<Attendance> selectAttendance(Integer courseId,Integer studentId) throws Exception {
		
			List <Attendance> result =new ArrayList<>();
			result = studentService.selectAttendance(1, 1);
//			result = studentService.selectAttendance(courseId, studentId);
			System.out.println(result.size());
			return result;
		}
		
		
		/** 
		 * 查询学生课程旷课状态
		 * */
		@ResponseBody
		@RequestMapping( "/selectAbsence")
		public int selectAbsence(Integer courseId,Integer studentId,Integer status) throws Exception {
		
			int result =0;
//			result = studentService.selectAbsence(courseId, studentId, status);
			result = studentService.selectAbsence(1, 1,2);
			return result;
		}
		
		
		

}
