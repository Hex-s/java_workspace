package com.niit;

import java.util.Random;
import java.util.Scanner;

/**
 * �����
 * @author Administrator
 *
 */
public class Player {
	//����ǳ�
	String name;
	//��ҵ�ǰ���ڵ�ͼ��λ��
	int index ;
	//��ͣ��״̬
	boolean isStop ;
	//�ж��Ƿ��ӡ
	boolean isDraw;
	//�ж��Ƿ�Ӯ��
	boolean isWin;
	Scanner sc;
	//�����ӣ�1-6���ķ���
	public int getRandomNum(int num){
		System.out.println("���������ʼ������");
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random random = new Random();
		int rand = random.nextInt(6)+1;
//		System.out.println("�����"+(num+1)+"����ǰ������");
//		rand = sc.nextInt();
 
		return rand;
	}
	
}
