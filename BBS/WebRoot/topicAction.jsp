<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topicAction.jsp' starting page</title>
    
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
   		//设置字符编码
    	request.setCharacterEncoding("utf-8");
    	//获取版块编号
    	int boardId = Integer.parseInt(request.getParameter("topicBoardId"));
    	//获取帖子标题
    	String topicTitle = request.getParameter("tpTitle");
    	//获取帖子内容
    	String topicContent = request.getParameter("tpContent");
    	//获取当前用户
    	User user =(User) session.getAttribute("loginUser");
    	//构建帖子对象
    	Topic topic = new Topic();
    	topic.settUserId(user.getUserId());
    	topic.settContent(topicContent);
    	topic.settTitle(topicTitle);
    	topic.setTbId(boardId);
    	//新增帖子
    	TopicDao topicDao = new TopicDao();
    	topicDao.addTopic(topic);
    	
    	//跳转页面
    	request.getRequestDispatcher("topiclist.jsp?boardId="+boardId).forward(request,response);
     %>
  </body>
</html>
