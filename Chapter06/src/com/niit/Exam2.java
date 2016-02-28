package com.niit;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//构建String的两种方式
//		String s1 = "hello";
//		String s2 = new String("hello");
//		System.out.println(s1);
//		System.out.println(s2);
		
		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = "a"+"b"+"c";
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);
	}

}
