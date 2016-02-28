<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteTopicAction.jsp' starting page</title>
    
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
    	//获取版块编号
    	int boardId = Integer.parseInt(request.getParameter("deleteTboardId"));
    	//获取主贴编号
    	int topicId = Integer.parseInt(request.getParameter("deleteTopicId"));
    	//当前页数
    	int pageNum = 1;
    	if(request.getParameter("pageNumber") != null){
    		pageNum = Integer.parseInt(request.getParameter("pageNumber"));
    	}
    	//当前分页数
    	int listNum = 1;
    	if(request.getParameter("listNum") != null){
    		listNum = Integer.parseInt(request.getParameter("listNum"));
    	}
    	//个人主页用户编号
    	int pageOwer = 1;
    	if(request.getParameter("pageOwer") != null){
    		pageOwer = Integer.parseInt(request.getParameter("pageOwer"));
    	}
    	//删除位置
    	int deleteLocation = Integer.parseInt(request.getParameter("deleteLocation"));
    	//创建DAO
    	TopicDao topicDao = new TopicDao();
    	ReplyDao replyDao = new ReplyDao();
    	//删除所有回帖
    	replyDao.deleteReplysByTopicId(topicId);
    	//删除主贴
    	topicDao.deleteTopicByTopicId(topicId);
    	//跳转回toplist页面
    	if(deleteLocation == 0){
    		request.getRequestDispatcher("topiclist.jsp?boardId="+boardId+"&page="+pageNum+"&list="+listNum).forward(request,response);
    	}
    	//跳转回首页
    	else if(deleteLocation == 1){
    		request.getRequestDispatcher("index.jsp").forward(request,response);
    	}
    	//跳转回个人主页
    	else if(deleteLocation == 2){
    		request.getRequestDispatcher("homepage.jsp?pageOwer="+pageOwer+"&page="+pageNum+"&list="+listNum).forward(request,response);
    	}
    %>
  </body>
</html>
