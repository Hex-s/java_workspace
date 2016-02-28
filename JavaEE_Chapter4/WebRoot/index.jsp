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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	sessionid=<%=session.getId() %><br/>
  	<%--获取session的最大存在时间，单位是秒 --%>
  	<%=session.getMaxInactiveInterval() %>
  	<% 
  		//强制销毁会话
  		session.invalidate();	
  	%>
  	
  	<hr/>
    <form action="loginAction.jsp" method="post">
    	username:<input type="text" name="userName">
    	<input type="submit" value="login">
    </form>
  </body>
</html>
