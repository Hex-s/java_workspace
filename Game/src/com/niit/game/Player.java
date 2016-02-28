package com.niit.game;

import java.util.Random;

/**
 * 玩家类
 * @author Administrator
 *
 */
public class Player {
	//玩家的昵称
	String playerName;
	//玩家当前所在地图的位置
	int index = 0;
	//暂停的状态
	boolean pauseState = false;
	/**
	 * 扔骰子(1-6)的方法
	 * @return
	 */
	public int random(){
		Random random = new Random();
		int num = random.nextInt(6)+1;
		return num;
	}
}
