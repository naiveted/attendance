/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年4月14日 下午3:57:10 
* @version V1.0   
*/
package com.sas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sas.mapper.AbsenteeismMapper;
import com.sas.mapper.AttendanceMapper;
import com.sas.mapper.CourseMapper;
import com.sas.mapper.OrganizationDictionaryMapper;
import com.sas.mapper.StudentMapper;
import com.sas.mapper.TeacherMapper;
import com.sas.mapper.UserLoginInfoMapper;
import com.sas.pojo.Absenteeism;
import com.sas.pojo.AbsenteeismExample;
import com.sas.pojo.Attendance;
import com.sas.pojo.AttendanceExample;
import com.sas.pojo.AttendanceExample.Criteria;
import com.sas.pojo.Course;
import com.sas.pojo.CourseExample;
import com.sas.pojo.Teacher;
import com.sas.pojo.TeacherExample;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserLoginInfoExample;
import com.sas.service.OrganizationService;
import com.sas.service.StudentService;
import com.sas.service.TeacherService;


/** 
 * @ClassName: StudentServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zyk
 * @date 2018年5月19日 下午3:17:10 
 * @version V1.0 
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource private StudentMapper studentMapper;
	@Resource private AttendanceMapper attendanceMapper;
//	@Resource private UserLoginInfo userLoginInfo;
//	@Resource private UserLoginInfoExample userLoginInfoExample;
	@Resource private UserLoginInfoMapper userLoginInfoMapper;
	@Resource private CourseMapper courseMapper;
	@Resource private AbsenteeismMapper absenteeismMapper;
//	/* (非 Javadoc) 
//	* <p>Title: selectAllTeacher</p> 
//	* <p>Description: </p> 
//	* @return 
//	* @see com.sas.service.TeacherService#selectAllTeacher() 
//	*/
//	@Override
//	public List<Teacher> selectAllTeacher() {
//		  TeacherExample example = new TeacherExample();
//			List<Teacher> result = teacherMapper.selectByExample(example);
//			if (result==null||result.size()==0) {
//				return null;
//			}
//			return result;
//	}

	@Override
	public int login(String loginName,String loginPassWord ) {
//		UserLoginInfoExample example = new UserLoginInfoExample();
//         Criteria  criteria = example.createCriteria();
//		criteria.andLoginnameEqualTo(String loginName);
//		List<UserLoginInfo> result = userLoginInfoMapper.selectByExample(example);
//		if (result==null||result.size()==0) {
//			return null;
//		}
//		return result.get(0);
		return 1;
	}
	
	
	@Override
	public int insert(Attendance attendance) {
		int result = attendanceMapper.insert(attendance);
		return result;
	}
	
	@Override
	public int update(Attendance attendance) {
		int result = attendanceMapper.updateByPrimaryKey(attendance);
		return result;
	}
	
	@Override
	public List<Attendance> selectAttendance(int courseId,int studentId) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseId);
		criteria.andStudentidEqualTo(studentId);
		List<Attendance> result = attendanceMapper.selectByExample(example);
		return result;
	}
	
	@Override
	public int selectAbsence(int courseId,int studentId,int status) {
		AttendanceExample example = new AttendanceExample();
		Criteria criteria =example.createCriteria();
		criteria.andCourseidEqualTo(courseId);
		criteria.andStudentidEqualTo(studentId);
		criteria.andStateEqualTo(status);
		List<Attendance> tmp = attendanceMapper.selectByExample(example);
		int result =tmp.size();
		return result;
	}


	@Override
	public Integer selectAttendenceCourse(Integer studentId) {
		CourseExample example =new CourseExample();
		com.sas.pojo.CourseExample.Criteria criteria =example.createCriteria();
//		criteria.andIsattendanceEqualTo(1);
		String id = String.valueOf(studentId);
//		System.out.println("%"+id+"%");
		criteria.andStudentidlistLike("%"+id+"%");
		List<Course> tmp= courseMapper.selectByExample(example);
//		System.out.println(tmp.size());
//		return 0;
		if(tmp.get(0)==null){
			return null;
		}
		else{
			Integer result =tmp.get(0).getCourseid();
			return result;
		}
	}


	@Override
	public int insertAbsenteeism(Absenteeism absenteeism) {
		int result =absenteeismMapper.insert(absenteeism);
		return 0;
	}


	@Override
	public List<Absenteeism>  selectAbsenteeism(int aId,int courseId) {
		AbsenteeismExample example =new AbsenteeismExample();
	    com.sas.pojo.AbsenteeismExample.Criteria criteria =example.createCriteria();
		criteria.andAidEqualTo(aId);
		criteria.andCourseidEqualTo(courseId);
		List<Absenteeism> tmp = absenteeismMapper.selectByExample(example);
		return tmp;
	}


	@Override
	public int updateAbsenteeism(Absenteeism absenteeism) {
		int result =absenteeismMapper.updateByPrimaryKey(absenteeism);
		return 0;
	}


	@Override
	public int delete(Integer aId) {
		int result = attendanceMapper.deleteByPrimaryKey(aId);
		return 0;
	}

}
