<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.EmployeeDao"%>
<%@page import="com.niit.entity.Employee"%>
<%@page import="com.niit.dao.impl.DepartmentDao"%>
<%@page import="com.niit.entity.Department"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EmployeeAction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	

  </head>
  
  <body>
   <%
   		//创建DAO
   		EmployeeDao empDao = new EmployeeDao();
   		DepartmentDao depDao = new DepartmentDao();
   		//获取部门编号
   		int depId = Integer.parseInt(request.getParameter("depId"));
   		//获取部门对象
   		Department dep = depDao.findDepartmentById(depId);
   		//获取部门经理
   		Employee manager = empDao.findEmployeeById(dep.getManager_id());
   		//获取部门下的所有员工
   		ArrayList<Employee> list = empDao.findEmployeeListByDepId(depId);
   		//将集合传递给下一个页面
   		request.setAttribute("list",list);
   		request.setAttribute("department",dep);
   		request.setAttribute("manager",manager);
   		//跳转页面
   		request.getRequestDispatcher("depEmployee.jsp").forward(request,response);
    %>
  </body>
</html>
