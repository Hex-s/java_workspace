package com.niit.entiry;

import java.sql.Timestamp;

/**
 * 收藏类
 * @author Administrator
 *
 */
public class Collect {

	//收藏编号
	private int collectId;
	//用户编号
	private int cUserId;
	//图书编号
	private int cBookId;
	//收藏时间
	private Timestamp cTime;

	public Collect(){
		
	}
	
	public Collect(int cUserId,int cBookId){
		this.cUserId = cUserId;
		this.cBookId = cBookId;
	}

	public int getCollectId() {
		return collectId;
	}

	public void setCollectId(int collectId) {
		this.collectId = collectId;
	}

	public int getcUserId() {
		return cUserId;
	}

	public void setcUserId(int cUserId) {
		this.cUserId = cUserId;
	}

	public int getcBookId() {
		return cBookId;
	}

	public void setcBookId(int cBookId) {
		this.cBookId = cBookId;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	
	
}
