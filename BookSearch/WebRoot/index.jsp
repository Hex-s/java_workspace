<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entiry.User"%>
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
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
  </head>
  
  <script type="text/javascript" src="js/jquery-1.6.js"></script>
  
  <body>
  
    <div id="body">
    	<!-- 标题 -start -->
    	<div id="title">
    		<div id="logo">图书搜索系统</div>
    		<%
    			User loginUser = null;
    			if(session.getAttribute("loginUser") == null){
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;"><a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a></div>
    		<%		
    			}
    			else{
    				loginUser = (User)session.getAttribute("loginUser");
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;">欢迎&nbsp;<%=loginUser.getuName() %>&nbsp;|&nbsp;<a href="index.jsp">首页</a>|<a href="showCollect.jsp">收藏</a>&nbsp;|<a href="exitLoginAction.jsp">注销</a></div>
    		<%		
    			}
    		 %>
    	</div>
    	<!-- 标题 -end -->
    	<!-- 主体 -start -->
    	<div style="margin: auto;width: 800;border:#C6D5FD 1px solid;margin-top: 30px;">
    		<div style="margin: auto;width: 500;padding-top: 30px;">
    		<form action="searchAction.jsp" method="post" id="searchForm">
    			<div><input type="text" id="searchContent" name="searchContent" style="width: 350px;"/>&nbsp;<input type="button" id="searchBtn" name="searchBtn" value="搜索"/></div>
    			<div style="padding-left: 60px;padding-top: 5px;">
	    			<input type="radio" name="searchType" value="bookName" checked="checked"/>图书名称
	    			<input type="radio" name="searchType" value="bookVarity"/>图书类别
	    			<input type="radio" name="searchType" value="bookWriter"/>作者
    			</div>
    			<div id="error" style="height: 30px;color: red;"></div>
    		</form>	
    		</div>
    	</div>
    	<!-- 主体 -end -->
    </div>
  </body>
  <script type="text/javascript">
  	//验证是否填写搜索内容
  	$("#searchBtn").click(function(){
  		if($("#searchContent").val() == ""){
  			$("#error").html("请填写搜索内容");
  		}
  		else{
  			$("#error").html("");
  			$("#searchForm").submit();
  		}
  	})
  </script>
</html>
