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

import com.sas.mapper.UserInfoMapper;
import com.sas.mapper.UserLoginInfoMapper;
import com.sas.mapper.UserRoleMapper;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserLoginInfoExample;
import com.sas.pojo.UserLoginInfoExample.Criteria;
import com.sas.pojo.UserRole;
import com.sas.service.TestService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2017年4月14日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Resource private UserInfoMapper userInfoMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param userLoginInfo
	* @return 
	* @see com.sas.service.UserLoginInfoService#insert(com.sas.pojo.UserLoginInfo) 
	*/
	@Override
	public int insert(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userInfo);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param userInfo
	* @return 
	* @see com.sas.service.UserInfoService#update(com.sas.pojo.UserInfo) 
	*/
	@Override
	public int updateByUserid(UserInfo userInfo) {	
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteByUserid</p> 
	* <p>Description: </p> 
	* @param userInfo
	* @return 
	* @see com.sas.service.UserInfoService#deleteByUserid(com.sas.pojo.UserInfo) 
	*/
	@Override
	public int deleteByUserid(int id) {
		// TODO Auto-generated method stub
		return userInfoMapper.deleteByPrimaryKey(id);
	}

	

	
	

}
