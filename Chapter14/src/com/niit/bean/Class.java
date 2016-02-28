package com.niit.bean;
/**
 * 班级
 * @author Administrator
 *
 */
public class Class {
	private int classId;
	private String className;
	//所在年级
	private int gradeId;
	
	public Class(int classId, String className, int gradeId){
		this.classId = classId;
		this.className = className;
		this.gradeId = gradeId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.className;
	}
	
}
