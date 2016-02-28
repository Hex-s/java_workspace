package com.niit.homework;

import java.util.Scanner;

public class TestHomeWork4 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入您的邮箱地址：");
		String emailStr = sc.next();
		HomeWork4 email = new HomeWork4();
		boolean bool = email.emailValid(emailStr);
		if(bool){
			System.out.println(emailStr+"是一个正确的邮箱地址：");
		}
		else{
			System.out.println(emailStr+"不是一个正确的邮箱地址：");
		}
	}

}
