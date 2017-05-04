<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="utf-8">
    <title>我的申请单</title>
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
  <script type="text/javascript" src="layer/layer.js"></script>
  <script type="text/javascript" src="laypage/laypage.js"></script></head>
  <script type="text/javascript">
  	$(function(){
  	var userID=$('#userID', parent.document).text();
  	var deptid=$('#deptid', parent.document).val();
  	
  	function show(result){
			var content="";
			
				$.each(result.ListFP.result,function(i,v){
				var type="";
					content+="<tr>";
  					content+="<td>"+(i+1)+"</td>"
  					content+="<td><a href='#' id='appid' appid="+v.applyID+">"+v.applyID+"</a></td>"
  					content+="<td>"+v.applyTypeID.applyTypeName+"</td>"
  					content+="<td>"+v.applyTitle+"</td>"
  					content+="<td>"+userID+"</td>"
  					if(v.assigner==undefined){
  					content+="<td>-</td>"
  					}else{
  						content+="<td>"+v.assigner+"</td>"
  					}
  					if(v.dealer==undefined){
  					content+="<td>-</td>"
  					}else{
  						content+="<td>"+v.dealer+"</td>"
  					}
  					content+="<td>待分配</td>"
  					content+="<td>"+v.applyDate+"</td>"
  					content+="<td><i class='icon-file' title='查看' id='edit' appID="+v.applyID+" ></i><i class='icon-pencil' title='设置处理人' id='setting' appID="+v.applyID+"></i></td>"
  					content+="</tr>";
				})
				$("#tbody").html(content);

  	}
  	
  	
 $("body").ready(function(){
  			$.post("apply/apply_listFP.action",{"pageNo":1,userid:userID},function(res){
 			show(res);

laypage({
        cont: fenye, //容器。值支持id名、原生dom对象，jquery对象。
        pages: res.ListSP.pageTotal, //通过后台拿到的总页数
        curr: 1, //初始化当前页
        skin: '#1E9FFF',
        jump: function(e){ //触发分页后的回调
         $.getJSON('apply/apply_listFP.action', {"pageNo": e.curr,userid:userID}, function(res){
               show(res)
                
            });
        }
        });
  	},"json")
  		});
  	$("body").on("click","#setting",function(){
  	var appid=$(this).attr("appID");
  	alert(appid);
  		$.post("user/user_listname.action",function(result){
  		var content1="";
  			$.each(result,function(i,v){
  				content1+="<option value="+v[0]+">"+v[1]+"</option>"
  		});
  		$("#role").html(content1);
  		},"json");
  		layer.open({
  			type:1,
  			title:'设置分配人',
  			content:$("#assigner"),
  			area: ['400px', '200px'],
  			btn:['确定','取消'],
  			btnAlign: 'c',
  			btn1:function(){
  			var assginer=$("select option:selected").val();
  				$.post("apply/apply_assginer.action",{appid:appid,assginer:assginer},function(res){
  					if(res=="success"){
  						layer.msg('操作成功',{icon:5});
  					}else{
  						layer.msg('操作失败',{icon:6});
  					}
  				},"text")
  				$("#assigner").hide();
  				layer.closeAll();
  				$.post("apply/apply_listFP.action",{"pageNo":1,userid:userID},function(res){
 				show(res);
 			},"json");
  			},btn2:function(){
  				$("#assigner").hide();
  				layer.closeAll();
  			}
  		})
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
				<h1>申请单分配</h1>
			</div>
			<div class="control-group">
						<label class="control-label" for="name">员工姓名</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="name" style="margin-top: 10px;"/>
							<a href="#" class="btn btn-success" id="SearCh">Search</a>&nbsp;&nbsp;&nbsp;
						</div>
					</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>序号</th>
						<th>申请单号</th>
						<th>申请类型</th>
						<th>标题</th>
						<th>审批人</th>
						<th>分配人</th>
						<th>处理人</th>
						<th>申请状态</th>
						<th>申请日期</th>
						<th>管理</th>
					</tr>
				</thead>
				<tbody id="tbody">
				
				</tbody>
			</table>
		  </div>
		  <div id="fenye"></div>
        </div>
      </div>

    </div>
    <div id="assigner" style="display: none;" align="center">
    	<div class="control-group">
						
						<div class="controls">
						<label class="control-label" for="role">分配人:</label>
							<select id="role">
								
							</select>
						</div>
					</div>	
    </div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
