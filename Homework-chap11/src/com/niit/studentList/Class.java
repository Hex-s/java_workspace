package com.niit.studentList;

import java.util.ArrayList;

public class Class {

	// 班级名
	private String className;
	//班级里的学生
	private ArrayList<Student> students;
	
	/**
	 * 无参构造
	 */
	public Class() {

	}

	/**
	 * 带参构造
	 * @param stuId 学号
	 * @param stuName 姓名
	 */
	public Class(String className, ArrayList<Student> students) {
		this.className = className;
		this.students = students;
	}

	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Class){
				Class cla = (Class) obj;
				if(this.className.equals(cla.getClassName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	
}
