<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.dao.impl.ReplyDao"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.Block"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.util.CommonUtil"%>
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
  	})
  });
  </script>
  <body>
    <%
    	//获取板块编号 
       	int boardId = Integer.parseInt(request.getParameter("boardId")); 
       	//创建DAO 
       	BlockDao boardDao = new BlockDao(); 
       	TopicDao topicDao = new TopicDao(); 
       	ReplyDao replyDao = new ReplyDao(); 
       	UserDao userDao = new UserDao(); 
       	//查询板块的名称 
       	Block board = boardDao.findBlockById(boardId); 
       	//查询主贴数
       	int topicCount = topicDao.findTopicCountByBlockdId(boardId);
		Block block = boardDao.findBlockById(boardId);
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
       	//分页查询该板块的主贴 
       	ArrayList<Topic> topicList = topicDao.findTopicListByBlockId(boardId,pageNum);
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
 	<div style="clear: both;"></div>
	<!-- 页眉 -end -->
  	<!-- 导航 -start -->
  	<div id="head">
  		<div id="navigation">
  			<a href="#"><b>首页&gt;&gt;</b></a><%=board.getbName() %>
  		</div>
  		<!-- 页数跳转 -start -->
  		<div style="padding-top: 15px;">
  		<!-- 上下页 -start -->
  		<div style="float:left; width:300px;">
  		<% 
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
  		<div><a href="topiclist.jsp?page=<%=pageNum+1 %>&boardId=<%=boardId %>&list=<%=(pageNum+1+2)/3 %>">下一页</a></div>
  		<%
  			}
  			else if(pageNum == totalPage){
  		%>
  		<div><a href="topiclist.jsp?page=<%=pageNum-1 %>&boardId=<%=boardId %>&list=<%=(pageNum-1+2)/3 %>">上一页</a></div>
  		<%
  			}
  			else{
  		%>
  		<div>
  			<a href="topiclist.jsp?page=<%=pageNum-1 %>&boardId=<%=boardId %>&list=<%=(pageNum-1+2)/3%>">上一页</a>
  			<a href="topiclist.jsp?page=<%=pageNum+1 %>&boardId=<%=boardId %>&list=<%=(pageNum+1+2)/3 %>">下一页</a>
  		</div>
  		<% 
  			}
  		%>
  		</div>
  		<!-- 上下页 -end -->
  		<!-- 分页 -start -->
  		<div style="float: right;width: 170px;height: 20px;">
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
  		<div class="list" style="background-color: gray;"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=i %>" style="color: blue;"><%=i %></a></div>
  		<% 		
  					}
  					else{
  		%>
  		<div class="list"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=i %>"><%=i %></a></div>
  		<%
  					
  					}
  				}
  			}
  			else{
  				if(listNum != 1){
  		%>
  		<div class="list"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum-1 %>">&lt;&lt;</a></div>
  		<%		
  				}
  				int toList = listNum * 3;;
  				if(toList > totalPage){
  					toList = totalPage;
  				}
  				for(int i = listNum*3-2; i <= toList; i++){
  					if(i == pageNum){
  		%>
  		<div class="list" style="background-color: gray;"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=i %>&list=<%=listNum %>" style="color: blue;"><%=i %></a></div>
  		<%			
  					}
  					else{
  		%>
  		<div class="list"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=i %>&list=<%=listNum %>"><%=i %></a></div>
  		<%			
  					} 			
  				}
  				if(listNum != totalList){
  		%>
  		<div class="list"><a href="topiclist.jsp?boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum+1 %>">&gt;&gt;</a></div>
  		<%		
  				}
  			}
  		%>
  		
  		</div>
  		<!-- 分页 -end -->
  		</div>
  		<!-- 页数跳转 -end -->
  	</div>
  	<!-- 导航 -end -->
  	<!-- 主贴信息 -->
  	<div style="padding-top: 5px;">
	<table border="0" id="boardContent" cellspacing="0" >
		<tr height="50" style="background-color: #ACDAFE;font-weight: bold;">
			<td>&nbsp;主贴名称</td>
			<td>作者</td>
			<td align="center">点击量</td>
			<td align="center">回帖量</td>
			<td align="center">发布时间</td>
			<td align="center">最近修改时间</td>
			<td>精华帖</td>
			<%
				int editFlag = 0;
				if(session.getAttribute("loginUser") != null){
					User loginUser = (User)session.getAttribute("loginUser");
					if(block.getMasterId() == loginUser.getUserId()){
					editFlag = 1;
			%>
			<td>编辑</td>
			<%		
					}
				}
			 %>
			
		</tr>
		<% 
			//遍历主贴
			for(Topic topic : topicList){
				//查询回帖数
				int replyCount = replyDao.findReplyCountByTopicId(topic.gettId());
				//查询发帖人
				User user = userDao.findUserById(topic.gettUserId());
				//查询点击量
				int clickCount = topic.gettClickCount();
				//查询发布时间
				Timestamp publishTime = topic.gettPublishTime();
				String publish = CommonUtil.formatDate(publishTime);
				//查询最近最近修改时间
				Timestamp lastEdit = topic.gettLastEdit();
				String last = CommonUtil.formatDate(lastEdit);
		%>
		<tr class="childBoardRow" height="50">
			<td><img src="image/pic1.jpg" align="middle" width="30" height="30"/><a href="replylist.jsp?topicId=<%=topic.gettId() %>&boardId=<%=boardId %>&deleteLocation=0"><%=topic.gettTitle() %></a></td>
			<td><a href="homepage.jsp?pageOwer=<%=user.getUserId() %>"><%=user.getuName() %></a></td>
			<td align="center"><%=clickCount %></td>
			<td align="center"><%=replyCount %></td>
			<td align="center"><%=publish %></td>
			<td align="center"><%=last %></td>
			<td>
			<%
				if(session.getAttribute("loginUser") != null){
					User loginUser = (User)session.getAttribute("loginUser");
					if(block.getMasterId() == loginUser.getUserId()){
						if(topic.gettFlag() == 1){
			%>
			<span style="color: #F46E03;">精华帖</span>&nbsp;<a href="creamAction.jsp?type=1&modifyTopicId=<%=topic.gettId() %>&modifyBoardID=<%=boardId %>&pageNumber=<%=pageNum %>&list=<%=listNum %>" style="color: #81CC81;font-size: 10px;">去精</a>
			<% 			
							
						}
						else{
			%>
			普通帖&nbsp;<a href="creamAction.jsp?type=0&modifyTopicId=<%=topic.gettId() %>&modifyBoardID=<%=boardId %>&pageNumber=<%=pageNum %>&list=<%=listNum %>" style="color: red;font-size: 10px;">加精</a>
			<%		
						}
			%>
			<%			
					}
					else{
						if(topic.gettFlag() == 1){
						out.print("<font color='#FF9900'>精华帖</font>");
						}
						else{
							out.print("普通帖");
						}
					}
					
				}
				else{
					if(topic.gettFlag() == 1){
						out.print("<font color='#FF9900'>精华帖<font>");
						}
						else{
							out.print("普通帖");
						}
				}
			 %>
			</td>
			<%
				if(editFlag == 1){
			%>
			<td>
				<a href="editTopic.jsp?editTopicId=<%=topic.gettId() %>&boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum %>&editLocation=0" class="topicEdit">编辑</a>|<a href="deleteTopicAction.jsp?deleteTopicId=<%=topic.gettId() %>&deleteTboardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum %>&deleteLocation=0" class="topicEdit">删除</a>
			</td>
			<%		
				}
			 %>
		</tr>
		<%
			}
		%>
	</table>
	</div>
	<!-- 发帖 -start -->
	<%
		if(session.getAttribute("loginUser") != null){
	%>
	<div style="padding-top: 20px;">
	<form action="topicAction.jsp" method="post" id="topicForm">
		<div style="width: 1000px;background-color: #B3CFFC;height: 30px;line-height: 30px;font-weight: bold;font-size: 16px">发帖：</div>
		<p>帖子标题：</p>
		<div>
			<input type="hidden" value="<%=boardId %>" name="topicBoardId">
			<textarea style="width: 1000px;height: 50px;" id="topicTitle" name="tpTitle" onblur="validte_topicTitle()"></textarea>
			<div style="color: red;height: 20px;" id="topicTitleError"></div>
		</div>
		<div style="clear: both;"></div>
		<br/><p>帖子内容：</p>
		<div>
			<textarea style="width: 1000px;height: 300px;" id="topicContent" name="tpContent" onblur="validte_topicContent()"></textarea>
			<div style="color: red;height: 20px;" id="topicContentError"></div>
		</div>	
		<div style="clear: both;"></div>
		<div style="padding-top: 10px;"><input type="button" name="submitTopic" id="subTopicBtn" value="发表" onclick="validate_btn()"></div>
	</form>	
	</div>
	<%		
		}
	 %>
	<!-- 发帖 -end -->
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
  <script type="text/javascript">
  
    var flag = 1;
 
	//验证帖子标题 
    var topicTitleError = document.getElementById("topicTitleError");
  	function validte_topicTitle(){ 		
		if($("#topicTitle").val() == ""){
			 topicTitleError.innerHTML = "请填写帖子标题";
			 flag = 0;
		}
		else{
			topicTitleError.innerHTML = "";
			flag = 1;
		}
  	} 
  	
  	//验证帖子内容
  	var topicContentError = document.getElementById("topicContentError");
  	function validte_topicContent(){ 		
		if($("#topicContent").val() == ""){
			 topicContentError.innerHTML = "请填写帖子内容";
			 flag = 0;
		}
		else{
			topicContentError.innerHTML = "";
			flag = 1;
		}
  	} 
  	//提交表单
	function validate_btn(){
		validte_topicTitle();
		validte_topicContent();
		if(flag == 1){
			$("#topicForm").submit();
		}
	}
  </script>
</html>
