package com.niit.game;

import java.util.Scanner;

/**
 * 游戏类
 * @author Administrator
 * 
 */
public class Game {
	// 玩家
	Player[] player;
	// 地图
	Map map;

	Scanner sc = new Scanner(System.in);

	/**
	 * 游戏初始化的方法
	 */
	public void initGame() {
		// 实例化地图
		map = new Map();
		// 初始化地图
		map.init();
		// 实例化玩家
		player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
	}

	/**
	 * 开始游戏的方法
	 */
	public void startGame() {
		//初始化游戏
		initGame();
		// 选择玩家的昵称
		for (int i = 0; i < player.length; i++) {
			System.out.print("请输入玩家" + (i + 1) + "的昵称:");
			player[i].playerName = sc.next();
		}
		System.out.println("-----------------------游戏开始！--------------------------"+"\n");
		// 打印目前游戏状态
		showIndex();
		// 开始游戏
		gameLogic(0);

	}

	/**
	 * 游戏逻辑过程的方法 
	 * @param num 玩家1的索引位置
	 */
	public void gameLogic(int num) {

		// 判断玩家是否暂停
		// 如果不是暂停，玩家扔骰子
		if (!player[num].pauseState) {
			
			//选择是否继续游戏
			System.out.print("是否继续游戏（y/n）：");
			String choose = sc.next();
			if(choose.equals("n")){
				System.out.println("中途退出游戏！");
				System.exit(0);
			}
			
			// 玩家1扔骰子
			int random = player[num].random();
			System.out.println(player[num].playerName + "的点数为：" + random);
			// 玩家前进
			player[num].index += random;
			// 判断玩家扔骰子后游戏是否可以结束，是否和另外一个玩家的位置重叠
			calculatIndex(num);
			// 对玩家1的位置进行判断
			switchMap(num, random);
		} 
		//玩家暂停
		else {
			player[num].pauseState = false;
		}
		// 第二个玩家进行游戏
		gameLogic(1-num);

	}

	/**
	 * 判断玩家扔骰子后游戏是否可以结束，是否和另外一个玩家的位置重叠
	 * 
	 * @param num 玩家1的索引位置
	 * @param random 玩家扔的骰子数
	 */
	public void calculatIndex(int num) {

		int length = map.map.length-1;
		// 任意玩家到达终点的时候游戏结束
		if (player[num].index == length) {
			showIndex();
			System.out.println("\n"+"-----------------------游戏结束！--------------------------");
			System.out.println("最终获胜者是：" + player[num].playerName);
			System.exit(0);

		}
		// 玩家扔的骰子数超过终点时将会根据目前的格子数倒退
		else if (player[num].index > length) {
			player[num].index = 2 * length - player[num].index;
		}
	}

	/**
	 * 对玩家的目前所处的位置进行判断，根据map的情况进行位置的调整
	 * @param num 玩家1的索引位置
	 * @param random 玩家1所扔的骰子数
	 */
	public void switchMap(int num, int random) {
		
		// 如果玩家1所在位置玩家2的位置，则玩家2被踩回起点
		if (player[num].index == player[1-num].index) {
			showIndex();
			System.out.println(player[num].playerName + "的位置与" + player[1-num].playerName+ "的位置重叠啦，" + player[1-num].playerName + "被踩回了原点！");
			player[1-num].index = 0;

		}
		int state = map.map[player[num].index];
		// 1.幸运轮盘 
		if (state == 1) {
			//如果扔的是123则玩家位置互换
			if (random >= 1 && random <= 3) {
				showIndex();
				System.out.println(player[num].playerName + "到达了幸运转盘，与"
						+ player[1-num].playerName + "的位置互换！");
				//玩家位置互换
				int temp = player[num].index;
				player[num].index = player[1-num].index;
				player[1-num].index = temp;
				showIndex();
			} 
			//如果扔的是456则多获得一次扔骰子的机会
			else if (random >= 4 && random <= 6) {
				showIndex();
				System.out.println("恭喜" + player[num].playerName
						+ "到达了幸运转盘，多获得一次扔骰子的机会");
				
				player[1-num].pauseState = true;
				
			}
		}
		// 2.地雷 玩家后退6格
		else if (state == 2) {
			showIndex();
			System.out.println("玩家" + player[num].playerName + "踩到了地雷，后退6步！");
			if (player[num].index < 6) {
				player[num].index = 0;
			} else {
				player[num].index -= 6;
			}
			//考虑后退后的情况
			switchMap(num, 0);
		}
		// 3.暂停 玩家暂停一轮
		else if (state == 3) {
			showIndex();
			System.out.println(player[num].playerName + "暂停一轮！");
			player[num].pauseState = true;
		}
		// 4.时空隧道 玩家前进至下一个时空隧道的位置
		else if (state == 4) {
			showIndex();
			//玩家不在最后一个时空隧道上
			if (player[num].index != map.timeTunnel[map.timeTunnel.length - 1]) {
				System.out.println(player[num].playerName + "进入了时空隧道，飞速前进！");
				//玩家进入下一个时空隧道
				for (int i = player[num].index + 1; i < map.map.length; i++) {
					if (map.map[i] == 4) {
						player[num].index = i;
						break;
					}
				}
				showIndex();
			}
		} 
		//玩家到达的地点是普通的格子
		else {
			showIndex();
		}

	}
	/**
	 * 打印目前map的情况，以及玩家的位置
	 */
	public void showIndex() {
		map.drawMap(player[0].index, player[1].index);
		System.out.println(player[0].playerName + "所在位置为：" + player[0].index+ "，" + player[1].playerName + "所在位置为：" + player[1].index);
	}
}
