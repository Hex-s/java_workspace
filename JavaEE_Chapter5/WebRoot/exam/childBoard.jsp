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
    
    <title>My JSP 'childBoard.jsp' starting page</title>
    
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
    子版块页面<hr/>
    <table border="1" width="500">
    	<tr>
    		<th>板块编号</th>
    		<th>板块名称</th>
    		<th>所在父版块</th>
    	</tr>
    	<c:forEach var="board" items="${list}">
    	<tr>
    		<td>${board.boardId }</td>
    		<td><a href="#">${board.boardName }</a></td>
    		<td><a href="#">${parentBoard.boardName }</a></td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
