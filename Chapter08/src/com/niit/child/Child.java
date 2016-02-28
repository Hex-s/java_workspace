package com.niit.child;

import com.niit.base.Base;

public class Child extends Base {

	public void method(){
		//可以直接访问父类中的protected属性
		System.out.println(b);
	}
}
