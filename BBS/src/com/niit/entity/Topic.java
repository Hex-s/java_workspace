package com.niit.entity;

import java.sql.Timestamp;
/**
 * Ö÷ÌùÀà
 * @author Administrator
 *
 */
public class Topic {
	private int tId;
	private int tbId;
	private int tUserId;
	private String tTitle;
	private String tContent;
	private Timestamp tPublishTime;
	private Timestamp tLastEdit;
	private int tClickCount;
	private int tFlag;
	
	public Topic(){
		
	}
	public Topic(int tId, int tbId, int tUserId, String tTitle, String tContent, Timestamp tPublishTime,Timestamp tLastEdit,int tClickCount,int tFlag){
		this.tId = tId;
		this.tbId = tbId;
		this.tUserId = tUserId;
		this.tTitle = tTitle;
		this.tClickCount = tClickCount;
		this.tContent = tContent;
		this.tPublishTime = tPublishTime;
		this.tLastEdit = tLastEdit;
		this.tFlag = tFlag;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	
	public int getTbId() {
		return tbId;
	}
	public void setTbId(int tbId) {
		this.tbId = tbId;
	}
	public int gettUserId() {
		return tUserId;
	}
	public void settUserId(int tUserId) {
		this.tUserId = tUserId;
	}
	public String gettTitle() {
		return tTitle;
	}
	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}
	public String gettContent() {
		return tContent;
	}
	public void settContent(String tContent) {
		this.tContent = tContent;
	}
	public Timestamp gettPublishTime() {
		return tPublishTime;
	}
	public void settPublishTime(Timestamp tPublishTime) {
		this.tPublishTime = tPublishTime;
	}
	public Timestamp gettLastEdit() {
		return tLastEdit;
	}
	public void settLastEdit(Timestamp tLastEdit) {
		this.tLastEdit = tLastEdit;
	}
	public int gettClickCount() {
		return tClickCount;
	}
	public void settClickCount(int tClickCount) {
		this.tClickCount = tClickCount;
	}
	public int gettFlag() {
		return tFlag;
	}
	public void settFlag(int tFlag) {
		this.tFlag = tFlag;
	}
	
	
	
}
