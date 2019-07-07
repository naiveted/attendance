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
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserLoginInfoExample;
import com.sas.pojo.UserLoginInfoExample.Criteria;
import com.sas.service.TestService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2017年4月14日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class TestServiceImpl implements TestService {
	
	@Resource private UserLoginInfoMapper userLoginInfoMapper;
	
	
	/* (非 Javadoc) 
	* <p>Title: findByloginname</p> 
	* <p>Description: </p> 
	* @param adminName
	* @return 
	* @see com.sas.service.TestService#findByloginname(java.lang.String) 
	*/
	@Override
	public UserLoginInfo findByloginname(String adminName,String password) {
		// TODO Auto-generated method stub
		        UserLoginInfoExample example = new UserLoginInfoExample();
		        Criteria criteria = example.createCriteria();
				criteria.andLoginnameEqualTo(adminName);
				criteria.andLoginpasswordEqualTo(password);
				List<UserLoginInfo> result = userLoginInfoMapper.selectByExample(example);
				if (result==null||result.size()==0) {
					return null;
				}
				return result.get(0);
	}

}
