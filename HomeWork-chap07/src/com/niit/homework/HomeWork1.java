package com.niit.homework;

import java.util.Scanner;

public class HomeWork1 {
	
	/**
	 * ���̽���һ�������ַ���������������м��ܣ�
	 * Ҫ���Ƚ�ÿ���ַ���ASCII��10��
	 * Ȼ��˳�򽫵ڶ����ַ�ת�Ƹ���һ���ַ���
	 * �������ַ�ת�Ƹ��ڶ����ַ����������ƣ���һ���ַ�ת�Ƹ������ַ�����
	 * ����ͨ���������ؼ��ܺ���ַ���
	 * @param string
	 */
	public String encripy(String string){
		//�ַ�������
		int length = string.length();
		//����ĳ��ȼ����ַ����ĳ���
		char[] array = new char[length];
		//���ܺ���ַ���
		String str = "";
		//���ַ�����ÿ���ַ���ASCII���10
		for(int i = 0; i < length; i++){
			array[i] =(char) (string.charAt(i) + 10);
		}
		//��1-length��ASCIIת�����ַ���
		for(int i = 1; i < length; i++){
			str += ""+array[i];;
		}
		//����һ��ASCIIֵ�����ַ���β��
		str  += ""+array[0];
		return str;
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		HomeWork1 hw = new HomeWork1();
		System.out.print("���������룺");
		Scanner sc = new Scanner(System.in);
		String pwd = sc.next();
		System.out.print("������ܺ�Ϊ��"+hw.encripy(pwd));
	}
}
