package com.niit.exam1;
/**
 * �˿�����
 * @author Administrator
 *
 */
public class Poker {
//	//��ɫ
//	private int type;
	
//	//ʹ�ó����������еĻ�ɫ��������Ӧ��д
//	public static final int HEART = 1;
//	public static final int SPADE = 2;
//	public static final int CLUB = 3;
//	public static final int DIAMOND = 4;
	
	//����
	private int num;                                                                                  
	//ʹ��ö������������ɫ
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
		System.out.println("�˿��ƵĻ�ɫ�ǣ�"+type.getName()+",�����ǣ�"+num);
	}
//	public String getTypeName(int type){
//		String typeName = "";
//		switch(type){
//		case 1:
//			typeName = "����";
//			break;
//		case 2:
//			typeName = "����";
//			break;
//		case 3:
//			typeName = "÷��";
//			break;
//		case 4:
//			typeName = "����";
//			break;
//		}
//		return typeName;
//	}
}
