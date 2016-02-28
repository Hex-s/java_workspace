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
    
    <title>My JSP 'car.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">


  </head>
  
  <body>
    <div id="content">
    	<div><a href="#">返回</a></div>
    	<div>
    		<table border="1" width="800">
    			<tr height="30">
    				<th>商品名称</th>
    				<th>单价</th>
    				<th>购买数量</th>
    				<th>购买时间</th>
    				<th>金额</th>
    			</tr>
    			<c:forEach items="${shoppingCar}" var="record">
    			<tr height="30">
    				<td align="center">${record.wareName }</td>
    				<td align="center">${record.price }</td>
    				<td align="center">${record.buyNum }</td>
    				<td align="center">${record.buyTime }</td>
    				<td align="center">${record.payPrice }</td>
    			</tr>
    			</c:forEach>
    			<tr height="30">
    				<td colspan="5" align="right">总计：${totalPrice } &yen;</td>
    			</tr>
    		</table>
    	</div>
    </div>
  </body>
</html>
