package com.niit.dao.iface;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;
import com.niit.bean.CarType;

public interface ICarDao {
	
	/**
	 * �������е�������Ϣ
	 * @return
	 */
	public ArrayList<Car> findAll();
	
	/**
	 * ���س����µ���������
	 * @param carType
	 * @return
	 */
	public ArrayList<Car> findCarTypeCar(CarType carType);

	/**
	 * �������
	 * @param car
	 */
	public void add(Car car);
	
	/**
	 * ���������ݷ���ʱ���������
	 * @param allCars
	 */
	public void carOrder();
	
	/**
	 * ����ʮ��������Ϣ
	 */
	public ArrayList<Car> newsCars();
	/**
	 * ����������Ų�������
	 * @param index
	 */
	public Car findCarByCarId(int carId);
	/**
	 * ������������޸�����
	 * @param car
	 */
	public void modify(int carId,Car car);
	
	/**
	 * ����ĳ�����µ���������
	 * @param carType
	 * @return
	 */
	public ArrayList<Car> findCarsByCarTypeId(CarType carType);
	
	/**
	 * ɾ��ĳ�����µ���������
	 * @param carType
	 */
	public void deleCarInCarType(CarType carType);
	
	/**
	 * ���ݼ۸��������
	 * @param lowPrice
	 * @param upPrice
	 * @return
	 */
	public ArrayList<Car> findCarsByPrice(int lowPrice,int upPrice);
	
	/**
	 * ��������ʱ���������
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Car> findCarsByBoardTime(Calendar start,Calendar end);
}
