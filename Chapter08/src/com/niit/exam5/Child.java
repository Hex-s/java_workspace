package com.niit.exam5;

public class Child extends Father {

	/**
	 * 子类在进行实例化前会先对父类进行实例化
	 */
	public Child(String name){
		//JVM会隐式调用如下代码
		//对父类进行实例化，父类实例化的调用必须写在子类构造的第一句
		//JVM只能对父类的空参进行隐式调用，如果父类中只有一个带参构造时，则必须要手动调用父类的构造方法
		super(name);
		//super();
		System.out.println("子类正在进行实例化");
	}
	
	
	public void childMethod(){
		System.out.println(super.getName());
	}
	
}
