package com.niit.exam5;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//对子类进行实例化
		Child child = new Child("tom");
		//Father father = new Father();
		child.setName("tom");
		child.childMethod();
	}

}
