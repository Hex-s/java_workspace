<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BoardDao"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.Board"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.util.CommonUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	
  });
  </script>
  <body>
  <div id="body">
  	<!-- 页眉 -->
  	<div id="head">
  		<div id="title">
  			<span style="padding-left: 20px; font-size: 30px; font-weight: bold;">NIIT</span>
  			<span style="font-size:30px; font-weight: bold;">BBS</span>
  		</div>
  		<div id="login">
  		<%-- include指令用来包含指定的页面 --%>
  		<%@include file="validateLogin.jsp" %>
  		<% 
  			User loginUser = null;
  			//判断当前用户是否登陆
  			if(session.getAttribute("loginUser") != null){
  				loginUser = (User)session.getAttribute("loginUser");
  		%>
  			<a href="#"><%=loginUser.getUserName() %></a>
  			<a href="#">退出登陆</a>
  		<%		
  			}
  			else{
  		%>
  			<a href="#">登陆</a>
  			<a href="#">注册</a>
  		<% 
  			}
  		%>
  		</div>
  	</div>
  	<!-- 版块信息 -->
	<table border="0" id="boardContent" cellspacing="0">
		<tr height="50" style="background-color: #06C;color: white">
			<th>版块名称</th>
			<th>主贴数</th>
			<th>最后发表</th>
		</tr>
		<% 
			//创建DAO对象
			BoardDao boardDao = new BoardDao();
			TopicDao topicDao = new TopicDao();
			UserDao userDao = new UserDao();
			//查询所有的父版块
			ArrayList<Board> parentBoardList = boardDao.findBoardListById(0);
			//遍历所有的父版块
			for(Board parentBoard : parentBoardList){
		%>
		<tr>
			<td colspan="3" height="35" style="padding-left: 20px"><%=parentBoard.getBoardName() %></td>
		</tr>
		<%	
				//根据父版块的编号查询对应的子板块集合
				ArrayList<Board> childBoardList = boardDao.findBoardListById(parentBoard.getBoardId());
				//遍历子版块集合
				for(Board childBoard : childBoardList){
					//根据子版块编号查询主贴数量
					int count = topicDao.findTopicCountByBoardId(childBoard.getBoardId());
					//根据子版块编号查询最后发表的主贴
					Topic topic = topicDao.findLastTopicByBoardId(childBoard.getBoardId());
					//根据最后发表的主贴编号查询发帖人的信息
					User user = userDao.findUserById(topic.getUserId());
		%>
		<tr height="35" class="childBoardRow">
			<td style="padding-left: 20px"><a href="topiclist.jsp?boardId=<%=childBoard.getBoardId() %>"><%=childBoard.getBoardName() %></a></td>
			<td align="center"><%=count %></td>
			<td style="padding-left: 20px; padding-top: 10px; padding-bottom: 10px">
				<div style="margin-bottom: 10px"><a href="#"><%=topic.getTitle() %></a></div>
				<div>
					发帖人: <a href="#"><%=user.getUserName() %></a>
					最后发表: <%=CommonUtil.formatDate(topic.getModifyTime()) %>
				</div>
			</td>
		</tr>
		<%	
				}
			}
		%>
	</table>
  	<!-- 页脚 -->
  	<div id="foot" style="text-align: center;">
  		CopyRight2014 NIIT
  		<a href="WEB-INF/publish.jsp">publish.jsp</a>
  		<% 
  			//request.getRequestDispatcher("WEB-INF/publish.jsp").forward(request,response);
  		%>
  	</div>
  </div>
  </body>
</html>
