package com.niit.exam5;
/**
 * USB接口，接口是不同类的另一种数据类型
 * 接口可以对数据类型进行统一化
 * 接口中定义的规范都是抽象方法，抽象方法没有方法体
 * 接口不能进行实例化
 * 
 * @author Administrator
 *
 */
public interface IUsb {
	/**
	 * 接口中的抽象方法默认添加public abstract访问修饰符，且访问级别必须是public
	 * 启动USB的方法
	 */
	public abstract void start();
	
	/**
	 * 停止USB的方法
	 */
	void stop();
	
	/**
	 * USB读取数据的方法
	 * @return 读取到的数据
	 */
	public String loadData(IUsb usb);
}
