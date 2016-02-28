package com.niit;

import java.util.Scanner;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入第一个同学喜欢的课程名称：");
//		String course1 = sc.next();
//		System.out.println("请输入第二个同学喜欢的课程名称：");
//		String  course2 = sc.next();
//		//equals方法是逐字符区分大小写的比较
//		//if(course1.equals(course2)){
//		//忽略大小写的比较
//		if(course1.equalsIgnoreCase(course2)){
//			System.out.println("喜欢的课程相同");
//		}
//		else{
//			System.out.println("喜欢的课程不一样");
//		}
		String course = "JAVA";
		//将字符串转换成大写
		//course = course.toUpperCase();
		course = course.toLowerCase();
		System.out.println(course);
	}

}
