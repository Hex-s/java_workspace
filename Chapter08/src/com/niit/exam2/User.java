package com.niit.exam2;

/**
 * ͨ��˽�й�������ģʽ
 * @author Administrator
 *
 */
public class User {
	//��̬User�������ڳ־ñ������ʵ������
	private static User user;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * ͨ��˽�й��칹���������ģʽ
	 */
	 private User(){
		
	 }
	 
	 /**
	  * ��ȡUser��ʵ���ķ���
	  * @return
	  */
	 public static User getInstance(){
		 //ͨ��һ����������¼User���Ƿ�ʵ������
		 //����ö���Ϊnull˵���ö���δ��ʵ����
		 //�����ʾ�ö����Ѿ�ʵ������������Ҫ�ٵ���new��ʵ��
		 if(user == null){
			 user = new User();
		 }
		 return user;
	 }
	 
	 
	 
}
