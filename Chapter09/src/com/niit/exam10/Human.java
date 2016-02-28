package com.niit.exam10;
/**
 * 人类
 * @author Administrator
 *
 */
public class Human {

	/**
	 * 具备使用各种打印机的方法
	 * @param printer
	 */
	public void usePrinter(IPrinter printer, IInfo info){
		//使用打印机打印信息
		System.out.println(printer.print(info));
	}
}
