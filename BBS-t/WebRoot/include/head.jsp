<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">

  </head>
  
  <body>
    <!-- 页眉 -->
  	<div id="head">
  		<div id="title">
  			<span style="padding-left: 20px; font-size: 30px; font-weight: bold;">NIIT</span>
  			<span style="font-size:30px; font-weight: bold;">BBS</span>
  		</div>
  		<div id="login">
  		<% 
  			User loginUser = null;
  			//判断当前用户是否登陆
  			if(session.getAttribute("loginUser") != null){
  				loginUser = (User)session.getAttribute("loginUser");
  		%>
  			<a href="#"><%=loginUser.getUserName() %></a>
  			<a href="loginOff.jsp">退出登陆</a>
  		<%		
  			}
  			else{
  		%>
  			<a href="#">登陆</a>
  			<a href="#">注册</a>
  		<% 
  			}
  		%>
  		</div>
  	</div>
  </body>
</html>
