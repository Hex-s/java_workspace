package com.niit.homework;
/**
 * 使用多线程计算1-100的和
 * @author Administrator
 *
 */
public class MutilpThread {
	//用于划分计算的线程数量
	private int count = 13;
	//要计算的数组
	private int[] array;
	//每个线程要计算数的最小索引
	private int minIndex;
	//每个线程要计算数的最大索引
	private int maxIndex;
	//每个线程的计算范围
	private int range;
	//计算结果对象
	private ResultObject resultObj;
	
	public MutilpThread(){
		//初始化数组
		array = new int[100];
		for(int i = 0; i <= 99; i++){
			array[i] = i+1;
		}
		//初始化计算结果对象
		resultObj = new ResultObject();
		//计算每个线程的计算范围
		range = array.length/count;
		//循环线程数量
		for(int i = 1; i <= count; i++){
			//计算每根线程要计算数在数组中的最小索引和最大索引
			minIndex = (i-1)*range;
			maxIndex = i*range-1;
			//如果是最后根线程
			if(i == count){
				//要计算的最大索引始终为数组中的最大索引值
				maxIndex = array.length-1;
			}
			//循环创建线程，使每个线程单独进行计算
			CalculateThread thread = new CalculateThread(minIndex, maxIndex, array, resultObj);
			//开启线程
			thread.start();
			//将线程加入队列
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		//输出计算结果
		System.out.println(resultObj.getResult());
	}
	
	public static void main(String[] args) {
		MutilpThread ex = new MutilpThread();
	}
}
