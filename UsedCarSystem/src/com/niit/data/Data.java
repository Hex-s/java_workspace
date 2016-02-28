package com.niit.data;

import java.util.Calendar;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * �����࣬�洢��ϵͳ����Ҫ�־ñ������������
 * @author Administrator
 *
 */
public class Data {
	//���е��û���Ϣ
	public User[] userData;
	//���е�������Ϣ
	public Car[] carData;
	//���е�Ʒ����Ϣ
	public Brand[] brandData;
	//���еĳ�����Ϣ
	public CarType[] carTypeData;
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		//ʵ�����洢������
		userData = new User[100];
		carData = new Car[100];
		brandData = new Brand[100];
		carTypeData = new CarType[100];
		
		/********��ʼ���û�����************/
		User user1 = new User();
		User user2 = new User();
		user1.init();
		user2.init();
		user1.userName = "admin";
		user1.password = "123";
		user1.isAdmin = true;
		user1.money = 80000;	
		user2.userName = "tom";
		user2.password = "123";
		user2.isAdmin = false;
		user2.money = 80000;	
		//����ʼ����д���û�����
		userData[0] = user1;
		userData[1] = user2;
		
		
		/************��ʼ��Ʒ������*************/
		Brand brand1 = new Brand();
		brand1.brandId = CommonUtil.getBrandId();
		brand1.brandName = "����";
		Brand brand2 = new Brand();
		brand2.brandId = CommonUtil.getBrandId();
		brand2.brandName = "�µ�";
		Brand brand3 = new Brand();
		brand3.brandId = CommonUtil.getBrandId();
		brand3.brandName = "����";
		//����ʼ����д��Ʒ������
		brandData[0] = brand1;
		brandData[1] = brand2;
		brandData[2] = brand3;
		
		
		/**************��ʼ����������****************/
		CarType type1 = new CarType();
		type1.typeId = CommonUtil.getTypeId();
		type1.brandId = 1;
		type1.typeName = "������";
		
		CarType type2 = new CarType();
		type2.typeId = CommonUtil.getTypeId();
		type2.brandId = 1;
		type2.typeName = "����";
		
		CarType type3 = new CarType();
		type3.typeId = CommonUtil.getTypeId();
		type3.brandId = 1;
		type3.typeName = "����";
		
		CarType type4 = new CarType();
		type4.typeId = CommonUtil.getTypeId();
		type4.brandId = 2;
		type4.typeName = "A4L";
		
		CarType type5 = new CarType();
		type5.typeId = CommonUtil.getTypeId();
		type5.brandId = 2;
		type5.typeName = "R8";
		
		CarType type6 = new CarType();
		type6.typeId = CommonUtil.getTypeId();
		type6.brandId = 3;
		type6.typeName = "320i";
		
		CarType type7 = new CarType();
		type7.typeId = CommonUtil.getTypeId();
		type7.brandId = 3;
		type7.typeName = "725i";
		//����ʼ����д�복������
		carTypeData[0] = type1;
		carTypeData[1] = type2;
		carTypeData[2] = type3;
		carTypeData[3] = type4;
		carTypeData[4] = type5;
		carTypeData[5] = type6;
		carTypeData[6] = type7;
		
		
		/**************��ʼ����������****************/
		Car car1 = new Car();
		car1.init();
		car1.carId = CommonUtil.getCarId();
		car1.brandId = 1;
		car1.typeId = 1;
		car1.price = 145000;
		car1.mileage = 280;
		car1.outputVolume = 1.6;
		car1.isSold = false;
		car1.clutchType = "�ֶ���";
		car1.boardTime.set(2009, 8, 9);
		car1.publishTime.set(2012, 7, 5);
		
		Car car2 = new Car();
		car2.init();
		car2.carId = CommonUtil.getCarId();
		car2.brandId = 1;
		car2.typeId = 2;
		car2.price = 106000;
		car2.mileage = 300;
		car2.outputVolume = 1.8;
		car2.isSold = false;
		car2.clutchType = "�Զ���";
		car2.boardTime.set(2010, 9, 16);
		car2.publishTime.set(2013, 6, 4);
		
		Car car3 = new Car();
		car3.init();
		car3.carId = CommonUtil.getCarId();
		car3.brandId = 1;
		car3.typeId = 3;
		car3.price = 79000;
		car3.mileage = 230;
		car3.outputVolume = 2.0;
		car3.isSold = false;
		car3.clutchType = "�Զ���";
		car3.boardTime.set(2009, 5, 19);
		car3.publishTime.set(2014, 5, 5);
		
		Car car4 = new Car();
		car4.init();
		car4.carId = CommonUtil.getCarId();
		car4.brandId = 2;
		car4.typeId = 4;
		car4.price = 49000;
		car4.mileage = 300;
		car4.outputVolume = 1.8;
		car4.isSold = false;
		car4.clutchType = "�Զ���";
		car4.boardTime.set(2012, 1, 1);
		car4.publishTime.set(2014, 4, 7);
		
		Car car5 = new Car();
		car5.init();
		car5.carId = CommonUtil.getCarId();
		car5.brandId = 2;
		car5.typeId = 5;
		car5.price = 80000;
		car5.mileage = 300;
		car5.outputVolume = 1.8;
		car5.isSold = false;
		car5.clutchType = "�Զ���";
		car5.boardTime.set(2012, 2, 17);
		car5.publishTime.set(2014, 7, 2);
		
		Car car6 = new Car();
		car6.init();
		car6.carId = CommonUtil.getCarId();
		car6.brandId = 3;
		car6.typeId = 6;
		car6.price = 120000;
		car6.mileage = 300;
		car6.outputVolume = 1.8;
		car6.isSold = false;
		car6.clutchType = "�Զ���";
		car6.boardTime.set(2011, 5, 23);
		car6.publishTime.set(2014, 6, 1);
		
		Car car7 = new Car();
		car7.init();
		car7.carId = CommonUtil.getCarId();
		car7.brandId = 3;
		car7.typeId = 7;
		car7.price = 48000;
		car7.mileage = 300;
		car7.outputVolume = 1.8;
		car7.isSold = false;
		car7.clutchType = "�Զ���";
		car7.boardTime.set(2009, 2, 27);
		car7.publishTime.set(2013, 8, 15);
		
		Car car8 = new Car();
		car8.init();
		car8.carId = CommonUtil.getCarId();
		car8.brandId = 3;
		car8.typeId = 7;
		car8.price = 156000;
		car8.mileage = 300;
		car8.outputVolume = 1.8;
		car8.isSold = false;
		car8.clutchType = "�Զ���";
		car8.boardTime.set(2010, 8, 17);
		car8.publishTime.set(2013, 5, 12);
		
		Car car9 = new Car();
		car9.init();
		car9.carId = CommonUtil.getCarId();
		car9.brandId = 3;
		car9.typeId = 6;
		car9.price = 149000;
		car9.mileage = 300;
		car9.outputVolume = 1.8;
		car9.isSold = false;
		car9.clutchType = "�Զ���";
		car9.boardTime.set(2011, 7, 13);
		car9.publishTime.set(2012, 9, 22);
		
		Car car10 = new Car();
		car10.init();
		car10.carId = CommonUtil.getCarId();
		car10.brandId = 2;
		car10.typeId = 4;
		car10.price = 160000;
		car10.mileage = 300;
		car10.outputVolume = 1.8;
		car10.isSold = false;
		car10.clutchType = "�Զ���";
		car10.boardTime.set(2010, 5, 3);
		car10.publishTime.set(2010, 3, 23);
		
		Car car11 = new Car();
		car11.init();
		car11.carId = CommonUtil.getCarId();
		car11.brandId = 1;
		car11.typeId = 3;
		car11.price = 98000;
		car11.mileage = 300;
		car11.outputVolume = 1.8;
		car11.isSold = false;
		car11.clutchType = "�Զ���";
		car11.boardTime.set(2009, 10, 3);
		car11.publishTime.set(2011, 6, 17);
		
		Car car12 = new Car();
		car12.init();
		car12.carId = CommonUtil.getCarId();
		car12.brandId = 1;
		car12.typeId = 3;
		car12.price = 58000;
		car12.mileage = 350;
		car12.outputVolume = 1.6;
		car12.isSold = false;
		car12.clutchType = "�Զ���";
		car12.boardTime.set(2010, 10, 3);
		car12.publishTime.set(2012, 6, 17);
		
		//����ʼ����д����������
		carData[0] = car1;
		carData[1] = car2;
		carData[2] = car3;
		carData[3] = car4;
		carData[4] = car5;
		carData[5] = car6;
		carData[6] = car7;
		carData[7] = car8;
		carData[8] = car9;
		carData[9] = car10;
		carData[10] = car11;
		carData[11] = car12;
	}
}
