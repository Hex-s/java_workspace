package com.niit.homework;

import java.util.Scanner;

public class HomeWork1_2 {
	
	/**
	 * ��Դ�ַ���������ĳ���ַ�������ȡ���ַ������ֵĴ���
	 * @param sourceStr Դ�ַ���
	 * @param searchStr �������ַ���
	 * @return �����������ַ�����Դ�ַ����еĴ���
	 */
	public int strCount(String sourceStr,String searchStr){
		//�������ַ������ֵĴ���
		int count = 0;
		//�������ַ�������ʱ������λ��
		int index = 0;
		//�������ַ����ĳ���
		int length = searchStr.length();
		//�ж��������ַ�����Դ�ַ������Ƿ����
		while(true){
			index = sourceStr.indexOf(searchStr,index);
			//���������ַ�����Դ�ַ����д���ʱ
			if(index != -1){
				//���ֵĴ���+1
				count++;
				System.out.println(searchStr+"��"+sourceStr+"�е�"+count+"�γ�����������"+index+"��λ��");
				index += length;;
			}
			else{
				break;
			}
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������Դ�ַ�����");
		String sourceStr = sc.next();
		System.out.print("������Ҫ�������ַ�����");
		String searchStr = sc.next();
		HomeWork1_2 hw = new HomeWork1_2();
		int count = hw.strCount(sourceStr, searchStr);
		System.out.println(searchStr+"��"+sourceStr+"��һ��������"+count+"��");
	}

}
