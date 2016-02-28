package com.niit;

public class CreateUserThread extends Thread{

	public void run(){
		//通过单例模式获取User类的实例
		User user = User.getInstance();
		//打印哈希码
		System.out.println(user.hashCode());
	}
	
	public static void main(String[] args) {
		
		//通过线程创建10个User对象
		CreateUserThread[] threads = new CreateUserThread[10];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new CreateUserThread();
			//启动线程
			threads[i].start();
		}
	}
}
