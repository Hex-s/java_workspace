package com.niit.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物记录
 * @author Administrator
 *
 */
public class Record extends Ware implements Serializable{
	//购买数量
	private int buyNum;
	//购买金额
	private double payPrice;
	//购物时间
	private Date buyTime;
	
	public Record(){
		
	}
	public Record(int wareId, String wareName, double price, int num, int buyNum, double payPrice, Date buyTime){
		super(wareId, wareName, price, num);
		this.buyNum = buyNum;
		this.payPrice = payPrice;
		this.buyTime = buyTime;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public double getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(double payPrice) {
		this.payPrice = payPrice;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	
}
