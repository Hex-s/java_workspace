package com.niit.exam6;
/**
 * 一个类可以同时实现多个接口,即接口可以多实现
 * 如果一个类同时实现了多个接口，多个接口中的所有抽象方法也都应在该实现类中实现
 * @author Administrator
 *
 */
public class ClassA implements IOtherA,ICommon,IOtherB {

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String b() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
