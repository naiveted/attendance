/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年4月14日 下午3:57:10 
* @version V1.0   
*/

package com.sas.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sas.mapper.CourseMapper;
import com.sas.pojo.Course;
import com.sas.pojo.CourseExample;
import com.sas.pojo.CourseExample.Criteria;
import com.sas.service.CourseService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class CourseServiceImpl implements CourseService {
	
	@Resource private CourseMapper courseMapper;

	/* (非 Javadoc) 
	* <p>Title: selectAllCourseByTeacherId</p> 
	* <p>Description: </p> 
	* @param teacherid
	* @return 
	* @see com.sas.service.CourseService#selectAllCourseByTeacherId(java.lang.Integer) 
	*/
	@Override
	public List<Course> selectAllCourseByTeacherId(Integer teacherid) {
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return courseMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param course
	* @return 
	* @see com.sas.service.CourseService#insert(com.sas.pojo.Course) 
	*/
	@Override
	public int insert(Course course) {
		return courseMapper.insert(course);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param Course
	* @return 
	* @see com.sas.service.CourseService#update(com.sas.pojo.Course) 
	*/
	@Override
	public int update(Course Course) {
		return courseMapper.updateByPrimaryKey(Course);
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.CourseService#delete(java.lang.Integer) 
	*/
	@Override
	public int delete(Integer courseid) {
		// TODO Auto-generated method stub
		return courseMapper.deleteByPrimaryKey(courseid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectClassRoomById</p> 
	* <p>Description: </p> 
	* @param courseid
	* @return 
	* @see com.sas.service.CourseService#selectClassRoomById(int) 
	*/
	@Override
	public Course selectCourseById(int courseid) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(courseid);
	}

	/* (非 Javadoc) 
	* <p>Title: updateSelect</p> 
	* <p>Description: </p> 
	* @param Course
	* @return 
	* @see com.sas.service.CourseService#updateSelect(com.sas.pojo.Course) 
	*/
	@Override
	public int updateSelect(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.updateByPrimaryKeySelective(course);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllOpenAttendanceCourse</p> 
	* <p>Description: </p> 
	* @param studentid
	* @param date
	* @param isAttendances
	* @return 
	* @see com.sas.service.CourseService#selectAllOpenAttendanceCourse(java.lang.Integer, java.util.Date, java.lang.Integer) 
	*/
	@Override
	public List<Course> selectAllOpenAttendanceCourse(Integer studentid,
			Date date, Integer isAttendances) {
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidlistLike("%"+","+studentid+","+"%");
		criteria.andIsattendanceEqualTo(isAttendances);
		return courseMapper.selectByExample(example);
	}

	/* (非 Javadoc) 
	* <p>Title: selectCourseByStudentId</p> 
	* <p>Description: </p> 
	* @param studentid
	* @return 
	* @see com.sas.service.CourseService#selectCourseByStudentId(java.lang.Integer) 
	*/
	@Override
	public List<Course> selectCourseByStudentId(Integer studentid) {
		CourseExample example = new CourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidlistLike("%"+","+studentid+","+"%");
		return courseMapper.selectByExample(example);
	}


	

	
	
	

}
