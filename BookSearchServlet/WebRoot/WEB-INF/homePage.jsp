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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/common.css">
  </head>
   <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <body>
     <div id="body">
    	<!-- 标题 -start -->
    	<div id="title">
    		 <jsp:include page="title.jsp"></jsp:include>	
    	</div>
    	<!-- 标题 -end -->
    	<!-- 主体 -start -->
    	<div style="margin: auto;width: 800;border:#C6D5FD 1px solid;margin-top: 30px;">
    		<div style="margin: auto;width: 500;padding-top: 30px;">
    		<form action="searchBook.do" method="post" id="searchForm">
    			<div><input type="text" id="searchContent" name="searchContent" style="width: 350px;"/>&nbsp;<input type="button" id="searchBtn" name="searchBtn" value="搜索"/></div>
    			<div style="padding-left: 60px;padding-top: 5px;">
	    			<input type="radio" name="searchType" value="bookName" checked="checked"/>图书名称
	    			<input type="radio" name="searchType" value="bookVarity"/>图书类别
	    			<input type="radio" name="searchType" value="bookWriter"/>作者
    			</div>
    			<div id="error" style="height: 30px;color: red;"></div>
    		</form>	
    		</div>
    	</div>
    	<!-- 主体 -end -->
    </div>		
  </body>
  <script type="text/javascript">
  	//验证是否填写搜索内容
  	$("#searchBtn").click(function(){
  		if($("#searchContent").val() == ""){
  			$("#error").html("请填写搜索内容");
  		}
  		else{
  			$("#error").html("");
  			$("#searchForm").submit();
  		}
  	})
  </script>
</html>
