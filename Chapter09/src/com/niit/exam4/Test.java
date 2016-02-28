package com.niit.exam4;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化信用卡
		Card card = new Card(2000);
		//实例化用户
		Human man = new Human(100, card);
		//实例化需要购买的物品
		Bag bag = new Bag(150, "背包");
		Clothes clothes = new Clothes(300, "上衣");
		//购买背包
		man.buy(bag);
		//购买上衣
		//man.buy(clothes);

	}

}
