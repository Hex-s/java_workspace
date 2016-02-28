package com.niit.entity;

import java.sql.Timestamp;

/**
 * ªÿÃ˚¿‡
 * @author Administrator
 *
 */
public class Reply {
	private int replyId;
	private String title;
	private String content;
	private int userId;
	private int topicId;
	private Timestamp publishTime;
	private Timestamp modifyTime;
	
	public Reply(){
		
	}
	public Reply(String title, String content, int userId, int topicId, Timestamp publishTime, Timestamp modifyTime){
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.topicId = topicId;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
	}
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
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
