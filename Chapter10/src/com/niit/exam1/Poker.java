package com.niit.exam1;
/**
 * 扑克牌类
 * @author Administrator
 *
 */
public class Poker {
//	//花色
//	private int type;
	
//	//使用常量描述所有的花色，常量名应大写
//	public static final int HEART = 1;
//	public static final int SPADE = 2;
//	public static final int CLUB = 3;
//	public static final int DIAMOND = 4;
	
	//数字
	private int num;                                                                                  
	//使用枚举类型描述花色
	private PokerEnum type;
	
//	public Poker(int type, int num){
//		this.type = type;
//		this.num = num;
//	}
	
	public Poker(PokerEnum type, int num){
		this.type = type;
		this.num = num;
	}
	
	public void details(){
		System.out.println("扑克牌的花色是："+type.getName()+",数字是："+num);
	}
//	public String getTypeName(int type){
//		String typeName = "";
//		switch(type){
//		case 1:
//			typeName = "红桃";
//			break;
//		case 2:
//			typeName = "黑桃";
//			break;
//		case 3:
//			typeName = "梅花";
//			break;
//		case 4:
//			typeName = "方块";
//			break;
//		}
//		return typeName;
//	}
}
