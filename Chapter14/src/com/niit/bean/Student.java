package com.niit.bean;

public class Student {
	private int stuId;
	private String stuName;
	private int age;
	private String sex;
	//ËùÔÚ°à¼¶±àºÅ
	private int classId;
	
	public Student(){
		
	}
	public Student(int stuId, String stuName, int age, String sex){
		this.stuId = stuId;
		this.stuName = stuName;
		this.age = age;
		this.sex = sex;
	}
	
	public Student(int stuId, String stuName, int age, String sex, int classId){
		this.stuId = stuId;
		this.stuName = stuName;
		this.age = age;
		this.sex = sex;
		this.classId = classId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
