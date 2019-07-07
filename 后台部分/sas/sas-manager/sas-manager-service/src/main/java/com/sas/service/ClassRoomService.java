package com.sas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.Course;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface ClassRoomService {
	PageInfo<ClassRoom> selectAllClassRoom(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer galleryful,String classroomaddress,String classroomname);//所有老师名称遍历
	int insert(ClassRoom classRoom);//添加
	int update(ClassRoom classRoom);//更新
	int delete(Integer classRoomid);//删除
	ClassRoom selectClassRoomById(int classRoomid);//根据id查找
	List<ClassRoom> selectClassRoomByOpen(ArrayList<Integer> oidList);//根据教师所属机构查找教室
	List<ClassRoom> selectClassRoomByHasUse(ArrayList<Integer> oidList,Date start,Date end,String coursetime,String dayofweek);//根据教师开课时间查找所属机构可用教室
}
