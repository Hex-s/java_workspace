package com.niit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.FieldPosition;

public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�Զ�����̽��ܹ���
		//�����ַ�����ȡ��������
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//������exit��ʱ���ʾ�������
			String str;
			while(!(str = reader.readLine()).equals("exit")){
				System.out.println(str);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
