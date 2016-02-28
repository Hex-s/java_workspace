package com.niit.entity;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private Timestamp regTime;
	
	public User(){
		
	}
	public User(String userName, String userPwd, Timestamp regTime){
		this.userName = userName;
		this.userPwd = userPwd;
		this.regTime = regTime;
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	
}
