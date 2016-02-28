package com.niit.game;

import java.util.Scanner;

/**
 * ��Ϸ��
 * @author Administrator
 * 
 */
public class Game {
	// ���
	Player[] player;
	// ��ͼ
	Map map;

	Scanner sc = new Scanner(System.in);

	/**
	 * ��Ϸ��ʼ���ķ���
	 */
	public void initGame() {
		// ʵ������ͼ
		map = new Map();
		// ��ʼ����ͼ
		map.init();
		// ʵ�������
		player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
	}

	/**
	 * ��ʼ��Ϸ�ķ���
	 */
	public void startGame() {
		//��ʼ����Ϸ
		initGame();
		// ѡ����ҵ��ǳ�
		for (int i = 0; i < player.length; i++) {
			System.out.print("���������" + (i + 1) + "���ǳ�:");
			player[i].playerName = sc.next();
		}
		System.out.println("-----------------------��Ϸ��ʼ��--------------------------"+"\n");
		// ��ӡĿǰ��Ϸ״̬
		showIndex();
		// ��ʼ��Ϸ
		gameLogic(0);

	}

	/**
	 * ��Ϸ�߼����̵ķ��� 
	 * @param num ���1������λ��
	 */
	public void gameLogic(int num) {

		// �ж�����Ƿ���ͣ
		// ���������ͣ�����������
		if (!player[num].pauseState) {
			
			//ѡ���Ƿ������Ϸ
			System.out.print("�Ƿ������Ϸ��y/n����");
			String choose = sc.next();
			if(choose.equals("n")){
				System.out.println("��;�˳���Ϸ��");
				System.exit(0);
			}
			
			// ���1������
			int random = player[num].random();
			System.out.println(player[num].playerName + "�ĵ���Ϊ��" + random);
			// ���ǰ��
			player[num].index += random;
			// �ж���������Ӻ���Ϸ�Ƿ���Խ������Ƿ������һ����ҵ�λ���ص�
			calculatIndex(num);
			// �����1��λ�ý����ж�
			switchMap(num, random);
		} 
		//�����ͣ
		else {
			player[num].pauseState = false;
		}
		// �ڶ�����ҽ�����Ϸ
		gameLogic(1-num);

	}

	/**
	 * �ж���������Ӻ���Ϸ�Ƿ���Խ������Ƿ������һ����ҵ�λ���ص�
	 * 
	 * @param num ���1������λ��
	 * @param random ����ӵ�������
	 */
	public void calculatIndex(int num) {

		int length = map.map.length-1;
		// ������ҵ����յ��ʱ����Ϸ����
		if (player[num].index == length) {
			showIndex();
			System.out.println("\n"+"-----------------------��Ϸ������--------------------------");
			System.out.println("���ջ�ʤ���ǣ�" + player[num].playerName);
			System.exit(0);

		}
		// ����ӵ������������յ�ʱ�������Ŀǰ�ĸ���������
		else if (player[num].index > length) {
			player[num].index = 2 * length - player[num].index;
		}
	}

	/**
	 * ����ҵ�Ŀǰ������λ�ý����жϣ�����map���������λ�õĵ���
	 * @param num ���1������λ��
	 * @param random ���1���ӵ�������
	 */
	public void switchMap(int num, int random) {
		
		// ������1����λ�����2��λ�ã������2���Ȼ����
		if (player[num].index == player[1-num].index) {
			showIndex();
			System.out.println(player[num].playerName + "��λ����" + player[1-num].playerName+ "��λ���ص�����" + player[1-num].playerName + "���Ȼ���ԭ�㣡");
			player[1-num].index = 0;

		}
		int state = map.map[player[num].index];
		// 1.�������� 
		if (state == 1) {
			//����ӵ���123�����λ�û���
			if (random >= 1 && random <= 3) {
				showIndex();
				System.out.println(player[num].playerName + "����������ת�̣���"
						+ player[1-num].playerName + "��λ�û�����");
				//���λ�û���
				int temp = player[num].index;
				player[num].index = player[1-num].index;
				player[1-num].index = temp;
				showIndex();
			} 
			//����ӵ���456�����һ�������ӵĻ���
			else if (random >= 4 && random <= 6) {
				showIndex();
				System.out.println("��ϲ" + player[num].playerName
						+ "����������ת�̣�����һ�������ӵĻ���");
				
				player[1-num].pauseState = true;
				
			}
		}
		// 2.���� ��Һ���6��
		else if (state == 2) {
			showIndex();
			System.out.println("���" + player[num].playerName + "�ȵ��˵��ף�����6����");
			if (player[num].index < 6) {
				player[num].index = 0;
			} else {
				player[num].index -= 6;
			}
			//���Ǻ��˺�����
			switchMap(num, 0);
		}
		// 3.��ͣ �����ͣһ��
		else if (state == 3) {
			showIndex();
			System.out.println(player[num].playerName + "��ͣһ�֣�");
			player[num].pauseState = true;
		}
		// 4.ʱ����� ���ǰ������һ��ʱ�������λ��
		else if (state == 4) {
			showIndex();
			//��Ҳ������һ��ʱ�������
			if (player[num].index != map.timeTunnel[map.timeTunnel.length - 1]) {
				System.out.println(player[num].playerName + "������ʱ�����������ǰ����");
				//��ҽ�����һ��ʱ�����
				for (int i = player[num].index + 1; i < map.map.length; i++) {
					if (map.map[i] == 4) {
						player[num].index = i;
						break;
					}
				}
				showIndex();
			}
		} 
		//��ҵ���ĵص�����ͨ�ĸ���
		else {
			showIndex();
		}

	}
	/**
	 * ��ӡĿǰmap��������Լ���ҵ�λ��
	 */
	public void showIndex() {
		map.drawMap(player[0].index, player[1].index);
		System.out.println(player[0].playerName + "����λ��Ϊ��" + player[0].index+ "��" + player[1].playerName + "����λ��Ϊ��" + player[1].index);
	}
}
