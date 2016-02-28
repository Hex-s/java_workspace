package com.niit.atm;

import java.util.Scanner;

/**
 * ATM类
 * @author Administrator
 *
 */
public class Atm {
	//所属银行
	private String bankName;
	Scanner sc = new Scanner(System.in);
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**
	 * 取款的方法
	 * @param card
	 */
	public void getMoney(Card card){
		boolean match = false;;
		if(bankName.equals(card.getBankName())){
			match = true;
		}
		System.out.println("请输入取款金额：");
		int getMoney = sc.nextInt();
		if(getMoney > card.getMoney()){
			System.out.println("余额不足！");
		}
		else{
			System.out.println("取款成功！");
			if(match){
				card.setMoney(card.getMoney() - getMoney);
			}
			else{
				card.setMoney(card.getMoney() - getMoney*1.02);
			}
		}
	}
	/**
	 * 存款的方法
	 * @param card
	 */
	public void saveMoney(Card card){
		System.out.println("请输入存款金额：");
		int saveMoney = sc.nextInt();
		System.out.println("1.确认存款 2.取消存款");
		int choice = sc.nextInt();
		if(choice == 1){
			card.setMoney(card.getMoney() + saveMoney);
			System.out.println("存款成功！");
		}
	}
	
	public void searchMoney(Card card){
		System.out.println("您卡内的余额为："+card.getMoney());
	}
}
