package com.niit;

public class CreateUserThread extends Thread{

	public void run(){
		//ͨ������ģʽ��ȡUser���ʵ��
		User user = User.getInstance();
		//��ӡ��ϣ��
		System.out.println(user.hashCode());
	}
	
	public static void main(String[] args) {
		
		//ͨ���̴߳���10��User����
		CreateUserThread[] threads = new CreateUserThread[10];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new CreateUserThread();
			//�����߳�
			threads[i].start();
		}
	}
}
