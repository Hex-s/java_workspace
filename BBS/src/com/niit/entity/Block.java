package com.niit.entity;
/**
 * °å¿éÀà
 * @author Administrator
 *
 */
public class Block {
	private int bId;
	private String bName;
	private int prarentId;
	private int masterId;
	
	public Block(){
		
	}
	
	public Block(int bId,String bName,int prarentId,int masterId){
		this.bId = bId;
		this.bName = bName;
		this.prarentId = prarentId;
		this.masterId = masterId;
		
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getPrarentId() {
		return prarentId;
	}

	public void setPrarentId(int prarentId) {
		this.prarentId = prarentId;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	
	
	
	
}
