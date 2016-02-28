package com.niit.exam6;
/**
 * 人类
 * @author Administrator
 *
 */
public class Human {
	
	private BankCard card;
	/**
	 * 存款
	 */
	public void saveMoney(Atm atm){
		try {
			//启动ATM
			atm.start(card);
			//使用ATM机存款
			atm.saveMoney(card);
			
		} catch (MoneyOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 取款
	 */
	public void getMoney(Atm atm) throws MoneyOutOfBoundsException{
		//启动ATM
		atm.start(card);
		//使用ATM机取款
		atm.getMoney(card);
	}
	public void setCard(BankCard card) {
		this.card = card;
	}
	
}
