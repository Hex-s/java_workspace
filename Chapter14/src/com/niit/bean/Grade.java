package com.niit.bean;
/**
 * �꼶
 * @author Administrator
 *
 */
public class Grade {
	private int gradeId;
	private String gradeName;
	
	public Grade(int gradeId, String gradeName){
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
