package com.niit.atm;
/**
 * 
 * @author Administrator
 *
 */
public class Bank {
	
	//银行名称
	private String bankName;
	//该银行下的银行卡
	private Card[] card;
	//该银行下的ATM机
	private Atm[] atm;
	
	public Bank(){
		card = new Card[100];
		atm = new Atm[100];
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Card getCard(int index) {
		return card[index];
	}

	public void setCard(Card card, int index) {
		this.card[index] = card;
	}
	
	public Atm getAtm(int index) {
		return atm[index];
	}

	public void setAtm(Atm atm,int index) {
		this.atm[index] = atm;
	}

}
