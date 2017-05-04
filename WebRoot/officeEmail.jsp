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
  <script type="text/javascript" src="layer/layer.js"></script></head>
  <script type="text/javascript">
  	$(function(){

  		$("#save").click(function(){
  			var submitlist=$("#form").serialize();
  			$.post("apply/apply_save.action",submitlist,function(result){
  				
				if(result=="success"){
				layer.msg('添加成功',{icon: 1})
				}else{
					layer.msg('添加失败',{icon: 2})
				}  				
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index);
				window.parent.location.reload();
  			},"json")
  		})
  		$("#cancel").click(function(){
  			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index);
  		});
  	});
  </script>
  <body>
  <!--<div id=""log>
  	<table>
  		<thead>
  			<tr><td>序号</td><td>操作类型</td><td>操作结果</td><td>操作说明</td><td>操作人</td><td>操作日期</td></tr>
  		</thead>
  	</table>
  </div>
  --><div align="center" style="margin-top: 40px;">
  <form id="form">
    <table>
    	<tr><td>申请人ID:</td><td colspan="2"><input type="hidden" value="${sessionScope.userinfo.userID }" name="apply.userID"/><span>${sessionScope.userinfo.userID }</span></td><td>申请部门:</td><td><span>${sessionScope.userinfo.deptID.deptName }</span></td></tr>
    	<tr><td>申请人姓名:</td><td colspan="2"><span>${sessionScope.userinfo.name }</span></td><td>联系电话：</td><td><input type="text" name="apply.phone"/></td></tr>
    	<tr><td>申请标题</td><td colspan="4"><input type="text" style="width: 572px" name="apply.applyTitle"/></td></tr>
    	<tr><td>申请原因</td><td colspan="4"><input type="text" style="width: 572px" name="apply.applyReason"/></td></tr>
    	<tr><td></td><td>空间(M):</td><td><input type="text" name="emailApply.zone"/></td><td>办公地点:</td><td><input type="text" name="emailApply.officePlace"/></td></tr>
    	<tr><td colspan="5">基本内容:</td></tr>
    	<tr><td></td><td>使用者姓名:</td><td><input type="text" name="emailApply.userName"/></td><td>姓名全拼:</td><td><input type="text" name="emailApply.fullName"/></td></tr>
    	<tr><td>备注:</td><td colspan="4" ><textarea style="width: 572px" name="apply.remark"></textarea></td></tr>
    	<tr><td>附件:</td><td colspan="4" ><input type="file" style="background-color: gray;width: 572px;"/></td></tr>
    	
    	<tr><td colspan="5" align="center"><input type="button" value="提交" id="save"/><input type="button" value="取消" id="cancel"/></td></tr>
    </table>
    </form>
    </div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>