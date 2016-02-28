package com.niit.exam4;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化子类
		Child child = new Child();
//		System.out.println("儿子的头发颜色是："+child.getHairColor());
//		System.out.println("儿子的眼睛颜色是："+child.getEyeColor());
		//习惯
//		child.habit();
		//喜欢抽烟
//		child.smoking();
//		child.play();
		child.setName("tom");
		System.out.println("儿子的名字是："+child.getName());
		child.hobby();
		
		//实例化父类
		Father father = new Father();
		//父类是不具备子类添加的方法或者是属性的
	}

}
