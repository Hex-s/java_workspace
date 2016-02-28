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
    
    <title>My JSP 'board.jsp' starting page</title>
    
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
  	<table border="1">
  		<tr>
  			<th colspan="2">板块名称</th>
  		</tr>
    <c:forEach var="element" items="${boardMap}">
    	<tr>
    		<td colspan="2">${element.key }</td>
    	</tr>
    	<c:forEach var="board" items="${element.value}">
    	<tr>
    		<td width="50"></td>
    		<td width="200"><a href="#">${board.boardName }</a></td>
    	</tr>
    	</c:forEach>
    </c:forEach>
    </table>
  </body>
</html>
