package com.niit.entiry;

/**
 * 作者类
 * @author Administrator
 *
 */
public class Writer {
	
	//作者编号
	private int writerId;
	//作者姓名
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
