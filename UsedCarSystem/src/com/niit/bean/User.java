package com.niit.bean;

public class User {
	//�û���
	public String userName;
	//����
	public String password;
	//���
	public double money;
	//���
	public boolean isAdmin;
	//�ղص�������Ϣ
	public Car[] collectCars;
	//�����������Ϣ
	public Car[] buyCars;

	/**
	 * �û���ʼ��
	 */
	public void init(){
		//��ʼ���ղ���Ϣ
		collectCars = new Car[10];
		//��ʼ��������Ϣ
		buyCars = new Car[10];
	}
}
