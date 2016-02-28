package com.niit.exam6;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * ATM取款机类
 * @author Administrator
 *
 */
public class Atm {
	private Scanner sc = new Scanner(System.in);
	//创建日志文件对象  参数表示日志文件记录的类的完整路径名称
	private Logger log = Logger.getLogger("com.niit.exam6.Atm");
	
	/**
	 * 插入银行卡启动ATM的方法
	 * 如果方法中抛出的是RuntimeException，可以 不用throws进行声明，这类异常在运行时可能出现也可能不出现
	 * @param card
	 */
	public void start(BankCard card) throws MoneyOutOfBoundsException{
		//记录日志信息
		log.debug("ATM启动");
		System.out.println("请输入密码：");
		String password = sc.next();
		//密码正确
		if(card.getPassword().equals(password)){
			log.info("卡号为"+card.getCardId()+"的银行卡通过密码验证");
			//显示主界面
			showBalance(card);
		}
		else{
			log.warn("卡号为"+card.getCardId()+"的银行卡在输入密码时发生了错误！");
			//密码错误引发异常，并将该异常抛出
			throw new PasswordException("密码错误！ATM机已被锁死！");
		}
	}
	/**
	 * 显示主菜单
	 * @param card
	 */
	public void showMainMenu(BankCard card) throws MoneyOutOfBoundsException{
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 存款");
		System.out.println("2. 取款");
		System.out.println("3. 查询余额");
		System.out.println("4. 退出");
		int choice = 0;
		try{
			choice = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("选择非法！");
			//递归方法
			showMainMenu(card);
		}
		switch(choice){
		case 1:
			saveMoney(card);
			break;
		case 2:
			//本类抛出的异常无需在本类中直接处理
			getMoney(card);
			break;
		case 3:
			showBalance(card);
			break;
		case 4:
			System.out.println("欢迎下次使用ATM存取款机！");
			System.exit(0);
			break;
		}
	}
	/**
	 * 存款方法
	 * @param card
	 */
	public void saveMoney(BankCard card) throws MoneyOutOfBoundsException{
		log.debug("卡号为"+card.getCardId()+"的银行卡开始进行存款");
		System.out.println("请输入存款的金额：");
		int money = sc.nextInt();
		card.setBalance(card.getBalance()+money);
		System.out.println("本次存款:"+money+",当前余额为:"+card.getBalance());
		log.debug("卡号为"+card.getCardId()+"的银行卡已完成存款，存款金额是"+money);
		//显示主菜单
		showMainMenu(card);
	}
	/**
	 * 取款方法
	 * 如果抛出的是非RuntimeException则必须要使用throws声明
	 * 声明异常时异常的类型范围必须大于等于当前已经抛出的异常类型
	 * @param card
	 */
	public void getMoney(BankCard card) throws MoneyOutOfBoundsException{
		log.debug("卡号为"+card.getCardId()+"的银行卡开始进行取款");
		System.out.println("请输入取款的金额：");
		int money = sc.nextInt();
		//判断取款的金额是否超出当前余额
		if(money > card.getBalance()){
			log.error("卡号为"+card.getCardId()+"的银行卡在取款时超出了额度！");
			//抛出异常
			throw new MoneyOutOfBoundsException("取款金额超出额度！ATM已自动报警！");
		}
		else{
			card.setBalance(card.getBalance()-money);
			log.info("卡号为"+card.getCardId()+"的银行卡完成了存款，本次存款"+money);
			//显示主菜单
			showMainMenu(card);
		}
	}
	/**
	 * 查询余额方法
	 * @param card
	 */
	public void showBalance(BankCard card) throws MoneyOutOfBoundsException{
		System.out.println("当前余额："+card.getBalance());
		//返回主菜单
		showMainMenu(card);
	}
}
