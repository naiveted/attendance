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
import com.sas.mapper.PersonnelMapper;
import com.sas.mapper.TeacherMapper;
import com.sas.pojo.Personnel;
import com.sas.pojo.PersonnelExample;
import com.sas.pojo.PersonnelExample.Criteria;
import com.sas.service.PersonnelService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class PersonnelServiceImpl implements PersonnelService {
	
	@Resource private PersonnelMapper personnelMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public PageInfo<Personnel> selectAllPersonnel(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer jobnum,String peoplenum,String teachername,Integer roleid ) {
						
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 5 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		PersonnelExample example = new PersonnelExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		for (int i = 0; i < oidList.size(); i++) {
			System.out.println("查询personen的oid有"+oidList);
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
			criteria.andNameLike("%"+teachername+"%");
		}
		if (roleid ==null|| roleid==0) {
			
		}
		else {
			criteria.andRoleidEqualTo(roleid);
		}
		
		List<Personnel> list = personnelMapper.selectByExample(example);
		PageInfo<Personnel> pageInfo = new PageInfo<>(list, 5);
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
	public int insert(Personnel personnel) {
		personnelMapper.insert(personnel);	
		System.out.println("key-------------"+personnel.getId());
		return personnel.getId();
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(Personnel personnel) {
		int result = personnelMapper.updateByPrimaryKeySelective(personnel);
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
		return personnelMapper.deleteByPrimaryKey(teacherid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param teacherId
	* @return 
	* @see com.sas.service.TeacherService#selectTeacherById(int) 
	*/
	@Override
	public Personnel selectPersonelById(int personelId) {
		
		return personnelMapper.selectByPrimaryKey(personelId);
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllStudent</p> 
	* <p>Description: </p> 
	* @param oidList
	* @param roleid
	* @return 
	* @see com.sas.service.PersonnelService#selectAllStudent(java.util.ArrayList, java.lang.Integer) 
	*/
	@Override
	public List<Personnel> selectAllStudent(ArrayList<Integer> oidList,
			Integer roleid) {
		PersonnelExample example = new PersonnelExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		criteria.andRoleidEqualTo(roleid);	
		List<Personnel> list = personnelMapper.selectByExample(example);
		return list;
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllStudentByListIds</p> 
	* <p>Description: </p> 
	* @param studentlist
	* @return 
	* @see com.sas.service.PersonnelService#selectAllStudentByListIds(java.util.ArrayList) 
	*/
	@Override
	public List<Personnel> selectAllStudentByListIds(
			ArrayList<Integer> studentlist) {
		PersonnelExample example = new PersonnelExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(studentlist);
		List<Personnel> list = personnelMapper.selectByExample(example);
		return list;
	}
	
	
	

}
