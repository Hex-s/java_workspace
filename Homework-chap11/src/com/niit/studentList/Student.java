package com.niit.studentList;

public class Student {

	// ѧ��
	private int stuId;
	// ����
	private String stuName;

	/**
	 * �޲ι���
	 */
	public Student(){
		
	}
	/**
	 * ���ι���
	 * @param stuId ѧ��
	 * @param stuName ����
	 */
	public Student(int stuId, String stuName) {
		this.stuId = stuId;
		this.stuName = stuName;
	}
	/**
	 * ��дequals����
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
