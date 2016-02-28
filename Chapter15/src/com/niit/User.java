package com.niit;

public class User {

	private static User user;
	
	private User(){
		
	}
	/**
	 * synchronized修饰方法表示该方法是一个同步方法，即方法中涉及到的对象都将被锁定，其他线程无法并发访问
	 * 
	 * @return
	 */
//	public synchronized static User getInstance(){
//		//由于user对象可以同时被多个线程同时访问
//		//因此当A线程进入条件后还未new对象时，B线程则可能也访问到该user,结果就造成了2个线程都new了对象
//		if(user == null){
//			//暂缓线程  当前线程会在短时间内阻塞并会自动恢复执行，该方法将导致其他并行的线程有着更高的优先级执行在本线程之前
//			Thread.yield();
//			user = new User();
//		}
//		return user;
//	}
	
	/**
	 * synchronized同步块用来锁定指定的某一个对象
	 */
	public static User getInstance(){
		//同步块
		//使用synchronized可以锁定指定的对象，该对象在多线程程序中，同一时间内只能被一个线程所访问
		synchronized (user) {
			if(user == null){
				//暂缓线程  当前线程会在短时间内阻塞并会自动恢复执行，该方法将导致其他并行的线程有着更高的优先级执行在本线程之前
				Thread.yield();
				user = new User();
			}
			return user;
		}
		
	}
}
