<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchAction.jsp' starting page</title>
    
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
    	//获取搜索内容
    	String searchContent = request.getParameter("searchContent");
    	session.setAttribute("searchContent",searchContent);
    	//获取搜索类别
    	String[] types = request.getParameterValues("searchType");
    	String type = "";
    	if(types != null){
    		for(String str : types){
    			if(!str.equals("")){
    				type += str;
    				break;
    			}
    			
    		}
    		session.setAttribute("searchType",type);
    	}
    	//跳转页面
    	request.getRequestDispatcher("searchList.jsp").forward(request,response);
     %>
  </body>
</html>
