package com.niit.exam4;

import java.util.Scanner;

public class TryCatchParseNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 登陆");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
//		int choice = 0;
//		try{
//			choice = sc.nextInt();
//		}
//		catch(Exception e){
//			//发现异常，重新输入
//			sc = new Scanner(System.in);
//			System.out.println("请重新输入：");
//			choice = sc.nextInt();
//		}
		
		sc = new Scanner(System.in);
		String s = sc.next();
		int choice = 0;
		try{
			choice = Integer.parseInt(s);
		}
		catch(Exception e){
			System.out.println("输入非法，请重新输入！");
			s = sc.next();
			choice = Integer.parseInt(s);
		}
		
		switch(choice){
		case 1:
			System.out.println("登陆");
			break;
		case 2:
			System.out.println("注册");
			break;
		case 3:
			System.out.println("退出");
			break;
		}
	}

}
