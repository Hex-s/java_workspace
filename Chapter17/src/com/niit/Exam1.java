package com.niit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//创建IP地址对象
			InetAddress address = InetAddress.getByName("www.sina.com");
			//获取IP地址
			System.out.println(address.getHostAddress());
			//获取主机名
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
