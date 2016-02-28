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
    
    <title>My JSP 'info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	

  </head>
  <script type="text/javascript">
  window.onload = function(){
  	if("${flag}" == "true"){
  		alert("已加入购物车");
  	}
  }
  </script>
  <body>
  <div id="content">
  	<jsp:include page="head.jsp"></jsp:include>
  	<div>
  		<form action="addWare.do" method="post">
  		<table border="1" width="400">
  			<tr height="30">
  				<td>商品名称</td>
  				<td>${ware.wareName }</td>
  			</tr>
  			<tr height="30">
  				<td>单价</td>
  				<td>${ware.price }</td>
  			</tr>
  			<tr height="30">
  				<td>库存</td>
  				<td>${ware.num }</td>
  			</tr>
  			<tr height="30">
  				<td>购买数量</td>
  				<td><input type="text" name="buyNum"/></td>
  			</tr>
  			<tr height="30">
  				<td colspan="2">
  					<input type="hidden" name="wareId" value="${ware.wareId }">
  					<input type="submit" value="加入购物车">
  					<a href="#">购买</a>
  				</td>
  			</tr>
  		</table>
  		</form>
  		<div style="color: red; text-align: center;">${error }</div>
  	</div>
  </div>
  </body>
</html>
