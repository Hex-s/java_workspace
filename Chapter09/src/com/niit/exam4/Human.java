package com.niit.exam4;

import java.util.Scanner;

public class Human {
	private double money;
	private Card card;
	
	public Human(double money, Card card){
		this.money = money;
		this.card = card;
	}
	/**
	 * ������ķ���
	 * @param bag
	 */
	public void buy(Ware ware){
		System.out.println("���ڹ���  "+ware.getWareName());
		System.out.println("ʹ����һ�ַ�ʽ����: 1.�ֽ�֧��  2.���ÿ�֧��  3.�ֽ�����ÿ�ͬʱ֧��");
		Scanner sc = new Scanner(System.in);
		int payType = sc.nextInt();
		//�ж�֧��������
		switch(payType){
		case 1:
			if(pay(ware.getPrice(), money)){
				System.out.println("�ֽ���"+ware.getWareName());
			}
			else{
				System.out.println("�ֽ𲻹�֧��");
			}
			break;
		case 2:
			if(pay(ware.getPrice(), card)){
				System.out.println("���ÿ�������"+ware.getWareName());
			}
			else{
				System.out.println("���ÿ���Ȳ�����");
			}
			break;
		case 3:
			if(pay(ware.getPrice(),money,card)){
				System.out.println("�ɹ�����"+ware.getWareName());
			}
			else{
				System.out.println("���ÿ���Ȳ�����");
			}
		}
	}
	
	/**
	 * �ֽ�֧��
	 * @param price ��Ʒ�ļ۸�
	 * @param money ��ʹ�õ��ֽ�
	 * @return �Ƿ���ɹ��ı�ʶ
	 */
	public boolean pay(double price,double money){
		//�ж��ֽ��Ƿ�����Ʒ
		if(money >= price){
			money-=price;
			return true;
		}
		return false;
		
	}
	/**
	 * ���ÿ�֧��
	 * @param price
	 * @param card
	 * @return �Ƿ���ɹ��ı�ʶ
	 */
	public boolean pay(double price,Card card){
		//�ж����ÿ��Ķ���Ƿ�֧��
		if(card.getBalance() >= price){
			card.setBalance(card.getBalance()-price);
		}
		else{
			return false;
		}
		return true;
	}
	/**
	 * �Ƚ����ֽ�֧������ʱʹ�����ÿ�֧��
	 * @param price
	 * @param money
	 * @param card
	 * @return �Ƿ���ɹ��ı�ʶ
	 */
	public boolean pay(double price, double money, Card card){
		//ʹ���ֽ���,�������ʹ�����ÿ�֧��
		if(!pay(price, money)){
			//������Ҫ���ÿ�֧���ļ۸�
			price -= money;
			//���ÿ�֧��
			return pay(price, card);
				
		}
		return true;
		
	}
}
