<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<!-- useBean标签用来构建JavaBean对象 -->
  	<!-- scope表示创建bean后存储的范围，默认为page,表示存储在pageContext中 -->
    <jsp:useBean id="user" class="com.niit.entity.User" scope="request"></jsp:useBean>
    <jsp:useBean id="user1" class="com.niit.entity.User" scope="session"></jsp:useBean>
    <% 
    	//useBean标签等同于如下代码
    	//User user = new User();
    	//pageContext.setAttribute("user",user);
    	//out.print(request.getAttribute("user"));
    %>
    <!-- setProperty标签用来对已有对象的属性进行赋值 -->
    <!-- name表示需要赋值对象的名称 -->
    <jsp:setProperty property="userId" name="user" value="1001"/>
    <jsp:setProperty property="userName" name="user" value="jack"/>
    <jsp:setProperty property="sex" name="user" value="male"/>
    <% 
    	//out.print(((User)request.getAttribute("user")).getSex());
    %>
    <!-- getProperty标签用来对属性进行呈现 -->
    userId:<jsp:getProperty property="userId" name="user"/><br/>
    userName:<jsp:getProperty property="userName" name="user"/><br/>
    sex:<jsp:getProperty property="sex" name="user"/>
    
    <form action="result.jsp" method="post">
    	userName:<input type="text" name="name"><br/>
    	sex:<input type="radio" value="male" name="userSex">male<input type="radio" value="female" name="userSex"/>female<br/>
    	<input type="submit"/>
    </form>
    <!-- 等价于请求跳转 -->
    <jsp:forward page="WEB-INF/page/myPage.jsp">
    	<jsp:param value="value" name="key"/>
    </jsp:forward>
    
  </body>
</html>
