package com.niit;

/**
 * wait��notify������ʹ��
 * @author Administrator
 *
 */
public class Exam5 extends Thread {
	//ͬ������
	private Object obj;
	
	public Exam5(Object obj, String name){
		super(name);
		this.obj = obj;
	}
	public void run(){
		//wait������ʾ������������߳̽���������״̬
		//����wait�����Ķ������Ҫ����ͬ����
		synchronized (obj) {
			try {
				System.out.println("�߳�wait������������״̬");
				//wait��������ͣ�߳̽��ͷŶ�����������ֻ������һ���߳��ж�ͬ���Ķ���ͨ��notify�������л���
				obj.wait();
				System.out.println(getName()+"�����ѳɹ�");
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
		Exam5 th = new Exam5(obj,"�߳�A");
		Exam5_notify th2 = new Exam5_notify(obj, "�߳�B");
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
