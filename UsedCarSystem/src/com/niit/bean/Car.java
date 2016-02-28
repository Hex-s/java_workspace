package com.niit.bean;
/**
 * 汽车类
 */

import java.util.Calendar;

public class Car {

	//汽车编号
	public int carId;
	//品牌编号
	public int brandId;
	//车型编号
	public int typeId;
	//排量
	public double outputVolume;
	//里程数
	public double mileage;
	//价格
	public int price;
	//离合器类型
	public String clutchType;
	//上牌时间
	public Calendar boardTime;
	//发布时间
	public Calendar publishTime;
	//购买标识
	public boolean isSold; 
	
	public void init(){
		boardTime = Calendar.getInstance();
		publishTime = Calendar.getInstance();
	}
	
}
