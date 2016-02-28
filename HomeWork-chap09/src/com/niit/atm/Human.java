package com.niit.atm;

public class Human {
	//用户名称
	private String name;
	//用户信用卡
	private Card[] card;
	
	public Human(){
		card = new Card[10];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Card getCard(int index) {
		return card[index];
	}
	public void setCard(Card card,int index) {
		this.card[index] = card;
	}
	
	
	
}
