<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'users.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="2" >
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function addUser(userName){
  	//iframe和包含该框架的页面是子父页面关系，通过parent访问到iframe的父页面
  	//获取父页面中的下拉列表框
  	var sel = window.parent.document.getElementById("reciveUser");
  	//创建新的选项
  	var option = new Option(userName,userName);
  	alert(sel.options);
  	//添加选项
  	sel.options.add(option);
  	sel.selectedIndex = sel.length-1;
  }
  </script>
  <body>
    <% 
		//从application获取所有登陆聊天室的用户集合
		ArrayList<User> userList = (ArrayList<User>)application.getAttribute("userList");
		for(int i = 0; i < userList.size(); i++){
	%>
	<div style="margin-top: 10px">
		<img src="image/head/<%=userList.get(i).getHead() %>" width="40" height="40"/>
		<a href="javascript:addUser('<%=userList.get(i).getUserName() %>')"><%=userList.get(i).getUserName() %></a>
	</div>
	<%
		}
	%>
  </body>
</html>
