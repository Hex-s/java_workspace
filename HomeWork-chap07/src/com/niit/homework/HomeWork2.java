package com.niit.homework;

import java.util.Scanner;

public class HomeWork2 {
	/**
	 * ���̽���һ��Сд�ַ������������ʹ��#�ֿ���
	 * ��дһ���������ܽ��ù������͵��ַ�����ΪCamel�������ı�����
	 * @param name
	 * @return
	 */
	public String camel(String name){
		String nameCamel = "";
		//�ַ������ݡ�#������
		String[] array = name.split("#");
		char c;
		String str;
		//���ַ���������ĸ��ɴ�д
		for(int i = 1 ; i <array.length; i++){
			c = array[i].charAt(0);
			str = ""+c;
		    str = str.toUpperCase();
		    array[i] =  str + array[i].substring(1);;
		}
		for(int i = 0; i < array.length; i++){
			nameCamel  += array[i];
		}
		return nameCamel;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HomeWork2 hw = new HomeWork2();
		System.out.print("��������Ҫת�����ַ�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("result:"+hw.camel(name));
	}

}
