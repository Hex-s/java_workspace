package com.niit.entiry;

/**
 * 出版社类
 * @author Administrator
 *
 */
public class Publish {

	//出版社编号
	private int publishId;
	//出版社名称
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
