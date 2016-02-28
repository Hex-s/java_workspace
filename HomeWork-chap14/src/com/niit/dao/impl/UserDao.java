package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.dao.iface.IUserDao;
import com.niit.data.Data;

public class UserDao implements IUserDao{
	
	private ArrayList<User> userData = new ArrayList<User>();
	
	public UserDao(Data data){
		userData = data.getUserData();
	}

	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) {
		userData.add(user);
	}

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public User findUserByName(String name) {
		for(User user: userData){
			if(user.getUserName().equals(name)){
				return user;
			}
		}
		return null;
	}

	/**
	 * 根据用户编号查找用户对象
	 */
	@Override
	public User findUserById(int userId) {
		//遍历用户集合
		for(User u : userData){
			if(u.getUserId() == userId){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * 根据用户编号修改用户信息
	 */
	@Override
	public void modify(int userId,User user) {
		User u = findUserById(userId);
		if(u != null){
			int index = userData.indexOf(u);
			userData.set(index, user);
		}
		
	}

	/**
	 * 查找所有用户
	 */
	@Override
	public ArrayList<User> findAll() {
		return userData;
	}

	/**
	 * 删除收藏中的车型
	 */
	@Override
	public void deleCollection(CarType carType) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(User user: userData){
			for(Car car: user.getCollectCars()){
				if(car.getTypeId() == carType.getTypeId()){
					cars.add(car);
				}
			}
			user.getCollectCars().removeAll(cars);
			cars.clear();
		}
	}

	/**
	 * 删除对比中的某车型下的汽车
	 */
	@Override
	public void deleCompare(CarType carType) {
		ArrayList<Car> cars = new ArrayList<Car>();
		for(User user: userData){
			for(Car car: user.getCompareCars()){
				if(car.getTypeId() == carType.getTypeId()){
					cars.add(car);
				}
			}
			user.getCompareCars().removeAll(cars);
			cars.clear();
		}
	}

	/**
	 * 删除收藏中的某车型下的汽车
	 */
	@Override
	public void deleCollectionAfterBuy(Car car) {
		Car delcar = new Car();
		for(User user : userData){
			for(Car cars : user.getCollectCars()){
				if(cars.getCarId() == car.getCarId()){
					delcar = cars;
					break;
				}
			}
			if(delcar != null){
				user.getCollectCars().remove(delcar);
			}
		}
	}

	/**
	 * 删除收藏中的某汽车
	 */
	@Override
	public void deleCompareAfterBuy(Car car) {
		Car delcar = new Car();
		for(User user : userData){
			for(Car cars : user.getCompareCars()){
				if(cars.getCarId() == car.getCarId()){
					delcar = cars;
					break;
				}
			}
			if(delcar != null){
				user.getCompareCars().remove(delcar);
			}
		}
		
	}

	

}
