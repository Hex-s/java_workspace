package com.niit.homework;

import java.util.Scanner;

public class HomeWork3 {
	/**
	 * ����һ���ļ���,�жϸ��ļ��Ǽ��±��ļ����ǻõ�Ƭ�ļ�����JAVAԴ�ļ��������ǿ�ִ���ļ��������ļ���Ƿ��ļ�
	 * @param fileName ��Ҫ�жϵ��ļ���
	 * @return ���ظ��ļ����Ƿ���ȷ
	 */
	public String file(String fileName){
		//�ļ����͵Ľ��
		String result = "";
		//�ļ�����ǰ��.
		int index = fileName.lastIndexOf(".");
		//�ļ�����
		String str = fileName.substring(index+1);
		//���±��ļ�
		if(str.equalsIgnoreCase("txt")){
			result = "���±��ļ�";
		}
		//�õ�Ƭ�ļ�
		else if(str.equalsIgnoreCase("ppt")){
			result = "�õ�Ƭ�ļ�";
		}
		//javaԴ�ļ�
		else if(str.equalsIgnoreCase("java")){
			result = "JAVAԴ�ļ�";
		}
		//��ִ���ļ�
		else if(str.equalsIgnoreCase("exe")){
			result = "��ִ���ļ�";
		}
		//�����ļ���Ƿ��ļ�
		else{
			result = "�����ļ���Ƿ��ļ�";
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ļ�����");
		String fileName = sc.next();
		HomeWork3 hw = new HomeWork3();
		String result = hw.file(fileName);
		System.out.println(fileName+"��һ��"+result);
	}

}
