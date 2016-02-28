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
  
  <body>
  
    <%
    	for(int i = 1; i <= 15 ; i++){
    		
     %>
     		<img  src="image/head/<%=i %>.gif"/>
     <%
     		if(i%4 == 0){
     			out.print("<br>");	
     		}
     	}
      %>
      
      <table>
      	<tr>
      		<%
	      		for(int j = 1; j <= 15; j++){
	      	%>
      			<td>
      				<img src="image/head/<%=j %>.gif"/>
      			</td>
	      	<%
	      			
	      			if(j%4 == 0){
	      	%>
	      	</tr>
	      	<tr>
	      	<%	
	      			}
	      		}
	      	 %>
      	</tr>
      </table>	
      
    <%!
      		public String birthday(String cardId){
      			String birthday = "";
      			for(int i = 6; i <= 13; i++){
      				char ch = cardId.charAt(i);
      				birthday += ch;
      				if(i == 9 || i == 11){
      					birthday += "-";
      				}
      			}
      			
      			return birthday;
      		}
      	
       %>
       
       <%
       		String cardId1 = "010010198810092211";
       		String cardId2 = "010010198010092211";
        %>
       <table border="1" style="width:400px;text-align: center">
       		<tr>
       			<td>
       				身份证号码
       			</td>
       			<td>
       				生日
       			</td>
       		</tr>
       		<tr>
       			<td>
       				<%=cardId1 %>
       			</td>
       			<td>
       				<%=birthday(cardId1) %>
       			</td>
       			
       		</tr>
       		<tr>
       			<td>
       				<%=cardId2 %>
       			</td>
       			
       			<td>
       				<%=birthday(cardId2) %>
       			</td>
       			
       		</tr>
       	
       </table>
      
  </body>
</html>
