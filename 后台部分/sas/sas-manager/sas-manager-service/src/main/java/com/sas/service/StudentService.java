package com.sas.service;

import java.util.List;

import com.sas.pojo.Absenteeism;
import com.sas.pojo.Attendance;
import com.sas.pojo.AttendanceExample;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserLoginInfo;


public interface StudentService {
	
	int insert(Attendance attendance);//签到
	int update(Attendance attendance);//学生签退
	int delete(Integer aId);//删除错误签到
	Integer selectAttendenceCourse(Integer studentId);//查询签到课程
	int insertAbsenteeism(Absenteeism absenteeism);//新增旷课信息
	List<Absenteeism> selectAbsenteeism(int aId,int courseId);//查询旷课信息
	int updateAbsenteeism(Absenteeism absenteeism);//修改旷课信息
	// --------------------------
	List<Attendance> selectAttendance(int courseId,int studentId);
	int selectAbsence(int courseId, int studentId, int status);
	int login(String loginName,String loginPassWord); //学生登录
}
