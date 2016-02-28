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
    <% 
    	//获取客户端地址
    	out.print(request.getLocalAddr()+"<br>");
    	//获取访问项目的名称
    	out.print(request.getContextPath()+"<br>");
    	//获取访问的协议
    	out.print(request.getScheme()+"<br>");
    	//获取访问服务器的名称
    	out.print(request.getServerName()+"<br>");
    	//获取访问服务器开放的端口
    	out.print(request.getServerPort()+"<br>");
    	//获取请求提交方式
    	out.print(request.getMethod()+"<br>");
    	//获取当前请求的路径ContextRootUrl
    	out.print(request.getRequestURI()+"<br>");
    	//获取当前请求的完整路径
    	out.print(request.getRequestURL()+"<br>");
    	
    %>
  </body>
</html>
