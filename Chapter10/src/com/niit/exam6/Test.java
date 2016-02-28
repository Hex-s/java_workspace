package com.niit.exam6;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//实例化人
		Human man = new Human();
		//实例化银行卡
		BankCard card = new BankCard(1000, "10001", "123");
		//实例化ATM机
		Atm atm = new Atm();
		//配备持有的银行卡
		man.setCard(card);
//		//人使用ATM取款
//		try {
//			man.getMoney(atm);
//		} catch (MoneyOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//取款
//		man.saveMoney(atm);
	
	}

}
