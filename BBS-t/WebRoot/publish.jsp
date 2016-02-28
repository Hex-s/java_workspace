<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.Message"%>
<%@page import="com.niit.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publish.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <% 
    	//设置请求中的字符集
    	request.setCharacterEncoding("utf-8");
    	//获取收信人的名字
    	String reciveUser = request.getParameter("reciveUser");
    	//获取动作
    	int action = Integer.parseInt(request.getParameter("action"));
    	//获取文字颜色
    	int color = Integer.parseInt(request.getParameter("color"));
    	//获取发送的信息
    	String msgContent = request.getParameter("msgContent");
    	//获取登录人的姓名
    	String formUser = ((User)session.getAttribute("loginUser")).getUserName();
    	//将获取的数据封装成消息对象
    	Message msg = new Message(formUser,reciveUser,action,color,msgContent,new Date());
    	
    	/*System.out.print(reciveUser);
    	System.out.print(action);
    	System.out.print(color);
    	System.out.print(msgContent);*/
    	
    	//获取聊天信息集合
    	ArrayList<Message> msgList = (ArrayList<Message>)application.getAttribute("msgList");
    	//将当前的信息添加至集合
    	msgList.add(msg);
    	//将消息集合重新存入application
    	application.setAttribute("msgList",msgList);
    	//将页面跳转至chat.jsp
    	response.sendRedirect("chat.jsp");
    %>
  </body>
</html>
