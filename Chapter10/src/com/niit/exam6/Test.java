package com.niit.exam6;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ʵ������
		Human man = new Human();
		//ʵ�������п�
		BankCard card = new BankCard(1000, "10001", "123");
		//ʵ����ATM��
		Atm atm = new Atm();
		//�䱸���е����п�
		man.setCard(card);
//		//��ʹ��ATMȡ��
//		try {
//			man.getMoney(atm);
//		} catch (MoneyOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//ȡ��
//		man.saveMoney(atm);
	
	}

}
