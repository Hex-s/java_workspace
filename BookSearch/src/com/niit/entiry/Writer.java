package com.niit.entiry;

/**
 * ������
 * @author Administrator
 *
 */
public class Writer {
	
	//���߱��
	private int writerId;
	//��������
	private String wName;
	
	public Writer(){
		
	}
	
	public Writer(String wName){
		this.wName = wName;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}
	
	
}
