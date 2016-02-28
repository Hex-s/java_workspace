package com.niit.entity;

import java.util.Date;

public class User {
	private int userId;
	private String userName;
	private String sex;
	private Book book;
	private Date time;
	private String show;
	
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		System.out.println("调用了getUserName");
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getShow(){
		//System.out.println("调用了show方法");
		return "调用了show方法";
	}
	
}
