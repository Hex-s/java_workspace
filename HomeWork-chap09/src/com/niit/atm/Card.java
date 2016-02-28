package com.niit.atm;

public class Card {
	//¿¨ºÅ
	private String cardNum;
	//ÃÜÂë
	private String password;
	//ËùÊôÒøĞĞ
	private String bankName;
	//Óà¶î
	private double money;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	

}
