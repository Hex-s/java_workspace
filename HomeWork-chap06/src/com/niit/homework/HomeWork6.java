/**
 * ��д����ʵ��String����trim������ͬ�Ĺ���
 */
package com.niit.homework;

public class HomeWork6 {

	public String trim(String string) {
		String str = string;
		char start;
		char end;
		// ȥ���ַ�����ͷ�Ŀո�
		while (true) {
			// �����ַ����ĵ�һ���ַ�
			start = str.charAt(0);
			if (start == ' ') {
				str = str.substring(1);
			} else {
				break;
			}
		}
		// ȥ���ַ���β���Ŀո�
		while (true) {
			// �����ַ��������һ���ַ�
			end = str.charAt(str.length() - 1);
			if (end == ' ') {
				str = str.substring(0, str.length() - 1);
			} else {
				break;
			}
		}
		return str;
	}

	public static void main(String[] args) {

		HomeWork6 hw = new HomeWork6();
		String str = "     java ";
		System.out.println(str);
		str = hw.trim(str);
		System.out.println(str);

	}

}
