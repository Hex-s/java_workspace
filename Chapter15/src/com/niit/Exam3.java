package com.niit;

public class Exam3 extends Thread {
	private LockObj obj;
	
	public Exam3(LockObj obj, String name){
		super(name);
		this.obj = obj;
	}
	
	public void run(){
		//如果还有票没卖完
		while(obj.getCount() > 0){
			//对锁定对象
			synchronized (obj) {
				//如果A,B,C3个线程执行到最后次循环，此时对象被D线程锁定，则在D线程中售卖了最后张票
				//但是A,B,C3个线程还未执行完毕，因此会继续执行售票的动作，因此需要在循环同步块中再次判断是否卖完了车票
				if(obj.getCount() > 0){
					//每次卖掉一张票
					obj.setCount(obj.getCount()-1);
					System.out.println(getName()+"售出了第"+(100-obj.getCount())+"车票");
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
		
		//构建被同步对象
		LockObj obj = new LockObj();
//		//创建线程数组
//		Exam3[] threads = new Exam3[5];
//		for(int i = 0; i < threads.length; i++){
//			//多个线程实例化时传入相同的对象
//			threads[i] = new Exam3(obj, i+1+"");
//			threads[i].start();
//		}
		Exam3 th1 = new Exam3(obj, "A售票点");
		Exam3 th2 = new Exam3(obj, "B售票点");
		Exam3 th3 = new Exam3(obj, "C售票点");
		Exam3 th4 = new Exam3(obj, "D售票点");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}
