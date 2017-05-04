<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <title>部门</title>
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
  <script type="text/javascript" src="js/exit.js"></script>
  <script type="text/javascript" src="layer/layer.js"></script></head>
  <script type="text/javascript">
$(function(){
  	function show(){
  		$.post("dept/dept_list.action",function(result){
  			var content="";
				$.each(result,function(i,v){
					content+="<tr>";
  					content+="<td>"+(i+1)+"</td>";
  					content+="<td>"+v.deptName+"</td>";
  					if(v.manager==undefined){
  						content+="<td>-</td>";
  					}else{
  						content+="<td>"+v.manager+"</td>";
  					}
  					content+="<td>"+v.deptInfo+"</td>"
  					if(v.deptID==10 || v.deptID==20){
  					content+="<td><i class='icon-pencil' title='编辑' id='edit' deptID="+v.deptID+"></i></td>"
  					}else{
  					content+="<td><i class='icon-pencil' title='编辑' id='edit' deptID="+v.deptID+" deptMan="+v.manager+"></i>&nbsp;&nbsp;<i class='icon-trash' title='删除' id='delete' deptID="+v.deptID+"></i></td>"
  					}
  					content+="</tr>";
				})
				$("#tbody").html(content);
  		},"json")
  	}
 $("body").ready(function(){

  		show();
  	});
 //模糊查询
$("#searchDept").click(function(){
	var deptname=$("#deptname").val();
	$.post("dept/dept_findByName.action",{deptName:deptname},function(result){
		var content="";
				$.each(result,function(i,v){
					content+="<tr>";
  					content+="<td>"+(i+1)+"</td>"
  					content+="<td>"+v.deptName+"</td>"
  					content+="<td>"+v.manager+"</td>"
  					content+="<td>"+v.deptInfo+"</td>"
  					if(v.deptID==10 || v.deptID==20){
  					content+="<td><i class='icon-pencil' id='edit' deptID="+v.deptID+"></i></td>"
  					}else{
  					content+="<td><i class='icon-pencil' id='edit' deptID="+v.deptID+" deptMan="+v.manager+"></i>&nbsp;&nbsp;<i class='icon-trash' id='delete' deptID="+v.deptID+"></i></td>"
  					}
  					content+="</tr>";
				})
				$("#tbody").html(content);
	},"json")
});

//添加部门
$("#addDept").click(function(){
	//$("#name").attr("readonly","readonly");
	layer.open({
		type:1,
		title:"添加部门",
		content:$(".adddept"),
		area: ['520px', '300px'],
		btn:['提交','取消'],
		anim:3,
		btn1:function(){
			var typename=$("#name").val();
			var remark=$("#remark").val();
			var submitlist=$("form").serialize();
			$("form").get(0).reset();
			$.post("dept/dept_save.action",submitlist,function(result){
				if(result=="success"){
					layer.msg("添加成功");
					show();
				}
			},"text")
			layer.closeAll();
			$(".adddept").hide();
		},btn2:function(){
		$("form").get(0).reset();
			layer.closeAll();
			$(".adddept").hide();
		},cancel: function(index){ 
  			if(confirm('确定要关闭么')){
  			$("form").get(0).reset();
    		layer.closeAll();
    		$(".adddept").hide();
  		}
  		return false; 
		}    
		
	});
});

//删除部门
$("body").on("click","#delete",function(){
	var id=$(this).attr("deptID")
	var this1=$(this);
	if(window.confirm("你确定删除吗")){
		$.post("dept/dept_delete.action",{Id:id},function(result){
		if(result=="success"){
			layer.msg("删除成功");
			this1.parents("tr").remove();
		}else{
			layer.msg("放弃吧，骚年",{icon:5});
		}
	},"text")
	}
});

//修改部门
$("body").on("click","#edit",function(){
	var id=$(this).attr("deptID")
	var deptman=$(this).attr("deptMan");
$.post("user/user_findNameAndIdByDeptId.action",{Id:id},function(result){
		var contetn="";
		$.each(result,function(i,v){
		if(deptman==v[0]){
			contetn+="<option value="+v[0]+" selected='selected'>"+v[1]+"</option>";
			}else{
				contetn+="<option value="+v[0]+">"+v[1]+"</option>";
			}
		});
		$(".Manoption").html(contetn);
	},"json")
$.post("dept/dept_findById.action",{Id:id},function(result){
		$("#deptid").val(result.dept.deptID);
		$("#name").val(result.dept.deptName);
		$("#name").attr("readonly","readonly")
		$("#remark").val(result.dept.deptInfo);
		$(".Manoption").html(contetn);
	},"json")
	$("#Manselect").show();
	layer.open({
		type:1,
		title:"修改部门信息",
		content:$(".adddept"),
		area: ['520px', '300px'],
		btn:['提交','取消'],
		anim:3,
		btn1:function(){
		var submitlist=$("form").serialize();
		
		$.post("dept/dept_save.action",submitlist,function(result){
				if(result=="success"){
					layer.msg("修改成功");
					show();
				}
			},"text")
			
			layer.closeAll();
			$(".adddept").hide();
		},btn2:function(){
		$("form").get(0).reset();
			layer.closeAll();
			$(".adddept").hide();
		},cancel: function(index){ 
  			if(confirm('确定要关闭么')){
  			$("form").get(0).reset();
    		layer.closeAll();
    		$(".adddept").hide();
  		}
  		return false; 
		}    
		
		});
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
				<h1>部门管理 <small>部门设置</small></h1>
			</div>
			<div class="control-group">
						<label class="control-label" for="name">部门名称</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="deptname" style="margin-top: 10px;"/>
							<a href="#" class="btn btn-success" id="searchDept">Search</a>&nbsp;&nbsp;&nbsp;
							<a href="#" class="btn btn-success" id="addDept"><i class="icon-plus-sign" style="margin-right: 2px;"></i>New Department</a>
						</div>
					</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>序号</th>
						<th>部门名称</th>
						<th>部门负责人</th>
						<th>备注</th>
						<th>管理</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
		  </div>
        </div>
      </div>

      <hr>
    </div>
	<div class="adddept" style="display: none;">
		<form class="form-horizontal">
				<fieldset>
					<div class="control-group" style="padding-top: 20px">
						<label class="control-label" for="name">部门名称：</label>
						<div class="controls">
							<input type="hidden" id="deptid" name="department.deptID"/>
							<input type="text" class="input-xlarge" id="name" name="department.deptName"/>
						</div>
					</div>
					<div class="control-group" style="display: none;" id="Manselect">
						<label class="control-label" for="role">负责人:</label>
						<div class="controls">
							<select id="role" class="Manoption" name="department.manager">
							</select>
						</div>
					</div>	
					<div class="control-group">
						<label class="control-label" for="name">备注：</label>
						<div class="controls">
						<textarea rows="4" class="input-xlarge" id="remark" name="department.deptInfo"></textarea>
						</div>
					</div>
					</fieldset>
					</form>
	</div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
