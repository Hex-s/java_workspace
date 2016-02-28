<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entiry.User"%>
<%@page import="com.niit.entiry.Collect"%>
<%@page import="com.niit.dao.impl.CollectDao"%>
<%@page import="com.niit.entiry.Books"%>
<%@page import="com.niit.dao.impl.BooksDao"%>
<%@page import="com.niit.dao.impl.WriterDao"%>
<%@page import="com.niit.dao.impl.PublishDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCollect.jsp' starting page</title>
    
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
    		<div id="logo">图书搜索系统</div>
    		<%
    			User loginUser = null;
    			if(session.getAttribute("loginUser") == null){
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;"><a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a></div>
    		<%		
    			}
    			else{
    				loginUser = (User)session.getAttribute("loginUser");
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;">欢迎&nbsp;<%=loginUser.getuName() %>&nbsp;|&nbsp;<a href="index.jsp">首页</a>|&nbsp;<a href="exitLoginAction.jsp">注销</a></div>
    		<%		
    			}
    		 %>
    	</div>
    	<!-- 标题 -end -->
    	<div>
    		<%
    		CollectDao collectDao = new CollectDao();
    		BooksDao bookDao = new BooksDao();
    		WriterDao writerDao = new WriterDao();
    		PublishDao publishDao = new PublishDao();
    		ArrayList<Collect> list = collectDao.findCollectByUserId(loginUser.getUserId());
    		if(list != null){
    		%>
    		<table border="1" width="100%">
    		<tr>
   				<td>名称</td>
   				<td>作者</td>
   				<td>出版社</td>
   			</tr>
    		<%
    			for(Collect c : list){
    				Books book = bookDao.findBookByBookId(c.getcBookId());
    		%>
    		<tr>	
    			<td><a href="bookInfo.jsp?bookId=<%=book.getBookId() %>"><%=book.getBookName() %></a></td>
   				<td><%=writerDao.findWriterByWriterId(book.getbWriterId()).getwName() %></td>
   				<td><%=publishDao.findPublishByPublishId(book.getbPublishId()).getpName() %></td>
   			</tr>	
    		<%		
    			}
    		 %>

    		</table>
    		<%
    		}
    		else{
    			out.print("您还没有收藏的书籍");
    		}
    		%>	
    		
    	</div>
    </div>	
  </body>
</html>
