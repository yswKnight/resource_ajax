<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>申请单管理系统登录</title>
<meta name="keywords" />
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		$(".form-control").blur(function(){
			var username=$(".form-control").val();
			if(username.length==0){
			layer.tips('用户名不能为空', '.form-control',{tips: 1});
			
			}
		});
			
		$("#pwd").blur(function(){
			var pwd=$("#pwd").val();
			if(pwd.length==0){
			layer.tips('密码不能为空', '#pwd',{tips: 1});
			return;
			}
		
		})
		
		$(".floating-btn").click(function(){
			var username=$(".form-control").val();
			var pwd=$("#pwd").val();
			if(username.length==0 || pwd.length==0){
				layer.msg("用户名和密码不能为空")
			}else{
			var submitlist=$("form").serialize();
			$.post("user/user_login.action",submitlist,function(result){
				if(result.msg=="error"){
					layer.msg("用户名或者密码错误");
					return;
				}else{
					if(result.type==0){
					window.location.href="admin.jsp";
					}else{
					window.location.href="ordinary.jsp";
					}
				}
			},"json")
			}
		})
	});
</script>
</head>
<body>

<div class="panel-lite">
  <div class="thumbur">
	<div class="icon-lock"></div>
  </div>
  <form>
  <h4>用户登录</h4>
  <div class="form-group">
	<input required="required" class="form-control" name="userInfo.userID"/>
	<label class="form-label">用户名    </label>
  </div>
  <div class="form-group">
	<input type="password" required="required" class="form-control" id="pwd" name="userInfo.password"/>
	<label class="form-label">密　码</label>
  </div><a href="http://www.hao123.com/">忘记密码 ?  </a>
  <button type="button" class="floating-btn"><i class="icon-arrow"></i></button>
  </form>
</div>

</body>
</html>