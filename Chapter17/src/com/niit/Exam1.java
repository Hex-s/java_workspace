package com.niit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//����IP��ַ����
			InetAddress address = InetAddress.getByName("www.sina.com");
			//��ȡIP��ַ
			System.out.println(address.getHostAddress());
			//��ȡ������
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
