<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台管理系统模版</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${ctx}/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${ctx}/css/ace-skins.min.css" />
        <script src="${ctx}/js/ace-extra.min.js"></script>
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<span class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							学生考勤后台管理系统
						</small>
					</span><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${ctx}/images/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎,</small>
									${user.loginname}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设 置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										用户信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										退出登录
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					 菜单导航
				</a>
				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li id="controller" class="active">
							<a>
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 功能导航 </span>
							</a>
						</li>
						<li id="myattendance">
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 我的考勤  </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li id="MyAttendanceRecord"
								 onclick="activechange(document.getElementById('myattendance'),document.getElementById('MyAttendanceRecord'),'menuController/selectMyAttendance')">
									<a>
										<i class="icon-double-angle-right"></i>
										我的考勤记录
									</a>
								</li>

								<li id="myclass" 
								onclick="activechange(document.getElementById('myattendance'),document.getElementById('myclass'),'menuController/selectMyClass')">
									<a>
										<i class="icon-double-angle-right"></i>
										我的班次安排
									</a>
									
								</li>
                               	 <li id="myRetroactive" 
								 onclick="activechange(document.getElementById('myattendance'),document.getElementById('myRetroactive'),'menuController/selectMyRetroactive')">
								
									<a >
										<i class="icon-double-angle-right"></i>
										我的补签申请
									</a>
								</li>
									 <li id="myAskForLeave" 
							        onclick="activechange(document.getElementById('myattendance'),document.getElementById('myAskForLeave'),'menuController/selectMyAskForLeave')">
									<a>
										<i class="icon-double-angle-right"></i>
										我要请假、加班、出差
									</a>
								</li>
							    <li id="punchCard" 
							    onclick="activechange(document.getElementById('myattendance'),document.getElementById('punchCard'),'menuController/punchCard')">
									<a>
										<i class="icon-double-angle-right"></i>
										 考勤打卡
									</a>
								</li>
							</ul>
						</li>

						<li id="renshiguanli">
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 机构/人员管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
							<li id="setDepartment"
								onclick="activechange(document.getElementById('renshiguanli'),document.getElementById('setDepartment'),'setFunction/main')">
									<a>
										<i class="icon-double-angle-right"></i>
										角色、功能设置
									</a>
								</li>
								<li id="roleset"
								onclick="activechange(document.getElementById('renshiguanli'),document.getElementById('roleset'),'setDeparment/main')">
									<a>
										<i class="icon-double-angle-right"></i>
										机构、学校设置
									</a>
								</li>
								<li id="renyuanluru"
								onclick="activechange(document.getElementById('renshiguanli'),document.getElementById('renyuanluru'),'teacherController/selectStaff')">
									<a >
										<i class="icon-double-angle-right"></i>
										人员录入
									</a>
								</li>							
								 
							</ul>
						</li>

						<li id="paibanguangli">
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 教室/课程管理  </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li id="classroom"
								onclick="activechange(document.getElementById('renshiguanli'),document.getElementById('classroom'),'classRoomController/selectClassRoom')">
									<a >
										<i class="icon-double-angle-right"></i>
										教室录入
									</a>
								</li>

								<li id="course" 
                              onclick="activechange(document.getElementById('paibanguangli'),document.getElementById('course'),'courseAdminController/selectAllCourse')">
									<a>
										<i class="icon-double-angle-right"></i>
										课程录入
									</a>
								</li>
								<!-- <li id="gudinglunbanshizhe"
                          onclick="activechange(document.getElementById('paibanguangli'),document.getElementById('gudinglunbanshizhe'),'SetShift/selectShift')">

									<a >
										<i class="icon-double-angle-right"></i>
										固定轮班设置
									</a>
								</li> -->
							</ul>
						</li>
 

						<li id="kaoqinguangli" >
							<a href="#" class="dropdown-toggle">
								<i class="icon-tag"></i>
								<span class="menu-text"> 考勤管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li  id="kaoqinzhidushezhi" onclick="activechange(document.getElementById('kaoqinguangli'),document.getElementById('kaoqinzhidushezhi'),'menuController/selectSystem')">
									<a>
										<i class="icon-double-angle-right"></i>
										考勤制度设置
									</a>
								</li>
							 
								<li  id="kaoqinleibieshezhi" onclick="activechange(document.getElementById('kaoqinguangli'),document.getElementById('kaoqinleibieshezhi'),'menuController/selectByAttendanceType')">
									<a>
										<i class="icon-double-angle-right"></i>
										考勤类别设置
									</a>
								</li>
							</ul>
						</li>
						<li id="kaoqinchuli">
							<a href="#" class="dropdown-toggle">
								<i class="icon-file-alt"></i>

								<span class="menu-text">
									课程审核
								</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li
							 id="qingjiajiabanchuli" onclick="activechange(document.getElementById('kaoqinchuli'),document.getElementById('qingjiajiabanchuli'),'menuController/selectAllAskForLeave')">
									<a>
										<i class="icon-double-angle-right"></i>
										请假、加班申请处理
									</a>
								</li>

								<li 
								 id="buqianyichang" onclick="activechange(document.getElementById('kaoqinchuli'),document.getElementById('buqianyichang'),'menuController/selectDealwihthRetroative')">
									<a >
										<i class="icon-double-angle-right"></i>
										补签、异常信息处理
									</a>
								</li>
							</ul>
						</li>
							<li id="kaoqingtongji">
							<a href="#" class="dropdown-toggle">
								<i class="icon-file-alt"></i>

								<span class="menu-text">
									考勤统计
								</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li 
								 id="bumentongji" onclick="activechange(document.getElementById('kaoqingtongji'),document.getElementById('bumentongji'),'menuController/attendanceStatistics')">
									<a >
										<i class="icon-double-angle-right"></i>
										部门考勤统计
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>
		       <!--主区显示 -->
		       <div id="mainContainer" class="main-content">
		         
		       </div>
		      
	<script src="${ctx}/js/jquery.min.js"></script>
  	<script type="text/javascript">
			window.jQuery || document.write("<script src='${ctx}/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
        <script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ctx}/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${ctx}/js/bootstrap.min.js"></script>
		<script src="${ctx}/js/typeahead-bs2.min.js"></script>
       <script src="${ctx}/js/ace-elements.min.js"></script>
		<script src="${ctx}/js/ace.min.js"></script>
        <script src="${ctx}/js/main.js"></script>
		<script type="text/javascript">
		 
		 function activechange(curfather,currentElement,gotopath){
			   $(".active").removeClass("active");
			     curfather.setAttribute('class','active open');
			     currentElement.setAttribute('class','active');
			      $.ajax({
					type : 'post',
					url : '${ctx}/'+gotopath+'.do',
					success : function(html) {
					     $('#mainContainer').empty();
					     $('#mainContainer').append(html);
					},
				});
				
			 }
			 function removeActive(){
			    
			      
			 } 
		</script>
	</body>
</html>

