package com.niit;

public class CharToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��charת����String�ķ�ʽ
		
		char ch = 'a';
		//��װ��char�İ�װ��ͨ��toString��������ת��
//		Character character = new Character(ch);
//		character.toString();
		
		//��char������char���飬ͨ��char���鹹��String
		char[] charArray = new char[2];
		charArray[0] = ch;
		charArray[1] = 'b';
		String str = new String(charArray);
		System.out.println(str);
		
		
	}

}
