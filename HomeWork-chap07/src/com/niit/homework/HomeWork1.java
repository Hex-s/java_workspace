package com.niit.homework;

import java.util.Scanner;

public class HomeWork1 {
	
	/**
	 * 键盘接受一个密码字符串，将该密码进行加密：
	 * 要求将先将每个字符的ASCII加10，
	 * 然后顺序将第二个字符转移给第一个字符，
	 * 第三个字符转移给第二个字符，依次类推（第一个字符转移给最后个字符），
	 * 最终通过方法返回加密后的字符串
	 * @param string
	 */
	public String encripy(String string){
		//字符串长度
		int length = string.length();
		//数组的长度即是字符串的长度
		char[] array = new char[length];
		//加密后的字符串
		String str = "";
		//将字符串的每个字符的ASCII码加10
		for(int i = 0; i < length; i++){
			array[i] =(char) (string.charAt(i) + 10);
		}
		//将1-length的ASCII转换成字符串
		for(int i = 1; i < length; i++){
			str += ""+array[i];;
		}
		//将第一个ASCII值加在字符串尾部
		str  += ""+array[0];
		return str;
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		HomeWork1 hw = new HomeWork1();
		System.out.print("请输入密码：");
		Scanner sc = new Scanner(System.in);
		String pwd = sc.next();
		System.out.print("密码加密后为："+hw.encripy(pwd));
	}
}
