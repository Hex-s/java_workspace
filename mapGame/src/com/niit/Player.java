package com.niit;

import java.util.Random;
import java.util.Scanner;

/**
 * 玩家类
 * @author Administrator
 *
 */
public class Player {
	//玩家昵称
	String name;
	//玩家当前所在地图的位置
	int index ;
	//暂停的状态
	boolean isStop ;
	//判断是否打印
	boolean isDraw;
	//判断是否赢了
	boolean isWin;
	Scanner sc;
	//仍骰子（1-6）的方法
	public int getRandomNum(int num){
		System.out.println("按任意键开始扔骰子");
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random random = new Random();
		int rand = random.nextInt(6)+1;
//		System.out.println("请玩家"+(num+1)+"输入前进几步");
//		rand = sc.nextInt();
 
		return rand;
	}
	
}
