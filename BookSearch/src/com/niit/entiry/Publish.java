package com.niit.entiry;

/**
 * ��������
 * @author Administrator
 *
 */
public class Publish {

	//��������
	private int publishId;
	//����������
	private String pName;
	
	public Publish(){
		
	}
	
	public Publish(String pName){
		this.pName = pName;
	}

	public int getPublishId() {
		return publishId;
	}

	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
}
