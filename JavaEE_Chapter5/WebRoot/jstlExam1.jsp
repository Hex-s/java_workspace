<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstlExam1.jsp' starting page</title>
    
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
  	<!-- 设置页面如果发生错误后需要跳转的页面路径 -->
  	<c:set var="path" value="elExam3.jsp" scope="request"></c:set>
  	<!-- set标签用来设置数据至作用域中 -->
  	<!-- var表示存入作用域的键 -->
    <c:set var="name" value="john" scope="page"></c:set>
    ${name }<br/>
    <jsp:useBean id="user" class="com.niit.entity.User"></jsp:useBean>
    <!-- 将user对象写入newUser中 -->
    <c:set var="newUser" value="${user}"></c:set>
     ${newUser }<br/>
    <!-- target必须和property属性结合使用，表示将value值写入target对象的property属性中 -->
    <c:set target="${user}" property="userName" value="jack"></c:set>
    ${user.userName }<br/>
    <!-- 输出数据 -->
    <%--<c:out value="${name}"></c:out>--%>
    <!-- remove用来移除作用中指定键的数据 -->
    <%--<c:remove var="name"/>--%>
    <% 
    	//remove等价于以下代码
    	//pageContext.removeAttribute("name");
    %>
    ${name }<br/>
    <!-- if标签中的 test属性需要boolean类型的返回值，并且该表达式必须使用EL表达式来实现 -->
    <%--<c:if test="${1 gt 1}">
    	 true
    </c:if>--%>
    <!-- 判断用户是否登陆 -->
    <c:if test="${not empty name}">
    	<div>欢迎<a href="#">${name }</a>登陆<a href="#">注销</a></div>
    </c:if>
    <c:if test="${empty name}">
    	<div><a href="#">登陆</a> <a href="#">注册</a></div>
    </c:if>
    <!-- choose标签用来对多个分支条件进行判断 -->
    <c:choose>
    	<c:when test="${name eq 'tom'}">
    		tom
    	</c:when>
    	<c:when test="${name eq 'jack'}">
    		jack
    	</c:when>
    	<c:when test="${name eq 'tony'}">
    		tony
    	</c:when>
    	<c:otherwise>
    		others
    	</c:otherwise>
    </c:choose>
    <!-- 重定向 -->
    <%--<c:redirect url="http://www.taobao.com">
    	<c:param name="key" value="value"></c:param>
    </c:redirect>--%>
    <hr/>
    <!-- 导入外部的页面 -->
    <%--<c:import url="http://www.taobao.com"></c:import>--%>
    <!-- 捕获异常 -->
    <c:catch var="msg">
    <% 
    	/*try{
    	Integer.parseInt("niit");
    	}catch(Exception e){
    		out.print(e.getMessage());
    	}*/
    	//Integer.parseInt("niit");
    %>
    </c:catch>
    ${msg }
    <% 
    	//Integer.parseInt("niit");
    %>
    <% 
    	ArrayList list = new ArrayList();
    	list.add("tom");
    	list.add("jack");
    	list.add("tony");
    	pageContext.setAttribute("list",list);
    %>
    <%--<c:forEach begin="1" end="5" step="1">
    	<a href="#">连接</a>
    </c:forEach>--%>
    <c:forEach var="name" items="${list}">
    	${name }<br/>
    </c:forEach>
  </body>
</html>
