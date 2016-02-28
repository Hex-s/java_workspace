package com.niit.collection;

public class User {
	//�û����
	private int userId;
	private String name;
	
	public User(){
		
	}
	public User(String name){
		this.name = name;
	}
	public User(int userId){
		this.userId = userId;
	}
	public User(int userId, String name){
		this.userId = userId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * ��дUser���е�equals����
	 * Object��equals�����ǻ����ڴ��ַ�Ƚϵ�
	 * ��д��Ŀ����ֻҪ�û�����ͬ�Ϳ�����Ϊ�Ƕ�����ͬ
	 */
//	@Override
//	public boolean equals(Object obj) {
//		//�жϲ����Ƿ�Ϊ��
//		if(obj != null){
//			//�����������User����
//			User user = (User)obj;
//			//�����趨�ȽϵĹ���ʹ���û����Ƚ�
//			if(this.name.equals(user.getName())){
//				return true;
//			}
//		}
//		return false;
//	}
	
	/**
	 * �����û���űȽ�
	 */
	@Override
	public boolean equals(Object obj) {
		//�жϲ����Ƿ�Ϊnull
		if(obj != null){
			//�жϲ��������Ƿ���User����
			if(obj instanceof User){
				//����
				User user = (User)obj;
				//�����û���ŵıȽ�
				if(this.userId == user.getUserId()){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
