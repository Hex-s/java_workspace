package com.niit.collection;

public class User {
	//用户编号
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
	 * 重写User类中的equals方法
	 * Object的equals方法是基于内存地址比较的
	 * 重写的目的是只要用户名相同就可以认为是对象相同
	 */
//	@Override
//	public boolean equals(Object obj) {
//		//判断参数是否为空
//		if(obj != null){
//			//将参数拆箱成User类型
//			User user = (User)obj;
//			//重新设定比较的规则，使用用户名比较
//			if(this.name.equals(user.getName())){
//				return true;
//			}
//		}
//		return false;
//	}
	
	/**
	 * 根据用户编号比较
	 */
	@Override
	public boolean equals(Object obj) {
		//判断参数是否为null
		if(obj != null){
			//判断参数类型是否是User类型
			if(obj instanceof User){
				//拆箱
				User user = (User)obj;
				//进行用户编号的比较
				if(this.userId == user.getUserId()){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
