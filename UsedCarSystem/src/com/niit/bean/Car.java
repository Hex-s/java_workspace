package com.niit.bean;
/**
 * ������
 */

import java.util.Calendar;

public class Car {

	//�������
	public int carId;
	//Ʒ�Ʊ��
	public int brandId;
	//���ͱ��
	public int typeId;
	//����
	public double outputVolume;
	//�����
	public double mileage;
	//�۸�
	public int price;
	//���������
	public String clutchType;
	//����ʱ��
	public Calendar boardTime;
	//����ʱ��
	public Calendar publishTime;
	//�����ʶ
	public boolean isSold; 
	
	public void init(){
		boardTime = Calendar.getInstance();
		publishTime = Calendar.getInstance();
	}
	
}
