package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;

import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.dao.iface.ICarDao;
import com.niit.data.Data;

public class CarDao implements ICarDao{
	
	private ArrayList<Car> carData = new ArrayList<Car>();
	
	public CarDao(Data data){
		carData = data.getCarData();
	}

	/**
	 * ������������
	 */
	@Override
	public ArrayList<Car> findAll() {
		return carData;
	}

	/**
	 * ���س����µ���������
	 */
	@Override
	public ArrayList<Car> findCarTypeCar(CarType carType) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(Car car: carData){
			if(car.getTypeId() == carType.getTypeId()){
				cars.add(car);
			}
		}
		return cars;
	}

	/**
	 * �������
	 */
	@Override
	public void add(Car car) {
		carData.add(car);
	}
	
	/**
	 * ���������ݷ���ʱ���������
	 * @param allCars
	 */
	@Override
	public void carOrder() {
		for(int i = 0; i < carData.size() - 1; i++){
			for(int j = i + 1; j < carData.size(); j++){
				if(carData.get(i).getPublishTime().before(carData.get(j).getPublishTime())){
					Car temp = carData.get(i);
					carData.set(i, carData.get(j));
					carData.set(j, temp);
				}
			}
		}
		
	}

	/**
	 * ����������Ų�������
	 * @param index
	 */
	@Override
	public Car findCarByCarId(int carId) {
		for(Car car: carData){
			if(car.getCarId() == carId){
				return car;
			}
		}
		return null;
	}

	/**
	 * ������������޸�����
	 */
	@Override
	public void modify(int carId, Car car) {
		Car c = findCarByCarId(carId);
		if(c != null){
			int index = carData.indexOf(c);
			carData.set(index, car);
		}
	}

	/**
	 * ���ݳ��ͱ�Ż��ĳ�����µ���������
	 */
	@Override
	public ArrayList<Car> findCarsByCarTypeId(CarType carType) {
		ArrayList<Car> cars= new ArrayList<Car>();
		for(Car car: carData){
			if(car.getTypeId() == carType.getTypeId()){
				cars.add(car);
			}
		}
		return cars;
	}

	/**
	 *  ɾ��ĳ�����µ���������
	 */
	@Override
	public void deleCarInCarType(CarType carType) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(Car car : carData){
			if(car.getTypeId() == carType.getTypeId()){
				cars.add(car);
			}
		}
		carData.removeAll(cars);
	}

	/**
	 * ���ݼ۸��������
	 */
	@Override
	public ArrayList<Car> findCarsByPrice(int lowPrice, int upPrice) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(Car car: carData){
			if(car.getPrice() >= lowPrice && car.getPrice() <= upPrice)
				cars.add(car);
		}
		return cars;
	}

	/**
	 * ��������ʱ���������
	 */
	@Override
	public ArrayList<Car> findCarsByBoardTime(Calendar start, Calendar end) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(Car car : carData){
			long time = car.getBoardTime().getTimeInMillis();
			if(time >= start.getTimeInMillis() && time <= end.getTimeInMillis()){
				cars.add(car);
			}
		}
		return cars;
	}

	/**
	 * �������µ�10����
	 */
	@Override
	public ArrayList<Car> newsCars() {
		ArrayList<Car> newCars= new ArrayList<Car>();
		int count = 0;
		for(Car car: carData){
			if(!car.getSoldState()){
				count++;
				if(count <= 10){
					newCars.add(car);
				}
				else{
					break;
				}
			}
			
		}
		return newCars;
	}

	/**
	 * ɾ������
	 */
	@Override
	public void deleteCar(Car deleCar) {
		Car c = new Car();
		for(Car car : carData){
			if(car.getCarId() == deleCar.getCarId()){
				c = car;
				break;
			}
		}
		carData.remove(c);
	}

	
	
	
}
