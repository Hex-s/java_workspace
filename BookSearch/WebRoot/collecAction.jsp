<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.CollectDao"%>
<%@page import="com.niit.entiry.Collect"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCollecAction.jsp' starting page</title>
    
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
    	CollectDao collectDao = new CollectDao();
    	int userId = Integer.parseInt(request.getParameter("userId"));
    	int bookId = Integer.parseInt(request.getParameter("bookId"));
    	int type = Integer.parseInt(request.getParameter("type"));
    	Collect collect = new Collect(userId,bookId);
    	if(type == 1){
    		collectDao.addCollect(collect);
    	}
    	else{
    		collectDao.deleteCollect(collect);
    	}
    	request.getRequestDispatcher("bookInfo.jsp?bookId="+bookId).forward(request,response);
     %>
  </body>
</html>
