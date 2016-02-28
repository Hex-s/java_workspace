package com.niit;

import java.util.Random;

public class RandomArray {
	/**
	 * ��ȡ1-100ֵ������
	 * @return
	 */
	public int[] getArray(){
		int[] array = new int[100];
		for(int i = 1; i <= array.length; i++){
			array[i-1] = i;
		}
		return array;
	}
	/**
	 * Ϊ�������ֵ�ķ���
	 * @param newArray ��ֵ������
	 * @param array ��ֵ������
	 * @param length ����������ķ�Χ
	 */
	public void setData(int[] newArray, int[] array, int length){
		//���ݷ�Χ���Ȳ���һ������±�
		Random random = new Random();
		//System.out.println(length);
		int index = random.nextInt(length);
		//ͨ���±���array�л�ȡ��Ӧ��ֵ
		int value = array[index];
		//��ֵд��newArray
		//�Ƿ����Ĭ��ֵ�ı�ʶ
		//boolean hasDefault = false;
		//�����������newArray�е�һ��ΪĬ��ֵ��Ԫ��λ��,����Ҫ����ֵ��λ��
		for(int i = 0; i < newArray.length; i++){
			//���Ԫ��ֵΪĬ��ֵ
			if(newArray[i] == 0){
				//hasDefault = true;
				//��ֵд��
				newArray[i] = value;
				//�˳�ѭ��
				break;
			}
		}
		//������������ֵ��ֵ�����е�����λ��
		array[index] = array[length-1];
		//��һ��������ķ�ΧҪ��Сһλ
		length--;
		//���newArray�л���Ĭ��ֵ��ݹ����
		//if(hasDefault){
		if(length != 0){
			setData(newArray, array, length);
		}	
	}
	
	public static void main(String[] args) {
		RandomArray test = new RandomArray();
		//��ȡ1-100������
		int[] array = test.getArray();
		//�����������ֵ
		int[] newArray = new int[100];
		test.setData(newArray, array, array.length);
		//ð����������
		for(int i = 1; i < newArray.length; i++){
			for(int j = 0; j < newArray.length-i; j++){
				if(newArray[j+1] < newArray[j]){
					int temp = newArray[j+1];
					newArray[j+1] = newArray[j];
					newArray[j] = temp;
				}
			}
		}
		//��ʾ
		for(int i = 0; i < newArray.length; i++){
			System.out.println(newArray[i]);
		}
	}
}
