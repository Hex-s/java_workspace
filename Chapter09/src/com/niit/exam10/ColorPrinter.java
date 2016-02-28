package com.niit.exam10;
/**
 * 彩色打印机
 * @author Administrator
 *
 */
public class ColorPrinter implements IPrinter {

	@Override
	public String print(IInfo info) {
		// TODO Auto-generated method stub
		return "彩色打印："+info.getData();
	}

}
