<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entiry.Books"%>
<%@page import="com.niit.entiry.User"%>
<%@page import="com.niit.dao.impl.BooksDao"%>
<%@page import="com.niit.dao.impl.WriterDao"%>
<%@page import="com.niit.dao.impl.PublishDao"%>
<%@page import="com.niit.dao.impl.VarityDao"%>
<%@page import="com.niit.entiry.Varity"%>
<%@page import="com.niit.entiry.Writer"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchList.jsp' starting page</title>
    
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
    	//获取查找类型
    	String type = session.getAttribute("searchType").toString();
    	//获取查找内容
    	String searchContent = session.getAttribute("searchContent").toString();
    	ArrayList<Books> bookList = new ArrayList<Books>();
    	//根据图书的名称搜索
    	if(type.equals("bookName")){
    		ArrayList<Books> list = booksDao.findBookListByBookName(searchContent);
    		if(list != null){
    			for(Books book : list){
    				bookList.add(book);
    			}
    		}
    	}
    	else if(type.equals("bookVarity")){
    		//查找类别
    		ArrayList<Varity> varityList = varityDao.findVarityListByVarityName(searchContent);
    		if(varityList != null){
    			//循环查询到的类别查找相应图书
    			for(Varity v : varityList){
    				ArrayList<Books> list = booksDao.findBookListByBookVarity(v.getvId());
    				if(list != null){
    					for(Books book : list){
			   				bookList.add(book);
			   			}
    				}
    			}
    		}
    	}
    	else{
    		//查找作家
    		ArrayList<Writer> writerList = writerDao.findWriterByWriterName(searchContent);
    		if(writerList != null){
    			//循环所有的作家查找所写的图书
    			for(Writer w : writerList){
    				ArrayList<Books> list = booksDao.findBookListByBookWriter(w.getWriterId());
    				if(list != null){
    					for(Books book : list){
			   				bookList.add(book);
			   			}
    				}
    			}
    		}
    	}
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
    	<%
    		if(bookList.isEmpty()){
    	%>
    		<div style="text-align: center;color: red;padding-top: 200px;font-size: 16px;">没有您要查找的书籍</div>
    	<%	
    		}
    		else{
    	%>
    	<div>
    		<table border="1" width="100%">
    			<tr>
    				<td>名称</td>
    				<td>作者</td>
    				<td>出版社</td>
    			</tr>
    	<%
    		for(Books book : bookList){
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
    	</div>
    	<%	
    		}
    	 %>
    	</div>
    	<!-- 主体 -end -->
    </div>	
  </body>
</html>
