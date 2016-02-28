package com.niit.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * �����¼
 * @author Administrator
 *
 */
public class Record extends Ware implements Serializable{
	//��������
	private int buyNum;
	//������
	private double payPrice;
	//����ʱ��
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
