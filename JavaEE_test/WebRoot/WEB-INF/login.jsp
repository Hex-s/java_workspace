<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <body>
    <div>
    	<form action="login.do" method="post" id="loginForm">
    		userName:<input type="text" value="${userName }" id="userName" name="userName"><br/>
    		password:<input type="password" value="${password }" id="pwd" name="pwd"><br/>
    		<input type="checkbox" name="remberName" checked="${remName }">记住用户名&nbsp;<input type="checkbox" name="remeberPwd" checked="${remPwd }">记住密码<br/>
    		<input type="button" value="submit" id="sumbitBtn">
    	</form>
    </div>
  </body>
  <script type="text/javascript">
  	$("#sumbitBtn").click(function(){
  		$("#loginForm").submit();
  	})
  </script>
</html>
