<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.Block"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>NIIT BBS</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">
	
  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  
  <body>
  <div id="body">
 	<!-- 页眉 -start -->
 	<div id="title">
 		<div style="font-size: 25px;width:300px;float:left;">NIIT BBS</div>
 		<div style="float:right;padding-top: 20px;padding-right: 10px;">
 		<%
 			if(session.getAttribute("loginUser") == null){
 		%>
 		<a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a>
 		<%	
 			
 			}else{
 				User loginUser = (User)session.getAttribute("loginUser");
 		%>
 		欢迎&nbsp;<a href="homepage.jsp?pageOwer=<%=loginUser.getUserId() %>"><%=loginUser.getuName() %></a>&nbsp;|&nbsp;&nbsp;<a href="exitLoginAction.jsp" id="exit">退出登录</a>
 		<%		
 			}
 		 %>
 		</div>
 	</div>
 	<!-- 页眉 -end -->
 	<!-- 版块 -start -->
 	<div style=" padding-top: 20px;">
 	<table id="index_table" cellpadding="0" cellspacing="0">
 		<tr style="height: 60px;background-color: #ACDAFE;font-weight: bold;font-size: 40px;width: 300px;">
 			<td width="300">&nbsp;版块名称</td>
 			<td width="150" align="center">版主</td>
			<td width="150" align="center">主贴数</td>
			<td style="padding-left: 20px;">最新发帖</td>
 		</tr>
 		<%
 			UserDao userDao = new UserDao();
 			BlockDao blockDao = new BlockDao();
 			TopicDao topicDao = new TopicDao();
 			ReplyDao replyDao = new ReplyDao();
 			//查询所有的父版块
 			ArrayList<Block> parentBoardList = blockDao.findBlockListById(0);
 			//遍历所有的父版块
 			for(Block parentBlock : parentBoardList){
 		%>
 		<tr style="font-weight: bold;height: 60px;"><td colspan="4"><img src="image/pic1.jpg" width="20" height="30" align="middle"><%=parentBlock.getbName() %></td></tr>
 		<%	
 			//根据父版块的编号查询对应的子板块集合
 			ArrayList<Block> childBlockList = blockDao.findBlockListById(parentBlock.getbId());
 			//遍历子版块集合
 			for(int i = 0; i < childBlockList.size();i++){
 				Block childBlock = childBlockList.get(i);
 				//根据子版块编号查询主贴数量
 				int count = topicDao.findTopicCountByBlockdId(childBlock.getbId());
 				//根据子版块编号查询最后发表的主贴
 				Topic topic = topicDao.findLastTopicByBlockdId(childBlock.getbId());
 				//根据父版块编号查询版主名称
 				User master = userDao.findUserById(childBlock.getMasterId());
 		%>
 		<tr height="35" id="boardContent">
			<td style="padding-left: 20px;font-weight:500;"><img src="image/index-arrow.jpg">&nbsp;<a href="topiclist.jsp?boardId=<%=childBlock.getbId() %>"><%=childBlock.getbName() %></a></td>
			<td align="center"><a href="homepage.jsp?pageOwer=<%=master.getUserId() %>"><%=master.getuName() %></a></td>
			<td align="center"><%=count %></td>
			<td style="padding-left: 20px; padding-top: 10px; padding-bottom: 10px">
			<%
				if(topic != null){
					//根据最后发表的主贴编号查询发帖人的信息
 					User user = userDao.findUserById(topic.gettUserId());
			%>
				<div style="margin-bottom: 10px"><a href="replylist.jsp?topicId=<%=topic.gettId() %>&boardId=<%=topic.getTbId() %>&deleteLocation=1"><%=topic.gettTitle() %></a></div>
				<div>
					发帖人: <a href="homepage.jsp?pageOwer=<%=user.getUserId() %>"><%=user.getuName() %></a>
					最后发表: <%=CommonUtil.formatDate(topic.gettLastEdit()) %>
				</div>
			<%	
				}
			 %>
				
			</td>
		</tr>
 	
 		<% 	
 				}
 			}
 		 %>
  
 	</table>
 	</div>
 	<!-- 版块 -end -->
 	<!-- 页脚 -start -->
 	<div style="padding-left: 350px;border-top: gray 1px solid;">
 		<table style="padding-top: 20px;width: 250px;">
 			<tr>
 				<td>论坛信息</td>
 				<td>联系我们</td>
 				<td>加入论坛</td>
 				<td>意见反馈</td>
 			</tr>
 			<tr>
 				<td colspan="4" align="center">&reg;CopyRight 2014</td>
 			</tr>
 		</table>
 	</div>
 	<!-- 页脚 -end -->
  </div>
  </body>
</html>
