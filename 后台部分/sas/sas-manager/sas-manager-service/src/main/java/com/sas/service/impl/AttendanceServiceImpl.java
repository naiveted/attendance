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

import com.mysql.fabric.xmlrpc.base.Data;
import com.sas.mapper.AttendanceMapper;
import com.sas.pojo.Attendance;
import com.sas.pojo.AttendanceExample;
import com.sas.pojo.AttendanceExample.Criteria;
import com.sas.service.AttendanceService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Resource private AttendanceMapper attendanceMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param attendance
	* @return 
	* @see com.sas.service.AttendanceService#insert(com.sas.pojo.Attendance) 
	*/
	@Override
	public int insert(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceMapper.insert(attendance);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param attendance
	* @return 
	* @see com.sas.service.AttendanceService#update(com.sas.pojo.Attendance) 
	*/
	@Override
	public int update(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceMapper.updateByPrimaryKey(attendance);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteList</p> 
	* <p>Description: </p> 
	* @param attendancelist
	* @param date
	* @param courseid
	* @return 
	* @see com.sas.service.AttendanceService#deleteList(java.util.ArrayList, java.util.Date, java.lang.Integer) 
	*/
	@Override
	public int deleteList(ArrayList<Integer> attendancelist, Date date,
			Integer courseid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStudentidIn(attendancelist);
		criteria.andCreatedateEqualTo(date);
		criteria.andStateEqualTo(0);//已经签到信息删除
		return attendanceMapper.deleteByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAttendanceById</p> 
	* <p>Description: </p> 
	* @param attendanceid
	* @return 
	* @see com.sas.service.AttendanceService#selectAttendanceById(int) 
	*/
	@Override
	public Attendance selectAttendanceById(int attendanceid) {
		// TODO Auto-generated method stub
		return attendanceMapper.selectByPrimaryKey(attendanceid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectLeaveAttendance</p> 
	* <p>Description: </p> 
	* @param attendancelist
	* @param date
	* @param courseid
	* @return 
	* @see com.sas.service.AttendanceService#selectLeaveAttendance(java.util.ArrayList, java.util.Date, java.lang.Integer) 
	*/
	@Override
	public List<Attendance> selectLeaveAttendance(
			ArrayList<Integer> attendancelist, Date date, Integer courseid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStudentidIn(attendancelist);
		criteria.andCreatedateEqualTo(date);
		criteria.andStateEqualTo(1);//已经请假信息
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAttendanceList</p> 
	* <p>Description: </p> 
	* @param attendancelist
	* @param date
	* @param courseid
	* @return 
	* @see com.sas.service.AttendanceService#selectAttendanceList(java.util.ArrayList, java.util.Date, java.lang.Integer) 
	*/
	@Override
	public List<Attendance> selectAttendanceList(
			ArrayList<Integer> attendancelist, Date date, Integer courseid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStudentidIn(attendancelist);
		criteria.andCreatedateEqualTo(date);
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAttendanceByCourseId</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.AttendanceService#selectAttendanceByCourseId(java.lang.Integer) 
	*/
	@Override
	public List<Attendance> selectAttendanceByCourseId(Integer courseid,Integer state) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStateEqualTo(state);
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAttendanceByCourseIdAndTimeAndState</p> 
	* <p>Description: </p> 
	* @param courseid
	* @param state
	* @param date
	* @return 
	* @see com.sas.service.AttendanceService#selectAttendanceByCourseIdAndTimeAndState(java.lang.Integer, java.lang.Integer, java.util.Date) 
	*/
	@Override
	public List<Attendance> selectAttendanceByCourseIdAndTimeAndState(
			Integer courseid, Integer state, Date date) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStateEqualTo(state);
		criteria.andCreatedateEqualTo(date);
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param aid
	* @return 
	* @see com.sas.service.AttendanceService#delete(java.lang.Integer) 
	*/
	@Override
	public int delete(Integer aid) {		
		return attendanceMapper.deleteByPrimaryKey(aid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectIsAttendance</p> 
	* <p>Description: </p> 
	* @param date
	* @param courseid
	* @param studentid
	* @return 
	* @see com.sas.service.AttendanceService#selectIsAttendance(java.util.Date, java.lang.Integer, java.lang.Integer) 
	*/
	@Override
	public int selectIsAttendance(Date date, Integer courseid, Integer studentid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andStateEqualTo(0);
		criteria.andCreatedateEqualTo(date);
		criteria.andStudentidEqualTo(studentid);
		return attendanceMapper.selectByExample(example).size();
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllLeave</p> 
	* <p>Description: </p> 
	* @param studentid
	* @return 
	* @see com.sas.service.AttendanceService#selectAllLeave(java.lang.Integer) 
	*/
	@Override
	public List<Attendance> selectAllLeave(Integer studentid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andStateEqualTo(1);
		criteria.andStudentidEqualTo(studentid);
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectOkToSeatNum</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.AttendanceService#selectOkToSeatNum(java.lang.Integer) 
	*/
	@Override
	public List<Attendance> selectOkToSeatNum(Integer courseid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		criteria.andCreatedateEqualTo(new Date());
		return attendanceMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteByCourseId</p> 
	* <p>Description: </p> 
	* @param aid
	* @return 
	* @see com.sas.service.AttendanceService#deleteByCourseId(java.lang.Integer) 
	*/
	@Override
	public int deleteByCourseId(Integer courseid) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseid);
		return attendanceMapper.deleteByExample(example);
	}

	



	
	
	
	

}
