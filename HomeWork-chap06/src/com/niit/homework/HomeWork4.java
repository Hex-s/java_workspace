/**
 * �ж������ַ�ĺϷ���
 * 1) Ҫ��@
 * 2) Ҫ��.
 * 3) @��.���ܳ�������βλ��
 * 4) @ֻ�ܳ���1��
 * 5) .���ܳ�����@��ǰ��
 * 6) .��@��������
 * 7) .��.��������
 */
package com.niit.homework;

import java.util.Scanner;

public class HomeWork4 {

	// �ж���Ч�������ַ
	public boolean emailValid(String email) {
		int index;
		char c;
		// Ҫ��.��@
		if (email.indexOf(".") == -1 || email.indexOf("@") == -1) {
//			System.out.println("û��.��@");
			return false;
		}

		// .��@���ܳ�������βλ��
		char start = email.charAt(0);
		char end = email.charAt(email.length() - 1);
		if (start == '.' || start == '@' || end == '.' || end == '@') {
//			System.out.println(".��@���ܳ�������βλ��");
			return false;
		}

		//@ֻ�ܳ���һ��
		if(email.indexOf("@") != email.lastIndexOf("@")){
//			System.out.println("@ֻ�ܳ���һ��");
			return false;
		}
		
		// .���ܳ�����@��ǰ��
		index = email.indexOf("@");
		for (int i = 0; i < index; i++) {
			c = email.charAt(i);
			if (c == '.') {
//				System.out.println(".���ܳ�����@��ǰ��");
				return false;
			}
		}
		
		//.��@�������� .��.��������
		if(email.indexOf("@.") != -1 && email.indexOf("..") != -1){
			return false;
		}
		
		

		return true;
	}

}
