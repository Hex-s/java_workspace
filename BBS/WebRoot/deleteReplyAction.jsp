<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteReplyAction.jsp' starting page</title>
    
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
   		ReplyDao replyDao = new ReplyDao();
   		//获取回帖编号
   		int replyId = Integer.parseInt(request.getParameter("replyId"));
   		//获取版块编号
   		int boardId = Integer.parseInt(request.getParameter("boardId"));
   		//获取主贴编号
   		int topicId = Integer.parseInt(request.getParameter("topicId"));
   		//当前页面
   		int pageNum = Integer.parseInt(request.getParameter("page"));
   		//当前分页页面
   		int listNum = Integer.parseInt(request.getParameter("list"));
   		//删除回帖
   		replyDao.deleteReplyByRid(replyId);
   		//跳转会回复页面
   		request.getRequestDispatcher("replylist.jsp?"+"topicId="+topicId+"&boardId="+boardId+"&replyPage="+pageNum+"&list="+listNum).forward(request,response);
    %>
  </body>
</html>
