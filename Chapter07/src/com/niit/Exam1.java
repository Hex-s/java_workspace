package com.niit;

public class Exam1 {

	/**
	 * 数组的构建
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*************方式一************/
//		int[] array;
//		//对数组进行初始化,需要设置数组的长度
//		//数组的长度是不可变
//		array = new int[5];
//		System.out.println(array);
//		//对数组进行赋值,是基于每一个元素进行
//		//通过索引下标访问数组中的每一个元素
//		//初始化后的数组的元素都具备默认值
//		//System.out.println(array[0]);
//		//对第一个元素进行赋值
//		array[0] = 5;
//		//对第三个元素赋值
//		array[2] = 10;
//		//通过索引下标访问元素时，不能超过索引的范围0到数组长度-1，否则将出现数组下标越界异常
//		//array[5] = 15;
//		//显示数组的每一个值
////		System.out.println(array[0]);
////		System.out.println(array[1]);
////		System.out.println(array[2]);
////		System.out.println(array[3]);
////		System.out.println(array[4]);
//		//通过循环获取数组的每一个元素
//		//length属性表示数组的长度范围
//		for(int i = 0; i < array.length; i++){
//			System.out.println(array[i]);
//		}
		
		
		/*************方式二************/
		//在声明数组时直接赋值
//		int[] array;
//		array = new int[]{10,20,30,40};
//		System.out.println(array[0]);
		
		/*************方式三************/
		//第三种方式在声明数组后必须直接赋值
		int[] array = {10,20,30,40};
	}

}
