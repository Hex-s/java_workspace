package com.niit.shoppingsys;

public class CreditCard {
	//信用卡所属银行
	private String cardBank;
	//信用卡余额
	private double money;
	
	/**
	 * 信用卡类的构造方法
	 * @param bank
	 * @param money
	 */
	public CreditCard(String bank,double money){
		this.cardBank = bank;
		setMoney(money);
	}
	
	public String getCardBank() {
		return cardBank;
	}
	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		if(money < 0){
			this.money = 0;
		}
		else{
			this.money = money;
		}
	}
	
	
}
