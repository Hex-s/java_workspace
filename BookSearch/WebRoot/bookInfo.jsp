<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.WriterDao"%>
<%@page import="com.niit.dao.impl.BooksDao"%>
<%@page import="com.niit.dao.impl.PublishDao"%>
<%@page import="com.niit.dao.impl.VarityDao"%>
<%@page import="com.niit.entiry.User"%>
<%@page import="com.niit.entiry.Books"%>
<%@page import="com.niit.entiry.Collect"%>
<%@page import="com.niit.dao.impl.CollectDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <%
    	//创建DAO 
    	WriterDao writerDao = new WriterDao();
		BooksDao booksDao = new BooksDao();
		PublishDao publishDao = new PublishDao();
		VarityDao varityDao = new VarityDao();
		CollectDao collectDao = new CollectDao();
    	//获取书籍编号
    	int bookId = Integer.parseInt(request.getParameter("bookId"));
    	//获取书籍对象
    	Books book = booksDao.findBookByBookId(bookId); 
     %>
      <div id="body">
    	<!-- 标题 -start -->
    	<div id="title">
    		<div id="logo">图书搜索系统</div>
    		<%
    			User loginUser = null;
    			if(session.getAttribute("loginUser") == null){
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;"><a href="index.jsp">[&nbsp;首&nbsp;页&nbsp;]</a><a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a><a href="register.jsp">[&nbsp;注&nbsp;册&nbsp;]</a></div>
    		<%		
    			}
    			else{
    				loginUser = (User)session.getAttribute("loginUser");
    		%>
    		<div style="float: right;padding-top: 15px;padding-right: 5px;">欢迎&nbsp;<%=loginUser.getuName() %>&nbsp;|&nbsp;<a href="index.jsp">首页</a>|<a href="showCollect.jsp">收藏</a>&nbsp;|<a href="exitLoginAction.jsp">注销</a></div>
    		<%		
    			}
    		 %>
    	</div>
    	<!-- 标题 -end -->
    	<!-- 主体 -start -->
    	<div>
    		<table width="100%" cellpadding="0" cellspacing="0" border="0">
    			<tr>
    				<td rowspan="5" width="20%" height="300"><img src="images/<%=book.getbPic() %>" height="300"/></td>
    			</tr>
    			<tr>
    				<td class="td">
    					<div style="float: left;">书名：<%=book.getBookName() %></div>
    					<div style="float: right;padding-right: 20px;">
    					<%
    						if(loginUser == null){
    							out.print("登陆后可进行收藏！");
    						}
    						else{
    							Collect collect= new Collect(loginUser.getUserId(),bookId);
    							Collect c = collectDao.findCollect(collect);
    							if(c == null){
    					%>
    					<a href="collecAction.jsp?userId=<%=loginUser.getUserId() %>&bookId=<%=bookId %>&type=1">收藏</a>
    					<%
    							}
    							else{
    					%>
    					<a href="collecAction.jsp?userId=<%=loginUser.getUserId() %>&bookId=<%=bookId %>&type=0">取消收藏</a>
    					<%
    							}
    						}
    					 %>
    					</div>
    				</td>
    			</tr>
    			<tr>
    				<td class="td">作者：<%=writerDao.findWriterByWriterId(book.getbWriterId()).getwName() %></td>
    			</tr>
    			<tr>
    				<td class="td">出版社：<%=publishDao.findPublishByPublishId(book.getbPublishId()).getpName() %></td>
    			</tr>
    			<tr>
    				<td valign="top" style="padding-left: 10px;">简介：<%=book.getbInfo()%></td>
    			</tr>
    		</table>
    	</div>
    	
    </div>	
  </body>
</html>
