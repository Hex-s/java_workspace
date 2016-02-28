package com.niit.entiry;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Test {
	//测试编号
	private int testId;
	//测试名称
	private String testName;
	//科目编号
	private int courseId;
	//考试起始时间
	private Timestamp startTime;
	private int totalTime;
	//班级编号
	private int classId;
	//单选题数量
	private int singleCount;
	//单选题总分值
	private int singleScore;
	//多选题数量
	private int multiCount;
	//多选题总分值
	private int multiScore;
	//0：测试为可进行状态  1：测试以结束
	private int isEnd;
	
	
	public Test(){
		
	}
	
	public Test(int testId,String testName,int courseId,Timestamp startTime,int totalTime,int classId,int singleCount,int singleScore,int multiCount,int multiScore,int isEnd){
		this.testId = testId;
		this.testName = testName;
		this.courseId = courseId;
		this.startTime = startTime;
		this.totalTime = totalTime;
		this.classId = classId;
		this.singleCount = singleCount;
		this.singleScore = singleScore;
		this.multiCount = multiCount;
		this.multiScore = multiScore;
		this.isEnd = isEnd;
	}


	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSingleCount() {
		return singleCount;
	}

	public void setSingleCount(int singleCount) {
		this.singleCount = singleCount;
	}

	public int getSingleScore() {
		return singleScore;
	}

	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}

	public int getMultiCount() {
		return multiCount;
	}

	public void setMultiCount(int multiCount) {
		this.multiCount = multiCount;
	}

	public int getMultiScore() {
		return multiScore;
	}

	public void setMultiScore(int multiScore) {
		this.multiScore = multiScore;
	}

	public int getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}


}
