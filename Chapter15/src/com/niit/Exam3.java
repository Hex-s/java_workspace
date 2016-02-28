package com.niit;

public class Exam3 extends Thread {
	private LockObj obj;
	
	public Exam3(LockObj obj, String name){
		super(name);
		this.obj = obj;
	}
	
	public void run(){
		//�������Ʊû����
		while(obj.getCount() > 0){
			//����������
			synchronized (obj) {
				//���A,B,C3���߳�ִ�е�����ѭ������ʱ����D�߳�����������D�߳��������������Ʊ
				//����A,B,C3���̻߳�δִ����ϣ���˻����ִ����Ʊ�Ķ����������Ҫ��ѭ��ͬ�������ٴ��ж��Ƿ������˳�Ʊ
				if(obj.getCount() > 0){
					//ÿ������һ��Ʊ
					obj.setCount(obj.getCount()-1);
					System.out.println(getName()+"�۳��˵�"+(100-obj.getCount())+"��Ʊ");
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
		
		//������ͬ������
		LockObj obj = new LockObj();
//		//�����߳�����
//		Exam3[] threads = new Exam3[5];
//		for(int i = 0; i < threads.length; i++){
//			//����߳�ʵ����ʱ������ͬ�Ķ���
//			threads[i] = new Exam3(obj, i+1+"");
//			threads[i].start();
//		}
		Exam3 th1 = new Exam3(obj, "A��Ʊ��");
		Exam3 th2 = new Exam3(obj, "B��Ʊ��");
		Exam3 th3 = new Exam3(obj, "C��Ʊ��");
		Exam3 th4 = new Exam3(obj, "D��Ʊ��");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}
