package com.niit.exam11;
/**
 * 抽象类，抽象类不能进行实例化，只能通过继承来使用
 * 抽象类是类和接口的结合体
 * @author Administrator
 *
 */
public abstract class User {
	private String name;
	
	/**
	 * 抽象类中可以有实体方法
	 */
	public void details(){
		System.out.println("用户的描述信息");
	}
	/**
	 * 抽象类中也可以有抽象方法
	 */
	public abstract void method();
}
