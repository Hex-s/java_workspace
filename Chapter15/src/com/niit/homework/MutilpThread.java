package com.niit.homework;
/**
 * ʹ�ö��̼߳���1-100�ĺ�
 * @author Administrator
 *
 */
public class MutilpThread {
	//���ڻ��ּ�����߳�����
	private int count = 13;
	//Ҫ���������
	private int[] array;
	//ÿ���߳�Ҫ����������С����
	private int minIndex;
	//ÿ���߳�Ҫ���������������
	private int maxIndex;
	//ÿ���̵߳ļ��㷶Χ
	private int range;
	//����������
	private ResultObject resultObj;
	
	public MutilpThread(){
		//��ʼ������
		array = new int[100];
		for(int i = 0; i <= 99; i++){
			array[i] = i+1;
		}
		//��ʼ������������
		resultObj = new ResultObject();
		//����ÿ���̵߳ļ��㷶Χ
		range = array.length/count;
		//ѭ���߳�����
		for(int i = 1; i <= count; i++){
			//����ÿ���߳�Ҫ�������������е���С�������������
			minIndex = (i-1)*range;
			maxIndex = i*range-1;
			//����������߳�
			if(i == count){
				//Ҫ������������ʼ��Ϊ�����е��������ֵ
				maxIndex = array.length-1;
			}
			//ѭ�������̣߳�ʹÿ���̵߳������м���
			CalculateThread thread = new CalculateThread(minIndex, maxIndex, array, resultObj);
			//�����߳�
			thread.start();
			//���̼߳������
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		//���������
		System.out.println(resultObj.getResult());
	}
	
	public static void main(String[] args) {
		MutilpThread ex = new MutilpThread();
	}
}
