package com.niit.shoppingsys;

/**
 * �˿���
 * 
 * @author Administrator
 * 
 */
public class Customer {


	// �˿�����
	private String customerName;
	// �û�ӵ�е��ֽ�
	private double cash;
	// �û����ÿ�
	private CreditCard card;
	
	public Customer(String name,double cash,CreditCard card){
		this.customerName = name;
		setCash(cash);
		this.card = card;
	}

	/***************************** ����ķ��� ********************************/
	/**
	 * ����ķ���
	 * 
	 * @param bag
	 */
	public void buy(Bags bag) {
		System.out.println(customerName + "����" + bag.getBagBrand());
	}

	/**
	 * ���·��ķ���
	 * 
	 * @param clothes
	 */
	public void buy(Clothes clothes) {
		System.out.println(customerName + "����" + clothes.getClothesBrand());
	}

	/**
	 * ����������Ʒ�ķ���
	 * 
	 * @param others
	 */
	public void buy(Others others) {
		System.out.println(customerName + "����" + others.getOthersBrand());
	}

	/*************************** ֧���ķ��� ********************************/
	/**
	 * �ֽ�֧���ķ���
	 * 
	 * @param money
	 */
	public void pay(double productPrice) {
		System.out.println(customerName + "���ֽ�֧����" + productPrice + "Ԫ");
	}

	/**
	 * ���ÿ�֧���ķ�ʽ
	 * 
	 * @param card
	 */
	public void pay(CreditCard card, double productPrice) {
		System.out.println(customerName + "��" + card.getCardBank() + "֧����"
				+ productPrice + "Ԫ");
	}

	/**
	 * �����ֽ�֧��������ֽ𲻹���ʹ�����ÿ�֧���ķ���
	 * @param card
	 * @param productPrice
	 * @param money
	 */
	public void pay(CreditCard card, double productPrice, double money) {
		System.out.println(customerName + "���ֽ�֧����" + money + "Ԫ����"
				+ card.getCardBank() + "֧����" + (productPrice - money) + "Ԫ");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		if(cash < 0){
			this.cash = 0;
		}
		else{
			this.cash = cash;
		}
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	
}
