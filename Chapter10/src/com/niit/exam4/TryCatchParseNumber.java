package com.niit.exam4;

import java.util.Scanner;

public class TryCatchParseNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. ��½");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
//		int choice = 0;
//		try{
//			choice = sc.nextInt();
//		}
//		catch(Exception e){
//			//�����쳣����������
//			sc = new Scanner(System.in);
//			System.out.println("���������룺");
//			choice = sc.nextInt();
//		}
		
		sc = new Scanner(System.in);
		String s = sc.next();
		int choice = 0;
		try{
			choice = Integer.parseInt(s);
		}
		catch(Exception e){
			System.out.println("����Ƿ������������룡");
			s = sc.next();
			choice = Integer.parseInt(s);
		}
		
		switch(choice){
		case 1:
			System.out.println("��½");
			break;
		case 2:
			System.out.println("ע��");
			break;
		case 3:
			System.out.println("�˳�");
			break;
		}
	}

}
