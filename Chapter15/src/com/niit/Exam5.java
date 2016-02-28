package com.niit;

/**
 * wait和notify方法的使用
 * @author Administrator
 *
 */
public class Exam5 extends Thread {
	//同步对象
	private Object obj;
	
	public Exam5(Object obj, String name){
		super(name);
		this.obj = obj;
	}
	public void run(){
		//wait方法表示将锁定对象的线程进入阻塞的状态
		//调用wait方法的对象必须要进行同步化
		synchronized (obj) {
			try {
				System.out.println("线程wait，将处于阻塞状态");
				//wait方法在暂停线程将释放对象锁，并且只能在另一个线程中对同步的对象通过notify方法进行唤醒
				obj.wait();
				System.out.println(getName()+"被唤醒成功");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Object();
		Exam5 th = new Exam5(obj,"线程A");
		Exam5_notify th2 = new Exam5_notify(obj, "线程B");
		try {
			
			th.join();
			th.start();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.start();

	}

}
