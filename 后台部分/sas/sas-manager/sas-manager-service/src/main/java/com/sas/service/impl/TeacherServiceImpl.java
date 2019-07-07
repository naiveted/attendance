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
import com.sas.mapper.TeacherMapper;
import com.sas.pojo.Teacher;
import com.sas.pojo.TeacherExample;
import com.sas.pojo.TeacherExample.Criteria;
import com.sas.service.TeacherService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Resource private TeacherMapper teacherMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public PageInfo<Teacher> selectAllTeacher(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer jobnum,String peoplenum,String teachername) {
						
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 5 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		for (int i = 0; i < oidList.size(); i++) {
			System.out.println("查询的oid有"+oidList);
		}
		if (jobnum!=null) {
			criteria.andJobnumEqualTo(jobnum);
		}
		if (peoplenum ==null || peoplenum.isEmpty()) {
			
		}
		else{
			criteria.andPeoplenumEqualTo(peoplenum);
		}
		if (teachername ==null || teachername.isEmpty()) {
			
		}
		else {
			criteria.andTeachernameLike("%"+teachername+"%");
		}
		
		List<Teacher> list = teacherMapper.selectByExample(example);
		PageInfo<Teacher> pageInfo = new PageInfo<>(list, 5);
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
	public int insert(Teacher teacher) {
		int result = teacherMapper.insert(teacher);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(Teacher teacher) {
		int result = teacherMapper.updateByPrimaryKeySelective(teacher);
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
	public int delete(Integer teacherid) {		
		return teacherMapper.deleteByPrimaryKey(teacherid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param teacherId
	* @return 
	* @see com.sas.service.TeacherService#selectTeacherById(int) 
	*/
	@Override
	public Teacher selectTeacherById(int teacherId) {
		
		return teacherMapper.selectByPrimaryKey(teacherId);
	}
	
	
	

}
