<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="tag.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allWare.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">

  </head>
  
  <body>
  <div id="content">
    <jsp:include page="head.jsp"></jsp:include>
    <div>
    	<table border="1" width="200">
    		<tr>
    			<th>商品名称</th>
    		</tr>
    		<c:forEach items="${wareList}" var="ware">
    		<tr>
    			<td height="30" align="center"><a href="showInfo.do?wareId=${ware.wareId }">${ware.wareName }</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    </div>
  </div>
  </body>
</html>
