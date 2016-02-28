package com.niit.entity;

import java.sql.Timestamp;

/**
 * ªÿÃ˚¿‡
 * @author Administrator
 *
 */
public class Reply {
	private int rId;
	private int rTid;
	private int rUserid;
	private String rContent;
	private Timestamp rTime;
	
	public Reply(){
		
	}
	public Reply(int rId, int rTid, int rUserid, String rContent,Timestamp rTime){
		this.rId = rId;
		this.rTid = rTid;
		this.rUserid = rUserid;
		this.rContent = rContent;
		this.rTime = rTime;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getrTid() {
		return rTid;
	}
	public void setrTid(int rTid) {
		this.rTid = rTid;
	}
	public int getrUserid() {
		return rUserid;
	}
	public void setrUserid(int rUserid) {
		this.rUserid = rUserid;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Timestamp getrTime() {
		return rTime;
	}
	public void setrTime(Timestamp rTime) {
		this.rTime = rTime;
	}
	
	
	
}
