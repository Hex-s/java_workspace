package com.niit.atm;

import java.util.Scanner;

/**
 * ATM��
 * @author Administrator
 *
 */
public class Atm {
	//��������
	private String bankName;
	Scanner sc = new Scanner(System.in);
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**
	 * ȡ��ķ���
	 * @param card
	 */
	public void getMoney(Card card){
		boolean match = false;;
		if(bankName.equals(card.getBankName())){
			match = true;
		}
		System.out.println("������ȡ���");
		int getMoney = sc.nextInt();
		if(getMoney > card.getMoney()){
			System.out.println("���㣡");
		}
		else{
			System.out.println("ȡ��ɹ���");
			if(match){
				card.setMoney(card.getMoney() - getMoney);
			}
			else{
				card.setMoney(card.getMoney() - getMoney*1.02);
			}
		}
	}
	/**
	 * ���ķ���
	 * @param card
	 */
	public void saveMoney(Card card){
		System.out.println("���������");
		int saveMoney = sc.nextInt();
		System.out.println("1.ȷ�ϴ�� 2.ȡ�����");
		int choice = sc.nextInt();
		if(choice == 1){
			card.setMoney(card.getMoney() + saveMoney);
			System.out.println("���ɹ���");
		}
	}
	
	public void searchMoney(Card card){
		System.out.println("�����ڵ����Ϊ��"+card.getMoney());
	}
}
