package com.niit.exam1;

import java.util.Scanner;

public class ProductTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化
		Product pro = new Product(1001,"鼠标",-50);
		//对对象进行赋值
//		pro.setProductId(1001);
//		pro.setProductName("鼠标");
//		pro.setPrice(-50);
		pro.details();
		
	}

}
