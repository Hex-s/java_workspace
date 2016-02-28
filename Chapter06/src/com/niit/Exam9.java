package com.niit;

public class Exam9 {

	public static void main(String[] args){
		//缓冲字符串StringBuffer
		//String是不可变长度的字符串，StringBuffer是可变长度的字符串
		//将来在需要反复拼接字符串的场合，适合使用StringBuffer来试下
		
		//创建空值的StringBuffer
		StringBuffer buffer = new StringBuffer();
		//StringBuffer与String允许相互转换
		String str = "hello";
//		//将StringBuffer转换成String
//		str = buffer.toString();
//		System.out.println(str);
//		//将String类型构建成StringBuffer
		buffer = new StringBuffer(str);
		System.out.println(buffer);
		
		//通过append追加字符串的值
		buffer.append("niit");
		System.out.println(buffer);
		String str1 = buffer.substring(5);
		System.out.println(str1);
//		buffer.deleteCharAt(5);
//		buffer.delete(0, 5);
		buffer.setCharAt(5, 'm');
		System.out.println(buffer);
	}
}
