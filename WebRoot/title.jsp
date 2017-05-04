<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-col lapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">资源信息管理系统</a>
          <div class="btn-group pull-right">
          	<input type="hidden" id="deptid" value="${sessionScope.userinfo.deptID.deptID}"/>
			<a class="btn" id="userID" href="#"><i class="icon-user"></i>${sessionScope.userinfo.userID}</a>
            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
			  <li><a href="my-profile.html">个人设置</a></li>
              <li class="divider"></li>
              <li><a href="#" id="exit">退出</a></li>
            </ul>
          </div>
          
        </div>
      </div>
    </div>