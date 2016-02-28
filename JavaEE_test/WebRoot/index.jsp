<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
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
          用户名：<input type="text" id = "userName"/><br>
          密码：<input type="password" id = "pwd"/><br>
   <a href="javascript:login()">提交数据</a> 
    <script type="text/javascript">
    function login(){
    	var name = document.getElementById("userName").value;
    	var pwd = document.getElementById("pwd").value;
    	location.href = "login.jsp?userName="+name +"&pwd="+pwd;
    }
    
    </script>
  </body>
</html>
