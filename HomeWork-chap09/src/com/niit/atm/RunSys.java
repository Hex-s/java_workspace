package com.niit.atm;

import java.util.Scanner;

/**
 * �û������е����п�
 * ��ATM�����д���ȡ��Ĳ�����
 * ������е����п���ATM��ƥ�䣬
 * ȡ��ʱ�����۳�2%��������
 * @author Administrator
 *
 */
public class RunSys {
	//������
	Data data;
	//���п�
	Card card;
	//ATM
	Atm atm;
	//�û�
	User user;
	Scanner sc;
	int choice;
	//��������Ĵ���
	int inputNum = 0;
	
	/**
	 * ��ʼ��ϵͳ �������ݿ�
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
	 * ��ʼʹ��ATMϵͳ
	 * @param data
	 */
	public void start(Data data){
		init(data);
		user = data.user[0];
		choose();
		login();
	}
	
	/**
	 * ѡ��ATM�������д�ȡ����������п�
	 */
	private void choose(){
		//ѡ�����п�
		System.out.println(user.getName()+"��ѡ�����п���");
		System.out.println("���\t���п���������");
		for(int i = 0; i < data.user.length; i++){	
			if(data.user[i] != null){
				System.out.println((i+1)+"\t"+user.getCard(i).getBankName());
			}
		}
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		card = user.getCard(choice-1);
		//ѡ��ATM��
		System.out.println("��ѡ��ATM����");
		System.out.println("���\tATM����������");
		for(int i = 0; i < data.atm.length; i++){
			if(data.atm[i] != null){
				System.out.println((i+1)+"\t"+data.atm[i].getBankName());
			}		
		}
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		atm = data.atm[choice-1];
	}
	/**
	 * �û���������
	 */
	private void login(){
		System.out.println("���������룺");
		String pwd = sc.next();
		if(!pwd.equals(card.getPassword())){
			inputNum++;
			if(inputNum == 3){
				System.out.println("���Ŀ��ѱ����ᣡ");
				System.exit(0);
			}
			else{
				System.out.println("������������"+(3-inputNum)+"�����뿨���ᱻ���ᣡ");
				System.out.println("1.��������");
				System.out.println("2.�˿�");
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
	 * �����˵�
	 */
	private void mainMenu(){
		System.out.println("1.ȡ��");
		System.out.println("2.����ѯ");
		System.out.println("3.�˿�");
		if(match()){
			System.out.println("4.���");
		}
		System.out.println("��ѡ��");
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
	 * ȡ��ķ���
	 */
	private void getMoney() {
		atm.getMoney(card);
		mainMenu();
	}
	/**
	 * ��ѯ���ķ���
	 */
	private void searchMoney() {
		atm.searchMoney(card);
		mainMenu();
	}
	/**
	 * ��Ǯ�ķ���
	 */
	private void saveMoney() {
		atm.saveMoney(card);
		mainMenu();
	}

	

	/**
	 * �ж����п���ATM�Ƿ�����ͬһ������
	 * @return
	 */
	private boolean match(){
		if(card.getBankName().equals(atm.getBankName())){
			return true;
		}		
		return false;
	}
}
