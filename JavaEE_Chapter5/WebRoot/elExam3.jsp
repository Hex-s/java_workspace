<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'elExam3.jsp' starting page</title>
    
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
  	<!-- 创建user对象 -->
    <jsp:useBean id="user" class="com.niit.entity.User"></jsp:useBean>
    <!-- 创建 book对象 -->
    <jsp:useBean id="book" class="com.niit.entity.Book"></jsp:useBean>
    <!-- 从作用域中获取book对象，并将对象放入user对象的book属性中 -->
    <jsp:setProperty property="book" name="user" value="${book}"/>
    <jsp:useBean id="time" class="java.util.Date"></jsp:useBean>
    <!-- 将时间对象写入user属性 -->
    <jsp:setProperty property="time" name="user" value="${time}"/>
    ${user.time }
    
    <!-- user类中具备phone,userName,buyTime属性，phone具备brand,phoneType属性，-->
    <!-- 要求创建并设置这些对象的属性值，buyTime使用当前系统时间 ,在页面中显示用户的姓名和电话的所有属性值 -->
  </body>
</html>
