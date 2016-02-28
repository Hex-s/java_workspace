package com.niit;

import java.util.Scanner;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用数组接受指定数量的学生的成绩，并打印显示第一位同学和最后第二位同学的平均成绩
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生的数量：");
		int num = sc.nextInt();
		//根据学生的数量创建数组
		int[] scoreArray = new int[num];
		//循环录入成绩
		for(int i = 0; i < scoreArray.length; i++){
			System.out.println("请输入第"+(i+1)+"个学生的成绩：");
			scoreArray[i] = sc.nextInt();
		}
		//计算第一个同学和最后第二位同学的平均成绩
		int avg = (scoreArray[0]+scoreArray[scoreArray.length-2])/2;
		System.out.println(avg);
	}

}
