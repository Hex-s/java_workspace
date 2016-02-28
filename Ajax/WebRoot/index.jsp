<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="ajax.js"></script>
  
  <script type="text/javascript" src="jquery-1.6.js"></script>
  <script type="text/javascript">
  function showAjaxPage(){
  
  	doAjax("content","ajax.jsp");
  	//使用jQuery进行AJAX请求
  	//$.post("search.do",{txt:$("#txt").val()},function(data){
  		//alert(data);
  		//$("#foot").html(data);
  	//	$("#data").html(data);
  	//});
  }
  </script>
  <body>
  	
    <a href="javascript:showAjaxPage()">doAjax</a><hr/>
   
    <input type="text"  onkeyup="showAjaxPage()" id="txt">
    <div id="data"></div>
    
    
    <div id="content" style="width: 1000px; height: 500px; background-color: orange"></div>
   
    <div id="foot" style="width: 1000px; height: 200px; background-color: yellow"></div>
  </body>
</html>
