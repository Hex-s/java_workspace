package com.niit.exam5;
/**
 * 移动电话
 * @author Administrator
 *
 */
public class Mobile implements IUsb {

	private String data = "存储了24个人的联系电话";
	
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("移动电话接入USB接口启动");
	}

	@Override
	public void stop() {
		System.out.println("移动电话从USB接口中拔出");
	}
	
}
