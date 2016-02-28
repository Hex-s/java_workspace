package com.niit;
/**
 * 实现和Exam3相同的售票效果，多线程中并发数据访问可以通过Runnable来编写线程
 * @author Administrator
 *
 */
public class Exam4 implements Runnable {
	//当前可售卖的票数
	private int count = 100;
	
	@Override
	public void run() {
		//如果还未售完
		while(count > 0){
			//同步
			synchronized(this){
				if(count > 0){
					count--;
					System.out.println(Thread.currentThread().getName()+"售出了第"+(100-count)+"张票");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		
		Exam4 target = new Exam4();
		//构建4条线程
		Thread th1 = new Thread(target, "A售票点");
		Thread th2 = new Thread(target, "B售票点");
		Thread th3 = new Thread(target, "C售票点");
		Thread th4 = new Thread(target, "D售票点");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
	}
	
}
