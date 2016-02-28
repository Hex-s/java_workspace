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
  
  <body>
  	<%-- 表单提交都应使用post --%>
    <form action="loginAction.jsp" method="post">
    	<%-- 提交表单数据时被提交的表单元素必须要加上name属性 --%>
    	userName:<input type="text" name="userName"><br/>
    	password:<input type="password" name="pwd"/><br/>
    	hobby:<input type="checkbox" value="javase" name="hobby"/>JavaSE
    		  <input type="checkbox" value="oracle" name="hobby" />Oracle
    		  <input type="checkbox" value="js" name="hobby"/>JavaScript
    		  <input type="checkbox" value="javaee" name="hobby">JavaEE<br/>
    	<input type="submit" value="regist">
    </form>
    <%-- URL中附带参数提交使用?，多个参数使用&间隔，参数的形式使用键=值的方式来实现 --%>
    <a href="loginAction.jsp?key=value&userName=Jack">提交数据</a><br/>
    
          userName:<input type="text" id="userName"><br/>
    password:<input type="password" id="password"/><br/>
    <a href="javascript:login()">login</a>
    
    <script type="text/javascript">
    function login(){
    	//获取用户名和密码
    	var name = document.getElementById("userName").value;
    	var pwd = document.getElementById("password").value;
    	//将 用户名和密码封装成URL并跳转
    	location.href = "loginAction.jsp?userName="+name+"&pwd="+pwd;
    }
    </script>
  </body>
</html>
