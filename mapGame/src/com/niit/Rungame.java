package com.niit;

import java.util.Scanner;

public class Rungame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化
		Map map = new Map();
		Game game = new Game();
		Scanner sc = new Scanner(System.in);
		System.out.println("请选择玩家数");
		int peopleNum = sc.nextInt();
		
		//输入玩家昵称
		game.init(peopleNum);
		game.playerName(peopleNum);
		
		game.rulesGame(peopleNum);
		//打印地图
		//map.showMap(player);
	}

}
