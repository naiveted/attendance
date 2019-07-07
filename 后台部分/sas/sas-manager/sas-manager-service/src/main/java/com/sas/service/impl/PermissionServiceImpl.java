/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年5月14日 下午3:57:10 
* @version V1.0   
*/
package com.sas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sas.mapper.PermissionMapper;
import com.sas.mapper.PersonnelMapper;
import com.sas.pojo.Permission;
import com.sas.pojo.PermissionExample;
import com.sas.pojo.PermissionExample.Criteria;
import com.sas.service.PermissionService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年5月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Resource private PermissionMapper permissionMapper;

	/* (非 Javadoc) 
	* <p>Title: selectAll</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.sas.service.OrganizationService#selectAll() 
	*/
	@Override
	public List<Permission> selectAll() {
		    PermissionExample example = new PermissionExample();
			List<Permission> result = permissionMapper.selectByExample(example);
			if (result==null||result.size()==0) {
				return null;
			}
			return result;
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#insert(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int insert(Permission permission) {
		int result = permissionMapper.insert(permission);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#update(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int update(Permission permission) {
		int result = permissionMapper.updateByPrimaryKey(permission);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#delete(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int delete(Permission permission) {
		int result = permissionMapper.deleteByPrimaryKey(permission.getId());
		PermissionExample example = new PermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(permission.getId());
		int result2 = permissionMapper.deleteByExample(example);
		return result+result2;
	}

	/* (非 Javadoc) 
	* <p>Title: selectAllByOId</p> 
	* <p>Description: </p> 
	* @param oid
	* @return 
	* @see com.sas.service.OrganizationService#selectAllByOId(int) 
	*/
	@Override
	public List<Permission> selectAllByOId(int oid) {
		List<Permission> list = new ArrayList<Permission>();
		PermissionExample example = new PermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(oid);
		System.out.println("管理员来自"+permissionMapper.selectByExample(example).get(0).getName());
		list.addAll(permissionMapper.selectByExample(example));
		PermissionExample example1 = new PermissionExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andParentidEqualTo(oid);
		List<Permission> list1 = permissionMapper.selectByExample(example1); 
		list.addAll(list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.size()+"---"+list1.get(i).getName());
			PermissionExample example2 = new PermissionExample();
			Criteria criteria2 = example2.createCriteria();
			criteria2.andParentidEqualTo(list1.get(i).getId());
			list.addAll(permissionMapper.selectByExample(example2));
		}
		
		return list;
	}

	/* (非 Javadoc) 
	* <p>Title: selectpPermissionByKey</p> 
	* <p>Description: </p> 
	* @param pid
	* @return 
	* @see com.sas.service.PermissionService#selectpPermissionByKey(java.lang.Integer) 
	*/
	@Override
	public Permission selectpPermissionByKey(Integer pid) {
		// TODO Auto-generated method stub
		return permissionMapper.selectByPrimaryKey(pid);
	}
	
	
	

}
