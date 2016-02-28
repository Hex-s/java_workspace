package com.niit;

public class Exam7 {
	
	public static void main(String[] args) {
		String str = "helloniit";
		//substring(int)表示截取字符串，参数表示从指定索引截取到字符串的最后
		//参数必须是有效的索引，否则将引起程序的异常
		//str = str.substring(5);
		
		//substring(int,int)表示从第一个参数对应的索引位置一直截取到第二个参数对应的索引位置为止
		//第二个参数对应的字符不会被截取
		str = str.substring(5, str.length());
		System.out.println(str);
		
		//获取邮箱的用户名和密码
		String email = "jack@qq.com";
		//获取用户名
		String userName = email.substring(0,email.indexOf("@"));
		//获取邮箱名
		String emailName = email.substring(email.indexOf("@")+1);
		System.out.println(userName+"@"+emailName);
	}
}
