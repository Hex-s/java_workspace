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
    
    <title>My JSP 'result.jsp' starting page</title>
    
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
    <!-- param表示获取请求中对应的键值数据，并将该请求的值写入bean对象 -->
    <%--<jsp:setProperty property="userName" name="user1" param="name"/>
    <jsp:setProperty property="sex" name="user1" param="userSex"/>--%>
    <% 
    	/*User user = (User)session.getAttribute("user1");
    	out.print(user.getUserName()+"<br>");
    	out.print(user.getSex());*/
    %>
    <!-- EL表达式也能获取请求中的参数 -->
    从elExam1.jsp传递的数据：${param.key }
    
  </body>
</html>
