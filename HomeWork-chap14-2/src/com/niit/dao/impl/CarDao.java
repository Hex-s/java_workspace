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
	 * 返回所有汽车
	 */
	@Override
	public ArrayList<Car> findAll() {
		return carData;
	}

	/**
	 * 返回车型下的所有汽车
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
	 * 添加汽车
	 */
	@Override
	public void add(Car car) {
		carData.add(car);
	}
	
	/**
	 * 对汽车根据发布时间进行排序
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
	 * 根据汽车编号查找汽车
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
	 * 根据汽车编号修改汽车
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
	 * 根据车型编号获得某车型下的所有汽车
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
	 *  删除某车型下的所有汽车
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
	 * 根据价格进行搜索
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
	 * 根据上牌时间进行搜索
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
	 * 返回最新的10辆车
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
	 * 删除汽车
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
