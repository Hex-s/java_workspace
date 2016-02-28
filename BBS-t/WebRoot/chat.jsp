<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chat.jsp' starting page</title>
    
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
  	$("#btnSend").click(function(){
  		$("#msgContent").val($("#msg").html());
  		$("#msgFrm").submit();
  	})
  })
  function insertImg(){
  	$("#msg").html($("#msg").html()+"<img src='image/head/1.gif'/>");
  }
  </script>
  <body>
    <body id="body">
    	<%@include file="validateLogin.jsp" %>
    	<%@include file="include/head.jsp" %>	
    	<!-- 聊天室部分 -->
    	<table border="1" width="800" align="center" cellspacing="0" style="margin-bottom: 30px">
    		<tr>
    			<!-- 聊天信息 -->
    			<td height="480" width="650" valign="top" style="padding-top: 5px; padding-left: 10px">
    				<iframe src="msg.jsp" width="100%" height="100%" frameborder="0"></iframe>
    			</td>
    			<!-- 聊天室用户 -->
    			<td width="120" valign="top" align="center">
    				<iframe src="users.jsp" width="100%" height="100%" frameborder="0"></iframe>
    			</td>
    		</tr>
    		<tr>
    			<!-- 信息发送 -->
    			<td colspan="2" height="100" valign="top">
    			<form action="publish.jsp" method="post" id="msgFrm">
    			对<select name="reciveUser">
    				<option value="all">所有人</option>
    			  </select>
    			  <select name="action">
    			  	<option value="0">--请选择--</option>
    			  	<option value="1">打了一拳</option>
    			  	<option value="2">献了一个吻</option>
    			  	<option value="3">献了一束鲜花</option>
    			  </select>
    			  <select name="color">
    			  	<option value="1">黑色</option>
    			  	<option value="2">红色</option>
    			  	<option value="3">蓝色</option>
    			  	<option value="4">绿色</option>
    			  </select>
    			  <a href="javascript:insertImg()">图片</a>
    			  <div id="msg" contentEditable="true" style="width: 800px; height: 100px; border: 1px solid #D7D7D7;overflow: scroll;"></div>
    			  <input type="button" value="发送" id="btnSend">
    			  <%-- 该隐藏域用以存储聊天发送的信息 --%>
    			  <input type="hidden" name="msgContent" id="msgContent">
    			  </form>
    			</td>
    		</tr>
    	</table>
    	<!-- 页脚 -->
	  	<div id="foot" style="text-align: center;">
	  		CopyRight2014 NIIT
	  		<a href="WEB-INF/publish.jsp">publish.jsp</a>
	  		<% 
	  			//request.getRequestDispatcher("WEB-INF/publish.jsp").forward(request,response);
	  		%>
	  	</div>
    </body>
  </body>
</html>
