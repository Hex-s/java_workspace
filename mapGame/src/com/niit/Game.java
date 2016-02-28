package com.niit;

import java.util.Random;
import java.util.Scanner;

/**
 * 游戏类
 * @author Administrator
 *
 */
public class Game {
	//玩家
	Player[] player;
	//地图
	 Map map;
	 
	 
	 /**
	  * 游戏初始化的方法
	  */
	 public void init(int peopleNum){
		 //2个玩家
		 player = new Player[peopleNum];
		 for(int i =0;i<player.length;i++){
			 player[i] = new Player();
			 player[i].index = 0;
			 player[i].isStop = false;
			 player[i].isDraw = true;
			 player[i].isWin = false;
		 }
		 map = new Map();
		 map.init();
	 }
	 
	 /**
	  * 开始游戏的方法
	  */
	 public void playerName(int peopleNum){
		//选择玩家的昵称
		 
		 Scanner sc = new Scanner(System.in); 
		 
		 for(int i=0;i<peopleNum;i++){
			 char show = 'Ａ';
			 show +=i;
			 System.out.println("请输入玩家"+(i+1)+"昵称,在地图上表示为"+show);
			 player[i].name = sc.next();
		 }
		 
	 }
	
	 
	 
	 /**
	  * 游戏逻辑过程的方法
	  */
	  public void rulesGame(int peopleNum){
		  for(int i = 0;i<peopleNum;i++){
			  process(i,peopleNum);
		  }
			//递归
			rulesGame(peopleNum);
		  
		 
		
	  }
	  
	 /**
	  * 玩家游戏 
	  * @param num
	  */
	  public void process(int num,int peopleNum){
		  //判断是否暂停
		  if(!player[num].isStop){
			  System.out.println("玩家"+player[num].name+"开始掷骰子");
			  
			  
			 int rand = playerGame(num);
			  //玩家位置在所在地图上的情况
			  positionJudge(rand, num,peopleNum);
			  //打印地图
			   map.showMap(player);
			  
			  
		  }
		  else{
			  player[num].isStop = false;
			 
		  }
	  }
	  /**
	   * 玩家玩游戏
	   * @param num 玩家的索引
	   * @return
	   */
	 public int playerGame(int num){
		 int rand = player[num].getRandomNum(num);
		 System.out.println("掷得得骰子数为"+rand);
		 
		 //判断是否超过地图的长度
		 //若超过，则返回
		 if(player[num].index+rand>map.map.length-1){
			 player[num].index=99-(rand-(99-player[num].index));
		 }
		 //判断是否成功
		 else if(player[num].index+rand == map.map.length-1){
			 System.out.println(player[num].name+"获得了胜利");
			 player[num].index+=rand;
			 map.showMap(player);
			 System.exit(0);
		 }
		 else{
			 player[num].index+=rand;
		 }
		 
		return rand;
	 }
	 /**
	  * 辨识玩家所在地图的位置的情况
	  * @param rand 所掷骰子的数
	  * @param num 玩家的索引
	  */
	 public void positionJudge(int rand,int num,int peopleNum){
		 
		 //判断是否位置相同
		 if(player[num].index!=0){
			 isSame(num,peopleNum);
		 }
		 //判断所踩的位置是什么
		 switch (map.map[player[num].index]) {
			case 1:
				//幸运轮盘
				System.out.println("进入幸运轮转");
				luckyTurn(rand,num,peopleNum);
				break;
			case 2:
				//2.地雷 后退6格，需考虑后退后的情况
				System.out.println("您踩到地雷了，请退后6格");
				landMine(rand,num,peopleNum);				
				break;
			case 3:
				//3.暂停 玩家暂停一轮
				System.out.println("您踩到暂停了，需暂停一次");
				pause(num);				
				break;
			case 4:
				//4.时空隧道 玩家前进至下一个时空隧道的位置
				System.out.println("进入时空隧道");
				timeTunnel(num);
				break;
			default:
				break;
			}
		 
		 
		 
	 }
	 
	  
	 /**
	  * 幸运轮盘
	  * @param rand 所掷骰子数
	  * @param num 玩家索引
	  */
	 public void luckyTurn(int rand,int num,int peopleNum){
		//1.幸运轮盘 如果扔的是123，则玩家位置互换，如果扔的是456则多获得一次扔骰子的机会
		 switch (rand) {
		case 1:
		case 2:
		case 3:
			System.out.println("您和另外一个玩家需互换位置");
			int randNum;
			while(true){
				randNum = turn(peopleNum);
				if(randNum!=num+1){
					break;
				}
			}
			System.out.println("掷骰子得："+randNum+"，您跟玩家"+randNum+"交换");
			int temp = player[num].index;
			player[num].index = player[randNum-1].index;
			player[randNum-1].index = temp;
			positionJudge(rand, num,peopleNum);
			break;

		default:
			System.out.println("您多获得一次扔骰子的机会");
			 rand = playerGame(num);
			positionJudge(rand, num, peopleNum);
			break;
		}
	 }
	 public int turn(int peopleNum){
		 Random random = new Random();
		 int randNum = random.nextInt(peopleNum)+1;
		 return randNum;
	 }
	 
	 /**
	  * 踩到地雷
	  */
	 public void landMine(int rand,int num,int peopleNum){
		 player[num].index-=6; 
		 if(player[num].index<0){
			 player[num].index = 0;
		 }
		 else{
			 positionJudge(rand, num,peopleNum);
		 }
	 }
	 /**
	  * 暂停
	  * @param num 玩家的索引
	  */
	 public void pause(int num){
		 player[num].isStop = true;
	 }
	 /**
	  * 时空隧道
	  * @param num
	  */
	 public void timeTunnel(int num){
		 for(int i = player[num].index+1;i<map.map.length;i++){
			 if(map.map[i]==4){
				 player[num].index = i;
				 break;
			 }
		 }
	 }
	 
	 /**
	  * 玩家的位置是否相等
	  * @param num
	  */
	 public void isSame(int num,int peopleNum){
		//5.如果所在位置是玩家2，则玩家2被踩会起点
		 for(int i = 0;i<peopleNum;i++){
			 if(i!=num){
				 if(player[num].index == player[i].index){
					 System.out.println("玩家"+(i+1)+"被超过了，请回起点继续");
					 player[i].index = 0;
					 break;
				 }
			 }
		 }
		 
	 }
	 
	
	 
	 
}
