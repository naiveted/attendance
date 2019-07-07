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
import com.sas.pojo.UserLoginInfoExample;
import com.sas.pojo.UserLoginInfoExample.Criteria;
import com.sas.pojo.UserRole;
import com.sas.service.TestService;
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
public class UserLoginInfoServiceImpl implements UserLoginInfoService {
	
	@Resource private UserLoginInfoMapper userLoginInfoMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param userLoginInfo
	* @return 
	* @see com.sas.service.UserLoginInfoService#insert(com.sas.pojo.UserLoginInfo) 
	*/
	@Override
	public int insert(UserLoginInfo userLoginInfo) {
		// TODO Auto-generated method stub
		return userLoginInfoMapper.insert(userLoginInfo);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param userLoginInfo
	* @return 
	* @see com.sas.service.UserLoginInfoService#update(com.sas.pojo.UserLoginInfo) 
	*/
	@Override
	public int updateByUserid(UserLoginInfo userLoginInfo) {
		UserLoginInfoExample example = new UserLoginInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userLoginInfo.getUserid());
		return userLoginInfoMapper.updateByExampleSelective(userLoginInfo, example);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteByUserid</p> 
	* <p>Description: </p> 
	* @param userLoginInfo
	* @return 
	* @see com.sas.service.UserLoginInfoService#deleteByUserid(com.sas.pojo.UserLoginInfo) 
	*/
	@Override
	public int deleteByUserid(int id) {
		UserLoginInfoExample example = new UserLoginInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(id);
		return userLoginInfoMapper.deleteByExample(example);
	}
	/* (非 Javadoc) 
	* <p>Title: selectByUidAndPassword</p> 
	* <p>Description: </p> 
	* @param uid
	* @param password
	* @return 
	* @see com.sas.service.UserInfoService#selectByUidAndPassword(java.lang.Integer, java.lang.String) 
	*/
	@Override
	public List<UserLoginInfo> selectByUidAndPassword(Integer uid, String password) {
		UserLoginInfoExample example =  new UserLoginInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(uid);
		criteria.andLoginpasswordEqualTo(password);
		return userLoginInfoMapper.selectByExample(example);
	}

	
	

}
