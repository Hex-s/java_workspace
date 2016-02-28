package com.niit;

import java.util.Random;
import java.util.Scanner;

/**
 * ��Ϸ��
 * @author Administrator
 *
 */
public class Game {
	//���
	Player[] player;
	//��ͼ
	 Map map;
	 
	 
	 /**
	  * ��Ϸ��ʼ���ķ���
	  */
	 public void init(int peopleNum){
		 //2�����
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
	  * ��ʼ��Ϸ�ķ���
	  */
	 public void playerName(int peopleNum){
		//ѡ����ҵ��ǳ�
		 
		 Scanner sc = new Scanner(System.in); 
		 
		 for(int i=0;i<peopleNum;i++){
			 char show = '��';
			 show +=i;
			 System.out.println("���������"+(i+1)+"�ǳ�,�ڵ�ͼ�ϱ�ʾΪ"+show);
			 player[i].name = sc.next();
		 }
		 
	 }
	
	 
	 
	 /**
	  * ��Ϸ�߼����̵ķ���
	  */
	  public void rulesGame(int peopleNum){
		  for(int i = 0;i<peopleNum;i++){
			  process(i,peopleNum);
		  }
			//�ݹ�
			rulesGame(peopleNum);
		  
		 
		
	  }
	  
	 /**
	  * �����Ϸ 
	  * @param num
	  */
	  public void process(int num,int peopleNum){
		  //�ж��Ƿ���ͣ
		  if(!player[num].isStop){
			  System.out.println("���"+player[num].name+"��ʼ������");
			  
			  
			 int rand = playerGame(num);
			  //���λ�������ڵ�ͼ�ϵ����
			  positionJudge(rand, num,peopleNum);
			  //��ӡ��ͼ
			   map.showMap(player);
			  
			  
		  }
		  else{
			  player[num].isStop = false;
			 
		  }
	  }
	  /**
	   * �������Ϸ
	   * @param num ��ҵ�����
	   * @return
	   */
	 public int playerGame(int num){
		 int rand = player[num].getRandomNum(num);
		 System.out.println("���õ�������Ϊ"+rand);
		 
		 //�ж��Ƿ񳬹���ͼ�ĳ���
		 //���������򷵻�
		 if(player[num].index+rand>map.map.length-1){
			 player[num].index=99-(rand-(99-player[num].index));
		 }
		 //�ж��Ƿ�ɹ�
		 else if(player[num].index+rand == map.map.length-1){
			 System.out.println(player[num].name+"�����ʤ��");
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
	  * ��ʶ������ڵ�ͼ��λ�õ����
	  * @param rand �������ӵ���
	  * @param num ��ҵ�����
	  */
	 public void positionJudge(int rand,int num,int peopleNum){
		 
		 //�ж��Ƿ�λ����ͬ
		 if(player[num].index!=0){
			 isSame(num,peopleNum);
		 }
		 //�ж����ȵ�λ����ʲô
		 switch (map.map[player[num].index]) {
			case 1:
				//��������
				System.out.println("����������ת");
				luckyTurn(rand,num,peopleNum);
				break;
			case 2:
				//2.���� ����6���迼�Ǻ��˺�����
				System.out.println("���ȵ������ˣ����˺�6��");
				landMine(rand,num,peopleNum);				
				break;
			case 3:
				//3.��ͣ �����ͣһ��
				System.out.println("���ȵ���ͣ�ˣ�����ͣһ��");
				pause(num);				
				break;
			case 4:
				//4.ʱ����� ���ǰ������һ��ʱ�������λ��
				System.out.println("����ʱ�����");
				timeTunnel(num);
				break;
			default:
				break;
			}
		 
		 
		 
	 }
	 
	  
	 /**
	  * ��������
	  * @param rand ����������
	  * @param num �������
	  */
	 public void luckyTurn(int rand,int num,int peopleNum){
		//1.�������� ����ӵ���123�������λ�û���������ӵ���456�����һ�������ӵĻ���
		 switch (rand) {
		case 1:
		case 2:
		case 3:
			System.out.println("��������һ������軥��λ��");
			int randNum;
			while(true){
				randNum = turn(peopleNum);
				if(randNum!=num+1){
					break;
				}
			}
			System.out.println("�����ӵã�"+randNum+"���������"+randNum+"����");
			int temp = player[num].index;
			player[num].index = player[randNum-1].index;
			player[randNum-1].index = temp;
			positionJudge(rand, num,peopleNum);
			break;

		default:
			System.out.println("������һ�������ӵĻ���");
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
	  * �ȵ�����
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
	  * ��ͣ
	  * @param num ��ҵ�����
	  */
	 public void pause(int num){
		 player[num].isStop = true;
	 }
	 /**
	  * ʱ�����
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
	  * ��ҵ�λ���Ƿ����
	  * @param num
	  */
	 public void isSame(int num,int peopleNum){
		//5.�������λ�������2�������2���Ȼ����
		 for(int i = 0;i<peopleNum;i++){
			 if(i!=num){
				 if(player[num].index == player[i].index){
					 System.out.println("���"+(i+1)+"�������ˣ����������");
					 player[i].index = 0;
					 break;
				 }
			 }
		 }
		 
	 }
	 
	
	 
	 
}
