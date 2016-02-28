package com.niit;

import java.io.Serializable;
/**
 * 被序列化的对象必须实现序列化接口
 * @author Administrator
 *
 */
public class User implements Serializable {
	private int userId;
	private String userName;
	
	public User(int userId, String userName){
		this.userId = userId;
		this.userName = userName;
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
	
}
