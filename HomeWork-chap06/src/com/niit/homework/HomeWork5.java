package com.niit.homework;

import java.util.Scanner;

public class HomeWork5 {

	public boolean emailValidTure(String emailStr) {
		
		//����HomeWork4��ʵ��
		HomeWork4 email = new HomeWork4();
		//�������Ҫ�����
		if (email.emailValid(emailStr)) {
			//��ȡ�û���
			int index = emailStr.indexOf("@");
			String user = emailStr.substring(0, index);
			//�ж��û�����ÿ���ַ�
			char c;
			for (int i = 0; i < user.length(); i++) {
				c = user.charAt(i);
				if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A'
						&& c <= 'Z' || c == '_')) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���������������ַ��");
		String emailStr = sc.next();
		HomeWork5 email = new HomeWork5();
		boolean bool = email.emailValidTure(emailStr);
		if (bool) {
			System.out.println(emailStr + "��һ���Ϸ��������ַ");
		} else {
			System.out.println(emailStr + "��һ���Ƿ��������ַ");
		}
	}
}
