package com.niit.exam6;
/**
 * ���п�
 * @author Administrator
 *
 */
public class BankCard {
	//���
	private double balance;
	//����
	private String cardId;
	//����
	private String password;
	
	public BankCard(double balance, String cardId, String password){
		this.balance = balance;
		this.cardId = cardId;
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
