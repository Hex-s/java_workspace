<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.niit.dao.impl.UserDao"%>
<%@page import="com.niit.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bbs-common.css">

  </head>
   <script type="text/javascript" src="js/jquery-1.6.js"></script>
   <script type="text/javascript">
 
   </script>
  <body>
    <div id="body">
	 	<!-- 页眉 -start -->
	 	<div id="title">
	 		<div style="font-size: 25px;width:300px;float:left;">NIIT BBS</div>
	 		<div style="float:right;padding-top: 20px;padding-right: 10px;">
	 		<a href="index.jsp">[&nbsp;首&nbsp;页&nbsp;]</a><a href="login.jsp">[&nbsp;登&nbsp;录&nbsp;]</a>
	 		</div>
	    </div>
	    <!-- 登录信息 -start-->
	    <div>
	    	<div style="width: 857px;padding-left: 75px;">
	    		<div><img src="image/register-top.gif"/></div>
		    	<div>
		    		<div style="background-image: url(image/register-line.gif);height: 600px;width: 3px;float: left;"></div>
		    		<div style="float: left;width: 800px;">
		    		<form action="registerAction.jsp" method="post" id="regForm">
		    			<table border="0" height="500" width="650" align="center">
		    				<tr>
		    					<td width="250" align="right">用户名：</td>
		    					<td>
		    						<div style="float: left;"><input type="text" id="regName" onblur="validate_name()" name="regName"/></div>
		    						<div class="register" id="regNameError"/>
		    						<%
		    							if(request.getAttribute("regUserError") != null){
		    								out.print(request.getAttribute("regUserError"));	
		    							}
		    						 %>
		    						</div>
		    					</td>
		    					
		    				</tr>
		    				<tr>
		    					<td align="right">密&nbsp;码：</td>
		    					<td>
		    						<div style="float: left;"><input type="password" id="regPwd" onblur="validate_pasword()" name="regPwd"/></div>
		    						<div class="register" id="regPwdError"/></div>		    						
		    					</td>
		    				</tr>
		    				<tr>
		    					<td align="right">确认密码：</td>
		    					<td>
		    						<div style="float: left;"><input type="password" id="regConfirmPwd" onblur="validate_confirmPasword()"/></div>
		    						<div class="register" id="regConfirmPwdError"/></div>		    					
		    					</td>
		    				</tr>
		    				<tr>
		    					<td align="right">性别：</td>
		    					<td><input type="radio" name="regSex" value="male" checked="checked"/>男<input type="radio" name="regSex" value="female"/>女</td>		    					
		    				</tr>
		    				<tr>
		    					<td align="right">邮箱：</td>
		    					<td>
		    						<div style="float: left;"><input type="text" id="regEmail" name="regEmail" onblur="validate_email()"/></div>
		    						<div class="register" id="regEmailError"/></div>							
		    					</td>
		    				</tr>
		    				<tr>
		    					<td align="right">生日：</td>
		    					<td>
		    						<select id="birthyear" name="birthyear" onchange="chengeDay()">
						                <option value=2011 selected>2011</option>   
						                <option value=2004>2010</option>
						                <option value=2003>2009</option>				                
						                <option value=2002>2008</option>
						                <option value=2001>2007</option>
						                <option value=2000>2006</option>					                
						                <option value=2005>2005</option>
						                <option value=2004>2004</option>
						                <option value=2003>2003</option>				                
						                <option value=2002>2002</option>
						                <option value=2001>2001</option>
						                <option value=2000>2000</option>
						                <option value=1999>1999</option>
						                <option value=1998>1998</option>
						                <option value=1997>1997</option>
						                <option value=1996>1996</option>
						                <option value=1995>1995</option>
						                <option value=1994>1994</option>
						                <option value=1993>1993</option>
						                <option value=1992>1992</option>
						                <option value=1991>1991</option>
						                <option value=1990>1990</option>
						                <option value=1989>1989</option>
						                <option value=1988>1988</option>
						                <option value=1987>1987</option>
						                <option value=1986>1986</option>
						                <option value=1985>1985</option>
						                <option value=1984>1984</option>
						                <option value=1983>1983</option>
						                <option value=1982>1982</option>
						                <option value=1981>1981</option>
						                <option value=1980>1980</option>
						                <option value=1979>1979</option>
						                <option value=1978>1978</option>
						                <option value=1977>1977</option>
						                <option value=1976>1976</option>
						                <option value=1975>1975</option>
						                <option value=1974>1974</option>
						                <option value=1973>1973</option>
						                <option value=1972>1972</option>
						                <option value=1971>1971</option>
						                <option value=1970>1970</option>
						                <option value=1969>1969</option>
						                <option value=1968>1968</option>
						                <option value=1967>1967</option>
						                <option value=1966>1966</option>
						                <option value=1965>1965</option>
						                <option value=1964>1964</option>
						                <option value=1963>1963</option>
						                <option value=1962>1962</option>
						                <option value=1961>1961</option>
						                <option value=1960>1960</option>
						                <option value=1959>1959</option>
						                <option value=1958>1958</option>
						                <option value=1957>1957</option>
						                <option value=1956>1956</option>
						                <option value=1955>1955</option>
						                <option value=1954>1954</option>
						                <option value=1953>1953</option>
						                <option value=1952>1952</option>
						                <option value=1951>1951</option>
						                <option value=1950>1950</option>
						                <option value=1949>1949</option>
						                <option value=1948>1948</option>
						                <option value=1947>1947</option>
						                <option value=1946>1946</option>
						                <option value=1945>1945</option>
						                <option value=1944>1944</option>
						                <option value=1943>1943</option>
						                <option value=1942>1942</option>
						                <option value=1941>1941</option>
						                <option value=1940>1940</option>
						                <option value=1939>1939</option>
						                <option value=1938>1938</option>
						                <option value=1937>1937</option>
						              </select> 年
						              <select id="birthmonth" name="birthmonth" onchange="chengeDay()">
						                <option value=1 selected>1</option>
						                <option value=2>2</option>
						                <option value=3>3</option>
						                <option value=4>4</option>
						                <option value=5>5</option>
						                <option value=6>6</option>
						                <option value=7>7</option>
						                <option value=8>8</option>
						                <option value=9>9</option>
						                <option value=10>10</option>
						                <option value=11>11</option>
						                <option value=12>12</option>
						              </select> 月
						              <select  id="birthday" name="birthday">
						                <option value=1 selected>1</option>
						                <option value=2>2</option>
						                <option value=3>3</option>
						                <option  value=4>4</option>
						                <option value=5>5</option>
						                <option value=6>6</option>
						                <option value=7>7</option>
						                <option value=8>8</option>
						                <option value=9>9</option>
						                <option value=10>10</option>
						                <option value=11>11</option>
						                <option value=12>12</option>
						                <option value=13>13</option>
						                <option value=14>14</option>
						                <option value=15>15</option>
						                <option value=16>16</option>
						                <option value=17>17</option>
						                <option value=18>18</option>
						                <option value=19>19</option>
						                <option value=20>20</option>
						                <option value=21>21</option>
						                <option value=22>22</option>
						                <option value=23>23</option>
						                <option value=24>24</option>
						                <option value=25>25</option>
						                <option value=26>26</option>
						                <option value=27>27</option>
						                <option value=28>28</option>
						                <option value=29>29</option>
						                <option value=30>30</option>
						                <option value=31>31</option>
						              </select> 日
		    					</td>
		    				</tr>
		    				<tr>
		    					<td align="right">居住地：</td>
		    					<td>
		    						<div style="float: left;"><select id="province" name="province" style="width: 100px" onchange="cityChange()" onblur="validate_location()">
						                <option value="-1">--选择省份--</option>
						                <option value="北京市">北京市</option>
						                <option value="上海市">上海市</option>
						                <option value="广州省">广州省</option>
						                <option value="深圳市">深圳市</option>
						                <option value="重庆市">重庆市</option>
						                <option value="天津市">天津市</option>
						                <option value="江苏省">江苏省</option>
						                <option value="浙江省">浙江省</option>
						                <option value="四川省">四川省</option>
						                <option value="海南省">海南省</option>
						                <option value="福建省">福建省</option>
						                <option value="山东省">山东省</option>
						                <option value="江西省">江西省</option>
						                <option value="广西省">广西省</option>
						                <option value="安徽省">安徽省</option>
						                <option value="河北省">河北省</option>
						                <option value="河南省">河南省</option>
						                <option value="湖北省">湖北省</option>
						                <option value="湖南省">湖南省</option>
						                <option value="陕西省">陕西省</option>
						                <option value="山西省">山西省</option>
						                <option value="黑龙江省">黑龙江省</option>
						                <option value="国外">国外</option>
						                <option value="其他">其他</option>
						              </select>
						              <select id="city" name="city" style="width: 100px">
						                <option>--选择城市--</option>
						              </select></div>
						              <div class="register" id="locationError"/></div>	
						              
		    					</td>
		    				</tr>	
		    				<tr>
		    					<td align="right">自我介绍：</td>
		    					<td>
		    						<div style="float: left;"><textarea id="statement" name="statement" style="width: 300px;height: 60px;" onblur="validate_statement()"></textarea></div>
		    						<div class="register" id="statementError"/></div>	
		    					</td>		    					
		    				</tr>
		    				<tr>
		    					<td align="right">选择头像：</td>
		    					<td>
		    						<div style="float: left;"><input type="text" name="head" id="head" onblur="validate_head()"><input type="button" value="点击查看头像" id="clickForHead" /></div>
		    						<div class="register" id="headError"></div>
		    					</td>
		    				</tr>
		    				<tr>
		    					<td colspan="2">&nbsp;</td>
		    				</tr>
		    				<tr>
		    					<td colspan="2" align="center"><input type="button" id="submitReg" onclick="validate()" style="background-image: url(image/register-sm1.gif);width: 127px;height: 39px;border: 0px;cursor: hand;"/></td>
		    				</tr>
		    			</table>
		    		</form>	
		    		</div>
		    		<!-- 头像选择 -start -->
		    		<div id="headChoice" style="display:none;background-color:#FFF5EA;width: 300px;height: 380px;position: absolute;top: 350px;left: 500px;border: gray 1px solid;">
		    			<div style="text-align: right;"><span style="cursor: hand;" id="confirmHead">[确认]</span>&nbsp;<span style="cursor: hand;" id="closeHead">[关闭]</span></div>
		    			<div>
		    				  <table>
							      	<tr>
							      		<%
								      		for(int j = 1; j <= 15; j++){
								      	%>
							      			<td>
							      				<input type="radio" name="head" value="<%=j %>.gif"/><img src="image/head/<%=j %>.gif"/>
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
			    		</div>
		    		</div>
		    		<!-- 头像选择 -end -->
		    		<div style="background-image: url(image/register-line.gif);height: 600px;width: 3px;float: right;"></div>
		    	</div>
		    	<div><img src="image/register-bottom.gif"/></div>
	    	</div>
	    </div>
	     <!-- 登录信息 -end-->
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
	
	<script type="text/javascript">
	
		var flag = 1;
		
		//校验用户名
		var regNameError = document.getElementById("regNameError");
		function validate_name(){
			if($("#regName").val() == ""){
			 regNameError.innerHTML = "请填写用户名";
			 flag = 0;
			}
			else{
				regNameError.innerHTML = "";
				flag = 1;
			}
		
		}
		//校验密码
		var regPwdError = document.getElementById("regPwdError");
		function validate_pasword(){
			var rule = /^.{6,}$/;
			if($("#regPwd").val() == ""){
				 regPwdError.innerHTML = "请填写密码";
			 	flag = 0;
			}
			else if(!rule.test($("#regPwd").val())){
				regPwdError.innerHTML = "请填写六位以上密码";
			 	flag = 0;
			}
			else{
				regPwdError.innerHTML = "";
				flag = 1;
			}
		
		}
		//校验确认密码
		var regConfirmPwdError = document.getElementById("regConfirmPwdError");
		function validate_confirmPasword(){
			var pwd = $("#regPwd").val();
			var conpwd = $("#regConfirmPwd").val();
			if(conpwd == ""){
				flag = 0;
				regConfirmPwdError.innerHTML = "请填写确认密码";
			}	
			else if(pwd != conpwd){
				flag = 0;
				regConfirmPwdError.innerHTML = "确认密码与密码不一致";	
			}
			else{
				flag = 1;
				regConfirmPwdError.innerHTML = "";	
			}
		}
		
		//校验邮箱
		var regEmailError = document.getElementById("regEmailError");
		function validate_email(){
			var email = $("#regEmail").val();
			var rule = /^\w+@(\w+\.\w+)+$/;;
			if(email == ""){
				flag = 0;
				regEmailError.innerHTML = "请填写常用电子邮箱";
			}	
			else if(!rule.test(email)){
				flag = 0;
				regEmailError.innerHTML = "请填写正确的电子邮箱";	
			}
			else{
				flag = 1;
				regEmailError.innerHTML = "";	
			}
		}
		
		//校验居住地
		var locationError = document.getElementById("locationError");
		var province = document.getElementById("province");
		function validate_location(){
			if(province.selectedIndex == 0)	{
				flag = 0;
				locationError.innerHTML = "请选择现居住地";	
			}
			else{
				flag = 1;
				locationError.innerHTML = "";	
			}
		}
		
		//校验自我介绍
		var statementError = document.getElementById("statementError");
		function validate_statement(){
			if($("#statement").val() == ""){
				flag = 0;
				statementError.innerHTML = "请填写自我介绍";	
			}
			else{
				flag = 1;
				statementError.innerHTML = "";	
			}
		}
		//校验头像
		var headError = document.getElementById("headError");
		function validate_head(){
		
			if($("#head").val() == ""){
				
				flag = 0;
				headError.innerHTML = "请选择头像";	
			}
			else{
				flag = 1;
				headError.innerHTML = "";	
			}
		}
		
		//提交表单
		function validate(){
		
			validate_name();
			if(flag == 1){
				validate_pasword();
				if(flag == 1){
					validate_confirmPasword();
					if(flag == 1){
						validate_email();
						if(flag == 1){
							validate_location();
							if(flag == 1){
								validate_statement();
									if(flag == 1){
										validate_head();
										if(flag == 1){
											$("#regForm").submit();
										}
									}
								}
						}
					}					
				}
			}
			
			
		}
		
		var headChoice = document.getElementById("headChoice");
		var heads = document.getElementsByName("head"); 
		var head = document.getElementById("head");
		//选择头像
		$("#clickForHead").click(function(){
			headChoice.style.display = "block";
		})
		//关闭头像选择
		$("#closeHead").click(function(){
			headChoice.style.display = "none";
		})
		//确认头像选择
		$("#confirmHead").click(function(){
			var headSelected = "";
			for(var i = 0; i < heads.length; i++){
				if(heads[i].checked){
					headSelected = heads[i].value;
					break;
				}
			}
			if(headSelected == ""){
				alert("请选择头像");
			}
			else{
				head.value = headSelected;
				headChoice.style.display = "none";
			}
		})
		//实现年月日的级联
		var birthyear = document.getElementById("birthyear");
		var birthmonth = document.getElementById("birthmonth");
		var birthday = document.getElementById("birthday");	
		
		function chengeDay(){
			
			birthday.length = 0;
			var year = 1997 - parseInt(birthyear.selectedIndex);
			var month = 1 + parseInt(birthmonth.selectedIndex);
			var day = daysInMonth(year,month);
			for(var i = 1; i <= day; i++){
				var t = new Option(i,i);	
				birthday.options.add(t);	
			}	
				
		}
		function daysInMonth(year,month){
			var days = 0;
			switch(month){
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
					days = 29;
				}
				else{
					days = 28;
				}
				break;
			default:
				days = 31;	
			}
			return days;
		}	
		
		//省市数组
	 var cityList = new Array();
     cityList[0] = ['北京市','朝阳区','东城区','西城区', '海淀区','宣武区','丰台区','怀柔','延庆','房山'];
	 cityList[1] = ['上海市','宝山区','长宁区','丰贤区', '虹口区','黄浦区','青浦区','南汇区','徐汇区','卢湾区'];
	 cityList[2] = ['广州省','广州市','惠州市','汕头市','珠海市','佛山市','中山市','东莞市'];
     cityList[3] = ['深圳市','福田区', '罗湖区', '盐田区', '宝安区', '龙岗区', '南山区', '深圳周边'];
	 cityList[4] =['重庆市','俞中区', '南岸区', '江北区', '沙坪坝区', '九龙坡区', '渝北区', '大渡口区', '北碚区'];
     cityList[5] = ['天津市','和平区', '河西区', '南开区', '河北区', '河东区', '红桥区', '塘古区', '开发区'];
	 cityList[6] = ['江苏省','南京市','苏州市','无锡市'];
	 cityList[7] = ['浙江省','杭州市','宁波市','温州市'];
	 cityList[8] = ['四川省','成都市'];
	 cityList[9] = ['海南省','海口市'];
	 cityList[10] = ['福建省','福州市','厦门市','泉州市','漳州市'];
	 cityList[11] = ['山东省','济南市','青岛市','烟台市'];
	 cityList[12] = ['江西省','南昌市'];
	 cityList[13] = ['广西','南宁市'];
	 cityList[14] = ['安徽省','合肥市'];
	 cityList[15] = ['河北省','石家庄市'];
	 cityList[16] = ['河南省','郑州市'];
	 cityList[17] = ['湖北省','武汉市','宜昌市'];
	 cityList[18] = ['湖南省','长沙市'];
	 cityList[19] = ['陕西省','西安市'];
	 cityList[20] = ['山西省','太原市'];
	 cityList[21] = ['黑龙江省','哈尔滨市'];
	 cityList[22] = ['国外'];
	 cityList[23] = ['其他'];
	 
	 var province = document.getElementById("province");
	 var city = document.getElementById("city");
	 function cityChange(){
		//清空城市列表
		city.length = 0;
		//添加城市
		 var index = province.selectedIndex;
		 for(var i = 1; i < cityList[index-1].length; i++){
				var c = new Option(cityList[index-1][i],cityList[index-1][i]);	
				city.options.add(c);
	 		}
	 }
 
	</script>
  </body>
</html>
