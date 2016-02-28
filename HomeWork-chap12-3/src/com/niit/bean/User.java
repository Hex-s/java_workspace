package com.niit.bean;

import java.util.ArrayList;

import com.niit.util.CommonUtil;

public class User {
	private int userId;
	//�û���
	private String userName;
	//����
	private String password;
	//���
	private double money;
	//���
	private boolean isAdmin;
	
	
	public User(){
		
	}
	
	/**
	 * ���ι���
	 */
	public User(String userName, String password,int money,boolean isAdmin){
		this.userId = CommonUtil.getUserId();
		this.userName = userName;
		this.password = password;
		this.money = money;
		this.isAdmin = isAdmin;
		
	}

	/**
	 * ��дequals����
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

	
}
