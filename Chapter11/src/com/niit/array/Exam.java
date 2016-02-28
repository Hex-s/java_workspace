package com.niit.array;

public class Exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//二维数组就是一种嵌套数组，表示一维数组中每一个元素也是一个数组类型
		//第一个中括号代表行(外层数组的长度)，第二个中括号代表了列(作为元素的数组的长度)
		int[][] array = new int[4][3];
		
		//为数组中的元素进行赋值
		array[0][0] = 1;
		array[0][1] = 2;
		array[0][2] = 3;
		
		array[1][0] = 11;
		array[1][1] = 22;
		array[2][2] = 33;
		
		//遍历二维数组
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
