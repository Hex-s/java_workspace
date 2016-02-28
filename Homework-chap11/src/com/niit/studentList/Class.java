package com.niit.studentList;

import java.util.ArrayList;

public class Class {

	// �༶��
	private String className;
	//�༶���ѧ��
	private ArrayList<Student> students;
	
	/**
	 * �޲ι���
	 */
	public Class() {

	}

	/**
	 * ���ι���
	 * @param stuId ѧ��
	 * @param stuName ����
	 */
	public Class(String className, ArrayList<Student> students) {
		this.className = className;
		this.students = students;
	}

	/**
	 * ��дequals����
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
