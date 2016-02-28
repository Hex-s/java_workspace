<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginAction.jsp' starting page</title>
    
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
    	//设置字符集编码
    	request.setCharacterEncoding("utf-8");
    	//获取用户名和密码
    	String userName = request.getParameter("userName");
    	String password = request.getParameter("password");
    	//获取登陆的类型
    	String type = request.getParameter("type");
    	//查找用户名是否存在
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByName(userName);
    	if(user != null){
    		//判断密码
    		if(user.getUserPwd().equals(password)){
    			//将登陆的用户保存至session
    			session.setAttribute("loginUser",user);
    			//记录登陆的时间
    			session.setAttribute("loginTime",new Date());
    			//判断当前登陆的类别
    			if(type.equals("bbs")){
					//页面跳转至板块页面
	    			response.sendRedirect("index.jsp");
				}
				//如果是聊天室登陆
				else{
					//将用户写入application
					if(application.getAttribute("userList") == null){
						ArrayList<User> userList = new ArrayList<User>();
						application.setAttribute("userList",userList);
					}
					ArrayList<User> userList = (ArrayList<User>)application.getAttribute("userList");
					//判断已经登陆的用户集合中是否存在当前登录人的信息
					for(int i = 0; i < userList.size(); i++){
						if(userList.get(i).getUserId() == user.getUserId()){
							request.setAttribute("error","用户已经登陆!");
							request.getRequestDispatcher("login.jsp").forward(request,response);
							return;
						}
					}
					userList.add(user);
					application.setAttribute("userList",userList);
					//跳转至聊天室页面
					response.sendRedirect("chat.jsp");
				}
    			
    		}
    		else{
    			//保存错误信息
    			request.setAttribute("pwdError","密码错误!");
    			//跳转回登陆页面
    			request.getRequestDispatcher("login.jsp").forward(request,response);
    		}
    	}
    	else{
    		request.setAttribute("nameError","用户名不存在!");
    		request.getRequestDispatcher("login.jsp").forward(request,response);
    	}
    %>
  </body>
</html>
