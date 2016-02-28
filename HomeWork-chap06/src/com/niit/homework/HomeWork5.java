package com.niit.homework;

import java.util.Scanner;

public class HomeWork5 {

	public boolean emailValidTure(String emailStr) {
		
		//创建HomeWork4的实例
		HomeWork4 email = new HomeWork4();
		//邮箱基本要求符合
		if (email.emailValid(emailStr)) {
			//获取用户名
			int index = emailStr.indexOf("@");
			String user = emailStr.substring(0, index);
			//判断用户名的每个字符
			char c;
			for (int i = 0; i < user.length(); i++) {
				c = user.charAt(i);
				if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A'
						&& c <= 'Z' || c == '_')) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入您的邮箱地址：");
		String emailStr = sc.next();
		HomeWork5 email = new HomeWork5();
		boolean bool = email.emailValidTure(emailStr);
		if (bool) {
			System.out.println(emailStr + "是一个合法的邮箱地址");
		} else {
			System.out.println(emailStr + "是一个非法的邮箱地址");
		}
	}
}
