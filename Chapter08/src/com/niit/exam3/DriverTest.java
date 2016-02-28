package com.niit.exam3;

import java.util.Scanner;

public class DriverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//驾驶员实例化
		//Driver driver = new Driver("tony");
		Driver driver = new Driver();
		driver.setUserName("tom");
		
		//实例化各类交通工具
		Car car = new Car("兰博基尼");
		Plane plane = new Plane("波音777");
		Ship ship = new Ship("泰坦尼克");
		//根据不同情况传入不同的参数，并且调用同名的方法来实现问题
		//driver.drive();
		
		
		/*******************测试重载设计***********************/
		Scanner sc = new Scanner(System.in);
		System.out.println("请选择出行的方式： 1.飞机  2.轮船  3.汽车");
		int choice = sc.nextInt();
		//根据选择决定调用的驾驶方法
		switch(choice){
		case 1:
			driver.drive(plane);
			break;
		case 2:
			driver.drive(ship);
			break;
		case 3:
			driver.drive(car);
		}
		
//		//使用重载可以让驾驶员不用去关心交通工具具体是哪一个，直接进行驾驶的动作
//		driver.drive();
	}

}
