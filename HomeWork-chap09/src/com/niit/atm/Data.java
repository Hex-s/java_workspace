package com.niit.atm;

public class Data {
	//���е�����
	public Bank[] bank;
	//���еĿ�
	public Card[] card;
	//���е�ATM
	public Atm[] atm;
	//���е��û�
	public User[] user;
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		//ʵ�����洢������
		bank = new Bank[10];
		card = new Card[10];
		atm = new Atm[10];
		user = new User[10];
		
		/********��ʼ����������************/
		Bank bank1 = new ICBCBank();
		Bank bank2 = new ABCBank();
		bank1.setBankName("ICBC");
		bank2.setBankName("ABC");
		
		/********��ʼ�����п�����************/
		Card card1 = new Card();
		Card card2 = new Card();
		Card card3 = new Card();
		Card card4 = new Card();
		
		card1.setBankName("ICBC");
		card1.setCardNum("123456");
		card1.setPassword("123");
		card1.setMoney(1000);
		
		card2.setBankName("ABC");
		card2.setCardNum("234567");
		card2.setPassword("123");
		card2.setMoney(2000);
		
		card3.setBankName("ICBC");
		card3.setCardNum("654321");
		card3.setPassword("123");
		card3.setMoney(3000);
		
		card2.setBankName("ABC");
		card2.setCardNum("765432");
		card2.setPassword("123");
		card2.setMoney(4000);
		
		card[0] = card1;
		card[1] = card2;
		card[2] = card3;
		card[3] = card4;
		
		/********��ʼ����������************/
		bank1.setCard(card[0], 0);
		bank1.setCard(card[2], 1);
		bank2.setCard(card[1], 0);
		bank2.setCard(card[4], 1);
		bank[0] = bank1;
		bank[1] = bank2;
		
		/********��ʼ��ATM����************/
		Atm atm1 = new Atm();
		Atm atm2 = new Atm();
		atm1.setBankName("ICBC");
		atm2.setBankName("ABC");
		atm[0] = atm1;
		atm[1] = atm2;
		
		/********��ʼ���û�����************/
		User user1 = new User();
		User user2 = new User();
		user1.setName("tom");
		user1.setCard(card[0], 0);
		user1.setCard(card[1], 1);
		user2.setName("jerry");
		user2.setCard(card3, 0);
		user2.setCard(card4, 1);
		user[0] = user1;
		user[1] = user2;
	}
}
