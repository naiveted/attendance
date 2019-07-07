package com.sas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.sas.pojo.Attendance;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.Course;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface AttendanceService {
	int insert(Attendance attendance);//添加
	int update(Attendance attendance);//更新
	int deleteList(ArrayList<Integer> attendancelist,Date date,Integer courseid);//删除
	Attendance selectAttendanceById(int attendanceid);//根据id查找
	List<Attendance> selectLeaveAttendance(ArrayList<Integer> attendancelist,Date date,Integer courseid);//根据教师所属机构查找教室
	List<Attendance> selectAttendanceList(ArrayList<Integer> attendancelist,Date date,Integer courseid);//根据教师所属机构查找教室
	List<Attendance> selectAttendanceByCourseId(Integer courseid,Integer state);//根据教师所属机构查找教室
	List<Attendance> selectAttendanceByCourseIdAndTimeAndState(Integer courseid,Integer state,Date date);//根据教师所属机构查找教室
	int delete(Integer aid);//删除
	int selectIsAttendance(Date date,Integer courseid,Integer studentid);//删除
	List<Attendance> selectAllLeave(Integer studentid);//查找请假信息
	List<Attendance> selectOkToSeatNum(Integer courseid);//查找请假信息
	int deleteByCourseId(Integer aid);//删除
	
}

