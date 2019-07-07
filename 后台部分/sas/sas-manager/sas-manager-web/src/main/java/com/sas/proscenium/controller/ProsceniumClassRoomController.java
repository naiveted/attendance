package com.sas.proscenium.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.UserInfoMapper;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.ClassRoomService;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/prosceniumClassRoomController")
public class ProsceniumClassRoomController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private ClassRoomService classRoomService;
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

	
			/**
			 * 
			* @Title: selectClassRoomByOpen 
			* @Description: TODO(老师查找课程) 
			* @param @param organizationid
			* @param @return    入参
			* @return String    返回类型
			* @author xieweipeng
			* @throws
			* @date 2018年6月12日 下午9:20:28 
			* @version V1.0
			 * @throws java.text.ParseException 
			 */
			@ResponseBody
			@RequestMapping(value = "/selectClassRoomByToUse", produces = "text/html;charset=UTF-8")
			public String selectClassRoomByOpen(Integer organizationid,String start,String end,String coursetime,String dayofweek) throws java.text.ParseException {	
				ArrayList<Integer> oidList = new ArrayList<Integer>();
 
		        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  		      
		        //使用SimpleDateFormat的parse()方法生成Date  
		        Date datestart = sf.parse(start); 
		        Date dateend = sf.parse(end);
		        //打印Date  
		        System.out.println(datestart); 
		        System.out.println(dateend);
				if (organizationid==null) {
					System.out.println("查询的时候没有选oid默认为最大机构");
					
					organizationid=0;
				}
				if (organizationid==0) {
					List<OrganizationDictionary> departments = organizationService.selectAll();
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}
				else {
					List<OrganizationDictionary> departments = organizationService.selectAllByOId(organizationid);
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}
				List<ClassRoom> list = classRoomService.selectClassRoomByHasUse(oidList, datestart, dateend, coursetime,dayofweek);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (list==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", list);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
				
				return data;			
			}

	
}
