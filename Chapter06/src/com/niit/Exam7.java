package com.niit;

public class Exam7 {
	
	public static void main(String[] args) {
		String str = "helloniit";
		//substring(int)��ʾ��ȡ�ַ�����������ʾ��ָ��������ȡ���ַ��������
		//������������Ч���������������������쳣
		//str = str.substring(5);
		
		//substring(int,int)��ʾ�ӵ�һ��������Ӧ������λ��һֱ��ȡ���ڶ���������Ӧ������λ��Ϊֹ
		//�ڶ���������Ӧ���ַ����ᱻ��ȡ
		str = str.substring(5, str.length());
		System.out.println(str);
		
		//��ȡ������û���������
		String email = "jack@qq.com";
		//��ȡ�û���
		String userName = email.substring(0,email.indexOf("@"));
		//��ȡ������
		String emailName = email.substring(email.indexOf("@")+1);
		System.out.println(userName+"@"+emailName);
	}
}
