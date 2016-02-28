<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    		<div id="logo">图书搜索系统</div>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;">
    			<a href="index.jsp">[&nbsp;首&nbsp;页&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a>
    		</div>
    	</div>
    	<!-- 标题 -end -->
    	<!-- 主体 -start -->
    	<div style="margin: auto;width: 800;border:#C6D5FD 1px solid;margin-top: 30px;">
    	<form action="loginServlet.do" method="post" id="loginForm">
    		<table style="border: 0px; padding-left: 300px;padding-top: 20px;">
    			<tr>
					<td width="60">用户名：</td>
					<td>
						<div style="float: left;"><input type="text" name="userName" id="userName" value="${name }"/></div>
						<div style="float: left;color: red;" id="userNameError">${nameError }</div>
					</td>	    							
	    		</tr>
	    		<tr>
					<td>密码：</td>
					<td>
				   		 <div style="float: left;"><input type="password" name="password" id="password"/></div>
				   		 <div style="float: left;color: red;" id="passwordError">${pwdError }</div>
					</td>	    							
	    		</tr>
	    		<tr>
					<td colspan="2" align="center"><input type="button" id="btn" value="登录"/></td>	    							
	    		</tr>
    		</table>
    	</form>	
    	</div>
    	<!-- 主体 -end -->
    </div>
  </body>
  <script type="text/javascript">
  
  	$("#btn").click(function(){
  
  		if($("#userName").val() == ""){
  			$("#userNameError").html("请填写用户名");
  		}
  		else if($("#password").val() == ""){
  			$("#userNameError").html("");
  			$("#passwordError").html("请填写密码");
  		}
  		else{
  		
  			$("#loginForm").submit();
  		}
  	})
  </script>
</html>
