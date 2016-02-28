package com.niit.atm;
/**
 * 
 * @author Administrator
 *
 */
public class Bank {
	
	//��������
	private String bankName;
	//�������µ����п�
	private Card[] card;
	//�������µ�ATM��
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
