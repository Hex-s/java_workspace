package com.niit.entiry;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User {

	//用户编号
	private int userId;
	//用户名
	private String uName;
	//用户密码
	private String uPwd;
	
	public User(){
		
	}
	
	public User(String uName,String uPwd){
		this.uName = uName;
		this.uPwd = uPwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	
	
}
