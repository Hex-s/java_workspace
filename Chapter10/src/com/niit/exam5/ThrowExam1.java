package com.niit.exam5;

public class ThrowExam1 {
	
	private int age;
	
	/**
	 * throws用来对已经跑出异常的方法进行异常的声明，提示该方法的调用者会出现异常，需要进行处理
	 * @param age
	 * @throws Exception
	 */
	public void setAage(int age) throws Exception{
		if(age >= 1 && age <= 150){
			this.age = age;
		}
		else{
			//System.out.println("参数非法");
			//throw可以强制在程序引发异常的实例出现，并且不对该异常进行处理，由该方法的调用者进行处理
			//任何Java中出现的异常都是通过throw引发的
			throw new Exception("输入的年龄非法！");
		}
	}
	
	public static void main(String[] args){
		ThrowExam1 ex = new ThrowExam1();
		try {
			ex.setAage(-100);
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		System.out.println("程序运行结束");
	}
}
