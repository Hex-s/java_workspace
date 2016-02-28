package com.niit.studentList;

import java.util.ArrayList;

public class Grade {

	//年级
	private String gradeName;
	//年级里的班级
	private ArrayList<Class> classes;
	
	/**
	 * 无参构造
	 */
	public Grade(){
		
	}
	
	/**
	 * 带参构造
	 * @param stuId 学号
	 * @param stuName 姓名
	 */
	public Grade(String gradeName, ArrayList<Class> classes){
		this.gradeName = gradeName;
		this.classes = classes;
	}

	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Grade){
				Grade gra = (Grade)obj;
				if(this.gradeName.equals(gra.gradeName)){
					return true;
				}
			}
		}
		return false;
	}
	
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public ArrayList<Class> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Class> classes) {
		this.classes = classes;
	}
	
	
}
