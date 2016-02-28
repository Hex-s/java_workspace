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
    	//获取验证码
    	String code = session.getAttribute("code").toString();
    	//获取输入验证码
    	String inputCode = request.getParameter("inputCode");
    	//查找用户名是否存在
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByName(userName);
    	
    	if(inputCode.equalsIgnoreCase(code)){
	    	if(user != null){
	    		//判断密码
	    		if(user.getuPwd().equals(password)){
	    			//将登陆的用户保存至session
	    			session.setAttribute("loginUser",user);
	    			//页面跳转至板块页面
	    			response.sendRedirect("index.jsp");
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
    	}
    	else{
    		request.setAttribute("codeError","验证码错误");
    		request.getRequestDispatcher("login.jsp").forward(request,response);
    	}
    %>
  </body>
</html>
