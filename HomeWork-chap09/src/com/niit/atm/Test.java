package com.niit.atm;

import java.util.Scanner;


public class Test {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化数据类
		Data data = new Data();
		//初始化数据
		data.init();
		//实例化系统类
		RunSys sys = new RunSys();
		sys.start(data);
	}
}
