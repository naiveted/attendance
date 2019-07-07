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

import com.sas.mapper.UserLoginInfoMapper;
import com.sas.mapper.UserRoleMapper;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.pojo.UserRoleExample;
import com.sas.pojo.UserRoleExample.Criteria;
import com.sas.service.TestService;
import com.sas.service.UserRoleService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2017年4月14日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource private UserRoleMapper userRoleMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param userRole
	* @return 
	* @see com.sas.service.UserRoleService#insert(com.sas.pojo.UserRole) 
	*/
	@Override
	public int insert(UserRole userRole) {
		
		return userRoleMapper.insert(userRole);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param userRole
	* @return 
	* @see com.sas.service.UserRoleService#update(com.sas.pojo.UserRole) 
	*/
	@Override
	public int updateByUserid(UserRole userRole) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolIdEqualTo(userRole.getUserid());
		return userRoleMapper.updateByExampleSelective(userRole, example);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteByUserid</p> 
	* <p>Description: </p> 
	* @param userRole
	* @return 
	* @see com.sas.service.UserRoleService#deleteByUserid(com.sas.pojo.UserRole) 
	*/
	@Override
	public int deleteByUserid(int id) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolIdEqualTo(id);
		return userRoleMapper.deleteByExample(example);
	}
	
	
	

}
