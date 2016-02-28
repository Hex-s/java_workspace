package com.niit;

public class CharToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//将char转换成String的方式
		
		char ch = 'a';
		//封装成char的包装类通过toString方法进行转换
//		Character character = new Character(ch);
//		character.toString();
		
		//将char构建成char数组，通过char数组构建String
		char[] charArray = new char[2];
		charArray[0] = ch;
		charArray[1] = 'b';
		String str = new String(charArray);
		System.out.println(str);
		
		
	}

}
