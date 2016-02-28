package com.niit;

public class Map {
	int[] map = new int[100];
	//幸运轮盘  
	int[] luckyTurn = {6, 23, 40, 55, 69, 83}; 
	 //地雷位置
	int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};  
	  //暂停
	int[] pause = {9, 27, 60, 93};    
	//时空隧道
	int[] timeTunnel = {20, 25, 45, 63, 72, 79, 90};   
	
	/**
	 * 初始化
	 */
	public void init(){
		//幸运轮盘的值为1；
		for(int  i = 0;i<luckyTurn.length;i++){
			map[luckyTurn[i]]=1;
		}
		//地雷的值是2
		for (int i = 0;i<landMine.length;i++){
			map[landMine[i]]=2;
		}
		//暂停的值是3
		for(int i = 0;i<pause.length;i++){
			map[pause[i]]=3;
		}
		//时空隧道的值是4
		for(int i = 0;i<timeTunnel.length;i++){
			map[timeTunnel[i]]=4;
		}
		
	}
	/**
	 * 根据地图中的元素值获取该格子要显示的图案
	 * @param index 绘制地图时的索引
	 * @param player1 玩家1所在地图中的索引位置
	 * @param player2 玩家2所在地图中的索引位置
	 * @return 根据地图的索引和玩家的位置绘制出的图案
	 */
	public String getGrahpic(int index,Player player[]){
		String graphic ="";
		//玩家重叠时
		for(int i =0;i<player.length;i++){
			if(player[i].index == index){
				for(int j = i+1;j<player.length;j++){
					if(player[j].index ==index){
						if(graphic==""){
							graphic += "@@";
						}
						
						break;
					}
					
			}
			if(graphic==""){
				graphic += (char)('Ａ'+i);
			}
			
			
			//break;	
			}
			
		}
		
		
		//功能格子需要通过地图的值来进行判断
		if(graphic==""){
			switch (map[index]) {
			case 1:
				graphic="◎";
				break;
			case 2:
				graphic = "★";
				break;
			case 3:
				graphic = "▉";
				break;
			case 4:
				graphic = "〓";
				break;

			default:
				graphic="∷";
				break;
			
		}
		}
			
		
		return graphic;
	}
	
	/**
	 * 打印地图
	 */
	public void showMap(Player player[]){
		init();
		//第一行打印
		for(int i = 0;i<=30;i++){
			System.out.print(getGrahpic(i,player));
		}
		System.out.println();
		//右竖行打印
		for(int i = 31;i<=34;i++){
			for(int j = 0;j<30;j++){
				System.out.print("　");
			}
			System.out.println(getGrahpic(i, player));
		}
		//第二行打印
		for(int i = 65;i>=35;i--){
			System.out.print(getGrahpic(i, player));
		}
		System.out.println();
		//左竖行打印
		for(int i = 66;i<=68;i++){
			System.out.println(getGrahpic(i, player));
		}
		//第三行打印
		for(int i = 69;i<=99;i++){
			System.out.print(getGrahpic(i, player));
		}
		System.out.println();
	
		
	}
}
