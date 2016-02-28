package com.niit.exam9;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		double num1 = sc.nextDouble();
		System.out.println("请输入运算符：");
		String opt = sc.next();
		System.out.println("请输入第二个数：");
		double num2 = sc.nextDouble();
		
		//创建计算工厂
		CalculateFactory factory = new CalculateFactory();
		//通过工厂生产对应的计算对象
		ICalculate calObj = factory.buildInstance(opt);
		//计算
		double result = calObj.calculate(num1, num2);
		System.out.println(result);

	}

}
