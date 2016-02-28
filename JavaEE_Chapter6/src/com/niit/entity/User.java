package com.niit.entity;

import java.sql.Timestamp;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String head;
	private Timestamp regTime;
	private int sex; //1 代表男 0 代表女
	
	public User(){
		
	}
	public User(String userName, String userPwd, String head, Timestamp regTime, int sex){
		this.userName = userName;
		this.userPwd = userPwd;
		this.head = head;
		this.regTime = regTime;
		this.sex = sex;
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
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
