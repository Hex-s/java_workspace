<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.entity.Book"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'elExam1.jsp' starting page</title>
    
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
    <%--<jsp:useBean id="user" class="com.niit.entity.User" scope="page"></jsp:useBean>
    <jsp:setProperty property="userName" name="user" value="tom"/>--%>
    <% 
    	User user = new User();
    	user.setUserName("tom");
    	Book book = new Book();
    	book.setBookName("三国演义");
    	book.setPrice(100);
    	user.setBook(book);
    	pageContext.setAttribute("user",user);
    	
    	pageContext.setAttribute("str","A");
    	request.setAttribute("str","B");
    	session.setAttribute("str","C");
    	application.setAttribute("str","D");
    %>
    <!-- 使用EL表达式可以快速的对作用域中(pageContent,request,session,application)的数据进行访问 -->
    <%-- ${user.userName }--%>
    <!-- EL表达式中只需要直接写入作用域中的键，由此获取对应的值 -->
    <!-- EL表达式如果检索不到数据，页面中则不会显示任何内容 -->
    <!-- EL使用链式访问操作数据 -->
    ${user.book.bookName }<br/>
   	${user['userName'] }<br/>
   	<!-- EL表达式默认从pageContext开始检索数据，如果搜索不到再到request中搜索，依次类推，直至application -->
   	默认检索：${str }<br/>
   	session检索：${sessionScope.str }<br/>
   	request检索：${requestScope.str }<br/>
   	<a href="result.jsp?key=value">result.jsp</a>
  </body>
</html>
