<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'main.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${ctx}/css/zTreeStyle.css" type="text/css">
 	<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.ztree.excheck-3.5.js"></script>
	
   <style type="text/css">
   .onediv{
   min-height:300px;height:100%;float: left
   }
   .twodiv{
   min-height:236px;width:100%;height:100%;
   }
   td{ /* padding-left: 40px; */
       padding-top: 10px;}
    #tbodyid td{
    text-align: center;
    }
   </style>
   <SCRIPT type="text/javascript">
		 var setting = {
			view: {
				dblClickExpand: true,
				selectedMulti : false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick
			}
		};	 
		var setting2 = {
				/* view: {
					dblClickExpand: true,
					selectedMulti : true
				}, */
				data: {
					simpleData: {
						enable: true
					}
				},
				check: {
					enable: true,
					chkStyle: "checkbox",
					chkboxType: { "Y": "p", "N": "s" }
				},
				callback: {
					onClick: onClick
				}
			};		
		function beforeClick(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;
		}
	     var departmentid=0;
		  function onClick(e, treeId, treeNode) {
		      $("#txtjigoubianhao").val(treeNode.number);
		      $("#cboshangjijigou").val(treeNode.fatherid);
		      $("#txtjigoumingcheng").val(treeNode.name);
		      $("#txtjigouurl").val(treeNode.lujin);
		      $("#txtremark").val(treeNode.remark);
		      departmentid=treeNode.id;
		      selectOpsition(treeNode.id);
		}
		  
		  $(document)
			.ready(
					function() {
						bangdingDepartment();//查询部门下拉树
						selectOpsition();
						$("#myModal").modal("hide");
					});

		function showMenu(){
	     $("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			//$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
       var zNode=[];
	   $(document).ready(function(){
	     initZtree();
		 showMenu();
		 bangdingOpsition(2);
		});
		
		//职务下拉框的加载
	function bangdingOpsition(attributeGatherId){
		 $.ajax({
            async: false,//同步异步
			type : 'post',
			url : '${ctx}/setDeparment/selectByAttributeGatherId.do'+'?attributeGatherId='+attributeGatherId,
	         dataType: "json", 
	         scriptCharset: "utf-8",
			 success: function(data) {
			      $('#cboOpsition').empty();
			      for(var i=0;i<data.length;i++){
			      var tr="<option value='"+data[i].attributegatherchildid+"'>"+data[i].name+"</option>";
				  $('#cboOpsition').append(tr);
				 }
			},
		  });
	}
		//初始化下拉树
	 function initZtree(){
	  $("#btnSelectCustomer").show();
       <c:forEach items="${departments}" var="dp">  
       zNode.push({id:"${dp.id}", pId:"${dp.parentid}", name:"${dp.name}",fatherid:"${dp.parentid}",lujin:"${dp.url}",open:true});
       </c:forEach> 
	   $.fn.zTree.init($("#treeDemo"), setting, zNode);
	 }
		var insert=0;
		var update=0;
		//功能新增操作
		function dpinsert(){
		   insert=1;
	      cancleDisabled();
	      $("#btndpinsert").attr({"disabled":"disabled"});
	      $("#btndpupdate").attr({"disabled":"disabled"});
	      $("#btndpdelete").attr({"disabled":"disabled"});
	      $("#txtjigouurl").val("");
	      $("#txtjigoumingcheng").val("");
		}
		//功能保存操作
		function dpsave(){
		var lujin=$("#txtjigouurl").val().trim();
		var mingcheng=$("#txtjigoumingcheng").val().trim();
		var fathid=$("#cboshangjijigou").val();
		//insert==1进行机构新增
		if(insert==1){
		if(mingcheng!=""){
		 if(panduan(mingcheng)){
		 alert("该机构名称已经存在，请重新输入！");
		}
		else{
		  ajax("/setFunction/insert?fatherid="+fathid+"&name="+mingcheng+"&url="+lujin,"新增");
		  	} 
		}
		else{
		alert("机构名称不能为空");
		}
		}
		else{
		//编辑进行保存
		if(update==1){
		if(mingcheng!=""){
		 if(panduan(mingcheng,departmentid)){
		 alert("该机构名称或编号已经存在，请重新输入！");
		}
		else{
		  ajax("/setFunction/update?fatherid="+fathid+"&name="+mingcheng+"&departmentid="+departmentid+"&url="+lujin,"更新");
		  	} 
		}
		else{
		alert("机构编号或机构名称不能为空");
		}
		}	 
		}
		
		}
		
		//重新加载数据
		function refresh(){
		//主界面的方法
		activechange(document.getElementById("renshiguanli"),document.getElementById("setDepartment"),"setFunction/main");
		}
		//判断机构编号是否相同
		function panduan(name){
		var b=false;
		for (var i = 0; i < zNode.length; i++) {
		
        if(zNode[i].name.trim()==name){
	        b=true; 
	       }
		
		}
		return b;
		}
		//机构删除操作
		function dpdelete(){
			if(confirm("是否确定删除此机构")){
				   ajax("/setFunction/delete?departmentid="+departmentid,"删除");
				} 
		}
		
		//ajax操作
		function ajax(url,caozuo,puanduan){
         $.ajax({
            async: true,//同步异步
			type : 'post',
			url : '${ctx}/'+url,
			success : function(data) {
				 if(data=="1"){
				 	alert(caozuo+"成功!"); 
				 	if(1!=puanduan){				 		
				 			refresh();
				 		}
				 	else{
				 			selectOpsition();
				 		}
				 }
				 else{
				  alert(caozuo+"失败");
				 }
			},
		  });
		 
		}
		 
		//机构修改操作
		function dpupdate(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getSelectedNodes();
		if(nodes.length==1){
		  update=1;
		  $("#btndpinsert").attr({"disabled":"disabled"});
		  $("#btndpdelete").attr({"disabled":"disabled"});
		  cancleDisabled();
			}
			else{
			if(nodes.length>1){
			alert("不能同时选择多个机构进行修改");
			}
			else{
			alert("请选择需要修改的机构");
			}
			}
		}
		//机构取消操作
		function dpcancle(){
		   insert=0;
		   update=0;
	       $("#btndpinsert").removeAttr("disabled"); 
           $("#btndpupdate").removeAttr("disabled"); 
           $("#txtjigoumingcheng").removeAttr("disabled"); 
           $("#txtjigouurl").removeAttr("disabled"); 
       
           $("#btndpdelete").removeAttr("disabled"); 
           disabled();
		}
		//取消文本禁用
		function cancleDisabled(){
		
           $("#cboshangjijigou").removeAttr("disabled"); 
           $("#txtjigoubianhao").removeAttr("disabled"); 
           $("#txtjigoumingcheng").removeAttr("disabled"); 
           $("#txtjigouurl").removeAttr("disabled");
           $("#txtremark").removeAttr("disabled"); 
		}
		//禁用文本
		function disabled(){
		 $("#cboshangjijigou").attr({"disabled":"disabled"});
		 $("#txtjigoubianhao").attr({"disabled":"disabled"});
	      $("#txtjigoumingcheng").attr({"disabled":"disabled"});
	      $("#txtjigouurl").attr({"disabled":"disabled"});
	      $("#txtremark").attr({"disabled":"disabled"});
		}
		//查询角色
		function selectOpsition(){
		 $.ajax({
            async: false,//同步异步
			type : 'post',
			url : '${ctx}/roleController/selectAllRole',
	         dataType: "json", 
	         scriptCharset: "utf-8",
			 success: function(data) {
			      $('#tbodyid').empty();
			      for(var i=0;i<data.length;i++){
			      var tr="<tr><td>"+"<a href=javascript:deleteOpsition("+data[i].roleid+")>【删除】</a>　　<a href=javascript:insertPosition(0,'"+data[i].roleid+"','"+data[i].positionid+"')>【编辑】</a>"+"</td><td>"+data[i].rolename+"</td><td>"+data[i].createdate+"</td></tr>";
				 $('#tbodyid').append(tr);
				 }
			  
			},
		  });
		 
		
		}
    var positionid;
	//新增修改角色
	function insertPosition(add_edit,id,zhiwuid){
	if(add_edit==0){
	   	 	$("#tladd_edit").empty();
			$("#tladd_edit").append("修改角色");
			$("#cboOpsition").val(zhiwuid);
			//$("#txthidden").val("edit");
			$.ajax({
				async : false,//同步异步
				type : 'post',
				url : "${ctx}/roleController/selectRoleById?id=" + id,
				dataType : "json",
				scriptCharset : "utf-8",
				success : function(data) {
					var tree = $.fn.zTree.getZTreeObj("treeDemo2");
					tree.checkAllNodes(false);
					for ( var i = 0; i < data[1].length; i++) {
						var node = tree.getNodeByParam("id",data[1][i].permissionid);
						alert(node.id);
						tree.checkNode(node, true, true);
					}										
					$("#txthidden").val(data[0].rolename);
					$("#idhidden").val(data[0].roleid);
					alert(data[0].rolename);					
				},
			});

		}
	else{
			alert("进入新增页面");
	 		$("#tladd_edit").empty();
			$("#tladd_edit").append("新增角色");
			$("#txthidden").val("add");
		 
		}
		$("#myModal").modal("show");
	}
	
	
	//角色保存
	function opsitionsave(){
	var arraylistnumber=[];
	var nodes = $.fn.zTree.getZTreeObj("treeDemo2").getCheckedNodes(true);
	for(var i=0;i<nodes.length;i++){  
		arraylistnumber.push(nodes[i].id); 
		alert(arraylistnumber[i]+"---");
        }  
	var name = $("#txthidden").val();
	if($("#idhidden").val()==""){
		alert("进行新增操作");
	 ajax("/roleController/addRole?list="+arraylistnumber+"&name="+name+"&add_edit=add","新增",1); 
	 $("#myModal").modal("hide");
	}
	 else{
		 alert("进行修改操作id为："+$("#idhidden").val());
		 var rid = $("#idhidden").val();
      ajax("/roleController/updateRole?list="+arraylistnumber+"&name="+name+"&rid="+rid+"&add_edit=edit","修改",1);
      $("#txthidden").val("");
	  $("#idhidden").val("");
	  var tree = $.fn.zTree.getZTreeObj("treeDemo2");
	  tree.checkAllNodes(false);
	  $("#tladd_edit").empty();
	  $("#tladd_edit").append("新增角色");
	  $("#myModal").modal("hide");
	 } 
	}
	//删除角色
	function deleteOpsition(roleid){
	if(confirm("是否确定删除此角色")){
	   ajax("/roleController/deleteRole?roleid="+roleid,"删除",1);
	} 
	}
	
	//显示待勾选权限
	function showMenu2() {
		var cityObj = $("#Department");
		var cityOffset = $("#Department").offset();
		$("#menuContent").css({
			left : "340px",
			top : "72px"
		}).slideDown("fast");
	}
	//查询功能绑定下拉树、
	function bangdingDepartment() {
		var zNode2 = [];
		$.ajax({
			async : false,//同步异步
			type : 'post',
			url : '${ctx}/setFunction/selectFunction',
			dataType : "json",
			scriptCharset : "utf-8",
			success : function(data) {
				for ( var i = 0; i < data.length; i++) {
					zNode2.push({
						id : data[i].id,
						pId : data[i].parentid,
						name : data[i].name,
						open : true
					});
				}
				$.fn.zTree.init($("#treeDemo2"), setting2, zNode2);

			},
		});
	}

	</SCRIPT>
    <body style="text-align: center">
    <div></div>
    <div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="#">首页</a>
			</li>
			<li><a href="#">人事管理</a>
			</li>
			<li class="active">功能设置</li>
		</ul>
    </div>
	<div class="onediv">
	<fieldset><legend>选择功能↓↓↓</legend>
    <ul  id="treeDemo" class="ztree" style="margin-top:0; width:260px;" ></ul>
    </fieldset>
    </div>
    <div>
    <div class="twodiv">
   <fieldset>
    <legend style="margin-bottom: 5px;">功能操作↓↓↓</legend>
    <table>
    <tr>
    <td colspan="2"><div>
    <span
									class="input-group-btn">
									<button id="btndpinsert" type="button" 
										onclick="dpinsert()"
										class="btn btn-info btn-sm" style="font-size:14px">
										新 增 <i class="icon-plus-sign icon-on-right bigger-120"></i>
									</button> </span> <span class="input-group-btn"></span> <span
									class="input-group-btn">
									<button id="btndpupdate" type="button" class="btn btn-warning btn-sm"
										onclick="dpupdate()"
										style="font-size:14px">
										编辑<i class="icon-pencil icon-on-right bigger-120"></i>
									</button> </span> <span class="input-group-btn"></span> <span
									class="input-group-btn">
									<button id="btndpdelete" type="button"
										onclick="dpdelete()"
										class="btn btn-danger btn-sm" style="font-size:14px">
										删 除 <i class="icon-trash icon-on-right bigger-120"></i>
									</button> </span>
									<span class="input-group-btn"></span> <span
									class="input-group-btn">
									<button id="btndpsave" onclick="dpsave()" type="button"
										class="btn btn-sm btn-success">
										保 存 <i class="icon-check icon-on-right bigger-110"></i>
									</button>
									</span>
									<span class="input-group-btn"></span> <span
									class="input-group-btn">
									<button  id="btndpcancle" type="reset" onclick="dpcancle()" class="btn btn-sm btn-warning">
										取消 <i class="icon-undo icon-on-right bigger-110"></i>
									</button></span>
    </div></td>
    </tr>
     
    <tr>
    <td>上级机构</td>
    <td><select id="cboshangjijigou" disabled="disabled" >
    <option value="0" >无上级功能</option>
     <c:forEach items="${departments}" var="dp">  
     <option value="${dp.id}" >${dp.name}</option>
       </c:forEach> 
    </select></td>
    </tr>
    <tr>
    <td>功能名称</td>
    <td><input id="txtjigoumingcheng" disabled="disabled"></td>
    </tr>
    <td>功能url</td>
    <td><input id="txtjigouurl" disabled="disabled"></td>
    </tr>
    </table>
    </fieldset>
 
 <legend style="margin-bottom: 5px;">角色操作↓↓↓</legend> 
       
						<div class="table-responsive" style="position:relative;">
						
							<table id="sample-table-2" style="border: 2px solid #dddddd;"
								class="table table-striped table-bordered table-hover">
								<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">添加角色</button>
								<thead>
									<tr>
										<th style="text-align: center;">操作</th>
										<th style="text-align: center;">角色名称</th>	
										<th style="text-align: center;">创建时间</th>								
									 </tr>
								</thead>
								<tbody id="tbodyid">
								</tbody>
							</table>
						</div>
					</fieldset>
    </div>
    </div>

 
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="width:800px;height: 500px;display:none">  
  <div class="modal-dialog">  
    <div class="modal-content">  
     <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
        <h4 id="tladd_edit" style="text-align:center" class="modal-title">新增角色</h4>  
      </div>  
     <div class="modal-body">
     <div style="text-align: center">
             <span style="font-size: 16px; padding: 10px;" >角色名称</span>
             <input id="txthidden" name="name" >
             <input id="idhidden" name="id" type="hidden" >
      </div> 
      <div style="text-align: center;height: 326px">
      <span style="font-size: 16px; padding: 10px;" >权限分配</span>
					<td><input id="Department" readonly="readonly" type="text"
						onblur="hideMenu()" onclick="showMenu2()" style="width:200px"
						class="form-control"> <input type="hidden"
						id="txtDepartmentid">
					</td>
      </div>
      <div id="menuContent" class="menuContent"
		style="displayx: none; position: absolute;z-index: 99;background-color: #f9f9f9;min-height: 200px;">
		<ul id="treeDemo2" class="ztree" style="margin-top: 0; width: 195px;">
		</ul>
	  </div>
      
     </div>  
     <div class="modal-footer" >  
      <button type="button" class="btn btn-sm btn-warning" data-dismiss="modal">关闭</button>  
       <button type="button" onclick="opsitionsave()" class="btn btn-primary" data-dismiss="modal">保存</button>  
     </div>  
   </div>
  </div> 
</div> 
 
 
  </body>
</html>
