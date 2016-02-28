<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.NamingException"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jndiDataSource.jsp' starting page</title>
    
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
		//创建目录检索的上下文对象
		Context ctx = new InitialContext();
		//基于目录名称进行远程资源对象的访问,获取创建于tomcat的连接池对象
		DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/source");
		Connection con = dataSource.getConnection();
		System.out.println("连接获取成功");
    %>
  </body>
</html>
