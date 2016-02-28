<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entiry.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginAction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//设置字符集编码
    	request.setCharacterEncoding("utf-8");
    	
    	String userName = request.getParameter("userName");
    	String password = request.getParameter("password");
    	//查找用户名是否存在
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserName(userName);
    	
    	//将登陆的用户保存至session
		session.setAttribute("loginUser",user);
		//页面跳转至板块页面
		response.sendRedirect("index.jsp");
     %>
  </body>
</html>
