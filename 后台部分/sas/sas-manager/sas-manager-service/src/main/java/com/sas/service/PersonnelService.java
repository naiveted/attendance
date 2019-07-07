package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface PersonnelService {
	PageInfo<Personnel> selectAllPersonnel(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer jobnum,String peoplenum,String teachername,Integer roleid);//所有老师名称遍历
	int insert(Personnel teacher);//添加老师
	int update(Personnel teacher);//更新老师
	int delete(Integer teacherid);//删除老师
	Personnel selectPersonelById(int personelId);//根据id查找老师
	List<Personnel> selectAllStudent(ArrayList<Integer> oidList,Integer roleid);
	List<Personnel> selectAllStudentByListIds(ArrayList<Integer> studentlist);
}
