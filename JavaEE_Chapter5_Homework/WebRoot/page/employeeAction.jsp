<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.JobDao"%>
<%@page import="com.niit.dao.impl.EmployeeDao"%>
<%@page import="com.niit.entity.Employee"%>
<%@page import="com.niit.entity.Job"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employeeAction.jsp' starting page</title>
    
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
    	//创建DAO
    	JobDao jobDao = new JobDao();
    	EmployeeDao empDao = new EmployeeDao();
    	//获取员工编号
    	int empId = Integer.parseInt(request.getParameter("empId"));
    	//获取员工对象
    	Employee emp = empDao.findEmployeeById(empId);
    	//获取员工岗位
    	Job job = jobDao.findJobTitleByJobId(emp.getJob_id());
    	//将对象传递给下一个页面
    	request.setAttribute("emp",emp);
    	request.setAttribute("job",job);
    	//跳转页面
    	request.getRequestDispatcher("employee.jsp").forward(request,response);
     %>
  </body>
</html>
