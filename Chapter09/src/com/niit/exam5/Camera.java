package com.niit.exam5;
/**
 * 相机类
 * @author Administrator
 *
 */
public class Camera implements IUsb {

	private String data = "相机中存储了100张照片";
	
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("相机通过USB接口启动");
	}

	@Override
	public void stop() {
		System.out.println("相机从USB接口拔出");
	}
	
}
