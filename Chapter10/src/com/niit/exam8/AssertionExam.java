package com.niit.exam8;

public class AssertionExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userName = "admin1";
		String password = "123";
		
//		if(userName.equals("admin")){
//			if(password.equals("123")){
//				System.out.println("登陆成功");
//			}
//		}
		
		//断言表示一种假设的肯定
		assert userName.equals("admin"):"用户名错误！";
		//断言密码也是正确的
		assert password.equals("123"):"密码错误！";
		System.out.println("登陆成功");

	}

}
