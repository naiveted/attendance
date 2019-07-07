package com.sas.controller;
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
@RequestMapping("/classRoomController")
public class ClassRoomController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private ClassRoomService classRoomService;
	/** 员工管理 **/
	@RequestMapping("/selectClassRoom")
	public String redirect() {
		return "/renshiguanli/classroom/classroom";
	}
	/** 地图管理 **/
	@RequestMapping("/gomap")
	public String redirectmap() {
		return "/renshiguanli/classroom/map";
	}
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

	/** 获取部门 绑定ztree
	  * */
		@ResponseBody
		@RequestMapping(value = "/selectDepartment", produces = "text/html;charset=UTF-8")
		public String selectDepartment(HttpServletRequest request) {
			UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
			System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
			String str = null;
			if (userLoginInfo.getOrganizationid()==0) {
				List<OrganizationDictionary> departments = organizationService.selectAll();
				 str = listToJson(departments);
			}
			else {
				List<OrganizationDictionary> departments = organizationService.selectAllByOId(userLoginInfo.getOrganizationid());
				 str = listToJson(departments);
			}
			
			return str;
		}
		/**
		 * 
		* @Title: selectAllStaff 
		* @Description: TODO(这里用一句话描述这个方法的作用) 
		* @param @param departmentid
		* @param @param pageNum
		* @param @param pageSize
		* @param @param request
		* @param @return    入参
		* @return String    返回类型
		 */
		@ResponseBody
		@RequestMapping(value = "/selectAllClassRoom", produces = "text/html;charset=UTF-8")
		public String selectAllStaff(Integer departmentid,@RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "5") Integer pageSize,HttpServletRequest request,Integer galleryful,String classroomaddress,String classroomname) {
			System.out.println("进入方法"+departmentid);
			ArrayList<Integer> oidList = new ArrayList<Integer>();
			if (departmentid==null) {
				System.out.println("查询的时候没有选oid默认为最大机构");
				
				departmentid=0;
			}
			if (departmentid==0) {
				List<OrganizationDictionary> departments = organizationService.selectAll();
				for (int i = 0; i < departments.size(); i++) {
					oidList.add(departments.get(i).getOrganizationid());
				}
			}
			else {
				List<OrganizationDictionary> departments = organizationService.selectAllByOId(departmentid);
				for (int i = 0; i < departments.size(); i++) {
					oidList.add(departments.get(i).getOrganizationid());
				}
			}			
			
			PageInfo<ClassRoom> pageInfo = classRoomService.selectAllClassRoom(pageNum, pageSize,oidList,galleryful,classroomaddress,classroomname);
			List<ClassRoom> list = pageInfo.getList();
			//String teachers = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
			List list2 = new ArrayList<>();
			list2.add(list);
			list2.add(pageInfo);
			if (pageNum!=1) {
				request.getSession().removeAttribute("pageInfo");
				request.getSession().setAttribute("pageInfo", pageInfo);			
				
			}
			request.getSession().setAttribute("pageInfo", pageInfo);
			//System.out.println(pageInfo.getPages()+"------"+list.get(0).getTeachername());
			String data = JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd");
			return data;
		}
		
		/**
		 * 
		* @Title: insertTeacher 
		* @Description: TODO(新增教师信息) 
		* @param @param teacher
		* @param @param entrytimes
		* @param @param file_img
		* @param @return
		* @param @throws Exception    入参
		* @return String    返回类型
		 */
		
			@ResponseBody
			@RequestMapping(value = "/insertClassRoom", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String insertTeacher(ClassRoom classRoom,String createdate2)
					throws Exception {	
				System.out.println("权限id为"+classRoom.getOrganizationid());
				classRoom.setClassroomid(null);
		        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
		        try {  
		            //使用SimpleDateFormat的parse()方法生成Date  
		            Date date = sf.parse(createdate2);  
		            classRoom.setCreatedate(date);
		             
		        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
				
				int i= classRoomService.insert(classRoom);
			
				String result =  Integer.toString(i);
				
				return result;
			}
			/**
			 * 
			* @Title: updateStaff 
			* @Description: TODO(修改教师信息) 
			* @param @param teacher
			* @param @param entrytimes
			* @param @param file_img
			* @param @return
			* @param @throws Exception    入参
			* @return String    返回类型
			 */
			
		    
			@ResponseBody
			@RequestMapping(value = "/updateClassRoom", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String updateStaff(ClassRoom classRoom,String createdate2,Integer id)
					throws Exception {
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
			        try {  
			            //使用SimpleDateFormat的parse()方法生成Date  
			            Date date = sf.parse(createdate2);  
			            classRoom.setCreatedate(date);
			            classRoom.setClassroomid(id);
			             
			        } catch (ParseException e) {  
			            e.printStackTrace();  
			        }						
				
				
				String i = Integer.toString(classRoomService.update(classRoom));
				return i;
			}

			/**
			 * 
			* @Title: selectById 
			* @Description: TODO(根据ID查询要修改教师的数据) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			 */
			 
			@ResponseBody
			@RequestMapping(value = "/selectByClassId", produces = "text/html;charset=UTF-8")
			public String selectById(Integer classId) {
				ClassRoom classRoom =  classRoomService.selectClassRoomById(classId);
				String data = JSON.toJSONStringWithDateFormat(classRoom, "yyyy-MM-dd");
				return data;
			}
			/**
			 * 
			* @Title: delete 
			* @Description: TODO(根据教师id删除老师) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			 */
			@ResponseBody
			@RequestMapping(value = "/deleteClassRoom", produces = "text/html;charset=UTF-8")
			public String delete(int classroomid) {	
				int flag = classRoomService.delete(classroomid);
				return Integer.toString(flag);
			}
			/**
			 * 
			* @Title: selectClassRoomByOpen 
			* @Description: TODO(老师查找课程) 
			* @param @param organizationid
			* @param @return    入参
			* @return String    返回类型
			 */
			@ResponseBody
			@RequestMapping(value = "/selectClassRoomByOpen", produces = "text/html;charset=UTF-8")
			public String selectClassRoomByOpen(Integer organizationid) {	
				ArrayList<Integer> oidList = new ArrayList<Integer>();
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
				List<ClassRoom> list = classRoomService.selectClassRoomByOpen(oidList);
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
