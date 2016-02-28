<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'title.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css">

  </head>
  
  <body>
    <div id="body">
    	<!-- 标题 -start -->
    	<div id="title">
    		<div id="logo">图书搜索系统</div>
    		<c:choose>
    			<c:when test="${empty loginUser}">
    				<div class="loginState"><a href="index.jsp">[&nbsp;首&nbsp;页&nbsp;]</a>&nbsp;<a href="loginServlet.do">[&nbsp;登&nbsp;录&nbsp;]</a><a href="#">[&nbsp;注&nbsp;册&nbsp;]</a></div>
    			</c:when>
    			<c:when test="${not empty loginUser}">
    				<div class="loginState">欢迎&nbsp;${loginUser.uName}&nbsp;|&nbsp;<a href="index.jsp">首页</a>&nbsp;|&nbsp;<a href="collect.do">收藏</a>&nbsp;|&nbsp;<a href="exitLoginServlet.do">注销</a></div>
    			</c:when>
    			
    		</c:choose> 		
    	</div>
    	<!-- 标题 -end -->
    </div>
  </body>
</html>
