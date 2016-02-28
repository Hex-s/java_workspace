package com.niit.atm;

import java.util.Scanner;

/**
 * 用户将持有的银行卡
 * 到ATM机进行存款和取款的操作，
 * 假如持有的银行卡和ATM不匹配，
 * 取款时会额外扣除2%的手续费
 * @author Administrator
 *
 */
public class RunSys {
	//数据类
	Data data;
	//银行卡
	Card card;
	//ATM
	Atm atm;
	//用户
	User user;
	Scanner sc;
	int choice;
	//输入密码的次数
	int inputNum = 0;
	
	/**
	 * 初始化系统 传入数据库
	 * @param data
	 */
	private void init(Data data){
		this.data = data;
		card = new Card();
		atm = new Atm();
		user = new User();
		sc = new Scanner(System.in);
	}
	
	/**
	 * 开始使用ATM系统
	 * @param data
	 */
	public void start(Data data){
		init(data);
		user = data.user[0];
		choose();
		login();
	}
	
	/**
	 * 选择ATM机及进行存取款操作的银行卡
	 */
	private void choose(){
		//选择银行卡
		System.out.println(user.getName()+"请选择银行卡：");
		System.out.println("序号\t银行卡所属银行");
		for(int i = 0; i < data.user.length; i++){	
			if(data.user[i] != null){
				System.out.println((i+1)+"\t"+user.getCard(i).getBankName());
			}
		}
		System.out.println("请选择：");
		choice = sc.nextInt();
		card = user.getCard(choice-1);
		//选择ATM机
		System.out.println("请选择ATM机：");
		System.out.println("序号\tATM机所属银行");
		for(int i = 0; i < data.atm.length; i++){
			if(data.atm[i] != null){
				System.out.println((i+1)+"\t"+data.atm[i].getBankName());
			}		
		}
		System.out.println("请选择：");
		choice = sc.nextInt();
		atm = data.atm[choice-1];
	}
	/**
	 * 用户输入密码
	 */
	private void login(){
		System.out.println("请输入密码：");
		String pwd = sc.next();
		if(!pwd.equals(card.getPassword())){
			inputNum++;
			if(inputNum == 3){
				System.out.println("您的卡已被冻结！");
				System.exit(0);
			}
			else{
				System.out.println("密码错误！再输错"+(3-inputNum)+"次密码卡将会被冻结！");
				System.out.println("1.输入密码");
				System.out.println("2.退卡");
				choice = sc.nextInt();
				if(choice == 1){
					login();
				}
				else{
					System.exit(0);
				}
			}
		}
		else{
			mainMenu();
		}
		
	}
	
	/**
	 * 操作菜单
	 */
	private void mainMenu(){
		System.out.println("1.取款");
		System.out.println("2.余额查询");
		System.out.println("3.退卡");
		if(match()){
			System.out.println("4.存款");
		}
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		case 1:
			getMoney();
			break;
		case 2:
			searchMoney();
			break;
		case 3:
			System.exit(0);
			break;
		case 4:
			saveMoney();
			break;
		}
	}
	
	
	/**
	 * 取款的方法
	 */
	private void getMoney() {
		atm.getMoney(card);
		mainMenu();
	}
	/**
	 * 查询余额的方法
	 */
	private void searchMoney() {
		atm.searchMoney(card);
		mainMenu();
	}
	/**
	 * 存钱的方法
	 */
	private void saveMoney() {
		atm.saveMoney(card);
		mainMenu();
	}

	

	/**
	 * 判断银行卡与ATM是否属于同一家银行
	 * @return
	 */
	private boolean match(){
		if(card.getBankName().equals(atm.getBankName())){
			return true;
		}		
		return false;
	}
}
