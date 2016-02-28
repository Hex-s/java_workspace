package com.niit;

public class Exam5_notify extends Thread {

	private Object obj;
	
	public Exam5_notify(Object obj, String name){
		super(name);
		this.obj = obj;
	}
	public void run(){
		//锁定同步对象
		synchronized (obj) {
			System.out.println(getName()+"将要唤醒线程");
			//将wait的线程唤醒
			obj.notify();
		}
	}
	
}
