package com.niit;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[]{87,67,34,20,98,73,59};
		//ð������
		//desc��������
		//���ѭ�����ƱȽϵ�����
//		for(int i = 1; i < array.length; i++){
//			//���ѭ������ÿһ�ֱȽϵĴ���,-i��ʾÿһ�ֲ���Ҫ�ȽϵĴ���
//			for(int j = 0; j < array.length-i; j++ ){
//				//ÿ�����ν���ǰԪ�غ���һ��Ԫ�ؽ��бȽ�
//				if(array[j] < array[j+1]){
//					//��������
//					int temp = array[j];
//					array[j] = array[j+1];
//					array[j+1] = temp;
//				}
//			}
//		}
		
		//���ƵıȽϵ�����
		//i��ʾÿһ�ֱȽϵĵ�һ������������ÿһ�ֵıȽ϶���ͬһ��Ԫ��
		for(int i = 0; i < array.length-1; i++){
			//���ƱȽϵĴ���
			//j��ʾҪ�Ƚϵĵڶ���������ÿһ�ֵıȽ��У��ڶ������ǲ��ϱ仯��
			for(int j = i+1; j < array.length; j++){
				if(array[i] < array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		Exam3 ex = new Exam3();
		//��ӡ��ʾ����
		ex.showArray(array, array.length);
		
	}

}
