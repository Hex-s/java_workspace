<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.TopicDao"%>
<%@page import="com.niit.entity.Topic"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.util.CommonUtil"%>
<%@page import="com.niit.dao.impl.BlockDao"%>
<%@page import="com.niit.entity.Block"%>
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
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">

  </head>
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$("#editTopicBtn").click(function(){
  		$("#test").val($("#divTitle").html());
  		$("#content").val($("#divContent").html());
  		//alert($("#title").val()+","+$("#content").val()+","+$("#editLoc").val());
  		$("#editTopicForm").submit();
  	})
  });
  </script>
  <body>
    <%
    	//创建DAO
    	TopicDao topicDao = new TopicDao();
    	UserDao userDao = new UserDao();
    	BlockDao boardDao = new BlockDao();
    	//获取主贴编号
    	int topicId = Integer.parseInt(request.getParameter("editTopicId"));
    	//获取板块编号
    	int boardId = 1;
    	Block block = null;
    	if(request.getParameter("boardId") != null){
    		boardId = Integer.parseInt(request.getParameter("boardId"));
    		//查询版块
    		block = boardDao.findBlockById(boardId);    
    	} 
    	//获取主贴内容
    	Topic topic = topicDao.findTopicById(topicId);
    	//获取帖主信息
    	User topicUser = userDao.findUserById(topic.gettUserId());
    	//获取当前页面
    	int pageNum = Integer.parseInt(request.getParameter("page"));
    	//获取当前分页
    	int listNum = Integer.parseInt(request.getParameter("list"));
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
	 		欢迎&nbsp;<a href="#"><%=loginUser.getuName() %></a>&nbsp;|&nbsp;<a href="index.jsp">首页</a>&nbsp;|&nbsp;<a href="exitLoginAction.jsp" id="exit">退出登录</a>
	 		<%		
	 			}
	 		 %>
	 		</div>
	 	</div>
	 	<!-- 页眉 -end -->
       	<!-- 主体信息 -start -->
       	<div>
       		<!-- 左侧用户信息 -start -->
       		<div style="width: 230px;border-right: 1px gray solid;float: left;height: 600px;">
       			<table height="400" align="center">
       				<tr><td>发帖人信息</td></tr>
       				<tr><td>..........................</td></tr>
       				<tr><td><img src="image/head/<%=topicUser.getuHead() %>" width="100" height="150"/></td></tr>
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
       		<!-- 左侧用户信息 -end -->
       		<!-- 右侧主贴内容 -start -->
       		<div style="width: 700px;float: left;padding-left: 20px;">
       			<!-- 导航 -start -->
				<div>
					<div id="navigation">
		  				<a href="#"><b>首页</b></a>&gt;&gt;
		  				<%
		  					if(request.getParameter("boardId") != null){
		  				%>	
		  				<a href="topiclist.jsp?boardId=<%=boardId %>"><b><%=block.getbName() %></b></a>&gt;&gt;
		  				<% 
		  					}
		  				 %>
		  				<a href="homepage.jsp?pageOwer=<%=topicUser.getUserId() %>"><%=topicUser.getuName() %>的主页</a>&gt;&gt;
		  			</div>
		  		</div>
				<!-- 导航 -end -->
				<!--修改信息 -start  -->
				<div style="padding-top: 20px;">
				<form action="editTopicAction.jsp?editTopicId=<%=topic.gettId() %>&boardId=<%=boardId %>&page=<%=pageNum %>&list=<%=listNum %>" method="post" id="editTopicForm">
					<table border=0" width="100%" height="500">
						<tr height="30"><td style="font-weight: bold;font-size: 14px;">标题：</td></tr>
						<tr height="150" valign="top"><td>
							<div contentEditable="true" style="height: 100%;border: 1px solid;" id="divTitle"><%=topic.gettTitle() %></div>
							<input type="hidden" name="test" id="test"/>
						</td></tr>
						<tr height="30"><td style="font-weight: bold;font-size: 14px;">内容：</td></tr>
						<tr valign="top"><td>
							<div contentEditable="true" style="height: 100%;border: 1px solid;" id="divContent"><%=topic.gettContent() %></div>
							<input type="hidden" name="content" id="content"/>
						</td></tr>
						<tr height="30"><td>
						<!-- //获取修改位置   0：在topiclist中点击编辑，修改后返回topiclist   1: 在replylist中点击编辑，修改后返回replylist -->
							<input type="hidden" value=<%=Integer.parseInt(request.getParameter("editLocation")) %> name="editLoc" id="editLoc">
							<input type="button" value="确认修改" id="editTopicBtn"/>
						</td></tr>
					</table>
				</form>	
				</div>
				<!--修改信息 -end  -->
       		</div>
       		<!-- 右侧主贴内容 -end  -->
       	</div>
         <!-- 主体信息 -end -->
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
   
  </script>
</html>
