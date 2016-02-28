package com.niit;
/**
 * 创建线程方式一 实现Runnable接口
 * @author Administrator
 *
 */
public class MyThread1 implements Runnable{

	/**
	 * run方法是线程的核心方法，表示该线程所需执行的代码段
	 */
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++){
			//Thread.currentThread()表示获取当前正在运行的线程实例对象
			System.out.println(Thread.currentThread().getName()+"线程打印了"+i);
		}
	}
	
	public static void main(String[] args) {
		
		//创建线程
		Thread th1 = new Thread(new MyThread1(),"A");
		
		
		
		MyThread2 th2 = new MyThread2("B");
		
		//开启线程通过start方法
		th2.start();
		th1.start();
		try {
			th2.join();
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程执行结束");
	}

}
