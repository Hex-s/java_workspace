package com.niit.exam9;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������");
		double num1 = sc.nextDouble();
		System.out.println("�������������");
		String opt = sc.next();
		System.out.println("������ڶ�������");
		double num2 = sc.nextDouble();
		
		//�������㹤��
		CalculateFactory factory = new CalculateFactory();
		//ͨ������������Ӧ�ļ������
		ICalculate calObj = factory.buildInstance(opt);
		//����
		double result = calObj.calculate(num1, num2);
		System.out.println(result);

	}

}
