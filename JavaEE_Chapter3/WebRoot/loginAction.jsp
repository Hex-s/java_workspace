         <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.OutputStreamWriter"%>
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
    	//该页面是用来处理登陆请求的
    	//out.print("服务器接收到了登陆请求");
    	//设置请求对象的字符集编码格式
    	request.setCharacterEncoding("utf-8");
    	//获取请求中的用户名和密码
    	//getParameter方法获取表单提交的数据，键表示表单元素的name值，返回该表单元素的value值
    	String userName = request.getParameter("userName");
    	String password = request.getParameter("pwd");
    	//System.out.print(userName+","+password);
    	
    	//解决url传递中文乱码,通过重构字符串，设置新的字符串的编码格式
    	userName = new String(userName.getBytes("iso-8859-1"),"utf-8");
    	password = new String(password.getBytes("iso-8859-1"),"utf-8");    	
    	String val = request.getParameter("key");
    	//out.print(val+"<br>");
    	 
    	//获取复选框的值
    	String[] vals = request.getParameterValues("hobby");
    	String hobby = "";
    	if(vals != null){
	    	for(String str : vals){
	    		hobby+=str+" ";
	    	}
	    	out.print(hobby);
    	}
    	
    	//判断用户名是否正确
    	if(userName.equals("admin")){
    		//判断密码是否正确
    		if(password.equals("0000")){
    			//进入success.jsp
    			//请求转发
    			request.getRequestDispatcher("success.jsp").forward(request,response);
    			//使用响应对象的重定向完成页面的跳转
    			//请求跳转和重定向都能进行页面的跳转，两者的差别是：
    			//1.请求跳转后的页面路径维持着上一个页面的地址,重定向由于服务器重新发起的新的请求，因此URL地址将更新为新的路径
    			//2.请求跳转由于将当前页面中的请求对象和响应都传递到了下一个页面，因此下一个页面可以继续获取前一个页面中的数据;
    			//重定向由于是发起的新的请求，因此在发送前上一个请求对象被销毁，重新产生了一个新的请求，因此不能访问前一个页面的数据
    			//3.请求跳转只能在当前项目内跳转，重定向可以由服务器向外部进行任意的跳转
    			//response.sendRedirect("success.jsp");
    		}
    		else{
    			//进入failed.jsp
    			//以键值对的方式将外部数据写入request对象
    			request.setAttribute("error","password is error!");
    			request.getRequestDispatcher("failed.jsp").forward(request,response);
    		}
    	}
    	else{
    		//进入failed.jsp
    		request.setAttribute("error","name is error");
    		request.getRequestDispatcher("failed.jsp").forward(request,response);
    	}
    	
    	//响应对象可以获取服务器的输出流向客户端输出信息
    	/*response.getWriter().write("<font color='red'>");
    	response.getWriter().write("this is loginAction.jsp");
    	response.getWriter().write("</font><br>");*/
    	
    
    	
     	/*BufferedWriter write = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
     	write.write("hello niit");*/
    	
    %>
    
    登陆的用户名是<%=userName %><br/>
    登陆的密码是<%=password %><br/>
  </body>
</html>
