package com.niit;
/**
 * 线程创建方式二：继承Thread类
 * @author Administrator
 *
 */
public class MyThread2 extends Thread {

	
	public MyThread2(String name){
		//调用父类构造传入线程的名称
		super(name);
		//获取线程的状态
		System.out.println(this.getState());
		//判断线程是否存活
		System.out.println(this.isAlive());
	}
	@Override
	public void run() {
		System.out.println(this.getState());
		//判断线程是否存活
		System.out.println(this.isAlive());
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10; i++){
			System.out.println(this.getName()+"线程打印了："+i);
		}
	}
	
	public static void main(String[] args) {
		
		MyThread2 th = new MyThread2("A");
		th.start();
		//线程开启会不能继续执行start
		//th.start();
		System.out.println("线程执行结束");
		//将多个线程加入队列，该队列相当于是一个线程组,执行顺序取决于CPU的随机分配，使用join方法可以保证后面的代码在该
		//队列线程都执行完毕后再继续执行
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(th.getState());
		//判断线程是否存活
		System.out.println(th.isAlive());
	}
}
