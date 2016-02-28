package com.niit.studentList;

import java.util.ArrayList;

public class Grade {

	//�꼶
	private String gradeName;
	//�꼶��İ༶
	private ArrayList<Class> classes;
	
	/**
	 * �޲ι���
	 */
	public Grade(){
		
	}
	
	/**
	 * ���ι���
	 * @param stuId ѧ��
	 * @param stuName ����
	 */
	public Grade(String gradeName, ArrayList<Class> classes){
		this.gradeName = gradeName;
		this.classes = classes;
	}

	/**
	 * ��дequals����
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
