<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.entity.Message"%>
<%@page import="com.niit.entity.User"%>
<%@page import="com.niit.util.ChatUtil"%>
<%@page import="com.niit.util.CommonUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'msg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="2">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">
  </head>
  
  <body>
    <% 
    	if(application.getAttribute("msgList") == null){
    		ArrayList<Message> msgList = new ArrayList<Message>();
    		application.setAttribute("msgList",msgList);
    	}
    	//获取登录人的姓名
    	String loginUser = ((User)session.getAttribute("loginUser")).getUserName();
    	//获取所有聊天信息
    	ArrayList<Message> msgList = (ArrayList<Message>)application.getAttribute("msgList");
    	//获取登陆时间
    	Date loginTime = (Date)session.getAttribute("loginTime");
    	//遍历聊天信息
    	for(int i = 0; i < msgList.size(); i++){
    		Message msg = msgList.get(i);
    		//如果消息时间晚于登陆时间则显示
    		if(msg.getPublishTime().after(loginTime)){
    			String fromUser = msg.getFromUser();
				String reciveUser = msg.getReciveUser();
    			//如果是对所有人说
    			if(msg.getReciveUser().equals("all")){
    				reciveUser = "所有人";
    				//如果消息是登陆人发送的
    				if(msg.getFromUser().equals(loginUser)){
    					fromUser = "我";
    				}
    %>
    <div style="margin-bottom: 10px">
    	<span style="color: green"><%=fromUser %></span>&nbsp;&nbsp;对&nbsp;&nbsp;<%=reciveUser %><span style="margin-left: 10px; color: blue"><%=ChatUtil.changeAction(msg.getAction()) %></span>:
    	<span style="color: <%=ChatUtil.changeColor(msg.getColor())%>"><%=msg.getMsgContent() %></span>
    	<span style="color: #D7D7D7">[<%=CommonUtil.formatDate(msg.getPublishTime()) %>]</span>
    </div>
    <%
    			}
    			//如果是私聊信息
    			else{
    				//私聊信息只有发信人和收信人可见
    				//如果登陆人是发信人或者是收信人
    				if(loginUser.equals(msg.getFromUser()) || loginUser.equals(msg.getReciveUser())){
    					//如果是登陆人发的信息
    					if(fromUser.equals(loginUser)){
    						fromUser = "我";
    					}
    					//如果如果消息是发给登录人
    					else if(reciveUser.equals(loginUser)){
    						reciveUser = "我";
    					}	
    %>
    <div style="margin-bottom: 10px">
    	<span style="color: green"><%=fromUser %></span>&nbsp;&nbsp;对&nbsp;&nbsp;<%=reciveUser %><span style="margin-left: 10px; color: blue"><%=ChatUtil.changeAction(msg.getAction()) %></span>:
    	<span style="color: <%=ChatUtil.changeColor(msg.getColor())%>"><%=msg.getMsgContent() %></span>
    	<span style="color: #D7D7D7">[<%=CommonUtil.formatDate(msg.getPublishTime()) %>]</span>
    </div>
    <%			
    				}
    			}
    		}
    	}
    %>
  </body>
</html>
