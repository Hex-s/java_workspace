package com.niit.shoppingsys;

import java.util.Scanner;

public class BuyProduct {
	//用户
	Customer customer;
	//包
	Bags bag;
	//衣服
	Clothes clothes;
	//其他商品
	Others others;
	Scanner sc;
	//从键盘接受界面跳转选项
	int choice;
	/**
	 * 初始化数据
	 * @param customer
	 * @param bag
	 * @param clothes
	 * @param others
	 */
	public void init(Customer customer,Bags bag,Clothes clothes,Others others){
		this.customer = customer;
		this.bag = bag;
		this.clothes = clothes;
		this.others = others;
		sc = new Scanner(System.in);
	}
	
	/**
	 * 开始购物	
	 */
	public void start(){
		System.out.println("欢迎"+customer.getCustomerName()+"来进行购物");
		//商品列表展示
		productMenu();
	}
	
	/**
	 * 商品列表
	 */
	private void productMenu(){
		System.out.println("-----商品列表：-----");
		System.out.println("1.包");
		System.out.println("2.衣服");
		System.out.println("3.其他商品");
		System.out.println("4.取消购买");
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		//1.包
		case 1:
			buy(bag);
			break;
		//2.衣服	
		case 2:
			buy(clothes);
			break;
		//3.其他商品
		case 3:
			buy(others);
			break;
		//4.取消购买
		case 4:
			System.out.println("-----再见！欢迎再次光临！-----");
			System.exit(0);
			break;
		default:
			System.out.println("非法输入！请重新选择！");
			productMenu();
		}
		
	}
	
	/**
	 * 购买包的方法
	 */
	private void buy(Bags bag) {
		System.out.println("包的品牌是："+bag.getBagBrand()+"，价格是："+bag.getBagPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(bag);
		}
		continueShopping();
	}
	/**
	 * 购买衣服的方法
	 */
	private void buy(Clothes clothes) {
		System.out.println("衣服的品牌是："+clothes.getClothesBrand()+"，价格是："+clothes.getClothesPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(clothes);
		}
		continueShopping();
	}

	/**
	 * 购买其他商品的方法
	 */
	private void buy(Others others) {
		System.out.println("其他商品的品牌是："+others.getOthersBrand()+"，价格是："+others.getOthersPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(others);
		}
		continueShopping();
	}
	/**
	 * 支付衣服的方法
	 */
	private void buyMethod(Clothes clothes){
		choice = payWay();
		switch(choice){
		//用现金支付
		case 1:
			//现金足够 支付衣服的金额 用户现金金额减少
			if(customer.getCash() >= clothes.getClothesPrice()){
				customer.pay(clothes.getClothesPrice());
				customer.buy(clothes);
				customer.setCash(customer.getCash() - clothes.getClothesPrice());
			}
			//现金不足 选择其他支付方式
			else{
				System.out.println("现金不足！");
				chooseOtherPayWay(clothes);
			}
			break;
		//用信用卡支付	
		case 2:
			//信用卡金额足够 信用卡金额减少
			if(customer.getCard().getMoney() >= clothes.getClothesPrice()){
				customer.pay(customer.getCard(), clothes.getClothesPrice());
				customer.buy(clothes);
				customer.getCard().setMoney(customer.getCard().getMoney() - clothes.getClothesPrice());
			}
			//信用卡金额不足 选择其他购买方式
			else{
				System.out.println("信用卡金额不足！");
				chooseOtherPayWay(clothes);
			}
			break;
		//用信用卡和现金支付	
		case 3:
			//总金额足够购买
			if(customer.getCard().getMoney()+customer.getCash() >= clothes.getClothesPrice()){
				customer.pay(customer.getCard(), clothes.getClothesPrice(), customer.getCash());
				customer.buy(clothes);
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - (clothes.getClothesPrice()-customer.getCash()));
			}
			else{
				System.out.println("金额不足");
				continueShopping();
			}
			break;
		}	
	}
	
	/**
	 * 支付其他商品的方法
	 */
	
	private void buyMethod(Others others){
		choice = payWay();
		switch(choice){
		//用现金支付
		case 1:
			if(customer.getCash() >= others.getOthersPrice()){
				customer.pay(others.getOthersPrice());
				customer.setCash(customer.getCash() - others.getOthersPrice());
				customer.buy(others);	
			}
			else{
				System.out.println("现金不足！");
				chooseOtherPayWay(others);
			}
			break;
		//用信用卡支付	
		case 2:
			if(customer.getCard().getMoney() >= others.getOthersPrice()){
				customer.pay(customer.getCard(), others.getOthersPrice());
				customer.getCard().setMoney(customer.getCard().getMoney() - others.getOthersPrice());
				customer.buy(others);	
			}
			else{
				System.out.println("信用卡金额不足！");
				chooseOtherPayWay(others);
			}
			break;
		//用信用卡和现金支付	
		case 3:
			if(customer.getCard().getMoney()+customer.getCash() >= others.getOthersPrice()){
				customer.pay(customer.getCard(), others.getOthersPrice(), customer.getCash());
				customer.buy(others);	
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - (others.getOthersPrice()-customer.getCash()));
			}
			else{
				System.out.println("金额不足");
				continueShopping();
			}
			break;
		}
	}
	/**
	 * 支付包的方法
	 */
	private void buyMethod(Bags bag){
		choice = payWay();
		switch(choice){
		//用现金支付
		case 1:
			if(customer.getCash() >= bag.getBagPrice()){
				customer.pay(bag.getBagPrice());
				customer.setCash(customer.getCash() - bag.getBagPrice());
				customer.buy(bag);	
			}
			else{
				System.out.println("现金不足！");
				chooseOtherPayWay(bag);
			}
			break;
		//用信用卡支付	
		case 2:
			if(customer.getCard().getMoney() >= bag.getBagPrice()){
				customer.pay(customer.getCard(), bag.getBagPrice());
				customer.getCard().setMoney(customer.getCard().getMoney() -  bag.getBagPrice());
				customer.buy(bag);	
			}
			else{
				System.out.println("信用卡金额不足！");
				chooseOtherPayWay(bag);
			}
			break;
		//用信用卡和现金支付	
		case 3:
			if(customer.getCard().getMoney()+customer.getCash() >= bag.getBagPrice()){
				customer.pay(customer.getCard(), bag.getBagPrice(), customer.getCash());
				customer.buy(bag);	
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - ( bag.getBagPrice()-customer.getCash()));
			}
			else{
				System.out.println("金额不足");
				continueShopping();
			}
			break;
		}	
	}
	/**
	 * 选择包其他购买方式
	 * @param bag
	 */
	public void chooseOtherPayWay(Bags bag){
		System.out.println("1.选择其他支付方式  2. 取消支付");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(bag);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * 选择衣服的其他购买方式
	 * @param bag
	 */
	public void chooseOtherPayWay(Clothes clothes){
		System.out.println("1.选择其他支付方式  2. 取消支付");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(clothes);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * 选择其他商品的其他购买方式
	 * @param bag
	 */
	public void chooseOtherPayWay(Others others){
		System.out.println("1.选择其他支付方式  2. 取消支付");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(others);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * 选择是否继续进行购物
	 */
	private void continueShopping(){
		System.out.println("1.继续进行购物  2.停止购物");
		choice = sc.nextInt();
		if(choice == 1){
			productMenu();
		}
		else{
			System.out.println("-----再见！欢迎再次光临！-----");
			System.exit(0);
		}
	}
	/**
	 * 选择是否进行购买商品
	 * @return
	 */
	public int buyOrNot(){
		System.out.println("1.确认购买 2.取消购买");
		choice = sc.nextInt();
		return choice;
	}
	/**
	 * 选择支付方式
	 * @return
	 */
	public int payWay(){
		System.out.println("请选择付款方式：");
		System.out.println("1.现金  2.信用卡  3.现金+信用卡");
		choice = sc.nextInt();
		return choice;
	}
}
