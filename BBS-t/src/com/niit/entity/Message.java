package com.niit.entity;

import java.util.Date;

/**
 * ������Ϣ
 * @author Administrator
 *
 */
public class Message {
	//������
	private String fromUser;
	//������
	private String reciveUser;
	//��Ϣ����
	private String msgContent;
	//���鶯��
	private int action;
	//������ɫ
	private int color;
	//����Ϣ��ʱ��
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
