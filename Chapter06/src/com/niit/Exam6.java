package com.niit;

import java.util.Scanner;

public class Exam6 {
	/**
	 * 搜索字符第一次出现的索引位置
	 * @param resourceStr
	 * @param ch
	 * @return
	 */
	public int indexOf(String resourceStr, char ch){
		//遍历字符串
		for(int i = 0; i < resourceStr.length(); i++){
			//将字符串中的每一个字符依次和要搜索的字符进行比较
			if(resourceStr.charAt(i) == ch){
				return i;
			}
		}
		//循环结束后仍未满足上面的条件，说明字符串中不包含搜索的字符
		return -1;
	}
	/**
	 * 搜索最后次字符出现的位置
	 * @param resourceStr
	 * @param ch
	 * @return
	 */
	public int lastIndexOf(String resourceStr, char ch){
		//遍历字符串
		for(int i = resourceStr.length()-1; i >= 0; i--){
			//将字符串中的每一个字符依次和要搜索的字符进行比较
			if(resourceStr.charAt(i) == ch){
				return i;
			}
		}
		//循环结束后仍未满足上面的条件，说明字符串中不包含搜索的字符
		return -1;
	}
	/**
	 * 判断字符串的值是否由整数构成的方法 
	 * @param str
	 * @return
	 */
	public boolean isInteger(String str){
		//遍历字符串
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			//判断每个字符是否是数字
			if(ch < '0' || ch > '9'){
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//chatAt获取索引对应的字符
//		String str = "hello";
//		System.out.println(str.charAt(3));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.next();
		//对字符串进行遍历
		for(int i = 0; i < str.length(); i++){
			System.out.print(str.charAt(i));
		}
		//编写方法判断某个字符串中是否是一个整数
	}

}
