package com.niit;

import java.util.Scanner;

public class Exam6 {
	/**
	 * �����ַ���һ�γ��ֵ�����λ��
	 * @param resourceStr
	 * @param ch
	 * @return
	 */
	public int indexOf(String resourceStr, char ch){
		//�����ַ���
		for(int i = 0; i < resourceStr.length(); i++){
			//���ַ����е�ÿһ���ַ����κ�Ҫ�������ַ����бȽ�
			if(resourceStr.charAt(i) == ch){
				return i;
			}
		}
		//ѭ����������δ���������������˵���ַ����в������������ַ�
		return -1;
	}
	/**
	 * ���������ַ����ֵ�λ��
	 * @param resourceStr
	 * @param ch
	 * @return
	 */
	public int lastIndexOf(String resourceStr, char ch){
		//�����ַ���
		for(int i = resourceStr.length()-1; i >= 0; i--){
			//���ַ����е�ÿһ���ַ����κ�Ҫ�������ַ����бȽ�
			if(resourceStr.charAt(i) == ch){
				return i;
			}
		}
		//ѭ����������δ���������������˵���ַ����в������������ַ�
		return -1;
	}
	/**
	 * �ж��ַ�����ֵ�Ƿ����������ɵķ��� 
	 * @param str
	 * @return
	 */
	public boolean isInteger(String str){
		//�����ַ���
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			//�ж�ÿ���ַ��Ƿ�������
			if(ch < '0' || ch > '9'){
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//chatAt��ȡ������Ӧ���ַ�
//		String str = "hello";
//		System.out.println(str.charAt(3));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = sc.next();
		//���ַ������б���
		for(int i = 0; i < str.length(); i++){
			System.out.print(str.charAt(i));
		}
		//��д�����ж�ĳ���ַ������Ƿ���һ������
	}

}
