package com.niit.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.util.CommonUtil;

/**
 * 数据类
 * @author Administrator
 *
 */
public class Data {

	//使用集合存储所有的数据
	//所有的用户信息
	private ArrayList<User> userData;
	//所有的汽车信息
	private ArrayList<Car> carData;
	//所有的品牌信息
	private ArrayList<Brand> brandData;
	//所有的车型信息
	private ArrayList<CarType> carTypeData;
	
	public Data(){
		userData = new ArrayList<User>();
		carData = new ArrayList<Car>();
		brandData = new ArrayList<Brand>();
		carTypeData = new ArrayList<CarType>();
		
		/********初始化用户数据************/
		User user1 = new User("admin", "123", 900000, true);
		User user2 = new User("tom", "123", 90000, false);
		userData.add(user1);
		userData.add(user2);
		
		/************初始化品牌数据*************/
		Brand brand1 = new Brand("大众");
		Brand brand2 = new Brand("奥迪");
		Brand brand3 = new Brand("宝马");
		brandData.add(brand1);
		brandData.add(brand2);
		brandData.add(brand3);
		
		/**************初始化车型数据****************/
		CarType carType1 = new CarType("帕萨特", brand1.getBrandId());//大众-帕萨特
		CarType carType2 = new CarType("速腾", brand1.getBrandId());//大众-速腾
		CarType carType3 = new CarType("迈腾", brand1.getBrandId());//大众-迈腾
		CarType carType4 = new CarType("A4L", brand2.getBrandId());//奥迪-A4L
		CarType carType5 = new CarType("R8",brand2.getBrandId());//奥迪-R8
		CarType carType6 = new CarType("320i", brand3.getBrandId());//宝马-320i
		CarType carType7 = new CarType("725i", brand3.getBrandId());//宝马-725i
		carTypeData.add(carType1);
		carTypeData.add(carType2);
		carTypeData.add(carType3);
		carTypeData.add(carType4);
		carTypeData.add(carType5);
		carTypeData.add(carType6);
		carTypeData.add(carType7);
		
		/**************初始化汽车数据****************/
		Calendar board1 = CommonUtil.getCalendar(2009, 8, 9);
		Calendar publish1 = CommonUtil.getCalendar(2012, 7, 5);
		Car car1 = new Car(1, 1, 1.6, 280, 145000, "手动档", board1, publish1, false);
		
		Calendar board2 = CommonUtil.getCalendar(2010, 9, 16);
		Calendar publish2 = CommonUtil.getCalendar(2013, 6, 4);
		Car car2 = new Car(1, 2, 1.8, 300, 106000, "自动档", board2, publish2, false);
		
		Calendar board3 = CommonUtil.getCalendar(2009, 5, 19);
		Calendar publish3 = CommonUtil.getCalendar(2014, 5, 5);
		Car car3 = new Car(1, 3, 2.0, 230, 79000, "手动档", board3, publish3, false);
		
		Calendar board4 = CommonUtil.getCalendar(2012, 1, 1);
		Calendar publish4 = CommonUtil.getCalendar(2014, 4, 7);
		Car car4 = new Car(2, 4, 1.8, 400, 49000, "自动档", board4, publish4, false);
		
		Calendar board5 = CommonUtil.getCalendar(2012, 2, 17);
		Calendar publish5 = CommonUtil.getCalendar(2014, 7, 2);
		Car car5 = new Car(2, 5, 1.8, 450, 80000, "手动档", board5, publish5, false);
		
		Calendar board6 = CommonUtil.getCalendar(2011, 5, 23);
		Calendar publish6 = CommonUtil.getCalendar(2014, 6, 1);
		Car car6 = new Car(3, 6, 1.8, 200, 120000, "自动档", board6, publish6, false);
		
		Calendar board7 = CommonUtil.getCalendar(2009, 2, 27);
		Calendar publish7 = CommonUtil.getCalendar(2013, 8, 15);
		Car car7 = new Car(3, 7, 1.8, 420, 48000, "自动档", board7, publish7, false);
		
		Calendar board8 = CommonUtil.getCalendar(2010, 8, 17);
		Calendar publish8 = CommonUtil.getCalendar(2013, 5, 12);
		Car car8 = new Car(3, 7, 1.8, 450, 156000, "手动档", board8, publish8, false);
		
		
		Calendar board9 = CommonUtil.getCalendar(2011, 7, 13);
		Calendar publish9 = CommonUtil.getCalendar(2012, 9, 22);
		Car car9 = new Car(3, 6, 1.8, 250, 149000, "自动档", board9, publish9, false);
		
		Calendar board10 = CommonUtil.getCalendar(2010, 5, 3);
		Calendar publish10 = CommonUtil.getCalendar(2012, 3, 23);
		Car car10 = new Car(3, 6, 1.8, 380, 149000, "手动档", board10, publish10, false);
		
		Calendar board11 = CommonUtil.getCalendar(2009, 10, 3);
		Calendar publish11 = CommonUtil.getCalendar(2011, 6, 17);
		Car car11 = new Car(2, 4, 1.8, 480, 160000, "自动档", board11, publish11, false);
		
		Calendar board12 = CommonUtil.getCalendar(2010, 10, 3);
		Calendar publish12 = CommonUtil.getCalendar(2012, 6, 17);
		Car car12 = new Car(1, 3, 1.6, 510, 58000, "手动档", board12, publish12, false);
		
		carData.add(car1);
		carData.add(car2);
		carData.add(car3);
		carData.add(car4);
		carData.add(car5);
		carData.add(car6);
		carData.add(car7);
		carData.add(car8);
		carData.add(car9);
		carData.add(car10);
		carData.add(car11);
		carData.add(car12);
		
	}

	public ArrayList<User> getUserData() {
		return userData;
	}

	public ArrayList<Car> getCarData() {
		return carData;
	}

	public ArrayList<Brand> getBrandData() {
		return brandData;
	}

	public ArrayList<CarType> getCarTypeData() {
		return carTypeData;
	}

}
