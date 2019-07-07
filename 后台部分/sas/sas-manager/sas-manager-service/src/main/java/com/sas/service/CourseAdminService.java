package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface CourseAdminService {
	PageInfo<CourseAdmin> selectAllCourseAdmin(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,String cname);//所有老师名称遍历
	int insert(CourseAdmin courseAdmin);//添加
	int update(CourseAdmin courseAdmin);//更新
	int delete(Integer courseAdminid);//删除
	CourseAdmin selectCourseAdminById(int courseAdminid);//根据id查找
	List<CourseAdmin> selectAllCourseAdminByOid(Integer Oid);//根据用户机构查找可开课程
}
