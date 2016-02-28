package com.niit.studentList;

public class Student {

	// 学号
	private int stuId;
	// 姓名
	private String stuName;

	/**
	 * 无参构造
	 */
	public Student(){
		
	}
	/**
	 * 带参构造
	 * @param stuId 学号
	 * @param stuName 姓名
	 */
	public Student(int stuId, String stuName) {
		this.stuId = stuId;
		this.stuName = stuName;
	}
	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Student){
				Student stu = (Student)obj;
				if(this.stuId == stu.getStuId()){
					return true;
				}
			}
		}
		return false; 
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
}
