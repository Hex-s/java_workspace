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
    
    <title>My JSP 'bookInfo.jsp' starting page</title>
    
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
    		<table border="0">
    			<tr>
    				<td width="20%"><img src="images/${book.bPic }" height="300"/></td>
    				<td valign="top" width="65%" style="padding-left: 10px;">
    					<p>书名：${book.bookName }</p>
    					<p>作者：${book.bWriterName }</p>
    					<p>出版社：${book.bPublishName }</p>
    					<p>分类：${book.bVarithName }</p>
    					<p>简介：${book.bInfo}</p>
    				</td>
    				<td valign="top">
    					<c:choose>
    						<c:when test="${empty loginUser}">
    							登陆后可进行收藏！
    						</c:when>
    						<c:otherwise>
    							<c:choose>
    								<c:when test="${empty collectState}">
    									<a href="bookInfo.do?bookId=${book.bookId}&type=1" class="collect">收藏</a>
    								</c:when>
    								<c:when test="${not empty collectState}">
    									<a href="bookInfo.do?bookId=${book.bookId}&type=0" class="collect">取消收藏</a>
    								</c:when>
    							</c:choose>
    						</c:otherwise>
    					</c:choose>
    				</td>
    			</tr>
    			
    			
    		</table>
    	</div>
    </div>	
  </body>
</html>
