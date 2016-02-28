package com.niit.exam5;

public class Father {
	
	private String name;
	/**
	 * 父类的带参构造
	 * @param name
	 */
	public Father(String name){
		this.name = name;
		System.out.println("父类正在进行实例化");
	}
	/**
	 * 重载父类的构造方法
	 */
	public Father(){
		System.out.println("父类正在进行无参的构造");
	}
	public void show(){
		System.out.println("父类的方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
