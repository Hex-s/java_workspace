package com.niit.array;

public class Exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ά�������һ��Ƕ�����飬��ʾһά������ÿһ��Ԫ��Ҳ��һ����������
		//��һ�������Ŵ�����(�������ĳ���)���ڶ��������Ŵ�������(��ΪԪ�ص�����ĳ���)
		int[][] array = new int[4][3];
		
		//Ϊ�����е�Ԫ�ؽ��и�ֵ
		array[0][0] = 1;
		array[0][1] = 2;
		array[0][2] = 3;
		
		array[1][0] = 11;
		array[1][1] = 22;
		array[2][2] = 33;
		
		//������ά����
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
