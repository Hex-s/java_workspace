package com.niit.exam7;
/**
 * 终态类不能被继承
 * @author Administrator
 *
 */
public final class Base {
	/**
	 * 终态方法不能被子类重写
	 */
	public final void method(){
		System.out.println("调用了父类method方法");
	}
}	
