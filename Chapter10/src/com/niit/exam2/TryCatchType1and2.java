package com.niit.exam2;

import java.util.Scanner;

public class TryCatchType1and2 {

	/**
	 * 异常处理的第一种情况：没有异常的发生，程序正常运行，catch语句将不被执行
	 * 异常处理的第二种情况：异常发生,catch捕获到异常并进行相应的处理，catch处理后代码将会继续执行
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字型的字符串");
		String s = sc.next();
		int num = 0;
		//将字符串转换成整型
		//该行代码处可能会出现异常，如果异常发生，将导致异常后的代码都无法执行
		//try用来对可疑代码进行监控，且必须要和catch语句结合使用
		try{
			num = Integer.parseInt(s);
			//异常发生时该行代码无法执行
			System.out.println("进入了try语句块");
		}
		//catch用来捕获try中可能出现的异常，并对异常进行处理
		catch(NumberFormatException e){
			//异常的处理
			System.out.println("进入了catch语句块");
			System.out.println("try语句块中出现了异常！打印跟踪信息：");
			e.printStackTrace();
		}
		System.out.println("转换后的数字是："+num);
	}
}
