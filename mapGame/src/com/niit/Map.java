package com.niit;

public class Map {
	int[] map = new int[100];
	//��������  
	int[] luckyTurn = {6, 23, 40, 55, 69, 83}; 
	 //����λ��
	int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};  
	  //��ͣ
	int[] pause = {9, 27, 60, 93};    
	//ʱ�����
	int[] timeTunnel = {20, 25, 45, 63, 72, 79, 90};   
	
	/**
	 * ��ʼ��
	 */
	public void init(){
		//�������̵�ֵΪ1��
		for(int  i = 0;i<luckyTurn.length;i++){
			map[luckyTurn[i]]=1;
		}
		//���׵�ֵ��2
		for (int i = 0;i<landMine.length;i++){
			map[landMine[i]]=2;
		}
		//��ͣ��ֵ��3
		for(int i = 0;i<pause.length;i++){
			map[pause[i]]=3;
		}
		//ʱ�������ֵ��4
		for(int i = 0;i<timeTunnel.length;i++){
			map[timeTunnel[i]]=4;
		}
		
	}
	/**
	 * ���ݵ�ͼ�е�Ԫ��ֵ��ȡ�ø���Ҫ��ʾ��ͼ��
	 * @param index ���Ƶ�ͼʱ������
	 * @param player1 ���1���ڵ�ͼ�е�����λ��
	 * @param player2 ���2���ڵ�ͼ�е�����λ��
	 * @return ���ݵ�ͼ����������ҵ�λ�û��Ƴ���ͼ��
	 */
	public String getGrahpic(int index,Player player[]){
		String graphic ="";
		//����ص�ʱ
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
				graphic += (char)('��'+i);
			}
			
			
			//break;	
			}
			
		}
		
		
		//���ܸ�����Ҫͨ����ͼ��ֵ�������ж�
		if(graphic==""){
			switch (map[index]) {
			case 1:
				graphic="��";
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
				graphic="��";
				break;
			
		}
		}
			
		
		return graphic;
	}
	
	/**
	 * ��ӡ��ͼ
	 */
	public void showMap(Player player[]){
		init();
		//��һ�д�ӡ
		for(int i = 0;i<=30;i++){
			System.out.print(getGrahpic(i,player));
		}
		System.out.println();
		//�����д�ӡ
		for(int i = 31;i<=34;i++){
			for(int j = 0;j<30;j++){
				System.out.print("��");
			}
			System.out.println(getGrahpic(i, player));
		}
		//�ڶ��д�ӡ
		for(int i = 65;i>=35;i--){
			System.out.print(getGrahpic(i, player));
		}
		System.out.println();
		//�����д�ӡ
		for(int i = 66;i<=68;i++){
			System.out.println(getGrahpic(i, player));
		}
		//�����д�ӡ
		for(int i = 69;i<=99;i++){
			System.out.print(getGrahpic(i, player));
		}
		System.out.println();
	
		
	}
}
