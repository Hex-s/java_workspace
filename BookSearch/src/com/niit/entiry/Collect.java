package com.niit.entiry;

import java.sql.Timestamp;

/**
 * �ղ���
 * @author Administrator
 *
 */
public class Collect {

	//�ղر��
	private int collectId;
	//�û����
	private int cUserId;
	//ͼ����
	private int cBookId;
	//�ղ�ʱ��
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
