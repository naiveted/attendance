/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年4月14日 下午3:57:10 
* @version V1.0   
*/
package com.sas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.sas.mapper.AbsenteeismMapper;
import com.sas.mapper.ClassRoomMapper;
import com.sas.mapper.CourseMapper;
import com.sas.pojo.Absenteeism;
import com.sas.pojo.AbsenteeismExample;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.ClassRoomExample;
import com.sas.pojo.ClassRoomExample.Criteria;
import com.sas.pojo.Course;
import com.sas.pojo.CourseExample;
import com.sas.service.AbsenteeismService;
import com.sas.service.ClassRoomService;
import com.sas.service.PersonnelService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class AbsenteeismServiceImpl implements AbsenteeismService {
	
	@Resource private AbsenteeismMapper absenteeismMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param absenteeismService
	* @return 
	* @see com.sas.service.AbsenteeismService#insert(com.sas.service.AbsenteeismService) 
	*/
	@Override
	public int insert(Absenteeism absenteeism) {
		// TODO Auto-generated method stub
		return absenteeismMapper.insert(absenteeism);
	}

	/* (非 Javadoc) 
	* <p>Title: selectallByCourseId</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.AbsenteeismService#selectallByCourseId(java.lang.Integer) 
	*/
	@Override
	public List<Absenteeism> selectallByCourseId(Integer courseid) {
		// TODO Auto-generated method stub
		AbsenteeismExample example = new AbsenteeismExample();
		com.sas.pojo.AbsenteeismExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		return absenteeismMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectallByCourseIdAndTime</p> 
	* <p>Description: </p> 
	* @param courseid
	* @param time
	* @return 
	* @see com.sas.service.AbsenteeismService#selectallByCourseIdAndTime(java.lang.Integer, java.util.Date) 
	*/
	@Override
	public List<Absenteeism> selectallByCourseIdAndTime(Integer courseid,
			Date time) {
		AbsenteeismExample example = new AbsenteeismExample();
		com.sas.pojo.AbsenteeismExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andCreatetimeEqualTo(time);
		return absenteeismMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param courseid
	* @param time
	* @return 
	* @see com.sas.service.AbsenteeismService#delete(java.lang.Integer, java.util.Date) 
	*/
	@Override
	public int delete(Integer courseid, Date time) {
		AbsenteeismExample example = new AbsenteeismExample();
		com.sas.pojo.AbsenteeismExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andCreatetimeEqualTo(time);
		return absenteeismMapper.deleteByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectallByStudent</p> 
	* <p>Description: </p> 
	* @param studentid
	* @return 
	* @see com.sas.service.AbsenteeismService#selectallByStudent(java.lang.Integer) 
	*/
	@Override
	public List<Absenteeism> selectallByStudent(Integer studentid) {
		AbsenteeismExample example = new AbsenteeismExample();
		com.sas.pojo.AbsenteeismExample.Criteria criteria = example.createCriteria();
		criteria.andAbsenteeismlistLike("%"+","+studentid+","+"%");
		return absenteeismMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteByCourse</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.AbsenteeismService#deleteByCourse(java.lang.Integer) 
	*/
	@Override
	public int deleteByCourse(Integer courseid) {
		AbsenteeismExample example = new AbsenteeismExample();
		com.sas.pojo.AbsenteeismExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		return absenteeismMapper.deleteByExample(example);
	}
	

	
	

}
