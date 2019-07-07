package com.sas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.Course;
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface CourseService {
	List<Course> selectAllCourseByTeacherId(Integer teacherid);//根据老师id遍历课程
	int insert(Course course);//添加
	int update(Course Course);//更新
	int delete(Integer courseid);//删除
	Course selectCourseById(int courseid);//根据id查找
	int updateSelect(Course Course);//更新部分
	List<Course> selectAllOpenAttendanceCourse(Integer studentid,Date date ,Integer isAttendances);//查找开启签到的课程
	List<Course> selectCourseByStudentId(Integer studentid);//查找学生的课程
}
