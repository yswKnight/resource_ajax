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
  	function show(result){
			var content="";
			
				$.each(result.apply.result,function(i,v){
				var type="";
					content+="<tr>";
  					content+="<td>"+(i+1)+"</td>"
  					content+="<td>"+v.applyID+"</td>"
  					if(v.applyStatus==0){
  						type="待审批"
  					}
  						if(v.applyStatus==1){
  						type="待分配"
  					}
  						if(v.applyStatus==2){
  						type="待处理"
  					}
  						if(v.applyStatus==3){
  						type="归档"
  					}
  						if(v.applyStatus==4){
  						type="审批否决"
  					}
  					if(v.applyStatus==5){
  						type="待反馈"
  					}
  					content+="<td>"+v.applyTypeID.applyTypeName+"</td>"
  					content+="<td>"+v.applyTitle+"</td>"
  					if(v.approver==undefined){
  					content+="<td>-</td>"
  					}else{
  						content+="<td>"+v.approver+"</td>"
  					}
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
  					content+="<td>"+type+"</td>"
  					content+="<td>"+v.applyDate+"</td>"
  					if(v.applyStatus!=0){
  					content+="<td><i class='icon-pencil' title='编辑' id='edit' AppID="+v.applyID+"></i></td>"
  					}else{
  						content+="<td><i class='icon-pencil' title='编辑' id='edit' AppID="+v.applyID+"></i>&nbsp;&nbsp;<i class='icon-trash' title='删除' id='delete' AppID="+v.applyID+"></i></td>"
  					}
  					content+="</tr>";
				})
				$("#tbody").html(content);

  	}
  	
  	
  		$("body").ready(function(){
  			$.post("apply/apply_list.action",{"pageNo":1,Id:userID},function(res){
 			show(res);

laypage({
        cont: fenye, //容器。值支持id名、原生dom对象，jquery对象。
        pages: res.apply.pageTotal, //通过后台拿到的总页数
        curr: 1, //初始化当前页
        skin: '#1E9FFF',
        jump: function(e){ //触发分页后的回调
         $.getJSON('apply/apply_list.action', {"pageNo": e.curr,Id:userID}, function(res){
               show(res)
                
            });
        }
        });
  	},"json")
  		})
  		$("#addApply").click(function(){
  		layer.open({
  			type:1,
  			content:$("#applyType"),
  			area: ['300px', '200px'],
  			btn:['确定'],
  			btn1:function(){
  				layer.closeAll();
  				$("#applyType").hide();
  				var type=$("select option:selected").val();
  				var jsp="";
  				if(type==1){
  					jsp="space.jsp";
  				}else if(type==2){
  					jsp="officeEmail.jsp";
  				}else{
  					jsp="IPAddress.jsp";
  				}
  				layer.open({
  					type:2,
  					title:'填写申请单',
  					content:jsp,
  					area: ['900px', '540px'],
  					 /* success: function(layero, index){
    					var body = layer.getChildFrame('body', index);
    					console.log(body.html()) //得到iframe页的body内容
    					body.find('input').attr("readonly","readonly")
  }*/
  				});
  				
  				
  			},cancel:function(){
  			$("#applyType").hide();
  				layer.closeAll();
  			}
  		})
  	})
  	
  	});
  </script>
  <body>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span9">
          
		  <br />
		  <div class="row-fluid">
			<div class="page-header">
				<h1>申请单 <small>我的申请单</small></h1>
			</div>
			<div class="control-group">
						<label class="control-label" for="name">员工姓名</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="name" style="margin-top: 10px;"/>
							<a href="#" class="btn btn-success" id="SearCh">Search</a>&nbsp;&nbsp;&nbsp;
							<a href="#" class="btn btn-success" id="addApply"><i class="icon-plus-sign" style="margin-right: 2px;"></i>新建</a>
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


	
	<div id="applyType" align="center" style="margin-top: 20px; display: none;">
    	<select>
    		<option value="1">存储空间申请单</option>
    		<option value="2">办公邮箱申请单</option>
    		<option value="3">IP地址申请单</option>
    	</select>
    </div>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </body>
</html>
