package com.niit;
/**
 * 连续打印4次ABCD,每个线程分别打印其中给一个字母，如：第一个线程负责打印A，第二个线程打印B
 * @author Administrator
 *
 */
public class Exam6 extends Thread{
	//线程的名称，也表示当前线程要打印的字母
	//private String name;
	private LockObj obj;
	
	//当前线程打印的次数
	private int count = 0;
	
	public Exam6(String name, LockObj obj){
		super(name);
		this.obj = obj;
	}
	public void run(){
		while(count < 4){
			//锁定对象
			synchronized (obj) {
				if(count < 4){
					//判断当前线程是否是需要打印的线程
					if(this.getName().equals(obj.getWord())){
						//累加当前线程打印的次数
						count++;
						//当前线程是指定打印的线程对象
						System.out.println(this.getName());
						//根据当前的线程名称决定一下个要打印的字母
						if(this.getName().equals("A")){
							obj.setWord("B");
						}
						else if(this.getName().equals("B")){
							obj.setWord("C");
						}
						else if(this.getName().equals("C")){
							obj.setWord("D");
							
						}
						else{
							obj.setWord("A");
						}
						//唤醒所有其他的线程
						obj.notifyAll();
					}
					//第一次打印的值应为A，如果此时B,C,D线程具备优先级先被启动锁定住obj则应进行暂停
					
					else{
						//如果当前线程不是要打印的线程，暂停当前的线程
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockObj obj = new LockObj();
		Exam6 th1 = new Exam6("A", obj);
		Exam6 th2 = new Exam6("B", obj);
		Exam6 th3 = new Exam6("C", obj);
		Exam6 th4 = new Exam6("D", obj);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}
