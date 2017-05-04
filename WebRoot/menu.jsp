
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<div class="well sidebar-nav" style="height: 700px;">
            <ul class="nav nav-list" id="menu">
              <li class="nav-header"><i class="icon-wrench"></i> 管理员模块</li>
              <li class="active"><a href="admin.jsp" id="shouapplyFlow">分配人设置</a></li>
              <li><a href="#" id="showdept">部门管理</a></li>
              <li><a href="#" id="usreInfo">员工管理</a></li>
              
            </ul>
            
            <ul class="nav nav-list" id="menu1" userid="${sessionScope.userinfo.userID}">
              <li class="nav-header"><i class="icon-wrench"></i> 普通用户模块</li>
              <li class="active"><a href="ordinary.jsp" id="myapply">我的申请单</a></li>
              <li><a href="#" id="upPwd">修改个人信息</a></li>
            </ul>
          </div>