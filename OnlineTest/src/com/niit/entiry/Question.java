package com.niit.entiry;

public class Question {

	//试题编号
	private int qid;
	//科目编号
	private int courseId;
	//题目类型
	private int qType;
	//题干
	private String qTitle;
	//选项
	private String qChoices;
	//答案
	private String qAnswer;
	
	public Question(){
		
	}
	
	public Question(int qid,int courseid,int qType,String qTitle,String qChoices,String qAnswer){
		this.qid = qid;
		this.courseId = courseid;
		this.qType = qType;
		this.qTitle = qTitle;
		this.qChoices = qChoices;
		this.qAnswer = qAnswer;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getqType() {
		return qType;
	}

	public void setqType(int qType) {
		this.qType = qType;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqChoices() {
		return qChoices;
	}

	public void setqChoices(String qChoices) {
		this.qChoices = qChoices;
	}

	public String getqAnswer() {
		return qAnswer;
	}

	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}
	
	
}
