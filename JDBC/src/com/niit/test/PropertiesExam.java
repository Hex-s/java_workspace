package com.niit.test;

import java.util.ResourceBundle;

public class PropertiesExam {

	public static void main(String[] args) {
		
		//������Դ�ļ���ȡ��
		ResourceBundle bundle = ResourceBundle.getBundle("DBConfig");
		//��ȡ��Դ�ļ�����Ϣ
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String pwd = bundle.getString("pwd");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(pwd);
	}
}
