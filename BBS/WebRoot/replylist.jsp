<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.entity.Block"%>
<%@page import="com.niit.entity.User"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.entity.Reply"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'replylist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" type="text/css" href="css/bbs-common.css">
   <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$("#submitReply").click(function(){
  		$("#replyForm").submit();
  	})
  })
  </script>
  <body>
    <%
    	
    	//创建DAO 
        BlockDao boardDao = new BlockDao();
       	TopicDao topicDao = new TopicDao(); 
       	ReplyDao replyDao = new ReplyDao(); 
       	UserDao userDao = new UserDao(); 
       	//进入地址 0：index 1:toplist 2:个人主页
       	
       	//获取主贴编号 
    	int topicId = Integer.parseInt(request.getParameter("topicId"));
    	//获取板块编号
    	int boardId = Integer.parseInt(request.getParameter("boardId"));
    	//查询版块
    	Block block = boardDao.findBlockById(boardId);    
    	//新增点击量
    	topicDao.addClickCount(topicId);
       	//查询主贴
       	Topic topic = topicDao.findTopicById(topicId);      	
       
       	//查询发帖人
       	User topicUser = userDao.findUserById(topic.gettUserId());
       	//查询发帖人性别
       	String sex = "";
       	if(topicUser.getuSex() == 0){
       		sex = "男";
       	}
       	else{
       		sex = "女";
       	}
       	//发帖人生日
       	String birthday = CommonUtil.formatBirthday(topicUser.getuBirthday());
       	//注册时间
       	String regTime = CommonUtil.formatBirthday(topicUser.getuRegdate());
       	//查询主贴标题
       	String title = topic.gettTitle(); 
       	//查询主贴内容
       	String content = topic.gettContent();
       	//查询主贴发布时间
       	String publishTime = CommonUtil.formatDate(topic.gettPublishTime());
       	//查询最后修改时间
       	String lastEdit = CommonUtil.formatDate(topic.gettLastEdit());
       	//查询主贴点击数
       	int cliclCount = topic.gettClickCount();
       	//查询精华帖
       	int tflag = topic.gettFlag();
       	//回帖总数
		int replyCount = replyDao.findReplyCountByTopicId(topicId);
       	//当前页数 
       	int pageNum; 
       	if(request.getParameter("replyPage") == null){ 
       		pageNum = 1; 
       	} 
       	else{ 
       		pageNum = Integer.parseInt(request.getParameter("replyPage")); 
       	} 
       		//当前分页数
       	int listNum;
       	if(request.getParameter("list") == null){
       		listNum = 1;
       	}
       	else{
       		listNum = Integer.parseInt(request.getParameter("list"));
       	}
       	//查询所有的回帖
       	ArrayList<Reply> replyList = replyDao.findReplyListByTopicId(topicId,pageNum);
       	//登录用户
       	User loginUser = null;
       	if(session.getAttribute("loginUser") != null){
       		loginUser = (User)session.getAttribute("loginUser");
       	}
     %>
    <div id="body">
   		<!-- 页眉 -start -->
		<div id="title">
			<div style="font-size: 25px;width:300px;float:left;">NIIT BBS</div>
 		<div style="float:right;padding-top: 20px;padding-right: 10px;">
 		<%
 			if(loginUser == null){
 		%>
		<a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a>
 		<%	
 			
 			}else{
 		%>
 		欢迎&nbsp;<a href="homepage.jsp?pageOwer=<%=loginUser.getUserId() %>"><%=loginUser.getuName() %></a>&nbsp;|&nbsp;<a href="index.jsp">首页</a>&nbsp;|&nbsp;<a href="exitLoginAction.jsp" id="exit">退出登录</a>
 		<%		
 			}
 		 %>
 		</div>
		</div>
		<div style="clear: both;"></div>
		<!-- 页眉 -end -->
		<!-- 主题部分 -start -->
		<div>
			<!-- 用户信息 -start -->
			<div style="width: 230px;border-right: 1px gray solid;float: left;height: 700px;">
				
				<table height="400" align="center">
					<tr><td>发帖人信息</td></tr>
       				<tr><td>..........................</td></tr>
     				<tr><td><img src="image/head/<%=topicUser.getuHead()%>" width="100" height="150"/></td></tr>
     				<tr><td>用户名：<%=topicUser.getuName() %></td></tr>
     				<tr><td>性别：<%=sex %></td></tr>
     				<tr><td>积分：<%=topicUser.getuPoint() %></td></tr>
     				<tr><td>邮箱：<%=topicUser.getuEmail() %></td></tr>
     				<tr><td>生日:<%=birthday %></td></tr>
     				<tr><td>简介：<%=topicUser.getuStatement() %></td></tr>
     				<tr><td>注册时间：<%=regTime %></td></tr>
     				<tr><td>居住地：<%=topicUser.getAddress()%></td></tr>
     			</table>
			</div>
			<!-- 用户信息 -end -->
			<!-- 主贴信息 -start -->
			<div style="width: 700px;float: left;padding-left: 20px;">
				<!-- 导航 -start -->
				<div>
					<div id="navigation">
		  				<a href="#"><b>首页</b></a>&gt;&gt;<a href="topiclist.jsp?boardId=<%=boardId %>"><b><%=block.getbName() %></b></a>&gt;&gt;<a href="homepage.jsp?pageOwer=<%=topicUser.getUserId() %>"><%=topicUser.getuName() %>的主页</a>&gt;&gt;
		  			</div>
		  		</div>
				<!-- 导航 -end -->
				<!-- 主贴信息 -start -->
				<div style="padding-top: 30px;">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="2" style="height: 60px;background-color: #E3E3E3;padding-left: 10px;">
								<p style="font-weight: bold;font-size: 20px;"><%=topic.gettTitle() %></p>
								<p style="font-size: 18px;"><%=topic.gettContent() %></p>
								<p style="color: gray;">发帖时间:<%=publishTime %>&nbsp;&nbsp;最近修改时间:<%=lastEdit %>&nbsp;&nbsp;点击量:<%=cliclCount %>&nbsp;&nbsp;回帖量:<%=replyCount %></p>
						<%
							if(loginUser != null){
							if(loginUser.getUserId() == topic.gettUserId() || loginUser.getUserId() == block.getMasterId()){
						%>
						<p style="text-align: right;"><a href="editTopic.jsp?editTopicId=<%=topicId%>&boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum %>&editLocation=1">编辑</a>|<a href="deleteTopicAction.jsp?deleteTboardId=<%=boardId %>&deleteTopicId=<%=topicId %>&deleteLocation=<%=request.getParameter("deleteLocation") %>">删除</a></p>
						<%	
							}}
						 %>		
								
							</td>
						</tr>
						<tr><td colspan="2" height="50">回帖：</td></tr>
						<tr>
							<td>
							<%
								int totalPage;
								if(replyCount % 5 == 0){
									totalPage = replyCount / 5;
								}
								else{
									totalPage = replyCount / 5 + 1;
								}
								if(pageNum == 1 && pageNum == totalPage || replyCount == 0){
								}	
								else if(pageNum == 1){
							%>
							<div><a href="replylist.jsp?topicId=<%=topic.gettId() %>&boardId=<%=boardId %>&replyPage=<%=pageNum+1 %>&list=<%=(pageNum+1+2)/3 %>">下一页</a></div>
							<%
								}
								else if(pageNum == totalPage){
							 %>
							 <div><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=pageNum-1 %>&list=<%=(pageNum-11+2)/3 %>">上一页</a></div>
							 <%
							 	}
							 	else{
							  %>
							  <div>
							   
								<a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=pageNum-1 %>&list=<%=(pageNum-1+2)/3 %>">上一页</a>
								<a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=pageNum+1 %>&list=<%=(pageNum+1+2)/3 %>">下一页</a>
							  </div>
							  <%
							  	}
							   %>
							</td>
							<td align="right">
							<div style="width: 170px;">
							<%
								//总分页数
					  			int totalList;
					  			if(totalPage%3 == 0){
					  				totalList = totalPage/3;
					  			}
					  			else{
					  				totalList = totalPage/3+1;
					  			}
					  			if(totalPage <= 1){
					  			}
					  			else if(totalPage > 1 && totalPage <= 3){
					  				for(int i = 1; i <= totalPage; i++){
					  					if(i == pageNum){
					  		%>
					  		<div class="list" style="background-color: gray;"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=i %>" style="color: blue;"><%=i %></a></div>
					  		<% 			
					  					}
					  					else{
					  		%>
					  		<div class="list"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=i %>"><%=i %></a></div>
					  		<% 			
					  					}		
					  				}
					  			}
					  			else{
					  				if(listNum != 1){
					  		%>
					  		<div class="list"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=pageNum %>&list=<%=listNum-1 %>">&lt;&lt;</a></div>
					  		<% 		
					  				}
					  				int toList = listNum * 3;;
					  				if(toList > totalPage){
					  					toList = totalPage;
					  				}
					  				for(int i = listNum*3-2; i <= toList; i++){
					  					if(i == pageNum){
					  		%>
					  		<div class="list" style="background-color: gray;"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=i %>&list=<%=listNum %>" style="color: blue;"><%=i %></a></div>
					  		<%			
										}
										else{
							%>
							<div class="list"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=i %>&list=<%=listNum %>"><%=i %></a></div>
					  		
							<%			
										}
									}	
									if(listNum != totalList){
							%>
							<div class="list"><a href="replylist.jsp?topicId=<%=topicId %>&boardId=<%=boardId %>&replyPage=<%=pageNum %>&list=<%=listNum+1 %>">&gt;&gt;</a></div>
							<%		
										
									}  
								}		
							 %>
							 </div>
							</td>
						</tr>
			<%
				for(Reply reply : replyList){
					//回帖人
					User replyUser = userDao.findUserById(reply.getrUserid());
					//回帖时间
					String replyTime = CommonUtil.formatDate(reply.getrTime());
			%>
				<tr id="replyTab" height="100">
					<td width="150">
						<img src="image/head/<%=replyUser.getuHead() %>" align="middle" width="50" height="50"><a href="homepage.jsp?pageOwer=<%=replyUser.getUserId() %>"><%=replyUser.getuName() %></a>
					</td>
					<td style="padding-top: 5px;">
						<div style="float: left;"><%=reply.getrContent() %></div>
						<%
							if(loginUser != null){
								if(block.getMasterId() == loginUser.getUserId() || loginUser.getUserId() == topic.gettUserId()){
						%>
						<div style="float: right;"><a href="deleteReplyAction.jsp?topicId=<%=topicId %>&replyId=<%=reply.getrId() %>&boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum %>" style="color: blue;">删除</a></div>
						<%		
								}
							}	
						 %>
						 <div style="clear: both;height: 10px;"></div>
						<p style="color: gray;">回帖时间：<%=replyTime %></p>
					</td>
				</tr>
			<% 	
				}
			 %>
					</table>
				</div>
				<!-- 主贴信息 -end -->
				
				<!-- 发布回帖 -start -->
				<%
					if(session.getAttribute("loginUser") != null){
				%>
				<div style="padding-top: 20px;">
					<form action="replyAction.jsp" method="post" id="replyForm">
						<div style="text-align: left;">回帖<br><textarea style="width: 700px;height: 150px;" name="replyContent"></textarea></div>
						<div>
							<input type="button" value="提交" id="submitReply"/><input name="topicId" value="<%=topicId %>" type="hidden"/>
							<input type="hidden" value="<%=boardId%>" name="getbaordId">
						</div>
					</form>
				</div>
				<%	
					
					}
				%>
				<!-- 发布回帖 -end -->
		
			</div>
			<!-- 主贴信息 -end -->
			
		</div>
		<!-- 主题部分 -end -->
		<div style="clear: both;"></div>
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
