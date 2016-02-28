package com.niit.exam5;
/**
 * U盘
 * 能够接入USB接口的U盘必须实现USB接口提供的所有规范
 * 通过implements实现接口
 * implements接口的类称为接口的实现类
 * @author Administrator
 *
 */
public class Udisk implements IUsb {
	
	private String data = "存储了1-9章的JAVA课件";
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("U盘通过USB接口启动了");
	}

	@Override
	public void stop() {
		System.out.println("U盘从USB接口中拔出了");
	}

	
	
}
