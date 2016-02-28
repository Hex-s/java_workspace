package com.niit.entiry;

/**
 * 课程类
 * @author Administrator
 *
 */
public class Course {
	//科目编号
	private int courseId;
	//科目名称
	private String courseName;
	//科目状态 0:未开课 1：开课中
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
