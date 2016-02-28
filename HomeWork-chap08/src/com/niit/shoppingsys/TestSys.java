package com.niit.shoppingsys;
/**
 * 使用面向的方式设计用户的物品的购买动作，
 * 购买的物品可以是包，衣服，其他物品，
 * 购买物品需要进行支付操作
 * 支付一共有3种情况：
 * 第一种情况可以直接使用现金来购买，
 * 第二种情况可以使用信用卡，
 * 第三种情况可以先用现金支付，如果现金不够再使用信用卡
 * 要求使用重载来进行设计
 * @author Administrator
 *
 */
public class TestSys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//包实例化
		Bags bag = new Bags("LV", 500);
		//衣服实例化
		Clothes clothes = new Clothes("艾格", 600);
		//其他商品实例化
		Others other = new Others("BELLE", 700);
		//信用卡实例化
		CreditCard card = new CreditCard("建行卡", 3000);
		//顾客实例化
		Customer customer = new Customer("tom", 550, card);
		//购买类实例化
		BuyProduct buy = new BuyProduct();
		//初始化数据
		buy.init(customer, bag, clothes, other);
		//购买方法
		buy.start();

		
	}

}
