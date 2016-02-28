<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BoardDao"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.Board"%>
<%@page import="com.niit.entity.Topic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topiclist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">

  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$(".childBoardRow").mouseenter(function(){
  		$(this).addClass("boardEnter");
  	}).mouseleave(function(){
  		$(this).removeClass("boardEnter");
  	});
  	
  	$(".pageCode").mouseenter(function(){
  		$(this).css("background-color","white");
  	}).mouseleave(function(){
  		$(this).css("background-color","#F3F3F3");
  	});
  });
  function forwardPage(page,boardId){
  	location.href = "topiclist.jsp?page="+page+"&boardId="+boardId;
  }
  </script>
  <body>
  	<%@include file="validateLogin.jsp" %>
    <%  
    	//获取板块编号 
    	int boardId = Integer.parseInt(request.getParameter("boardId")); 
    	//创建DAO 
    	BoardDao boardDao = new BoardDao(); 
    	TopicDao topicDao = new TopicDao(); 
    	ReplyDao replyDao = new ReplyDao(); 
    	UserDao userDao = new UserDao(); 
    	//查询板块的名称 
    	Board board = boardDao.findBoardById(boardId); 
    	//查询主贴数
    	int topicCount = topicDao.findTopicCountByBoardId(boardId);
    	 
    	int pageNum; 
    	if(request.getParameter("page") == null){ 
    		pageNum = 1; 
    	} 
    	else{ 
    		pageNum = Integer.parseInt(request.getParameter("page")); 
    	} 
    	//分页查询该板块的主贴 
    	ArrayList<Topic> topicList = topicDao.findTopicListByBoardId(boardId,pageNum); 
    %>
    <div id="body">
  	<!-- 页眉 -->
  	<div id="head">
  		<div id="title">
  			<span style="padding-left: 20px; font-size: 30px; font-weight: bold;">NIIT</span>
  			<span style="font-size:30px; font-weight: bold;">BBS</span>
  		</div>
  		<div id="login">
  			<a href="#">登陆</a>
  			<a href="#">注册</a>
  		</div>
  		<div id="navigation">
  			<a href="#">首页</a>
  			&gt;&gt;
  			<%=board.getBoardName() %>
  		</div>
  		<!-- 分页 -->
  		<div style="margin-top: 10px">
  			<div style="float: left; line-height: 20px">
  		<% 
  			//计算总页数
  			int totalPage;
  			if(topicCount%5 == 0){
  				totalPage = topicCount/5;
  			}
  			else{
  				totalPage = topicCount/5+1;
  			}
  			if(pageNum == 1){
  		%>
  				<a href="topiclist.jsp?page=<%=pageNum+1 %>&boardId=<%=boardId %>">下一页</a>
  		<%
  			}
  			else if(pageNum == totalPage){
  		%>
  				<a href="topiclist.jsp?page=<%=pageNum-1 %>&boardId=<%=boardId %>">上一页</a>
  		<%
  			}
  			else{
  		%>
	  			<a href="topiclist.jsp?page=<%=pageNum-1 %>&boardId=<%=boardId %>">上一页</a>
	  			<a href="topiclist.jsp?page=<%=pageNum+1 %>&boardId=<%=boardId %>">下一页</a>
  		<% 
  			}
  		%>
  			</div>
  			<div style="float: right;">
  			<% 
  				for(int i = 1; i <= totalPage; i++){
  			%>
  			<div class="pageCode" onclick="forwardPage(<%=i%>,<%=boardId %>)"><%=i %></div>
  			<%	
  				}
  			%>
  			</div>
  			<div style="clear: both;"></div>
  		</div>
  	</div>
  	<!-- 主贴信息 -->
	<table border="0" id="boardContent" cellspacing="0">
		<tr height="50" style="background-color: #06C;color: white">
			<th>主贴名称</th>
			<th>回帖数</th>
			<th>作者</th>
		</tr>
		<% 
			//遍历主贴
			for(Topic topic : topicList){
				//查询回帖数
				int replyCount = replyDao.findReplyCountByTopicId(topic.getTopicId());
				//查询发帖人
				User user = userDao.findUserById(topic.getUserId());
		%>
		<tr class="childBoardRow" height="35">
			<td width="70%"><img src="image/topic.gif" style="margin:0 10"/><a href="#"><%=topic.getTitle() %></a></td>
			<td align="center" width="10%"><%=replyCount %></td>
			<td width="20%" align="center"><a href="#"><%=user.getUserName() %></a></td>
		</tr>
		<%
			}
		%>
	</table>
  	<!-- 页脚 -->
  	<div id="foot">
  		CopyRight2014 NIIT
  	</div>
  </div>
  </body>
</html>
