package com.niit.exam4;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʵ�������ÿ�
		Card card = new Card(2000);
		//ʵ�����û�
		Human man = new Human(100, card);
		//ʵ������Ҫ�������Ʒ
		Bag bag = new Bag(150, "����");
		Clothes clothes = new Clothes(300, "����");
		//���򱳰�
		man.buy(bag);
		//��������
		//man.buy(clothes);

	}

}
