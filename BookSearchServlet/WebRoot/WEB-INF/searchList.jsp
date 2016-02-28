<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.Books"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.dao.impl.BooksDao"%>
<%@page import="com.niit.dao.impl.WriterDao"%>
<%@page import="com.niit.dao.impl.PublishDao"%>
<%@page import="com.niit.dao.impl.VarityDao"%>
<%@page import="com.niit.entity.Varity"%>
<%@page import="com.niit.entity.Writer"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css">

  </head>
  
  <body>
      <div id="body">
    	<!-- 标题 -start -->
    	<div id="title">
    		<jsp:include page="title.jsp"></jsp:include>
    	</div>
    	<!-- 标题 -end -->
    	<!-- 主体 -start -->
    	<div style="padding-top: 50px;">
    		<c:choose>
    			<c:when test="${not empty list}">
    				<table width="100%" cellpadding="0" cellspacing="0">
			   			<tr style="background-color: #E8F2FE;height: 40px; font-size: 16px;font-weight: bold;">
			   				<td style="padding-left: 10px;">名称</td>
			   				<td>作者</td>
			   				<td>出版社</td>
			   			</tr>
			   			<c:forEach var="book" items="${list}">
			   			<tr>
			   				<td class="bookList" style="padding-left: 10px;"><a href="bookInfo.do?bookId=${book.bookId}">${book.bookName }</a></td>
			   				<td class="bookList">${book.bWriterName }</td>
			   				<td class="bookList">${book.bPublishName }</td>
			   			</tr>
			   			</c:forEach>			   			
			   		</table>
    			</c:when>
    			<c:otherwise>
    				<div class="nullContent">没有您要查找的图书</div>
    			</c:otherwise>
    		</c:choose>
    		
    	</div>
    	<!-- 主体 -end -->
    </div>	
  </body>
</html>
