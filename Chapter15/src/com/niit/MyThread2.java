package com.niit;
/**
 * �̴߳�����ʽ�����̳�Thread��
 * @author Administrator
 *
 */
public class MyThread2 extends Thread {

	
	public MyThread2(String name){
		//���ø��๹�촫���̵߳�����
		super(name);
		//��ȡ�̵߳�״̬
		System.out.println(this.getState());
		//�ж��߳��Ƿ���
		System.out.println(this.isAlive());
	}
	@Override
	public void run() {
		System.out.println(this.getState());
		//�ж��߳��Ƿ���
		System.out.println(this.isAlive());
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10; i++){
			System.out.println(this.getName()+"�̴߳�ӡ�ˣ�"+i);
		}
	}
	
	public static void main(String[] args) {
		
		MyThread2 th = new MyThread2("A");
		th.start();
		//�߳̿����᲻�ܼ���ִ��start
		//th.start();
		System.out.println("�߳�ִ�н���");
		//������̼߳�����У��ö����൱����һ���߳���,ִ��˳��ȡ����CPU��������䣬ʹ��join�������Ա�֤����Ĵ����ڸ�
		//�����̶߳�ִ����Ϻ��ټ���ִ��
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(th.getState());
		//�ж��߳��Ƿ���
		System.out.println(th.isAlive());
	}
}
