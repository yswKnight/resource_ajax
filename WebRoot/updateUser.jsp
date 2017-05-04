<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>New User | Strass</title>
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
  <script type="text/javascript" src="layer/layer.js"></script></head>
  <script type="text/javascript">
  	$(function(){
 var userID=$('#userID', parent.document).text();
  		$("#uppwd").click(function(){
  			$("#UPUSER").hide();
  			$("#UPPWD").show();
  		})
  		$("#upuser").click(function(){
  			$("#UPPWD").hide();
  			$("#UPUSER").show();
  		})
 $("body").ready(function(){
 var deptid=0;
 $.post("user/user_findUserById.action",{Id:userID},function(result){
			$("#UserID").val(result.user.userID);
			$("#userName").val(result.user.name);
			$("#passWord").val(result.user.password);
			$("#telePhone").val(result.user.telephone);
			$("#eMail").val(result.user.email);
			$("#password2").val(result.user.password);
			$("#password1").val(result.user.password);
			$("#dept2").val(result.user.deptID.deptID);
	},"json");
  		
		
		
$.post("dept/dept_list.action",function(result){
	var dept=$("#dept2").val();
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
  		});
 //修改基本信息
 $("#saveUser").click(function(){
	var submitlist=$("#form").serialize();
	alert(submitlist);
	$.post("user/user_update.action",submitlist,function(result){
		if(result=="success"){
			$("#form").get(0).reset();
			layer.msg("修改成功");
		}else{
			$("#form").get(0).reset();
			layer.msg("修改失败");
		}
	},"text")
});

//修改密码
 $("#savePwd").click(function(){
 alert($("#newpwd").val());
	$.post("user/user_updatePwd.action",{Pwd:$("#newpwd").val(),Id:userID},function(result){
		if(result=="success"){
			$("#form").get(0).reset();
			layer.msg("修改成功");
		}else{
			$("#form").get(0).reset();
			layer.msg("修改失败");
		}
	},"text")
});

$("#password").blur(function(){
	var password1=$("#password1").val();
	var password=$("#password").val();
	if(password1==password){
		layer.tips('OK', '#password',{tips: 2});
	}else{
		layer.tips('与原密码不一致', '#password',{tips: 2});
		$(this).focus();
	}
	$.post("")
})
  	})
  </script>
  <body>
    

    <div class="container-fluid">
      <div class="row-fluid">
       
        <div class="span9">
		  <div class="row-fluid" id="UPUSER" >
			<div class="page-header">
				<h1>员工操作 <small>修改员工基本信息</small></h1><input id="uppwd" type="button" class="btn btn-success btn-large" value="修改密码" style="float: right"/>
			</div>
			<form class="form-horizontal" id="form">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name">用户ID:</label>
						<div class="controls">
						<input type="hidden" class="input-xlarge" id="dept2" value="" name="userInfo.deptID.deptID"/>
						<input type="hidden" class="input-xlarge" id="password2" value="" name="userInfo.password"/>
							<input type="text" class="input-xlarge" id="UserID"  name="userInfo.userID" readonly="readonly"/>
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
							<select id="role"  disabled="disabled">
								
							</select>
						</div>
					</div>	
				
					<div class="form-actions">
						<input type="button" id="saveUser" class="btn btn-success btn-large" value="Save User" />
					</div>					
				</fieldset>
			</form>
		  </div>
		  
		  <div class="row-fluid" id="UPPWD" style="display: none;">
			<div class="page-header">
				<h1>员工操作 <small>修改员工密码</small></h1><input type="button" id="upuser" class="btn btn-success btn-large" value="修改基本信息" style="float: right"/>
			</div>
			<form class="form-horizontal" id="form1">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="name">原密码:</label>
						<div class="controls">
							<input type="hidden" class="input-xlarge" id="password1" value=""/>
							<input type="text" class="input-xlarge" id="password" name="userInfo.password"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">新密码:</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="newpwd" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="pnohe">再次输入新密码</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="tnewpwd" />
						</div>
					</div>
					
					<div class="form-actions">
						<input type="button" id="savePwd" class="btn btn-success btn-large" value="Save User" />
					</div>					
				</fieldset>
			</form>
		  </div>
        </div>
      </div>

    </div>

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
