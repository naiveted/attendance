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
import com.sas.mapper.ClassRoomMapper;
import com.sas.mapper.CourseMapper;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.ClassRoomExample;
import com.sas.pojo.ClassRoomExample.Criteria;
import com.sas.pojo.Course;
import com.sas.pojo.CourseExample;
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
public class ClassRoomServiceImpl implements ClassRoomService {
	
	@Resource private ClassRoomMapper classRoomMapper;

	@Resource private CourseMapper courseMapper;
	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public PageInfo<ClassRoom> selectAllClassRoom(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer galleryful,String classroomaddress,String classroomname ) {
						
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 5 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		ClassRoomExample example = new ClassRoomExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		for (int i = 0; i < oidList.size(); i++) {
			System.out.println("查询personen的oid有"+oidList);
		}
		if (galleryful!=null) {
			criteria.andGalleryfulEqualTo(galleryful);
		}
		if (classroomaddress ==null || classroomaddress.isEmpty()) {
			
		}
		else{
			criteria.andClassroomaddressLike("%"+classroomaddress+"%");
		}
		if (classroomname ==null || classroomname.isEmpty()) {
			
		}
		else {
			criteria.andClassroomnameLike("%"+classroomname+"%");
		}
		
		
		List<ClassRoom> list = classRoomMapper.selectByExample(example);
		PageInfo<ClassRoom> pageInfo = new PageInfo<>(list, 5);
		if (list==null||list.size()==0) {
			System.out.println("空值返回");
			return pageInfo;
		}
		System.out.println("pageinfo返回");
		return pageInfo;
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#insert(com.sas.pojo.Teacher) 
	*/
	@Override
	public int insert(ClassRoom classRoom) {
			
		
		return classRoomMapper.insert(classRoom);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(ClassRoom classRoom) {
		int result = classRoomMapper.updateByPrimaryKeySelective(classRoom);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#delete(com.sas.pojo.Teacher) 
	*/
	@Override
	public int delete(Integer classroomid) {		
		return classRoomMapper.deleteByPrimaryKey(classroomid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param teacherId
	* @return 
	* @see com.sas.service.TeacherService#selectTeacherById(int) 
	*/
	@Override
	public ClassRoom selectClassRoomById(int classroomid) {
		
		return classRoomMapper.selectByPrimaryKey(classroomid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectClassRoomByOpen</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.sas.service.ClassRoomService#selectClassRoomByOpen() 
	*/
	@Override
	public List<ClassRoom> selectClassRoomByOpen(ArrayList<Integer> oidList) {
		ClassRoomExample example = new ClassRoomExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		criteria.andIsuseEqualTo(0);
		List<ClassRoom> list = classRoomMapper.selectByExample(example);
		if (list==null||list.size()==0) {
			
			return null;
		}
		return list;
	}

	/* (非 Javadoc) 
	* <p>Title: selectClassRoomByHasUse</p> 
	* <p>Description: </p> 
	* @param oidList
	* @param start
	* @param end
	* @param coursetime
	* @return 
	* @see com.sas.service.ClassRoomService#selectClassRoomByHasUse(java.util.ArrayList, com.mysql.fabric.xmlrpc.base.Data, com.mysql.fabric.xmlrpc.base.Data, java.lang.String) 
	*/
	@Override
	public List<ClassRoom> selectClassRoomByHasUse(ArrayList<Integer> oidList,
			Date start, Date end, String coursetime,String dayofweek) {			
		List<Course> list = new ArrayList<>();
		String[] str = coursetime.split(",");
		System.out.println("for开始"+coursetime+"---"+coursetime.indexOf(","));
		for (int i = 0; i < str.length-1; i++) {
			System.out.println("for--执行--第几节："+str[i+1]);
			CourseExample example = new CourseExample();
			com.sas.pojo.CourseExample.Criteria criteria = example.createCriteria();
			criteria.andOrganizationidIn(oidList);
			criteria.andStarttimeGreaterThanOrEqualTo(start);
			criteria.andStarttimeLessThanOrEqualTo(end);
			criteria.andSchooltimeLike("%"+","+str[i+1]+","+"%");
			criteria.andDayofweekEqualTo(dayofweek);
			list.addAll(courseMapper.selectByExample(example));
			
			CourseExample example2 = new CourseExample();
			com.sas.pojo.CourseExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andOrganizationidIn(oidList);
			criteria2.andEndtimeGreaterThanOrEqualTo(start);
			criteria2.andEndtimeLessThanOrEqualTo(end);
			criteria2.andSchooltimeLike("%"+","+str[i+1]+","+"%");
			criteria2.andDayofweekEqualTo(dayofweek);
			list.addAll(courseMapper.selectByExample(example2));
		}
		System.out.println("for结束");
		if (list.size()==0||list.isEmpty()) {
			System.out.println("该条件下没有开课");
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getCoursename());
			}
		}
		
		 
		ArrayList<Integer> listcourseid = new ArrayList<>();
		ClassRoomExample example2 = new ClassRoomExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andOrganizationidIn(oidList);
		criteria2.andIsuseEqualTo(0);
		if (list.size()==0||list.isEmpty()) {
			//该条件下没有课程开启，不占教室
			System.out.println("该条件下没有课程");
		}else {
			for (int i = 0; i < list.size(); i++) {
				//获取所有当前条件下已经使用的教室id
				System.out.println("已经使用的教室id"+list.get(i).getClassroomid());
				listcourseid.add(list.get(i).getClassroomid());
			}
			//查找当前条件下未使用的教室
			
			criteria2.andClassroomidNotIn(listcourseid);
		}
		
		List<ClassRoom> list2 = classRoomMapper.selectByExample(example2);
		if (list2==null||list2.size()==0) {
			
			return null;
		}
		return list2;
	}
	
	
	

}
