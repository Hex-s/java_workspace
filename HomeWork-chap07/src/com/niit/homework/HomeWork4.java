package com.niit.homework;

public class HomeWork4 {

	/**
	 * ��д��������ֵ��1-100���ظ��ĳ���Ϊ100������
	 */
	public void randomArray(int[] array){
		//������һ�������
		array[0] = (int)(Math.random() * 100)+1;
		int temp;
		//����ʣ��������
		//�ӵڶ����������ʼ����
		for(int i = 1; i < array.length; i++){
			//����һ������������Ѿ���������������бȽϣ�����ظ��������²���һ�������
			temp =  (int)(Math.random() * 100)+1;
			//���Ѿ���������������бȽ�
			for(int j = 0; j < i; j++){
				if(temp == array[j]){
					//����ظ��������²���һ�������
					temp = (int)(Math.random() * 100)+1;
					j = -1;
				}
			}
			array[i] = temp;
		}
	}
	/**
	 * ��ӡ����
	 * @param array
	 */
	public void showArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+"\t");
			if((i+1) %10==0){
				System.out.println();
			}
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		HomeWork4 hw = new HomeWork4();
		int[] array = new int[500];
		hw.randomArray(array);
		hw.showArray(array);
	}

}
