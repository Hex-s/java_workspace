package com.niit.game;
/**
 * 地图类
 * @author Administrator
 *
 */
public class Map {
	//整个地图使用数组表示，地图上的每一个格子即数组的每一个元素
	int[] map = new int[100];
	int[] luckyTurn = {6, 23, 40, 55, 69, 83}; //幸运轮盘  
	int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};   //地雷位置
	int[] pause = {9, 27, 60, 93};         //暂停
	int[] timeTunnel = {20, 25, 45, 63, 72, 79, 90};   //时空隧道
	
	/**
	 * 地图初始化
	 */
	public void init(){
		//0表示普通格子
		//幸运轮盘的值为1
		for(int i = 0; i < luckyTurn.length; i++){
			map[luckyTurn[i]] = 1;
		}
		//地雷的值是2
		for(int i = 0; i < landMine.length; i++){
			map[landMine[i]] = 2;
		}
		//暂停的值是3
		for(int i = 0; i < pause.length; i++){
			map[pause[i]] = 3;
		}
		//时空隧道的值是4
		for(int i = 0; i < timeTunnel.length; i++){
			map[timeTunnel[i]] = 4;
		}
	}
	/**
	 * 根据地图中的元素值获取该格子要显示的图案
	 * @param index 绘制地图时的索引
	 * @param player1 玩家1所在地图中的索引位置
	 * @param player2 玩家2所在地图中的索引位置
	 * @return 根据地图索引和玩家的位置绘制出的图案
	 */
	public String getGrahpic(int index, int player1, int player2){
		/*@@   两人重合时
		Ａ   玩家1
		Ｂ   玩家2
		◎   幸运轮盘
		★   地雷
		■   暂停
		〓   时空隧道
		∷   普通格*/
		String graphic ="  ";
		
		//玩家重叠时
		if(player1 == index && player2 == index ){
			graphic = "@@";
		}
		//当前玩家1在当前地图位置时
		else if(player1 == index){
			graphic = "Ａ";
		}
		//当前玩家2在当前地图位置时
		else if(player2 == index){
			graphic = "Ｂ";
		}
		else{
			//功能格子需要通过地图的值来进行判断
			switch(map[index]){
				case 1:
					graphic = "◎";
					break;
				case 2:
					graphic = "★";
					break;
				case 3:
					graphic = "■";
					break;
				case 4:
					graphic = "〓";
					break;
				default:
					graphic = "∷";
					break;
			}
		}
		
		return graphic;
	}
	/**
	 * 绘制地图的方法
	 * 地图的打印索引：
	 * 第一行 0-30
	 * 右竖列 31-34
     * 第二行 35-65
	 * 左竖列 66-68
	 * 第三行 69-99
	 */
	public void drawMap(int player1, int player2){
		//第一行
		for(int i = 0; i <= 30; i++){
			System.out.print(getGrahpic(i, player1, player2));
		}
		//换行
		System.out.println();
		//右竖列
		for(int i = 31; i <= 34; i++){
			for(int j = 1; j <= 30; j++){
				System.out.print("　");
			}
			System.out.println(getGrahpic(i, player1, player2));
		}
		//第二行
		for(int i = 65; i >= 35; i--){
			System.out.print(getGrahpic(i, player1, player2));
		}
		//换行
		System.out.println();
		//左竖列
		for(int i = 66; i <= 68; i++){
			System.out.println(getGrahpic(i, player1, player2));
		}
		//第三行
		for(int i = 69; i <= 99; i++){
			System.out.print(getGrahpic(i, player1, player2));
		}
		System.out.println();
	}
}
