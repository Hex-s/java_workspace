package com.niit;
/**
 * ʵ�ֺ�Exam3��ͬ����ƱЧ�������߳��в������ݷ��ʿ���ͨ��Runnable����д�߳�
 * @author Administrator
 *
 */
public class Exam4 implements Runnable {
	//��ǰ��������Ʊ��
	private int count = 100;
	
	@Override
	public void run() {
		//�����δ����
		while(count > 0){
			//ͬ��
			synchronized(this){
				if(count > 0){
					count--;
					System.out.println(Thread.currentThread().getName()+"�۳��˵�"+(100-count)+"��Ʊ");
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
		//����4���߳�
		Thread th1 = new Thread(target, "A��Ʊ��");
		Thread th2 = new Thread(target, "B��Ʊ��");
		Thread th3 = new Thread(target, "C��Ʊ��");
		Thread th4 = new Thread(target, "D��Ʊ��");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
	}
	
}
