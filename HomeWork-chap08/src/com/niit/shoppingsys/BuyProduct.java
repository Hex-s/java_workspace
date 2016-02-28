package com.niit.shoppingsys;

import java.util.Scanner;

public class BuyProduct {
	//�û�
	Customer customer;
	//��
	Bags bag;
	//�·�
	Clothes clothes;
	//������Ʒ
	Others others;
	Scanner sc;
	//�Ӽ��̽��ܽ�����תѡ��
	int choice;
	/**
	 * ��ʼ������
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
	 * ��ʼ����	
	 */
	public void start(){
		System.out.println("��ӭ"+customer.getCustomerName()+"�����й���");
		//��Ʒ�б�չʾ
		productMenu();
	}
	
	/**
	 * ��Ʒ�б�
	 */
	private void productMenu(){
		System.out.println("-----��Ʒ�б�-----");
		System.out.println("1.��");
		System.out.println("2.�·�");
		System.out.println("3.������Ʒ");
		System.out.println("4.ȡ������");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		//1.��
		case 1:
			buy(bag);
			break;
		//2.�·�	
		case 2:
			buy(clothes);
			break;
		//3.������Ʒ
		case 3:
			buy(others);
			break;
		//4.ȡ������
		case 4:
			System.out.println("-----�ټ�����ӭ�ٴι��٣�-----");
			System.exit(0);
			break;
		default:
			System.out.println("�Ƿ����룡������ѡ��");
			productMenu();
		}
		
	}
	
	/**
	 * ������ķ���
	 */
	private void buy(Bags bag) {
		System.out.println("����Ʒ���ǣ�"+bag.getBagBrand()+"���۸��ǣ�"+bag.getBagPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(bag);
		}
		continueShopping();
	}
	/**
	 * �����·��ķ���
	 */
	private void buy(Clothes clothes) {
		System.out.println("�·���Ʒ���ǣ�"+clothes.getClothesBrand()+"���۸��ǣ�"+clothes.getClothesPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(clothes);
		}
		continueShopping();
	}

	/**
	 * ����������Ʒ�ķ���
	 */
	private void buy(Others others) {
		System.out.println("������Ʒ��Ʒ���ǣ�"+others.getOthersBrand()+"���۸��ǣ�"+others.getOthersPrice());
		choice = buyOrNot();
		if(choice == 1){
			buyMethod(others);
		}
		continueShopping();
	}
	/**
	 * ֧���·��ķ���
	 */
	private void buyMethod(Clothes clothes){
		choice = payWay();
		switch(choice){
		//���ֽ�֧��
		case 1:
			//�ֽ��㹻 ֧���·��Ľ�� �û��ֽ������
			if(customer.getCash() >= clothes.getClothesPrice()){
				customer.pay(clothes.getClothesPrice());
				customer.buy(clothes);
				customer.setCash(customer.getCash() - clothes.getClothesPrice());
			}
			//�ֽ��� ѡ������֧����ʽ
			else{
				System.out.println("�ֽ��㣡");
				chooseOtherPayWay(clothes);
			}
			break;
		//�����ÿ�֧��	
		case 2:
			//���ÿ�����㹻 ���ÿ�������
			if(customer.getCard().getMoney() >= clothes.getClothesPrice()){
				customer.pay(customer.getCard(), clothes.getClothesPrice());
				customer.buy(clothes);
				customer.getCard().setMoney(customer.getCard().getMoney() - clothes.getClothesPrice());
			}
			//���ÿ����� ѡ����������ʽ
			else{
				System.out.println("���ÿ����㣡");
				chooseOtherPayWay(clothes);
			}
			break;
		//�����ÿ����ֽ�֧��	
		case 3:
			//�ܽ���㹻����
			if(customer.getCard().getMoney()+customer.getCash() >= clothes.getClothesPrice()){
				customer.pay(customer.getCard(), clothes.getClothesPrice(), customer.getCash());
				customer.buy(clothes);
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - (clothes.getClothesPrice()-customer.getCash()));
			}
			else{
				System.out.println("����");
				continueShopping();
			}
			break;
		}	
	}
	
	/**
	 * ֧��������Ʒ�ķ���
	 */
	
	private void buyMethod(Others others){
		choice = payWay();
		switch(choice){
		//���ֽ�֧��
		case 1:
			if(customer.getCash() >= others.getOthersPrice()){
				customer.pay(others.getOthersPrice());
				customer.setCash(customer.getCash() - others.getOthersPrice());
				customer.buy(others);	
			}
			else{
				System.out.println("�ֽ��㣡");
				chooseOtherPayWay(others);
			}
			break;
		//�����ÿ�֧��	
		case 2:
			if(customer.getCard().getMoney() >= others.getOthersPrice()){
				customer.pay(customer.getCard(), others.getOthersPrice());
				customer.getCard().setMoney(customer.getCard().getMoney() - others.getOthersPrice());
				customer.buy(others);	
			}
			else{
				System.out.println("���ÿ����㣡");
				chooseOtherPayWay(others);
			}
			break;
		//�����ÿ����ֽ�֧��	
		case 3:
			if(customer.getCard().getMoney()+customer.getCash() >= others.getOthersPrice()){
				customer.pay(customer.getCard(), others.getOthersPrice(), customer.getCash());
				customer.buy(others);	
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - (others.getOthersPrice()-customer.getCash()));
			}
			else{
				System.out.println("����");
				continueShopping();
			}
			break;
		}
	}
	/**
	 * ֧�����ķ���
	 */
	private void buyMethod(Bags bag){
		choice = payWay();
		switch(choice){
		//���ֽ�֧��
		case 1:
			if(customer.getCash() >= bag.getBagPrice()){
				customer.pay(bag.getBagPrice());
				customer.setCash(customer.getCash() - bag.getBagPrice());
				customer.buy(bag);	
			}
			else{
				System.out.println("�ֽ��㣡");
				chooseOtherPayWay(bag);
			}
			break;
		//�����ÿ�֧��	
		case 2:
			if(customer.getCard().getMoney() >= bag.getBagPrice()){
				customer.pay(customer.getCard(), bag.getBagPrice());
				customer.getCard().setMoney(customer.getCard().getMoney() -  bag.getBagPrice());
				customer.buy(bag);	
			}
			else{
				System.out.println("���ÿ����㣡");
				chooseOtherPayWay(bag);
			}
			break;
		//�����ÿ����ֽ�֧��	
		case 3:
			if(customer.getCard().getMoney()+customer.getCash() >= bag.getBagPrice()){
				customer.pay(customer.getCard(), bag.getBagPrice(), customer.getCash());
				customer.buy(bag);	
				customer.setCash(0);
				customer.getCard().setMoney(customer.getCard().getMoney() - ( bag.getBagPrice()-customer.getCash()));
			}
			else{
				System.out.println("����");
				continueShopping();
			}
			break;
		}	
	}
	/**
	 * ѡ�����������ʽ
	 * @param bag
	 */
	public void chooseOtherPayWay(Bags bag){
		System.out.println("1.ѡ������֧����ʽ  2. ȡ��֧��");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(bag);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * ѡ���·�����������ʽ
	 * @param bag
	 */
	public void chooseOtherPayWay(Clothes clothes){
		System.out.println("1.ѡ������֧����ʽ  2. ȡ��֧��");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(clothes);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * ѡ��������Ʒ����������ʽ
	 * @param bag
	 */
	public void chooseOtherPayWay(Others others){
		System.out.println("1.ѡ������֧����ʽ  2. ȡ��֧��");
		choice = sc.nextInt();
		if(choice == 1){
			buyMethod(others);
		}
		else{
			continueShopping();
		}
	}
	/**
	 * ѡ���Ƿ�������й���
	 */
	private void continueShopping(){
		System.out.println("1.�������й���  2.ֹͣ����");
		choice = sc.nextInt();
		if(choice == 1){
			productMenu();
		}
		else{
			System.out.println("-----�ټ�����ӭ�ٴι��٣�-----");
			System.exit(0);
		}
	}
	/**
	 * ѡ���Ƿ���й�����Ʒ
	 * @return
	 */
	public int buyOrNot(){
		System.out.println("1.ȷ�Ϲ��� 2.ȡ������");
		choice = sc.nextInt();
		return choice;
	}
	/**
	 * ѡ��֧����ʽ
	 * @return
	 */
	public int payWay(){
		System.out.println("��ѡ�񸶿ʽ��");
		System.out.println("1.�ֽ�  2.���ÿ�  3.�ֽ�+���ÿ�");
		choice = sc.nextInt();
		return choice;
	}
}
