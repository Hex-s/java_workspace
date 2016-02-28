package com.niit.homework;
/**
 * 用于计算的单根线程对象
 * @author Administrator
 *
 */
public class CalculateThread extends Thread {
	//计算的最小索引
	private int minIndex;
	//计算的最大索引
	private int maxIndex;
	//计算的数组
	private int[] array;
	//计算的结果
	private ResultObject resultObj;
	
	public CalculateThread(int minIndex, int maxIndex, int[] array, ResultObject resultObj){
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.array = array;
		this.resultObj = resultObj;
	}
	
	@Override
	public void run() {
		//循环计算结果
		for(int i = minIndex; i <= maxIndex; i++){
			//同步计算的结果
			synchronized (resultObj) {
				resultObj.setResult(resultObj.getResult()+array[i]);
			}
		}	
	}

}
