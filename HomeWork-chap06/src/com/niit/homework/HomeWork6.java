/**
 * 编写方法实现String类中trim方法相同的功能
 */
package com.niit.homework;

public class HomeWork6 {

	public String trim(String string) {
		String str = string;
		char start;
		char end;
		// 去除字符串开头的空格
		while (true) {
			// 接收字符串的第一个字符
			start = str.charAt(0);
			if (start == ' ') {
				str = str.substring(1);
			} else {
				break;
			}
		}
		// 去除字符串尾部的空格
		while (true) {
			// 接收字符串的最后一个字符
			end = str.charAt(str.length() - 1);
			if (end == ' ') {
				str = str.substring(0, str.length() - 1);
			} else {
				break;
			}
		}
		return str;
	}

	public static void main(String[] args) {

		HomeWork6 hw = new HomeWork6();
		String str = "     java ";
		System.out.println(str);
		str = hw.trim(str);
		System.out.println(str);

	}

}
