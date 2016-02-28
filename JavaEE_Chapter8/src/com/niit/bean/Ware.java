package com.niit.bean;

import java.io.Serializable;

/**
 * …Ã∆∑¿‡
 * @author Administrator
 *
 */
public class Ware implements Serializable {
	private int wareId;
	private String wareName;
	private double price;
	private int num;
	
	public Ware(){
		
	}
	public Ware(int wareId, String wareName, double price, int num){
		this.wareId = wareId;
		this.wareName = wareName;
		this.price = price;
		this.num = num;
	}
	
	public int getWareId() {
		return wareId;
	}
	public void setWareId(int wareId) {
		this.wareId = wareId;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
