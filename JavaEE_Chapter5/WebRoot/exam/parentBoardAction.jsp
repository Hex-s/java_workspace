<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BoardDao"%>
<%@page import="com.niit.entity.Board"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'parentBoardAction.jsp' starting page</title>
    
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
    	//查询所有的父版块 
    	BoardDao boardDao = new BoardDao();
    	ArrayList<Board> list = boardDao.findBoardListById(0);
    	//将集合传递给下一个页面
    	request.setAttribute("list",list);
    	request.getRequestDispatcher("parentBoard.jsp").forward(request,response);
    %>
  </body>
</html>
