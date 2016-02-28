<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">
	
  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$("#loginBtn").click(function(){
  		//修改表单的action参数
  		$("#loginForm").get(0).action = $("#loginForm").attr("action")+"?type=bbs";
  		$("#loginForm").submit();
  	});
  	
  	$("#chatBtn").click(function(){
  		//修改表单的action参数
  		$("#loginForm").get(0).action = $("#loginForm").attr("action")+"?type=chat";
  		$("#loginForm").submit();
  	});
  })
  </script>
  <body>
    <div id="body">
  	<!-- 页眉 -->
  	<div id="head">
  		<div id="title">
  			<span style="padding-left: 20px; font-size: 30px; font-weight: bold;">NIIT</span>
  			<span style="font-size:30px; font-weight: bold;">BBS</span>
  		</div>
  	</div>
  	<div>
  		<form action="loginAction.jsp" method="post" id="loginForm">
  		<div style=" margin: auto; margin-top: 50px; margin-bottom: 50px;">
  			<div style="width: 500px; padding-left: 350px"> 
	  			<span style="color: #666">用户名:</span>
	  			<input type="text" name="userName" style="width: 150px"/>
	  			<span style="color: red">
	  			<% 
 					if(request.getAttribute("nameError") != null){
 						out.print(request.getAttribute("nameError"));
 					}
  				%>
	  			</span>
  			</div>
  			<div style="margin-top: 20px; margin-bottom: 20px;width: 500px; padding-left: 350px">
  				<span style="color: #666">密&nbsp;&nbsp;码:</span>
  				<input type="password" name="password" style="width: 150px"/>
  				<span style="color: red">
	  			<% 
 					if(request.getAttribute("pwdError") != null){
 						out.print(request.getAttribute("pwdError"));
 					}
  				%>
	  			</span>
  			</div>
  			<div style="width: 500px; padding-left: 406px">
  				<input value="论坛" type="button" id="loginBtn" style="margin-right: 5px;"/>
				<input value="聊天室" type="button" id="chatBtn"/>
  			</div>
  			<div style="color: red; text-align: center;">
  			<% 
  				if(request.getAttribute("error") != null){
  					out.print(request.getAttribute("error"));
  				}
  			%>
  			</div>
  		</div>		
  		</form>
  	</div>
  	<!-- 页脚 -->
  	<div id="foot" style="text-align: center;">
  		CopyRight2014 NIIT
  	</div>
  </div>
  </body>
</html>
