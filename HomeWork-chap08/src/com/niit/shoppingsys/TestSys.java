package com.niit.shoppingsys;
/**
 * ʹ������ķ�ʽ����û�����Ʒ�Ĺ�������
 * �������Ʒ�����ǰ����·���������Ʒ��
 * ������Ʒ��Ҫ����֧������
 * ֧��һ����3�������
 * ��һ���������ֱ��ʹ���ֽ�������
 * �ڶ����������ʹ�����ÿ���
 * ������������������ֽ�֧��������ֽ𲻹���ʹ�����ÿ�
 * Ҫ��ʹ���������������
 * @author Administrator
 *
 */
public class TestSys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ʵ����
		Bags bag = new Bags("LV", 500);
		//�·�ʵ����
		Clothes clothes = new Clothes("����", 600);
		//������Ʒʵ����
		Others other = new Others("BELLE", 700);
		//���ÿ�ʵ����
		CreditCard card = new CreditCard("���п�", 3000);
		//�˿�ʵ����
		Customer customer = new Customer("tom", 550, card);
		//������ʵ����
		BuyProduct buy = new BuyProduct();
		//��ʼ������
		buy.init(customer, bag, clothes, other);
		//���򷽷�
		buy.start();

		
	}

}
