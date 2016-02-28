package com.niit;

public class Exam1 {
	//访问修饰符既可以修饰属性，也可以修饰方法
	
	//默认的  和protected相似，也能在当前包中访问
	int a;
	//公共的 允许在当前项目中访问
	public int b;
	//保护的 允许在当前包的范围中访问
	protected int c;
	//私有的 只能在当前类中访问
	private int d;
	
	public void method(){
		System.out.println(a);
	}
}
