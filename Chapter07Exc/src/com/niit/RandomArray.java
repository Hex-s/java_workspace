package com.niit;

import java.util.Random;

public class RandomArray {
	/**
	 * 获取1-100值的数组
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
	 * 为数组填充值的方法
	 * @param newArray 空值的数组
	 * @param array 带值的数组
	 * @param length 产生随机数的范围
	 */
	public void setData(int[] newArray, int[] array, int length){
		//根据范围长度产生一个随机下标
		Random random = new Random();
		//System.out.println(length);
		int index = random.nextInt(length);
		//通过下标在array中获取对应的值
		int value = array[index];
		//将值写入newArray
		//是否存在默认值的标识
		//boolean hasDefault = false;
		//遍历数组查找newArray中第一次为默认值的元素位置,即所要插入值的位置
		for(int i = 0; i < newArray.length; i++){
			//如果元素值为默认值
			if(newArray[i] == 0){
				//hasDefault = true;
				//将值写入
				newArray[i] = value;
				//退出循环
				break;
			}
		}
		//将数组中最后的值赋值到现有的索引位置
		array[index] = array[length-1];
		//下一次随机数的范围要缩小一位
		length--;
		//如果newArray中还有默认值则递归调用
		//if(hasDefault){
		if(length != 0){
			setData(newArray, array, length);
		}	
	}
	
	public static void main(String[] args) {
		RandomArray test = new RandomArray();
		//获取1-100的数组
		int[] array = test.getArray();
		//设置新数组的值
		int[] newArray = new int[100];
		test.setData(newArray, array, array.length);
		//冒泡升序排序
		for(int i = 1; i < newArray.length; i++){
			for(int j = 0; j < newArray.length-i; j++){
				if(newArray[j+1] < newArray[j]){
					int temp = newArray[j+1];
					newArray[j+1] = newArray[j];
					newArray[j] = temp;
				}
			}
		}
		//显示
		for(int i = 0; i < newArray.length; i++){
			System.out.println(newArray[i]);
		}
	}
}
