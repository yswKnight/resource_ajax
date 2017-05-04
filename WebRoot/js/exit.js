$(function(){
	$("#exit").click(function(){
  		$.get("user/user_exit.action",function(){
  			window.location="login.jsp";
  		})
  	});
	
})
