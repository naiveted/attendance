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

import com.sas.mapper.RoleMapper;
import com.sas.mapper.RolePermissionMapper;
import com.sas.pojo.Role;
import com.sas.pojo.RoleExample;
import com.sas.pojo.RolePermission;
import com.sas.pojo.RoleExample.Criteria;
import com.sas.pojo.RolePermissionExample;
import com.sas.service.RoleService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource private RoleMapper roleMapper;
	@Resource private RolePermissionMapper rolePermissionMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public List<Role> selectAllRole(Integer schoolid) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andSchoolidEqualTo(schoolid);
		List<Role> list = roleMapper.selectByExample(example);
		return list;						
	}






	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param role
	* @return 
	* @see com.sas.service.RoleService#insert(com.sas.pojo.Role) 
	*/
	@Override
	public int insert(Role role) {
		int key = roleMapper.insert(role);
		System.out.println("key---------:"+key+"----"+role.getRoleid());
		return role.getRoleid();
	}




	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param role
	* @return 
	* @see com.sas.service.RoleService#update(com.sas.pojo.Role) 
	*/
	@Override
	public int update(Role role) {		
		return roleMapper.updateByPrimaryKeySelective(role);
	}




	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param roleid
	* @return 
	* @see com.sas.service.RoleService#delete(java.lang.Integer) 
	*/
	@Override
	public int delete(Integer roleid) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(roleid);
	}




	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param roleid
	* @return 
	* @see com.sas.service.RoleService#selectTeacherById(int) 
	*/
	@Override
	public Role selectRoleById(int roleid) {
		 
		return roleMapper.selectByPrimaryKey(roleid);
	}
	
	
	

}
