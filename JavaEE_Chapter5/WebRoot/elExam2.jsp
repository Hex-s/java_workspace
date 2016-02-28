<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'elExam2.jsp' starting page</title>
    
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
    	pageContext.setAttribute("num1",10);
    	pageContext.setAttribute("num2",5);
    	pageContext.setAttribute("str1","niit");
    	pageContext.setAttribute("str2","miit");
    	pageContext.setAttribute("str3","niit");	
    %>
    <!-- EL表达式支持数学运算和其他表达式计算 -->
    ${10 > 15 }<br/>
    ${num1 eq 10 }<br/>
    <!-- EL表达式中出现的字符串都是作用域中的键 -->
    ${str1 eq str3}<br/>
    ${str1 == 'niit' }<br/>
    <!-- 在EL表达式中只能对数值类型的值进行算数运算 -->
    ${num1 + num2 }<br/>
    <!-- 判断是否存在数据 -->
    ${empty num1 }<br/>
    ${not empty num1 }<br/>
  </body>
</html>
