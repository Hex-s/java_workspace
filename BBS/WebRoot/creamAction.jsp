<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.entity.Topic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addremovejinghua.jsp' starting page</title>
    
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
    	//创建DAO
    	TopicDao topicDao = new TopicDao();
    	//获取当前主贴类型 1：精华帖 0：普通帖
    	int type = Integer.parseInt(request.getParameter("type"));
    	//获取版块编号
    	int boardId = Integer.parseInt(request.getParameter("modifyBoardID"));
    	//获取主贴编号 
    	int topicId = Integer.parseInt(request.getParameter("modifyTopicId"));
    	//当前页面
    	int pageNum = Integer.parseInt(request.getParameter("pageNumber"));
    	//当前分页页面
    	int listNum = Integer.parseInt(request.getParameter("list"));
    	//修改主贴状态
    	if(type == 1){
    		topicDao.modifyTopicFlag(topicId,0);
    	}
    	else{
    		topicDao.modifyTopicFlag(topicId,1);
    	}
    	Topic topic = topicDao.findTopicById(topicId);
    	//跳转页面
    	request.getRequestDispatcher("topiclist.jsp?page="+pageNum+"&boardId="+boardId+"&list="+listNum).forward(request,response);
    	
    	
     %>
  </body>
</html>
