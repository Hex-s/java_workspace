package com.niit;
/**
 * �����̷߳�ʽһ ʵ��Runnable�ӿ�
 * @author Administrator
 *
 */
public class MyThread1 implements Runnable{

	/**
	 * run�������̵߳ĺ��ķ�������ʾ���߳�����ִ�еĴ����
	 */
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++){
			//Thread.currentThread()��ʾ��ȡ��ǰ�������е��߳�ʵ������
			System.out.println(Thread.currentThread().getName()+"�̴߳�ӡ��"+i);
		}
	}
	
	public static void main(String[] args) {
		
		//�����߳�
		Thread th1 = new Thread(new MyThread1(),"A");
		
		
		
		MyThread2 th2 = new MyThread2("B");
		
		//�����߳�ͨ��start����
		th2.start();
		th1.start();
		try {
			th2.join();
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߳�ִ�н���");
	}

}
