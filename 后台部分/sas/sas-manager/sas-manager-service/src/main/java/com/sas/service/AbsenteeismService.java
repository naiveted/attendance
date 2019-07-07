package com.sas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.sas.pojo.Absenteeism;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.Course;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface AbsenteeismService {
	int insert(Absenteeism absenteeism);//添加
	List<Absenteeism> selectallByCourseId(Integer courseid);
	List<Absenteeism> selectallByCourseIdAndTime(Integer courseid,Date time);
	int delete(Integer courseid,Date time);
	List<Absenteeism> selectallByStudent(Integer studentid);
	int deleteByCourse(Integer courseid);
}
