package com.niit.entiry;

/**
 * 教师类
 * @author Administrator
 *
 */
public class Teacher {
	//老师编号
	private int tId;
	//姓名
	private String tName;
	//密码
	private String pwd;
	
	public Teacher(){
		
	}
	
	public Teacher(int tId,String tName,String pwd){
		this.tId = tId;
		this.tName = tName;
		this.pwd = pwd;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
