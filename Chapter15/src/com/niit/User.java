package com.niit;

public class User {

	private static User user;
	
	private User(){
		
	}
	/**
	 * synchronized���η�����ʾ�÷�����һ��ͬ�����������������漰���Ķ��󶼽��������������߳��޷���������
	 * 
	 * @return
	 */
//	public synchronized static User getInstance(){
//		//����user�������ͬʱ������߳�ͬʱ����
//		//��˵�A�߳̽���������δnew����ʱ��B�߳������Ҳ���ʵ���user,����������2���̶߳�new�˶���
//		if(user == null){
//			//�ݻ��߳�  ��ǰ�̻߳��ڶ�ʱ�������������Զ��ָ�ִ�У��÷����������������е��߳����Ÿ��ߵ����ȼ�ִ���ڱ��߳�֮ǰ
//			Thread.yield();
//			user = new User();
//		}
//		return user;
//	}
	
	/**
	 * synchronizedͬ������������ָ����ĳһ������
	 */
	public static User getInstance(){
		//ͬ����
		//ʹ��synchronized��������ָ���Ķ��󣬸ö����ڶ��̳߳����У�ͬһʱ����ֻ�ܱ�һ���߳�������
		synchronized (user) {
			if(user == null){
				//�ݻ��߳�  ��ǰ�̻߳��ڶ�ʱ�������������Զ��ָ�ִ�У��÷����������������е��߳����Ÿ��ߵ����ȼ�ִ���ڱ��߳�֮ǰ
				Thread.yield();
				user = new User();
			}
			return user;
		}
		
	}
}
