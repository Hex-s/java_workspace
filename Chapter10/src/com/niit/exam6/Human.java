package com.niit.exam6;
/**
 * ����
 * @author Administrator
 *
 */
public class Human {
	
	private BankCard card;
	/**
	 * ���
	 */
	public void saveMoney(Atm atm){
		try {
			//����ATM
			atm.start(card);
			//ʹ��ATM�����
			atm.saveMoney(card);
			
		} catch (MoneyOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ȡ��
	 */
	public void getMoney(Atm atm) throws MoneyOutOfBoundsException{
		//����ATM
		atm.start(card);
		//ʹ��ATM��ȡ��
		atm.getMoney(card);
	}
	public void setCard(BankCard card) {
		this.card = card;
	}
	
}
