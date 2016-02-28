package com.niit.exam2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchType3 {

	/**
	 * �쳣�ĵ����������������쳣�ͷ������쳣��ƥ�䣬�������쳣�޷���ȷ���д���
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Java����������쳣�������һ����Ӧ���쳣���ʵ������
		 * chatch��ʾ������Ҫ������쳣���ͺ�JVM�в������쳣ʵ�����ͽ���ƥ�䣬���ƥ��ɹ����ܶԸ��쳣������ȷ�Ĵ���
		 * ��֮���򲶻񲻵��쳣
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���������");
		//���ӿ��ܳ��ֵ��쳣�����
		try{
			int num = sc.nextInt();
			User[] users = new User[num];
			for(int i = 0; i < users.length; i++){
				System.out.println("�������û�������");
				users[i].setName(sc.next());
				System.out.println("�������û�������");
				users[i].setAge(sc.nextInt());
			}
		}
		//�����Ӧ���쳣������
		//���ڶ���쳣����ʹ�ö���catch�����
		//��������д��ڶ����쳣�����Ҷ����쳣����Ҫʹ�ò�ͬ�ķ�ʽ������Ӧʹ�ö���catch
		catch(InputMismatchException e){
			System.out.println("����Ƿ������쳣��");
		}
		catch(NullPointerException e){
			System.out.println("���񵽿�ָ���쳣��");
			//e.printStackTrace();
		}
		//��ʹʹ�ö���catch��ҲӦ��������Exception�Ĳ���
		catch(Exception e){
			//��ӡ�쳣�����е���Ϣ
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("����ִ�н���");
		
	}

}
