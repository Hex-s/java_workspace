<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'depEmployee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	

  </head>
  
  <body>
    <div>部门名称：${department.department_name}</div>
    <div><p>部门经理：<a href="page/employeeAction.jsp?empId=${manager.emp_id}">${manager.emp_name}</a></p></div>
    <hr/>
   	<div style="padding-top: 10px;">
   	<div>部门下所有员工：</div>
   	<c:forEach var="emp" items="${list}" varStatus="listNum">
   		<div>
   			${listNum.index+1}.&nbsp;<a href="page/employeeAction.jsp?empId=${emp.emp_id}">${emp.emp_name }</a>
   		</div>
   	</c:forEach>
   	</div>
  </body>
</html>
