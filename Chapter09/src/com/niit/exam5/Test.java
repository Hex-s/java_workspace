package com.niit.exam5;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化电脑
		Computer cpu = new Computer();
		//实例化U盘
		Udisk uDisk = new Udisk();
		//实例化相机
		Camera camera = new Camera();
		//实例化移动电话
		Mobile mobile = new Mobile();
		//将U盘接入电脑的USB接口
		cpu.setUsb(camera);
//		//对USB接口中的设备进行启动
//		cpu.getUsb().start();
//		//停止USB接口中的设备使用
//		cpu.getUsb().stop();
		//读取接入USB接口中的数据
		System.out.println(cpu.getUsb().loadData(null));
	}

}
