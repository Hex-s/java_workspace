package com.niit;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ȡ��������ֵ
		int[] array = new int[]{83,76,48,62,98,83,99};
		//���ֵ,���������еĵ�һ��Ԫ��Ϊ���ֵ
		int max = array[0];
		//�����ֵ���κ͵ڶ���Ԫ�ؿ�ʼ���бȽϣ�һֱ�������е�Ԫ��
		for(int i = 1; i < array.length; i++){
			//���ĳ��Ԫ�ر����ֵ��Ҫ�󣬸�ֵ��Ϊ���ֵ
			if(array[i] > max){
				max = array[i];
			}
		}
		System.out.println(max);
	}

}
