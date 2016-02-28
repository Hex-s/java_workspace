package com.niit.exam2;

/**
 * 通过私有构建单例模式
 * @author Administrator
 *
 */
public class User {
	//静态User类型用于持久保存类的实例对象
	private static User user;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 通过私有构造构建单例设计模式
	 */
	 private User(){
		
	 }
	 
	 /**
	  * 获取User类实例的方法
	  * @return
	  */
	 public static User getInstance(){
		 //通过一个变量来记录User类是否被实例化过
		 //如果该对象为null说明该对象未被实例化
		 //否则表示该对象已经实例化过，不需要再调用new的实例
		 if(user == null){
			 user = new User();
		 }
		 return user;
	 }
	 
	 
	 
}
