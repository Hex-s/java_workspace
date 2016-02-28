package com.niit.homework;

public class HomeWork4 {

	/**
	 * 编写方法产生值是1-100不重复的长度为100的数组
	 */
	public void randomArray(int[] array){
		//产生第一个随机数
		array[0] = (int)(Math.random() * 100)+1;
		int temp;
		//产生剩余的随机数
		//从第二个随机数开始产生
		for(int i = 1; i < array.length; i++){
			//产生一个随机数，与已经产生的随机数进行比较，如果重复，则重新产生一个随机数
			temp =  (int)(Math.random() * 100)+1;
			//与已经产生的随机数进行比较
			for(int j = 0; j < i; j++){
				if(temp == array[j]){
					//如果重复，则重新产生一个随机数
					temp = (int)(Math.random() * 100)+1;
					j = -1;
				}
			}
			array[i] = temp;
		}
	}
	/**
	 * 打印数组
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
