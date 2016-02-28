/**
 * 判断邮箱地址的合法性
 * 1) 要有@
 * 2) 要有.
 * 3) @和.不能出现在首尾位置
 * 4) @只能出现1次
 * 5) .不能出现在@的前面
 * 6) .和@不能相邻
 * 7) .和.不能相邻
 */
package com.niit.homework;

import java.util.Scanner;

public class HomeWork4 {

	// 判断有效的邮箱地址
	public boolean emailValid(String email) {
		int index;
		char c;
		// 要有.和@
		if (email.indexOf(".") == -1 || email.indexOf("@") == -1) {
//			System.out.println("没有.和@");
			return false;
		}

		// .和@不能出现在首尾位置
		char start = email.charAt(0);
		char end = email.charAt(email.length() - 1);
		if (start == '.' || start == '@' || end == '.' || end == '@') {
//			System.out.println(".和@不能出现在首尾位置");
			return false;
		}

		//@只能出现一次
		if(email.indexOf("@") != email.lastIndexOf("@")){
//			System.out.println("@只能出现一次");
			return false;
		}
		
		// .不能出现在@的前面
		index = email.indexOf("@");
		for (int i = 0; i < index; i++) {
			c = email.charAt(i);
			if (c == '.') {
//				System.out.println(".不能出现在@的前面");
				return false;
			}
		}
		
		//.和@不能相邻 .和.不能相邻
		if(email.indexOf("@.") != -1 && email.indexOf("..") != -1){
			return false;
		}
		
		

		return true;
	}

}
