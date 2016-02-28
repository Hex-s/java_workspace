<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%@page import="com.niit.entity.Block"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'homepage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">


  </head>
  
  <body>
    <%
    	//创建DAO
    	UserDao userDao = new UserDao();
    	TopicDao topicDao = new TopicDao();
    	ReplyDao replyDao = new ReplyDao();
    	BlockDao boardDao = new BlockDao();
    	//主页主人编号
    	int pageOwerId = Integer.parseInt(request.getParameter("pageOwer"));
    	//获取用户对象
    	User user = userDao.findUserById(pageOwerId);
    		//查询发帖人性别
       	String sex = "";
       	if(user.getuSex() == 0){
       		sex = "男";
       	}
       	else{
       		sex = "女";
       	}
       	//发帖人生日
       	String birthday = CommonUtil.formatBirthday(user.getuBirthday());
       	//注册时间
       	String regTime = CommonUtil.formatBirthday(user.getuRegdate());
       	//当前页数 
       	int pageNum; 
       	if(request.getParameter("page") == null){ 
       		pageNum = 1; 
       	} 
       	else{ 
       		pageNum = Integer.parseInt(request.getParameter("page")); 
       	} 
       	//当前分页数
       	int listNum;
       	if(request.getParameter("list") == null){
       		listNum = 1;
       	}
       	else{
       		listNum = Integer.parseInt(request.getParameter("list"));
       	}
       	//分页查询该用户的主贴 
       	ArrayList<Topic> topicList = topicDao.findTopicListByUserId(pageOwerId,pageNum);
     %>
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
		 		欢迎&nbsp;<a href="homepage.jsp?pageOwer=<%=loginUser.getUserId() %>"><%=loginUser.getuName() %></a>&nbsp;|&nbsp;<a href="index.jsp">首页</a>&nbsp;|&nbsp;<a href="exitLoginAction.jsp" id="exit">退出登录</a>
		 		<%		
		 			}
		 		 %>
 			</div>
 		</div>
 	<!-- 页眉 -end -->
 	<!-- 主体部分 -start -->
 	<div>
 		<!-- 左侧用户信息 -start -->
 		<div style="width: 182px;border-right: 1px gray solid;float: left;height: 700px;">
				
				<table height="400" align="center">
					<tr><td>发帖人信息</td></tr>
       				<tr><td>..........................</td></tr>
     				<tr><td><img src="image/head/<%=user.getuHead()%>" width="100" height="150"/></td></tr>
     				<tr><td>用户名：<%=user.getuName() %></td></tr>
     				<tr><td>性别：<%=sex %></td></tr>
     				<tr><td>积分：<%=user.getuPoint() %></td></tr>
     				<tr><td>邮箱：<%=user.getuEmail() %></td></tr>
     				<tr><td>生日:<%=birthday %></td></tr>
     				<tr><td>简介：<%=user.getuStatement() %></td></tr>
     				<tr><td>注册时间：<%=regTime %></td></tr>
     				<tr><td>居住地：<%=user.getAddress()%></td></tr>
     			</table>
			</div>
 		<!-- 左侧用户信息 -end -->
 		<!-- 用户发帖信息 -start -->
		<div style="width: 780px;float: left;padding-left: 20px;">
			<!-- 导航 -start -->
			<div><a href="#"><b>首页</b></a>&gt;&gt;欢迎来到&nbsp;<%=user.getuName() %>&nbsp;的主页</div>
			<!-- 页数 -start -->
			<div style="padding-top: 20px;">
				<!--上下页 -start -->
				<div style="width: 200px;float: left;">
				<%
					//总发帖量
					int topicCount = topicDao.findTopicCountByUserId(pageOwerId);
					//总页数
					int totalPage;
		  			if(topicCount%5 == 0){
		  				totalPage = topicCount/5;
		  			}
		  			else{
		  				totalPage = topicCount/5+1;
		  			}
		  			
			  		if(pageNum == 1 && pageNum == totalPage || topicCount == 0){
			  		}	
			  		else if(pageNum == 1){
			  	%>
			  	<div><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum+1 %>&list=<%=(pageNum+1+2)/3 %>">下一页</a></div>
			  	<% 	
			  		}
			  		else if(pageNum == totalPage){
			  	%>
			  	<div><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum-1 %>&list=<%=(pageNum-1+2)/3 %>">上一页</a></div>
			  	<%	
			  		}
			  		else{
			  	%>
			  	<div>
		  			<a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum-1 %>&list=<%=(pageNum-1+2)/3 %>">上一页</a>
		  			<a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum+1 %>&list=<%=(pageNum+1+2)/3 %>">下一页</a>
		  		</div>
			  	<%	
			  		}
				 %>
				</div>
				<!--上下页 -end -->
				<!-- 翻页 -start -->
				<div style="float: right;width: 200px;">
				<%
					//总分页数
		  			int totalList;
		  			if(totalPage%3 == 0){
		  				totalList = totalPage/3;
		  			}
		  			else{
		  				totalList = totalPage/3+1;
		  			}
		  			
		  			if(totalPage <= 1){}
		  			else if(totalPage >1 && totalPage <= 3){
		  				for(int i = 1; i <= totalPage; i++){
		  					if(i == pageNum){
		  			%>
		  			<div class="list" style="background-color: gray;"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=i %>" style="color: blue;"><%=i %></a></div>
		  			<%		
		  					}
		  					else{
		  			%>
		  			<div class="list"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=i %>"><%=i %></a></div>
		  			<%		
		  					}
		  				}
		  			}	
		  			else{
					  	if(listNum != 1){
			  		%>
			  		<div class="list"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum %>&list=<%=listNum-1 %>">&lt;&lt;</a></div>
			  		<%		
		  				}
		  				int toList = listNum * 3;;
		  				if(toList > totalPage){
		  					toList = totalPage;
		  				}
		  				for(int i = listNum*3-2; i <= toList; i++){
		  					if(i == pageNum){
			  		%>
			  		<div class="list" style="background-color: gray;"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=i %>&list=<%=listNum %>" style="color: blue;"><%=i %></a></div>
		  		<%			
		  					}
		  					else{
			  		%>
			  		<div class="list"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=i %>&list=<%=listNum %>"><%=i %></a></div>
			  		<%			
			  				} 			
			  			}
			  			if(listNum != totalList){
			  		%>
			  		<div class="list"><a href="homepage.jsp?pageOwer=<%=pageOwerId %>&page=<%=pageNum %>&list=<%=listNum+1 %>">&gt;&gt;</a></div>
			  		<%		
			  				}
			  			}
			  		%>
				</div>
				<!-- 翻页 -end -->
			</div>
			<!-- 页数 -end -->
			<!-- 导航 -end -->
			<!-- 用户发帖 -start -->
			<div style="padding-top: 30px;">
				<table border="0" width="100%">
			<%
				for(Topic topic : topicList){
					//所属板块
					Block block = boardDao.findBlockById(topic.getTbId());
			%>
			<tr height="60">
				<td>
					<div style="float: left;">标题：<a href="replylist.jsp?topicId=<%=topic.gettId() %>&boardId=<%=topic.getTbId() %>&deleteLocation=2" style="font-weight: bold;font-size: 14px;"><%=topic.gettTitle() %></a></div>
					
			<%
				if(session.getAttribute("loginUser") != null){
				if(((User)session.getAttribute("loginUser")).getUserId() == user.getUserId()){
			%>
			<div style="float: right;"><a href="editTopic.jsp?editTopicId=<%=topic.gettId() %>&boardId=<%=topic.getTbId() %>&page=<%=pageNum %>&list=<%=listNum %>&editLocation=2"">编辑</a>|<a href="deleteTopicAction.jsp?deleteTopicId=<%=topic.gettId() %>&deleteTboardId=<%=topic.getTbId() %>&pageNumber=<%=pageNum %>&listNum=<%=listNum %>&deleteLocation=2&pageOwer=<%=pageOwerId %>">删除</a></div>
			<%	
				}}
			 %>		
				</td>
			</tr>
			
			<tr height="40">
				<td style="color: gray;border-bottom:1px blue solid;">
					<p style="font-size: 12x;">所属板块：<a href="topiclist.jsp?boardId=<%=block.getbId() %>"><%=block.getbName() %></a></p>
					点击量:<%=topic.gettClickCount()%>&nbsp;&nbsp;回帖量:<%=replyDao.findReplyCountByTopicId(topic.gettId()) %>&nbsp;&nbsp;发帖时间:<%=CommonUtil.formatDate(topic.gettPublishTime()) %>&nbsp;&nbsp;最后修改时间:<%=CommonUtil.formatDate(topic.gettLastEdit()) %>
				</td>
			</tr>
			<%	
				}
			 %>		
				</table>
			</div>
			<!-- 用户发帖 -end -->
		</div>
		<!-- 用户发帖信息 -end -->
 	</div>
 	<!-- 主体部分 -end -->
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
