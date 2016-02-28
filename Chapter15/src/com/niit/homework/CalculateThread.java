package com.niit.homework;
/**
 * ���ڼ���ĵ����̶߳���
 * @author Administrator
 *
 */
public class CalculateThread extends Thread {
	//�������С����
	private int minIndex;
	//������������
	private int maxIndex;
	//���������
	private int[] array;
	//����Ľ��
	private ResultObject resultObj;
	
	public CalculateThread(int minIndex, int maxIndex, int[] array, ResultObject resultObj){
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.array = array;
		this.resultObj = resultObj;
	}
	
	@Override
	public void run() {
		//ѭ��������
		for(int i = minIndex; i <= maxIndex; i++){
			//ͬ������Ľ��
			synchronized (resultObj) {
				resultObj.setResult(resultObj.getResult()+array[i]);
			}
		}	
	}

}
