package com.niit.entiry;

/**
 * �����
 * @author Administrator
 *
 */
public class Varity {

	//�����
	private int vId;
	//�������
	private String vName;
	
	public Varity(){
		
	}
	
	public Varity(String vName){
		this.vName = vName;
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}
	
	
}
