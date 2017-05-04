<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <title>首页</title>
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
  <script type="text/javascript" src="js/exit.js"></script><script type="text/javascript" src="layer/layer.js"></script></head>
  <script type="text/javascript">
  	$(function(){
  	$("body").ready(function(){
  		listaf();
  	});
  	
  	function listaf(){
  		$.post("applyflow/applyFlow_list.action",function(result){
  			var content="";
  			$.each(result,function(i,v){
  				content+="<tr>";
  				content+="<td>"+v.applyTypeID+"</td>"
  				content+="<td>"+v.applyTypeName+"</td>"
  				content+="<td>"+v.assigner+"</td>"
  				content+="<td><i class='icon-pencil' title='编辑' id='edit' afID="+v.applyTypeID+" afname="+v.applyTypeName+" afass="+v.assigner+"></i></td>"
  				content+="</tr>";
  			})
  			$("#tbody").html(content);
  		},"json")
  	}
  	
  	$("body").on("click","#edit",function(){
  	var type=$(this).attr("afname");
  	var id=$(this).attr("afID");
  	var ass=$(this).attr("afass");
  	
  	$("#name").val(type);
  	$("#afid").val(id);
  	
  		$.post("user/user_listname.action",function(result){
  		var content1="";
  		$.each(result,function(i,v){
  		if(ass==v[0]){
  			content1+="<option value="+v[0]+" selected='selected'>"+v[1]+"</option>"
  			}else{
  				content1+="<option value="+v[0]+">"+v[1]+"</option>"
  			}
  		});
  		$("#role").html(content1);
  		
  		layer.open({
  			type:1,
  			content:$(".Edit"),
  			area: ['520px', '230px'],
  			btn:['提交','取消'],
  			btn1:function(){
  			var submitlist=$("form").serialize();
  				$.post("applyflow/applyFlow_update.action",submitlist,function(result){
  				},"text")
  				$("form").get(0).reset();
				layer.closeAll();
				$(".Edit").hide();
				listaf();
  			},btn2:function(){
			$("form").get(0).reset();
			layer.closeAll();
			$(".Edit").hide();
		},
  		})
  		},"json")
  		
  	});
  	});
  </script>
  <body>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span9">
          
		  <br />
		  <div class="row-fluid">
			<div class="page-header">
				<h1>申请单分配人 <small>分配人设置</small></h1>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>申请单类型</th>
						<th>分配人</th>
						<th>管理</th>
					</tr>
				</thead>
				<tbody id="tbody">
				<tr class="pending-user">
					
					
				</tr>
				
				</tbody>
			</table>
		  </div>
        </div>
      </div>

    </div>

<div class="Edit" style="display: none;">
		<form class="form-horizontal">
				<fieldset>
					<div class="control-group" style="padding-top: 20px">
						<label class="control-label" for="name">类型：</label>
						<div class="controls">
							<input type="hidden" id="afid" name="applyflow.applyTypeID"/>
							<input type="text" class="input-xlarge" id="name" name="applyflow.applyTypeName" readonly="readonly"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="role">分配人:</label>
						<input type="hidden" id="deptname"/>
						<div class="controls">
							<select id="role" name="applyflow.assigner" >
							</select>
						</div>
					</div>	
					
					</fieldset>
					</form>
	</div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
