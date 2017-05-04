<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <title>Users | Strass</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/site.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="laypage/laypage.js"></script>
  <script type="text/javascript" src="js/exit.js"></script>
  <script type="text/javascript">
  	$(function(){
 function show(result){
  	var userID=$('#userID', parent.document).text();
			var content="";
				$.each(result.user1,function(i,v){
					content+="<tr>";
  					content+="<td>"+v.userID+"</td>"
  					content+="<td>"+v.name+"</td>"
  					content+="<td>"+v.email+"</td>"
  					content+="<td>"+v.telephone+"</td>"
  					content+="<td>"+v.deptID.deptName+"</td>"
  					if(userID==v.userID){
  					content+="<td><i class='icon-pencil' title='编辑' id='edit' UserID="+v.userID+"></i></td>"
  					}else{
  					content+="<td><i class='icon-pencil' title='编辑' id='edit' UserID="+v.userID+" deptId="+v.deptID.deptID+"></i>&nbsp;&nbsp;<i class='icon-trash' title='删除' id='delete' UserID="+v.userID+"></i></td>"
  					}
  					content+="</tr>";
				})
				$("#tbody").html(content);

  	}
  	
  	function ready(){
  		$.post("user/user_fenye.action",{"pageNo":1},function(res){
 		show(res);
 		var pageALL=res.pageTotal;   
 		var fenye=$("#fenye"); 

laypage({
        cont: fenye, //容器。值支持id名、原生dom对象，jquery对象。
        pages: pageALL, //通过后台拿到的总页数
        curr: 1, //初始化当前页
        skin: '#1E9FFF',
        jump: function(e){ //触发分页后的回调
         $.getJSON('user/user_fenye.action', {"pageNo": e.curr}, function(res){
               show(res)
                
            });
        }
  	},"json")

		});
  	}
$("body").ready(function(){
		ready();
    });
  
//删除		
$("body").on("click","#delete",function(){
	var id=$(this).attr("UserID")
	var this1=$(this);
	if(window.confirm("你确定删除吗")){
		$.post("user/user_delete.action",{Id:id},function(result){
		if(result=="success"){
			layer.msg("删除成功");
			ready();
		}
	},"text")
	}
	
});

//添加员工预处理
$("#addUser").click(function(){
$.post("dept/dept_list.action",function(result){
	content1="";
	$.each(result,function(i,v){
		content1+="<option value="+v.deptID+">"+v.deptName+"</option>";
	})
	$("#role").html(content1)
},"json")
$("#saveUser1").hide();
$("#saveUser").show();
		$("#UserID").removeAttr("readonly");
	layer.open({
		type:1,
		title:"添加员工",
		content:$("#save"),
		area: ['500px', '430px'],
		anim:3,
		cancel: function(index){ 
  			if(confirm('确定要关闭么')){
  			$("form").get(0).reset();
    		layer.closeAll();
    		$("#save").hide();
  		}
  		return false; 
		}   
		});
});

//验证用户是否已存在
$("#UserID").blur(function(){
	var id=$("#UserID").val();
	$.post("user/user_findById.action",{Id:id},function(result){
		if(result=="error"){
			layer.tips('用户名已存在', '#UserID',{tips: 2});
			return;
		}else{
			layer.tips('OK!', '#UserID',{tips: 2});
		}
	},"text")
});



//添加
$("#saveUser").click(function(){
	var submitlist=$("form").serialize();
	$.post("user/user_save.action",submitlist,function(result){
		if(result=="success"){
			layer.closeAll();
			$("#save").hide();
			$("form").get(0).reset();
			layer.msg("添加成功");
			ready();
		}else{
			layer.clossAll();
			$("#save").hide();
			$("form").get(0).reset();
			layer.msg("添加失败");
		}
	},"text")
});

//修改预处理
$("body").on("click","#edit",function(){
	var id=$(this).attr("UserID")
	var dept=$(this).attr("deptId");
	$.post("dept/dept_list.action",function(result){
		var content2="";
		$.each(result,function(i,v){
		if(v.deptID==dept){
			content2+="<option value="+v.deptID+" selected='selected'>"+v.deptName+"</option>"
			}else{
				content2+="<option value="+v.deptID+">"+v.deptName+"</option>"			
			}
		});	
		$("#role").html(content2);
	},"json")
	$("#saveUser").hide();
	$("#saveUser1").show();
//根据ID查询，然后逐个填进去
	$.post("user/user_findUserById.action",{Id:id},function(result){
		$("#UserID").val(result.user.userID);
		$("#UserID").attr("readonly","readonly")
		$("#userName").val(result.user.name);
		$("#passWord").val(result.user.password);
		$("#telePhone").val(result.user.telephone);
		$("#eMail").val(result.user.email);
	},"json")
	layer.open({
		type:1,
		title:"修改员工信息",
		content:$("#save"),
		area: ['500px', '420px'],
		anim:3,
		cancel: function(index){ 
  			if(confirm('确定要关闭么')){
  			$("form").get(0).reset();
    		layer.closeAll();
    		$("#save").hide();
  		}
  		return false; 
		}   
		
		});
});
$("#saveUser1").click(function(){
	var submitlist=$("form").serialize();
	$.post("user/user_update.action",submitlist,function(result){
		if(result=="success"){
			layer.closeAll();
			$("#save").hide();
			$("form").get(0).reset();
			layer.msg("修改成功");
			$.getJSON("user/user_fenye.action",{"pageNo":1},function(res){
				show(res);
			});
		}else{
			layer.clossAll();
			$("#save").hide();
			$("form").get(0).reset();
			layer.msg("修改失败");
		}
	},"text")
});
$("#back").click(function(){
	$("form").get(0).reset();
    		layer.closeAll();
    		$("#save").hide();
})

//模糊查询
$("#SearCh").click(function(){
var name=$("#name").val();

	$.post("user/user_findUserLikeName.action",{"pageNo":1,"Name":name},function(res){
 		show(res);
 		var pageALL=res.pageTotal;   
 		var fenye=$("#fenye"); 

laypage({
        cont: fenye, //容器。值支持id名、原生dom对象，jquery对象。
        pages: pageALL, //通过后台拿到的总页数
        curr: 1, //初始化当前页
        skin: '#1E9FFF',
        jump: function(e){ //触发分页后的回调
         $.post('user/user_findUserLikeName.action', {"pageNo": e.curr,Name:name}, function(res){
               show(res)
                
            },"json");
        }
    });
  

},"json")
	
});
  	});
  </script>
  <style>
  	
  </style>
  </head>
<body>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span9">
		  <div class="row-fluid">
			<div class="page-header">
				<h1>员工管理 <small>所有员工</small></h1>
			</div>
			<div class="control-group">
						<label class="control-label" for="name">员工姓名</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="name" style="margin-top: 10px;"/>
							<a href="#" class="btn btn-success" id="SearCh">Search</a>&nbsp;&nbsp;&nbsp;
							<a href="#" class="btn btn-success" id="addUser"><i class="icon-plus-sign" style="margin-right: 2px;"></i>New User</a>
						</div>
					</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>邮件地址</th>
						<th>联系电话</th>
						<th>所在部门</th>
						<th>管理</th>
					</tr>
				</thead>
				<tbody id="tbody">
				
				
				</tbody>
			</table>
	
		  </div>
		  <div id="fenye" style="font-size: 18px;"></div>
        </div>
      </div>

    </div>
	<div class="row-fluid" id="save" style="display: none; margin-top: 30px;">
			
			<form class="form-horizontal">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name">用户ID:</label>
						<div class="controls">
						<input type="hidden" class="input-xlarge" id="passWord"  name="userInfo.password"/>
							<input type="text" class="input-xlarge" id="UserID"  name="userInfo.userID"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">用户姓名:</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="userName"  name="userInfo.name"/>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="pnohe">电话:</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="telePhone"  name="userInfo.telephone"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="city">邮件:</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="eMail"  name="userInfo.email"/>
						</div>
					</div>	
					<div class="control-group">
						<label class="control-label" for="role">部门:</label>
						<input type="hidden" id="deptname"/>
						<div class="controls">
							<select id="role" name="userInfo.deptID.deptID">
								
							</select>
						</div>
					</div>	
					
					<div class="form-actions">
						<input type="button" class="btn btn-success btn-large" value="保存信息"  id="saveUser"/><input type="button" class="btn btn-success btn-large" value="保存信息"  id="saveUser1"/><a class="btn" href="#" id="back">返回</a>
					</div>					
				</fieldset>
			</form>
		  </div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {
		$('.dropdown-menu li a').hover(
		function() {
			$(this).children('i').addClass('icon-white');
		},
		function() {
			$(this).children('i').removeClass('icon-white');
		});
		
		if($(window).width() > 760)
		{
			$('tr.list-users td div ul').addClass('pull-right');
		}
	});
	</script>
  </body>
<script type="text/javascript" src="layer/layer.js"></script></html>
