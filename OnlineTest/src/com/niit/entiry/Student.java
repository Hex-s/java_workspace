package com.niit.entiry;

/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {
	//ѧ�����
	private int stuId;
	//����
	private String stuName;
	//�༶���
	private int classId;
	//����
	private String pwd;
	
	public Student(){
		
	}
	
	public Student(int stuId,String stuName,int classId,String pwd){
		this.stuId = stuId;
		this.stuName = stuName;
		this.classId = classId;
		this.pwd = pwd;
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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
