package com.niit.exam3;

import java.util.Scanner;

public class DriverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ʻԱʵ����
		//Driver driver = new Driver("tony");
		Driver driver = new Driver();
		driver.setUserName("tom");
		
		//ʵ�������ཻͨ����
		Car car = new Car("��������");
		Plane plane = new Plane("����777");
		Ship ship = new Ship("̩̹���");
		//���ݲ�ͬ������벻ͬ�Ĳ��������ҵ���ͬ���ķ�����ʵ������
		//driver.drive();
		
		
		/*******************�����������***********************/
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ����еķ�ʽ�� 1.�ɻ�  2.�ִ�  3.����");
		int choice = sc.nextInt();
		//����ѡ��������õļ�ʻ����
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
		
//		//ʹ�����ؿ����ü�ʻԱ����ȥ���Ľ�ͨ���߾�������һ����ֱ�ӽ��м�ʻ�Ķ���
//		driver.drive();
	}

}
