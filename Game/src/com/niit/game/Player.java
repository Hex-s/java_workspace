package com.niit.game;

import java.util.Random;

/**
 * �����
 * @author Administrator
 *
 */
public class Player {
	//��ҵ��ǳ�
	String playerName;
	//��ҵ�ǰ���ڵ�ͼ��λ��
	int index = 0;
	//��ͣ��״̬
	boolean pauseState = false;
	/**
	 * ������(1-6)�ķ���
	 * @return
	 */
	public int random(){
		Random random = new Random();
		int num = random.nextInt(6)+1;
		return num;
	}
}
