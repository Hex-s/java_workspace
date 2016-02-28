package com.niit.entity;

import java.util.Date;

/**
 * 聊天信息
 * @author Administrator
 *
 */
public class Message {
	//发信人
	private String fromUser;
	//接收人
	private String reciveUser;
	//消息内容
	private String msgContent;
	//表情动作
	private int action;
	//字体颜色
	private int color;
	//发信息的时间
	private Date publishTime;
	
	public Message(){
		
	}
	public Message(String fromUser, String reviceUser, int action, int color, String msgContent, Date publishTime){
		this.fromUser = fromUser;
		this.reciveUser = reviceUser;
		this.action = action;
		this.color = color;
		this.msgContent = msgContent;
		this.publishTime = publishTime;
	}
	
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getReciveUser() {
		return reciveUser;
	}
	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	
}
