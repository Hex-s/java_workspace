package com.niit.test;

import com.niit.data.Data;
import com.niit.sys.UsedCarSystem;

public class RunApplication {

	public static void main(String[] args) {
		//实例化数据类
		Data data = new Data();
		data.init();
		//实例化系统类
		UsedCarSystem sys = new UsedCarSystem();
		sys.start(data);
	}
}
