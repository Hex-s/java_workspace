package com.niit.dao.iface;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;
import com.niit.bean.CarType;

public interface ICarDao {
	
	/**
	 * 返回所有的汽车信息
	 * @return
	 */
	public ArrayList<Car> findAll();
	
	/**
	 * 返回车型下的所有汽车
	 * @param carType
	 * @return
	 */
	public ArrayList<Car> findCarTypeCar(CarType carType);

	/**
	 * 添加汽车
	 * @param car
	 */
	public void add(Car car);
	
	/**
	 * 对汽车根据发布时间进行排序
	 * @param allCars
	 */
	public void carOrder();
	
	/**
	 * 最新十辆车的信息
	 */
	public ArrayList<Car> newsCars();
	/**
	 * 根据汽车编号查找汽车
	 * @param index
	 */
	public Car findCarByCarId(int carId);
	/**
	 * 根据汽车编号修改汽车
	 * @param car
	 */
	public void modify(int carId,Car car);
	
	/**
	 * 查找某车型下的所有汽车
	 * @param carType
	 * @return
	 */
	public ArrayList<Car> findCarsByCarTypeId(CarType carType);
	
	/**
	 * 删除某车型下的所有汽车
	 * @param carType
	 */
	public void deleCarInCarType(CarType carType);
	
	/**
	 * 根据价格进行搜索
	 * @param lowPrice
	 * @param upPrice
	 * @return
	 */
	public ArrayList<Car> findCarsByPrice(int lowPrice,int upPrice);
	
	/**
	 * 根据上牌时间进行搜索
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Car> findCarsByBoardTime(Calendar start,Calendar end);
}
