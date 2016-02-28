<!-- page指令用来设置当前页面的全局配置 -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.niit.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- base标签表示设置当前页面访问资源的相对路径 -->
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
  
  <body> 
  	<%-- jsp注释 --%>
  	
    <!-- 小脚本的使用 -->
    <%
    	String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    	/*System.out.print(time);*/
    	//通过jsp内置对象out完成页面的输出
    	out.print(time);
    	
    	/*for(int i = 1; i <= 10; i++){
    		out.print("<img src='image/head/"+i+".gif'/>");
    	}
    	out.print("<br>");
    	out.print(path+"<br>");
    	out.print(basePath);*/

    	String name = "tom";
    	int age = 20;
    %>
    <hr/>
      欢迎
    <% 
    	//在同一个jsp中，多个小脚本中的代码是可以互相访问的
    	out.print(name);
    %>
     登陆<hr/>
     
	<% 
		for(int i = 1; i <= 10; i++){
	%>
	<img src="image/head/<%=i %>.gif"/>
	<% 
		}
	%>
	<%-- 如果需要直观得呈现变量或某个值的时候可以使用表达式来实现, 表达式的功能等同于out.print--%>
	<%-- 一个表达式只能显示一个值，该值可以通过各种方式来获取 --%>
	<hr>name:<%=name %>,age:<%=age %><hr/>
	 
	<%-- 呈现所有的头像图片，每4张图片换一行 --%>
	<% 
		for(int i = 1; i <= 15; i++){
	%>
	<img src="image/head/<%=i %>.gif"/>
	<%
			if(i%4 == 0){
	%>
	<br/>
	<%
			}
		}
	%>
	<hr/>
	<%-- 呈现所有的头像图片，每4张图片换一行，在表格中呈现 --%>
	<%-- <table border="1">
	<% 
		int count = 0;
		int row = 15/4;
		if(15%4 != 0){
			row++;
		}
		for(int i = 1; i <= row; i++){
	%>
	<tr>
	<%
			for(int j = 1; j <= 4; j++){
				count++;
				if(count <= 15){
	%>
		<td><img src="image/head/<%=count %>.gif"/></td>
	<%
				}
			}
	%>
	</tr>
	<%
		}
	%>
	</table>
	--%>
	
	<%-- <table border="1">
		<tr>
			<%
				for(int i = 1; i <= 15; i++){
			%>
			<td><img src="image/head/<%=i %>.gif"/></td>
			<%
					if(i%4 == 0){
			%>
		</tr>
		<tr>
			<%
					}
				}
			%>
		</tr>
	</table>
	--%>
	
	<%-- 小脚本和表达式可以嵌入在页面的任何位置，包括js脚本 --%>
	<%--<%
		int m = 10;
		int n = 5;
		if(m < n){
	%>
	<script>
		alert(<%=m%>+">"+<%=n %>);
	</script>
	<%
		} 
		
		String userName = "admin";
		if(userName.equals("admin")){
	%>
	<script>
		alert("<%=userName %>");
	</script>
	<%	
		}
	%>
	--%>
	
	<%
		//访问src中的对象
		User user = new User();
		user.setUserName("tom");
		user.setPassword("tom123");
	%>
	用户名是：<%=user.getUserName() %><br/>
	密码是：<%=user.getPassword() %><br/>
	
	<%-- 声明用来定义方法 --%>
	<%!
		public String parsePassword(String pwd){
			String newPwd = "";
			//将密码的每一个字符使用ASCII连接，并且每个ASCII根据字符的索引递进值
			for(int i = 0; i < pwd.length(); i++){
				char ch = pwd.charAt(i);
				newPwd+=(int)ch+(i+1);
			}
			return newPwd;
		}
	%>
	<div>加密后的密码是：<%=parsePassword(user.getPassword()) %></div>
  </body>
</html>
