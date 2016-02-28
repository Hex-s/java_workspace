package com.niit.exam10;
/**
 * 学生类
 * 在继承父类的同时实现多个接口
 * 必须要先继承后实现
 * @author Administrator
 *
 */
public class Student extends Human implements IInfo{

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "学生的个人资料";
	}
	
}
