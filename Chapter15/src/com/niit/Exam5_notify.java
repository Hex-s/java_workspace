package com.niit;

public class Exam5_notify extends Thread {

	private Object obj;
	
	public Exam5_notify(Object obj, String name){
		super(name);
		this.obj = obj;
	}
	public void run(){
		//����ͬ������
		synchronized (obj) {
			System.out.println(getName()+"��Ҫ�����߳�");
			//��wait���̻߳���
			obj.notify();
		}
	}
	
}
