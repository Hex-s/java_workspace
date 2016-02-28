package com.niit.bean;

import java.util.ArrayList;

import com.niit.util.CommonUtil;

public class User {
	private int userId;
	//用户名
	private String userName;
	//密码
	private String password;
	//金额
	private double money;
	//身份
	private boolean isAdmin;
	//收藏的汽车信息 最多10辆
	private ArrayList<Car> collectCars;
	//加入对比的车辆，最多4辆
	private ArrayList<Car> compareCars;
	
	public User(){
		
	}
	
	/**
	 * 带参构造
	 */
	public User(String userName, String password, double money, boolean isAdmin){
		this.userId = CommonUtil.getUserId();
		this.userName = userName;
		this.password = password;
		this.money = money;
		this.isAdmin = isAdmin;
		collectCars = new ArrayList<Car>();
		compareCars = new ArrayList<Car>();
	}

	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof User){
				User user = (User)obj;
				if(this.userName.equals(user.getUserName())){
					return true;
				}
			}
		}
		return false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ArrayList<Car> getCollectCars() {
		return collectCars;
	}

	public void setCollectCars(ArrayList<Car> collectCars) {
		this.collectCars = collectCars;
	}

	public ArrayList<Car> getCompareCars() {
		return compareCars;
	}

	public void setCompareCars(ArrayList<Car> compareCars) {
		this.compareCars = compareCars;
	}
		
	
}
