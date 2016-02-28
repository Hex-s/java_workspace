package com.niit.entity;

import java.sql.Timestamp;

/**
 * ”√ªß¿‡
 * @author Administrator
 *
 */
public class User {
	private int userId;
	private String uName;
	private String uPwd;
	private int uSex;
	private String uEmail;
	private Timestamp uBirthday;
	private String uStatement;
	private Timestamp uRegdate;
	private int uPoint; 
	private String uHead;
	private String address;
	
	public User(){
		
	}
	public User(String uName, String uPwd, int uSex, String uEmai,Timestamp uBirthday,String uStatement,Timestamp uRegdate,int uPoint,String uHead,String address){
		this.uName = uName;
		this.uPwd = uPwd;
		this.uSex = uSex;
		this.uEmail = uEmai;
		this.uBirthday = uBirthday;
		this.uStatement = uStatement;
		this.uRegdate = uRegdate;
		this.uPoint = uPoint;
		this.uHead = uHead;
		this.address = address;
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
	public int getuSex() {
		return uSex;
	}
	public void setuSex(int uSex) {
		this.uSex = uSex;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public Timestamp getuBirthday() {
		return uBirthday;
	}
	public void setuBirthday(Timestamp uBirthday) {
		this.uBirthday = uBirthday;
	}
	public String getuStatement() {
		return uStatement;
	}
	public void setuStatement(String uStatement) {
		this.uStatement = uStatement;
	}
	public Timestamp getuRegdate() {
		return uRegdate;
	}
	public void setuRegdate(Timestamp uRegdate) {
		this.uRegdate = uRegdate;
	}
	public int getuPoint() {
		return uPoint;
	}
	public void setuPoint(int uPoint) {
		this.uPoint = uPoint;
	}
	public String getuHead() {
		return uHead;
	}
	public void setuHead(String uHead) {
		this.uHead = uHead;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
