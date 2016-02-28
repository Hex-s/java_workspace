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
	
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">

  </head>
 
  <body>
   <script type="text/javascript" src="js/jquery-1.6.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  	$("#loginBtn").click(function(){
  		$("#loginForm").submit();
  	})
  });
  
  function refreshCode()
  {
  	var ran=Math.floor(Math.random()*10000);
	document.getElementById("imgCode").src="code.jsp?id="+ran;
  }
 
  </script>
   <div id="body">
	 	<!-- 页眉 -start -->
	 	<div id="title">
	 		<div style="font-size: 25px;width:300px;float:left;">NIIT BBS</div>
	 		<div style="float:right;padding-top: 20px;padding-right: 10px;">
	 		<a href="index.jsp">[&nbsp;首&nbsp;页&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a>
	 		</div>
	    </div>
	    <!-- 登录信息  -start-->
	    <div style="padding-top: 50px;">
	    	<form action="loginAction.jsp" method="post" id="loginForm">
	    		<table align="center" border="0" cellpadding="0" cellspacing="0" width="350" height="120" style="padding-left: -20px;">
	    			<tr>
	    				<td colspan="3" width="324"><img src="image/login_top.gif" width="324"/></td>
	    			</tr>
	    			<tr>
	    				<td width="21"><img src="image/Login_left.gif" /></td>
	    				<td width="115">
	    					<table width="235" height="200">
	    						<tr>
	    							<td>用户名：</td>
	    							<td><input type="text" name="userName"/></td>
	    							
	    						</tr>
	    						<tr><td></td><td style="color: red;font-size: 11px;">
				    			<% 
				  					if(request.getAttribute("nameError") != null){
				  						out.print(request.getAttribute("nameError"));
				  					}
				  				%>
	    						</td></tr>
	    						<tr>
	    							<td>密码：</td>
	    							<td><input type="password" name="password"/></td>	    							
	    						</tr>
	    						<tr><td></td><td style="color: red;font-size: 11px;">
	    						<% 
				  					if(request.getAttribute("pwdError") != null){
				  						out.print(request.getAttribute("pwdError"));
				  					}
				  				%>
	    						</td></tr>
	    						<tr>
	    							<td>验证码：</td>
	    							<td>
	    								<input type="text" name="inputCode" style="width: 100px;"/>
	    							</td>
	    						</tr>
	    						<tr>
	    							<td></td>
	    							<td style="color: red">
	    							<%
	    								if(request.getAttribute("codeError") != null){
	    									out.print(request.getAttribute("codeError"));
	    								}
	    							 %>
	    							</td>
	    						</tr>
	    						<tr>
	    							<td></td>
	    							<td>
	    								<img id="imgCode" src="code.jsp">
	    								<a href="javascript:refreshCode()">刷新</a>
	    							</td>
	    						</tr>
	    						
	    						<tr>
	    							<td colspan="2" align="center">
					    				<input value="登陆" type="button" id="loginBtn"/>
			    					</td>
	    							
	    						</tr>
	    						<tr><td colspan="2" align="center"><a href="register.jsp"><img src="image/login-1.gif" id="register" border="0"/></a></td></tr>
	    					</table>
	    				</td>
	    				<td width="21"><img src="image/Login_right.gif"/></td>
	    			</tr>
	    			<tr>
	    				<td colspan="3" width="324"><img src="image/login_bottom.gif" /></td>
	    			</tr>
	    		</table>
	    	</form>
	    </div>
	    <!-- 登录信息  -end-->
	    <!-- 页脚 -start -->
	 	<div style="padding-left: 350px;">
	 		<table style="padding-top: 20px;width: 250px;">
	 			<tr>
	 				<td>论坛信息</td>
	 				<td>联系我们</td>
	 				<td>加入论坛</td>
	 				<td>意见反馈</td>
	 			</tr>
	 			<tr>
	 				<td colspan="4" align="center">&reg;CopyRight 2014</td>
	 			</tr>
	 		</table>
	 	</div>
 	<!-- 页脚 -end -->
   </div>
   <%
   
    %>
  </body>
</html>
