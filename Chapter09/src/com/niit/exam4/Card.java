package com.niit.exam4;
/**
 * 信用卡
 * @author Administrator
 *
 */
public class Card {
	//使用额度
	private double balance;
	
	public Card(double balance){
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
