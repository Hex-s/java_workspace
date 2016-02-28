<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wellcome.jsp' starting page</title>
    
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
    	//登陆的用户名
    	String name = "niit";
    	
    	//如果登陆的用户名没有填写则页面显示为带有超链接的登陆
    	//如果登陆的用户是admin则显示后台管理界面
    	//如果登陆的用户是普通用户则显示欢迎用户归来的页面
    	
    	if(name == null){
    %>
    	<div><a href="#">[登陆]</a></div>
    <%
    	}
    	else if(name.equals("admin")){
    %>
    	<div>欢迎管理员：<a href="#"><%=name%></a></div>
    <%	
    	}
    	else{
    %>
    	<div>欢迎 <a href="#"><%=name%></a> 回来</div>
    <%	
   		}
    %>
  </body>
</html>
