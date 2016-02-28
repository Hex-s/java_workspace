package com.niit.bean;

public class User {
	//用户名
	public String userName;
	//密码
	public String password;
	//金额
	public double money;
	//身份
	public boolean isAdmin;
	//收藏的汽车信息
	public Car[] collectCars;
	//购买的汽车信息
	public Car[] buyCars;

	/**
	 * 用户初始化
	 */
	public void init(){
		//初始化收藏信息
		collectCars = new Car[10];
		//初始化购买信息
		buyCars = new Car[10];
	}
}
