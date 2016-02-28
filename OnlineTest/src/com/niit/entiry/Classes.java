package com.niit.entiry;

/**
 * 班级类
 * @author Administrator
 *
 */
public class Classes {
	//班级编号
	private int classId;
	//班级名称
	private String className;
	
	public Classes(){
		
	}
	
	public Classes(int classId,String className){
		this.classId = classId;
		this.className = className;
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
	
	

}
