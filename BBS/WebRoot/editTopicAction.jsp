<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%@page import="com.niit.entity.Block"%>
<%@page import="com.niit.entity.Topic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editTopicAction.jsp' starting page</title>
    
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
    	//设置字符集编码
    	request.setCharacterEncoding("utf-8");
    	//创建DAO
    	TopicDao topicDao = new TopicDao();
    	UserDao userDao = new UserDao();
    	BlockDao boardDao = new BlockDao();
    	//获取修改位置   0：在topiclist中点击编辑，修改后返回topiclist   1: 在replylist中点击编辑，修改后返回replylist
    	int editLocation = Integer.parseInt(request.getParameter("editLoc"));
    	//获取主贴编号
    	int topicId = Integer.parseInt(request.getParameter("editTopicId"));
    	//获取主贴对象
    	Topic topic = topicDao.findTopicById(topicId);
    	//获取板块编号
    	int boardId = 1;
    	Block block = null;
    	if(request.getParameter("boardId") != null){
    		boardId = Integer.parseInt(request.getParameter("boardId"));
    		//查询版块
    		block = boardDao.findBlockById(boardId);   
    	}
    	
    	 
    	//获取当前页面
    	int pageNum = Integer.parseInt(request.getParameter("page"));
    	//获取当前分页
    	int listNum = Integer.parseInt(request.getParameter("list"));
    	//获取新的标题内容
    	//String title = request.getParameter("title");
    	//获取新的内容
    	String content = request.getParameter("content");
    	
    	String test = request.getParameter("test");
    	//out.print("标题："+test+",内容:"+content);
    	
    	//修改主贴信息
    	topicDao.modifyTopicById(topicId,test,content);
    	
    	//跳转回topiclist页面
    	if(editLocation == 0){
    		request.getRequestDispatcher("topiclist.jsp?boardId="+boardId+"&page="+pageNum+"&list="+listNum).forward(request,response);
    	}
    	//跳转回replylist页面
    	else if(editLocation == 1){
    		request.getRequestDispatcher("replylist.jsp?topicId="+topicId+"&boardId="+boardId+"&replyPage="+pageNum+"&list="+listNum).forward(request,response);
    	}
    	//跳转回个人主页
    	else if(editLocation == 2){
    		request.getRequestDispatcher("homepage.jsp?pageOwer="+topic.gettUserId()+"&page="+pageNum+"&list"+listNum).forward(request,response);
    	}
     %>
  </body>
</html>
