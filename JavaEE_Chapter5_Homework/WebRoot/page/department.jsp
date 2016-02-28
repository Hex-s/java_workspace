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
    
    <title>My JSP 'department.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css">
	

  </head>
  
  <body>
    <div>部门名称</div>
    <hr/>
    <c:forEach var="department" items="${list}" varStatus="listNum">
    	<div style="padding-left: 10px;height: 30px;">
    		${listNum.index+1}.&nbsp;<a href="page/depEmployeeAction.jsp?depId=${department.department_id}">${department.department_name}</a>
    	</div>
    </c:forEach>
  </body>
</html>