package com.niit.test;

import com.niit.data.Data;
import com.niit.sys.UsedCarSystem;

public class RunApplication {

	public static void main(String[] args) {
		//ʵ����������
		Data data = new Data();
		data.init();
		//ʵ����ϵͳ��
		UsedCarSystem sys = new UsedCarSystem();
		sys.start(data);
	}
}
