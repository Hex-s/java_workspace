package com.niit;

public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "a#b#c#d";
		//����ָ���Ĳ������ַ������зָ����String[]
		String[] array = str.split("#");
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}

}
