<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.entity.Reply"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'replyAction.jsp' starting page</title>
    
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
    	//获取回帖内容
    	String replyContent = request.getParameter("replyContent");
    	//获取帖子编号
    	int topicId = Integer.parseInt(request.getParameter("topicId"));
    	//获取版块编号
    	int baordId = Integer.parseInt(request.getParameter("getbaordId"));
    	System.out.print(baordId);
    	if(!replyContent.equals("")){
    		//获取回帖用户
    		User replyUser =(User) session.getAttribute("loginUser");
    		//构建回帖对象
    		Reply reply = new Reply();
    		reply.setrUserid(replyUser.getUserId());
    		reply.setrTid(topicId);
    		reply.setrContent(replyContent);
    		//新增回帖
    		ReplyDao replyDao = new ReplyDao();
    		replyDao.addReply(reply);
  			//跳转回回帖页面
  			request.getRequestDispatcher("replylist.jsp?"+"topicId="+topicId+"&boardId="+baordId).forward(request,response);
    	}
    	else{
    		request.getRequestDispatcher("replylist.jsp?"+"topicId="+topicId+"&boardId="+baordId).forward(request,response);
    	}
     %>
    
  </body>
</html>
