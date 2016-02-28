package com.niit;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//获取数组的最大值
		int[] array = new int[]{83,76,48,62,98,83,99};
		//最大值,假设数组中的第一个元素为最大值
		int max = array[0];
		//将最大值依次和第二个元素开始进行比较，一直比完所有的元素
		for(int i = 1; i < array.length; i++){
			//如果某个元素比最大值还要大，该值成为最大值
			if(array[i] > max){
				max = array[i];
			}
		}
		System.out.println(max);
	}

}
