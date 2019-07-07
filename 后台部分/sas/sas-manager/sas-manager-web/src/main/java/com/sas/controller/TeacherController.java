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
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.OrganizationService;
import com.sas.service.TeacherService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/teacherController")
public class TeacherController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private TeacherService teacherService;

	
	/** 员工管理 **/
	@RequestMapping("/selectStaff")
	public String redirect() {
		return "/renshiguanli/renyuanluru/staff";
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
		* @author xieweipeng
		* @throws
		* @date 2018年5月14日 下午8:48:45 
		* @version V1.0
		 */
		@ResponseBody
		@RequestMapping(value = "/selectAllTeacher", produces = "text/html;charset=UTF-8")
		public String selectAllStaff(Integer departmentid,@RequestParam(defaultValue = "1") Integer pageNum,
				@RequestParam(defaultValue = "5") Integer pageSize,HttpServletRequest request,Integer jobnum,String peoplenum,String teachername) {
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
			
			PageInfo<Teacher> pageInfo = teacherService.selectAllTeacher(pageNum, pageSize,oidList,jobnum,peoplenum,teachername);
			List<Teacher> list = pageInfo.getList();
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
		* @author xieweipeng
		* @throws
		* @date 2018年5月14日 下午8:48:31 
		* @version V1.0
		 */
		
			@ResponseBody
			@RequestMapping(value = "/insertTeacher", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String insertTeacher(Teacher teacher,String entrytimes, MultipartFile file_img)
					throws Exception {				
		        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
		        try {  
		            //使用SimpleDateFormat的parse()方法生成Date  
		            Date date = sf.parse(entrytimes);  
		            teacher.setEntrytime(date);
		             
		        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
				if (file_img.getSize() > 0) {
					teacher.setImage(CommonMethod.saveFile(file_img, "headImg/"));
				}
				
				System.out.println("进入老师控制器方法"+teacher.getTeachername());
				System.out.println(teacher.getOrganizationid());
				System.out.println(entrytimes);
				String result =  Integer.toString(teacherService.insert(teacher));
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
			* @author xieweipeng
			* @throws
			* @date 2018年5月14日 下午8:48:12 
			* @version V1.0
			 */
			
		    
			@ResponseBody
			@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public String updateStaff(Teacher teacher,String entrytimes, MultipartFile file_img)
					throws Exception {
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
			        try {  
			            //使用SimpleDateFormat的parse()方法生成Date  
			            Date date = sf.parse(entrytimes);  
			            teacher.setEntrytime(date);
			             
			        } catch (ParseException e) {  
			            e.printStackTrace();  
			        }
				if (file_img.getSize() > 0) {
					CommonMethod.deleteFile("D:\\Project\\upload\\pic\\"
							+ teacher.getImage());
					teacher.setImage(CommonMethod.saveFile(file_img, "headImg/"));
				}
				String i = Integer.toString(teacherService.update(teacher));
				return i;
			}

			/**
			 * 
			* @Title: selectById 
			* @Description: TODO(根据ID查询要修改教师的数据) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			* @author xieweipeng
			* @throws
			* @date 2018年5月14日 下午8:47:34 
			* @version V1.0
			 */
			 
			@ResponseBody
			@RequestMapping(value = "/selectByTeacherid", produces = "text/html;charset=UTF-8")
			public String selectById(Integer teacherid) {
				Teacher teacher =  teacherService.selectTeacherById(teacherid);
				String data = JSON.toJSONStringWithDateFormat(teacher, "yyyy-MM-dd");
				return data;
			}
			/**
			 * 
			* @Title: delete 
			* @Description: TODO(根据教师id删除老师) 
			* @param @param teacherid
			* @param @return    入参
			* @return String    返回类型
			* @author xieweipeng
			* @throws
			* @date 2018年5月14日 下午8:47:19 
			* @version V1.0
			 */
			@ResponseBody
			@RequestMapping(value = "/deleteTeacher", produces = "text/html;charset=UTF-8")
			public String delete(int teacherid) {				
				return Integer.toString(teacherService.delete(teacherid));
			}

	
}
