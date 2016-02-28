package com.niit.entity;

public class Department {
	
	private int depId;
	private String depName;
	private int magId;
	
	public Department(){
		
	}
	
	public Department(int depId,String depName,int magId){
		this.depId = depId;
		this.depName = depName;
		this.magId = magId;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public int getMagId() {
		return magId;
	}

	public void setMagId(int magId) {
		this.magId = magId;
	}
	
	

}
