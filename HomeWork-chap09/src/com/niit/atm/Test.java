package com.niit.atm;

import java.util.Scanner;


public class Test {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//ʵ����������
		Data data = new Data();
		//��ʼ������
		data.init();
		//ʵ����ϵͳ��
		RunSys sys = new RunSys();
		sys.start(data);
	}
}
