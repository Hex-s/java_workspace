package com.niit.shoppingsys;

/**
 * 顾客类
 * 
 * @author Administrator
 * 
 */
public class Customer {


	// 顾客姓名
	private String customerName;
	// 用户拥有的现金
	private double cash;
	// 用户信用卡
	private CreditCard card;
	
	public Customer(String name,double cash,CreditCard card){
		this.customerName = name;
		setCash(cash);
		this.card = card;
	}

	/***************************** 购物的方法 ********************************/
	/**
	 * 买包的方法
	 * 
	 * @param bag
	 */
	public void buy(Bags bag) {
		System.out.println(customerName + "买了" + bag.getBagBrand());
	}

	/**
	 * 买衣服的方法
	 * 
	 * @param clothes
	 */
	public void buy(Clothes clothes) {
		System.out.println(customerName + "买了" + clothes.getClothesBrand());
	}

	/**
	 * 购买其他商品的方法
	 * 
	 * @param others
	 */
	public void buy(Others others) {
		System.out.println(customerName + "买了" + others.getOthersBrand());
	}

	/*************************** 支付的方法 ********************************/
	/**
	 * 现金支付的方法
	 * 
	 * @param money
	 */
	public void pay(double productPrice) {
		System.out.println(customerName + "用现金支付了" + productPrice + "元");
	}

	/**
	 * 信用卡支付的方式
	 * 
	 * @param card
	 */
	public void pay(CreditCard card, double productPrice) {
		System.out.println(customerName + "用" + card.getCardBank() + "支付了"
				+ productPrice + "元");
	}

	/**
	 * 先用现金支付，如果现金不够再使用信用卡支付的方法
	 * @param card
	 * @param productPrice
	 * @param money
	 */
	public void pay(CreditCard card, double productPrice, double money) {
		System.out.println(customerName + "用现金支付了" + money + "元，用"
				+ card.getCardBank() + "支付了" + (productPrice - money) + "元");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		if(cash < 0){
			this.cash = 0;
		}
		else{
			this.cash = cash;
		}
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	
}
