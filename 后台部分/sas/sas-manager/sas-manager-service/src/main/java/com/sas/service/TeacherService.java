package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface TeacherService {
	PageInfo<Teacher> selectAllTeacher(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer jobnum,String peoplenum,String teachername);//所有老师名称遍历
	int insert(Teacher teacher);//添加老师
	int update(Teacher teacher);//更新老师
	int delete(Integer teacherid);//删除老师
	Teacher selectTeacherById(int teacherId);//根据id查找老师
}
