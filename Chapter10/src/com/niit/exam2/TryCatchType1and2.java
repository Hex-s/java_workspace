package com.niit.exam2;

import java.util.Scanner;

public class TryCatchType1and2 {

	/**
	 * �쳣����ĵ�һ�������û���쳣�ķ����������������У�catch��佫����ִ��
	 * �쳣����ĵڶ���������쳣����,catch�����쳣��������Ӧ�Ĵ���catch�������뽫�����ִ��
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�������͵��ַ���");
		String s = sc.next();
		int num = 0;
		//���ַ���ת��������
		//���д��봦���ܻ�����쳣������쳣�������������쳣��Ĵ��붼�޷�ִ��
		//try�����Կ��ɴ�����м�أ��ұ���Ҫ��catch�����ʹ��
		try{
			num = Integer.parseInt(s);
			//�쳣����ʱ���д����޷�ִ��
			System.out.println("������try����");
		}
		//catch��������try�п��ܳ��ֵ��쳣�������쳣���д���
		catch(NumberFormatException e){
			//�쳣�Ĵ���
			System.out.println("������catch����");
			System.out.println("try�����г������쳣����ӡ������Ϣ��");
			e.printStackTrace();
		}
		System.out.println("ת����������ǣ�"+num);
	}
}
