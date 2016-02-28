package com.niit.entiry;

public class Score {
	//≥…º®±‡∫≈
	private int scId;
	//—ß∫≈
	private int stuId;
	//≤‚ ‘±‡∫≈
	private int testId;
	//≥…º®
	private int tScore;
	
	public Score(){
		
	}
	
	public Score(int scId,int stuId,int testId,int tScore){
		this.scId = scId;
		this.stuId = stuId;
		this.testId = testId;
		this.tScore = tScore;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int gettScore() {
		return tScore;
	}

	public void settScore(int tScore) {
		this.tScore = tScore;
	}
	
	
	

}
