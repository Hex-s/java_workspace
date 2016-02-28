package com.niit.exam6;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * ATMȡ�����
 * @author Administrator
 *
 */
public class Atm {
	private Scanner sc = new Scanner(System.in);
	//������־�ļ�����  ������ʾ��־�ļ���¼���������·������
	private Logger log = Logger.getLogger("com.niit.exam6.Atm");
	
	/**
	 * �������п�����ATM�ķ���
	 * ����������׳�����RuntimeException������ ����throws���������������쳣������ʱ���ܳ���Ҳ���ܲ�����
	 * @param card
	 */
	public void start(BankCard card) throws MoneyOutOfBoundsException{
		//��¼��־��Ϣ
		log.debug("ATM����");
		System.out.println("���������룺");
		String password = sc.next();
		//������ȷ
		if(card.getPassword().equals(password)){
			log.info("����Ϊ"+card.getCardId()+"�����п�ͨ��������֤");
			//��ʾ������
			showBalance(card);
		}
		else{
			log.warn("����Ϊ"+card.getCardId()+"�����п�����������ʱ�����˴���");
			//������������쳣���������쳣�׳�
			throw new PasswordException("�������ATM���ѱ�������");
		}
	}
	/**
	 * ��ʾ���˵�
	 * @param card
	 */
	public void showMainMenu(BankCard card) throws MoneyOutOfBoundsException{
		Scanner sc = new Scanner(System.in);
		System.out.println("1. ���");
		System.out.println("2. ȡ��");
		System.out.println("3. ��ѯ���");
		System.out.println("4. �˳�");
		int choice = 0;
		try{
			choice = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("ѡ��Ƿ���");
			//�ݹ鷽��
			showMainMenu(card);
		}
		switch(choice){
		case 1:
			saveMoney(card);
			break;
		case 2:
			//�����׳����쳣�����ڱ�����ֱ�Ӵ���
			getMoney(card);
			break;
		case 3:
			showBalance(card);
			break;
		case 4:
			System.out.println("��ӭ�´�ʹ��ATM��ȡ�����");
			System.exit(0);
			break;
		}
	}
	/**
	 * ����
	 * @param card
	 */
	public void saveMoney(BankCard card) throws MoneyOutOfBoundsException{
		log.debug("����Ϊ"+card.getCardId()+"�����п���ʼ���д��");
		System.out.println("��������Ľ�");
		int money = sc.nextInt();
		card.setBalance(card.getBalance()+money);
		System.out.println("���δ��:"+money+",��ǰ���Ϊ:"+card.getBalance());
		log.debug("����Ϊ"+card.getCardId()+"�����п�����ɴ��������"+money);
		//��ʾ���˵�
		showMainMenu(card);
	}
	/**
	 * ȡ���
	 * ����׳����Ƿ�RuntimeException�����Ҫʹ��throws����
	 * �����쳣ʱ�쳣�����ͷ�Χ������ڵ��ڵ�ǰ�Ѿ��׳����쳣����
	 * @param card
	 */
	public void getMoney(BankCard card) throws MoneyOutOfBoundsException{
		log.debug("����Ϊ"+card.getCardId()+"�����п���ʼ����ȡ��");
		System.out.println("������ȡ��Ľ�");
		int money = sc.nextInt();
		//�ж�ȡ��Ľ���Ƿ񳬳���ǰ���
		if(money > card.getBalance()){
			log.error("����Ϊ"+card.getCardId()+"�����п���ȡ��ʱ�����˶�ȣ�");
			//�׳��쳣
			throw new MoneyOutOfBoundsException("ȡ�������ȣ�ATM���Զ�������");
		}
		else{
			card.setBalance(card.getBalance()-money);
			log.info("����Ϊ"+card.getCardId()+"�����п�����˴����δ��"+money);
			//��ʾ���˵�
			showMainMenu(card);
		}
	}
	/**
	 * ��ѯ����
	 * @param card
	 */
	public void showBalance(BankCard card) throws MoneyOutOfBoundsException{
		System.out.println("��ǰ��"+card.getBalance());
		//�������˵�
		showMainMenu(card);
	}
}
