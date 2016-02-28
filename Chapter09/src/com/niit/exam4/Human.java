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
	 * 购买包的方法
	 * @param bag
	 */
	public void buy(Ware ware){
		System.out.println("正在购买  "+ware.getWareName());
		System.out.println("使用哪一种方式购买: 1.现金支付  2.信用卡支付  3.现金和信用卡同时支付");
		Scanner sc = new Scanner(System.in);
		int payType = sc.nextInt();
		//判断支付的类型
		switch(payType){
		case 1:
			if(pay(ware.getPrice(), money)){
				System.out.println("现金购买"+ware.getWareName());
			}
			else{
				System.out.println("现金不够支付");
			}
			break;
		case 2:
			if(pay(ware.getPrice(), card)){
				System.out.println("信用卡购买了"+ware.getWareName());
			}
			else{
				System.out.println("信用卡额度不够！");
			}
			break;
		case 3:
			if(pay(ware.getPrice(),money,card)){
				System.out.println("成功购买"+ware.getWareName());
			}
			else{
				System.out.println("信用卡额度不够！");
			}
		}
	}
	
	/**
	 * 现金支付
	 * @param price 商品的价格
	 * @param money 可使用的现金
	 * @return 是否购买成功的标识
	 */
	public boolean pay(double price,double money){
		//判断现金是否够买物品
		if(money >= price){
			money-=price;
			return true;
		}
		return false;
		
	}
	/**
	 * 信用卡支付
	 * @param price
	 * @param card
	 * @return 是否购买成功的标识
	 */
	public boolean pay(double price,Card card){
		//判断信用卡的额度是否够支付
		if(card.getBalance() >= price){
			card.setBalance(card.getBalance()-price);
		}
		else{
			return false;
		}
		return true;
	}
	/**
	 * 先进行现金支付不够时使用信用卡支付
	 * @param price
	 * @param money
	 * @param card
	 * @return 是否购买成功的标识
	 */
	public boolean pay(double price, double money, Card card){
		//使用现金购买,如果不够使用信用卡支付
		if(!pay(price, money)){
			//计算需要信用卡支付的价格
			price -= money;
			//信用卡支付
			return pay(price, card);
				
		}
		return true;
		
	}
}
