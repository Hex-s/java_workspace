package com.niit;

import java.util.Scanner;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʹ���������ָ��������ѧ���ĳɼ�������ӡ��ʾ��һλͬѧ�����ڶ�λͬѧ��ƽ���ɼ�
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ����������");
		int num = sc.nextInt();
		//����ѧ����������������
		int[] scoreArray = new int[num];
		//ѭ��¼��ɼ�
		for(int i = 0; i < scoreArray.length; i++){
			System.out.println("�������"+(i+1)+"��ѧ���ĳɼ���");
			scoreArray[i] = sc.nextInt();
		}
		//�����һ��ͬѧ�����ڶ�λͬѧ��ƽ���ɼ�
		int avg = (scoreArray[0]+scoreArray[scoreArray.length-2])/2;
		System.out.println(avg);
	}

}
