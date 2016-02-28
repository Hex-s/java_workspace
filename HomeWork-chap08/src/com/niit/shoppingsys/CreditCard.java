package com.niit.shoppingsys;

public class CreditCard {
	//���ÿ���������
	private String cardBank;
	//���ÿ����
	private double money;
	
	/**
	 * ���ÿ���Ĺ��췽��
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
