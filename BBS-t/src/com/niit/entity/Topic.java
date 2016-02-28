package com.niit.entity;

import java.sql.Timestamp;
/**
 * Ö÷ÌùÀà
 * @author Administrator
 *
 */
public class Topic {
	private int topicId;
	private String title;
	private String content;
	private int userId;
	private int boardId;
	private Timestamp publishTime;
	private Timestamp modifyTime;
	
	public Topic(){
		
	}
	public Topic(String title, String content, int userId, int boardId, Timestamp publishTime, Timestamp modifyTime){
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
	}
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	
}
