package com.niit.entiry;

/**
 * 类别类
 * @author Administrator
 *
 */
public class Varity {

	//类别编号
	private int vId;
	//类别名称
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
