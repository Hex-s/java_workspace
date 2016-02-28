<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.Reply"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.niit.util.CommonUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerAction.jsp' starting page</title>
    
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
    	//创建DAO
    	UserDao userDao = new UserDao();   	
    	//获取注册用户名
    	String name = request.getParameter("regName");
    	User regUser = userDao.findUserByName("name");
    	//获取注册密码
    	String regPwd = request.getParameter("regPwd");
    	//获取注册性别
    	String[] sexs = request.getParameterValues("regSex");
    	String sex = "";
    	int sexInt;
    	if(sexs != null){
    		for(String str : sexs){
    			sex = str;
    		}
    	}
    	if(sex.equals("male")){
    		sexInt = 0;
    	}
    	else{
    		sexInt = 1;
    	}
    	//获取邮箱
    	String email = request.getParameter("regEmail");
    	//获取注册生日
    	int birthdayYear = Integer.parseInt(request.getParameter("birthyear"));
		int birthdayMonth = Integer.parseInt(request.getParameter("birthmonth"));    	
		int birthdayDay = Integer.parseInt(request.getParameter("birthday"));  
		Calendar cal = Calendar.getInstance();
		cal.set(birthdayYear,birthdayMonth-1,birthdayDay,0,0,0);
		Timestamp birthday = new Timestamp(cal.getTimeInMillis());
		//获取居住地
		String address = "";
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		address = province + city;
		//获取自我介绍
		String statement = request.getParameter("statement");
		//获取头像
		String head = request.getParameter("head");
    	//用户已存在
    	if(regUser != null){
    		//保存错误信息
    		request.setAttribute("regUserError","用户名已存在!");
    		//跳转回注册页面
    		request.getRequestDispatcher("register.jsp").forward(request,response);
    	}
    	else{
    		//创建user对象
    		User newUser = new User();
    		newUser.setuName(name);
    		newUser.setuPwd(regPwd);
    		newUser.setuSex(sexInt);
    		newUser.setuEmail(email);
    		newUser.setuBirthday(birthday);
    		newUser.setuHead(head);
    		newUser.setAddress(address);
    		newUser.setuStatement(statement);
    		//添加新用户
    		userDao.addUser(newUser);
    		//跳转进登录页面
    		request.getRequestDispatcher("login.jsp").forward(request,response);
    	}
    	
     %>
  </body>
</html>
