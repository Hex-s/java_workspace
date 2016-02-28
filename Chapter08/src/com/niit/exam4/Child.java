package com.niit.exam4;
/**
 * 子类由父类派生出
 * 子类能获取父类中所有的属性和方法
 * 子类实现继承时应比父类更具体，1)比父类拥有更多的属性 2)比父类拥有更多的方法 3)重写父类原有的方法
 * @author Administrator
 *
 */
public class Child extends Father{
	//添加的属性
	private String name;
	
	/**
	 * 添加的方法
	 */
	public void play(){
		System.out.println("喜欢玩耍");
	}
	/**
	 * 子类可以对父类的原有方法进行重写
	 * 重写只有在子类中存在，同时要求重写方法的返回值类型，方法名以及参数列表必须要和父类的被重写的方法保持一致，并且访问修饰符不能低于父类方法的访问级别
	 * 
	 */
	public void smoking(){
		System.out.println("喜欢抽烟时进行深呼吸");
		//调用父类的同名方法
		super.smoking();
	}
	
	public String getName() {
		return name;
	}

	/**
	 * 使用Override注解的方法必须是一个重写方法
	 */
//	@Override
//	public void smoking() {
//		// TODO Auto-generated method stub
//		super.smoking();
//	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
