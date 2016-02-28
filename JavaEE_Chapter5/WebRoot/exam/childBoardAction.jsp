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
    
    <title>My JSP 'childBoardAction.jsp' starting page</title>
    
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
   		//获取父版块的编号
   		int boardId = Integer.parseInt(request.getParameter("boardId"));
   		BoardDao boardDao = new BoardDao();
   		//根据父版块编号查询子版块
   		ArrayList<Board> list = boardDao.findBoardListById(boardId);
   		request.setAttribute("list",list);
   		//查询父版块对象
   		Board parentBoard = boardDao.findBoardById(boardId);
   		request.setAttribute("parentBoard",parentBoard);
   		request.getRequestDispatcher("childBoard.jsp").forward(request,response);
   		
   	%>
  </body>
</html>
