package com.niit.exam5;
/**
 * 电脑
 * @author Administrator
 *
 */
public class Computer {
	//电脑中存在一个USB接口
	private IUsb usb;

	/**
	 * 将设备接入USB接口的方法
	 * @param usb
	 */
	public void setUsb(IUsb usb) {
		//接口可以接受实现类
		this.usb = usb;
	}

	public IUsb getUsb() {
		return usb;
	}
	
}
