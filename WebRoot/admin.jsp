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
</head>
<script>
$(function(){
	 $("#showapplyFlow").click(function(){
  		$("#iframe").attr('src','applyflow.jsp');
  });
	
  $("#showdept").click(function(){
  		$("#iframe").attr('src','department.jsp');
  });
  
  $("#usreInfo").click(function(){
  		$("#iframe").attr('src','users.jsp');
  });
});

  </script>
<body>
   <jsp:include page="title.jsp"></jsp:include>


    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3" style="width: 300px;">
          <jsp:include page="menu.jsp"></jsp:include>
        </div>
         <iframe id="iframe" src="/applyFlow.jsp" width="80%" height="700px" style="margin-left: 50px; " ></iframe>
      </div>
	
      <footer class="well" style="position:fixed; bottom:0; width:96%; text-align: center">
        &copy; Strass - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="............">.......</a> - Collect from <a href="http://www.cssmoban.com/" title="武汉厚溥教育科技有限公司" target="_blank">武汉厚溥教育科技有限公司</a>
      </footer>

    </div>
	
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
	$(function() {
		$("#menu1").hide();
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
