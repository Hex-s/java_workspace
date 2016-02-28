package com.niit.game;
/**
 * ��ͼ��
 * @author Administrator
 *
 */
public class Map {
	//������ͼʹ�������ʾ����ͼ�ϵ�ÿһ�����Ӽ������ÿһ��Ԫ��
	int[] map = new int[100];
	int[] luckyTurn = {6, 23, 40, 55, 69, 83}; //��������  
	int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};   //����λ��
	int[] pause = {9, 27, 60, 93};         //��ͣ
	int[] timeTunnel = {20, 25, 45, 63, 72, 79, 90};   //ʱ�����
	
	/**
	 * ��ͼ��ʼ��
	 */
	public void init(){
		//0��ʾ��ͨ����
		//�������̵�ֵΪ1
		for(int i = 0; i < luckyTurn.length; i++){
			map[luckyTurn[i]] = 1;
		}
		//���׵�ֵ��2
		for(int i = 0; i < landMine.length; i++){
			map[landMine[i]] = 2;
		}
		//��ͣ��ֵ��3
		for(int i = 0; i < pause.length; i++){
			map[pause[i]] = 3;
		}
		//ʱ�������ֵ��4
		for(int i = 0; i < timeTunnel.length; i++){
			map[timeTunnel[i]] = 4;
		}
	}
	/**
	 * ���ݵ�ͼ�е�Ԫ��ֵ��ȡ�ø���Ҫ��ʾ��ͼ��
	 * @param index ���Ƶ�ͼʱ������
	 * @param player1 ���1���ڵ�ͼ�е�����λ��
	 * @param player2 ���2���ڵ�ͼ�е�����λ��
	 * @return ���ݵ�ͼ��������ҵ�λ�û��Ƴ���ͼ��
	 */
	public String getGrahpic(int index, int player1, int player2){
		/*@@   �����غ�ʱ
		��   ���1
		��   ���2
		��   ��������
		��   ����
		��   ��ͣ
		��   ʱ�����
		��   ��ͨ��*/
		String graphic ="  ";
		
		//����ص�ʱ
		if(player1 == index && player2 == index ){
			graphic = "@@";
		}
		//��ǰ���1�ڵ�ǰ��ͼλ��ʱ
		else if(player1 == index){
			graphic = "��";
		}
		//��ǰ���2�ڵ�ǰ��ͼλ��ʱ
		else if(player2 == index){
			graphic = "��";
		}
		else{
			//���ܸ�����Ҫͨ����ͼ��ֵ�������ж�
			switch(map[index]){
				case 1:
					graphic = "��";
					break;
				case 2:
					graphic = "��";
					break;
				case 3:
					graphic = "��";
					break;
				case 4:
					graphic = "��";
					break;
				default:
					graphic = "��";
					break;
			}
		}
		
		return graphic;
	}
	/**
	 * ���Ƶ�ͼ�ķ���
	 * ��ͼ�Ĵ�ӡ������
	 * ��һ�� 0-30
	 * ������ 31-34
     * �ڶ��� 35-65
	 * ������ 66-68
	 * ������ 69-99
	 */
	public void drawMap(int player1, int player2){
		//��һ��
		for(int i = 0; i <= 30; i++){
			System.out.print(getGrahpic(i, player1, player2));
		}
		//����
		System.out.println();
		//������
		for(int i = 31; i <= 34; i++){
			for(int j = 1; j <= 30; j++){
				System.out.print("��");
			}
			System.out.println(getGrahpic(i, player1, player2));
		}
		//�ڶ���
		for(int i = 65; i >= 35; i--){
			System.out.print(getGrahpic(i, player1, player2));
		}
		//����
		System.out.println();
		//������
		for(int i = 66; i <= 68; i++){
			System.out.println(getGrahpic(i, player1, player2));
		}
		//������
		for(int i = 69; i <= 99; i++){
			System.out.print(getGrahpic(i, player1, player2));
		}
		System.out.println();
	}
}
