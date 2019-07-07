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
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.CourseAdminMapper;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.ClassRoomExample;
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.CourseAdminExample;
import com.sas.pojo.CourseAdminExample.Criteria;
import com.sas.service.CourseAdminService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class CourseAdminServiceImpl implements CourseAdminService {
	
	@Resource private CourseAdminMapper courseAdminMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public PageInfo<CourseAdmin> selectAllCourseAdmin(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,String cname ) {
						
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 5 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		CourseAdminExample example = new CourseAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		for (int i = 0; i < oidList.size(); i++) {
			System.out.println("查询personen的oid有"+oidList);
		}
		
		if (cname ==null || cname.isEmpty()) {
			
		}
		else {
			criteria.andCnameLike("%"+cname+"%");
		}
		
		
		List<CourseAdmin> list = courseAdminMapper.selectByExample(example);
		PageInfo<CourseAdmin> pageInfo = new PageInfo<>(list, 5);
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
	public int insert(CourseAdmin courseAdmin) {
			
		
		return courseAdminMapper.insert(courseAdmin);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(CourseAdmin courseAdmin) {
		int result = courseAdminMapper.updateByPrimaryKeySelective(courseAdmin);
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
	public int delete(Integer courseAdminid) {		
		return courseAdminMapper.deleteByPrimaryKey(courseAdminid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param teacherId
	* @return 
	* @see com.sas.service.TeacherService#selectTeacherById(int) 
	*/
	@Override
	public CourseAdmin selectCourseAdminById(int courseAdminid) {
		
		return courseAdminMapper.selectByPrimaryKey(courseAdminid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllCourseAdminByOid</p> 
	* <p>Description: </p> 
	* @param Oid
	* @return 
	* @see com.sas.service.CourseAdminService#selectAllCourseAdminByOid(java.lang.Integer) 
	*/
	@Override
	public List<CourseAdmin> selectAllCourseAdminByOid(Integer Oid) {
		CourseAdminExample example = new CourseAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidEqualTo(Oid);
		criteria.andIsopenEqualTo(0);	
		List<CourseAdmin> list = courseAdminMapper.selectByExample(example);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	
	
	

}
