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
import com.sas.pojo.RolePermissionExample;
import com.sas.pojo.RolePermissionExample.Criteria;
import com.sas.service.RolePermissionService;
import com.sas.service.RoleService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Resource private RolePermissionMapper rolePermissionMapper;
	/* (非 Javadoc) 
	* <p>Title: selectAllRolePermission</p> 
	* <p>Description: </p> 
	* @param schoolid
	* @return 
	* @see com.sas.service.RolePermissionService#selectAllRolePermission(java.lang.Integer) 
	*/
	@Override
	public List<RolePermission> selectAllRolePermission(Integer schoolid) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param rolePermission
	* @return 
	* @see com.sas.service.RolePermissionService#insert(com.sas.pojo.RolePermission) 
	*/
	@Override
	public int insert(RolePermission rolePermission) {
		
		return rolePermissionMapper.insert(rolePermission);
	}
	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param rolePermission
	* @return 
	* @see com.sas.service.RolePermissionService#update(com.sas.pojo.RolePermission) 
	*/
	@Override
	public int update(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param rolePermissionId
	* @return 
	* @see com.sas.service.RolePermissionService#delete(java.lang.Integer) 
	*/
	@Override
	public int delete(Integer roleId) {
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);		
		return rolePermissionMapper.deleteByExample(example);
	}
	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param rolePermissionId
	* @return 
	* @see com.sas.service.RolePermissionService#selectTeacherById(int) 
	*/
	@Override
	public Role selectTeacherById(int rolePermissionId) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (非 Javadoc) 
	* <p>Title: selectAllRolePermissionByRid</p> 
	* <p>Description: </p> 
	* @param roleid
	* @return 
	* @see com.sas.service.RolePermissionService#selectAllRolePermissionByRid(java.lang.Integer) 
	*/
	@Override
	public List<RolePermission> selectAllRolePermissionByRid(Integer roleid) {
		RolePermissionExample example = new RolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		return rolePermissionMapper.selectByExample(example);
	}


	
	
	

}
