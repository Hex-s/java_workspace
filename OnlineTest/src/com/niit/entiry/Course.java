package com.niit.entiry;

/**
 * �γ���
 * @author Administrator
 *
 */
public class Course {
	//��Ŀ���
	private int courseId;
	//��Ŀ����
	private String courseName;
	//��Ŀ״̬ 0:δ���� 1��������
	private int courseState;
	
	public Course(){
		
	}
	
	public Course(int courseId,String courseName,int courseState){
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseState = courseState;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseState() {
		return courseState;
	}

	public void setCourseState(int courseState) {
		this.courseState = courseState;
	}
	
	

}
