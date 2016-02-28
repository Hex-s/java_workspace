<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'phoneJsp.jsp' starting page</title>
    
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
  
    <jsp:useBean id="phone" class="com.niit.entiry.Phone"></jsp:useBean>
    <jsp:setProperty property="brand" name="phone" value="iphone"/>
    <jsp:setProperty property="phoneType" name="phone" value="5s"/>
    
    <%
    	Date date = new Date();
    	pageContext.setAttribute("buyTime",date);
     %>
    <jsp:useBean id="user" class="com.niit.entiry.User"></jsp:useBean>
    <jsp:setProperty property="userName" name="user" value="tom"/>
    <jsp:setProperty property="phone" name="user" value="${phone}"/>
    <jsp:useBean id="time" class="java.util.Date"></jsp:useBean>
    <jsp:setProperty property="buyTime" name="user" value="${time}"/>
    
    
   用户：${user.userName}<br/>
   手机  ：${user.phone.brand },${user.phone.phoneType}<br/> 
   购买时间   ：${user.buyTime}
    
  </body>
</html>
