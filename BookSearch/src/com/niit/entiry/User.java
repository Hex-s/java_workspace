package com.niit.entiry;

/**
 * �û���
 * @author Administrator
 *
 */
public class User {

	//�û����
	private int userId;
	//�û���
	private String uName;
	//�û�����
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
