package com.niit.bean;
/**
 * ������
 */

import java.util.Calendar;

import com.niit.util.CommonUtil;

public class Car {
	
	//�������
	private int carId;
	//Ʒ�Ʊ��
	private int brandId;
	//���ͱ��
	private int typeId;
	//����
	private double outputVolume;
	//�����
	private long mileage;
	//�۸�
	private int price;
	//���������
	private String clucthType;
	//����ʱ��
	private Calendar boardTime;
	//����ʱ��
	private Calendar publishTime;
	//�����ʶ
	private boolean isSold;
	/**
	 * �޲ι���
	 */
	public Car(){
		
	}
	/**
	 * ���ι���
	 * @param carId
	 * @param brandId
	 * @param typeId
	 * @param displacement
	 * @param distance
	 * @param price
	 * @param cluthType
	 * @param boardTime
	 * @param publishTime
	 * @param isSell
	 */
	public Car(int brandId, int typeId, double outputVolume, long mileage, int price, String clutchType, Calendar boardTime, Calendar publishTime, boolean isSell){
		this.carId = CommonUtil.getCarId();
		this.brandId = brandId;
		this.typeId = typeId;
		this.outputVolume = outputVolume;
		this.mileage = mileage;
		this.price = price;
		this.clucthType = clutchType;
		this.boardTime = boardTime;
		this.publishTime = publishTime;
		this.isSold = isSell;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public double getOutputVolume() {
		return outputVolume;
	}
	public void setOutputVolume(double outputVolume) {
		this.outputVolume = outputVolume;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getClucthType() {
		return clucthType;
	}
	public void setClucthType(String clucthType) {
		this.clucthType = clucthType;
	}
	public Calendar getBoardTime() {
		return boardTime;
	}
	public void setBoardTime(Calendar boardTime) {
		this.boardTime = boardTime;
	}
	public Calendar getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Calendar publishTime) {
		this.publishTime = publishTime;
	}
	public boolean getSoldState() {
		return isSold;
	}
	public void setSoldState(boolean isSold) {
		this.isSold = isSold;
	}
	
	
	
}
