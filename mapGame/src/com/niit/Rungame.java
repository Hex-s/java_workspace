package com.niit;

import java.util.Scanner;

public class Rungame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʵ����
		Map map = new Map();
		Game game = new Game();
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ�������");
		int peopleNum = sc.nextInt();
		
		//��������ǳ�
		game.init(peopleNum);
		game.playerName(peopleNum);
		
		game.rulesGame(peopleNum);
		//��ӡ��ͼ
		//map.showMap(player);
	}

}
