package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.Brand;
import com.niit.bean.CarType;
import com.niit.dao.iface.ICarTypeDao;
import com.niit.data.Data;

public class CarTypeDao implements ICarTypeDao{
	
	private ArrayList<CarType> carTypeData = new ArrayList<CarType>();
	
	public CarTypeDao(Data data){
		carTypeData = data.getCarTypeData();
	}

	/**
	 * 添加车型
	 */
	@Override
	public void add(CarType carType) {
		carTypeData.add(carType);
	}

	/**
	 * 根据品牌查找该品牌下的所有车型
	 */
	@Override
	public ArrayList<CarType> findBrandCarType(Brand brand) {
		ArrayList<CarType> cartypeInBrand =new ArrayList<CarType>();
		for(CarType cartype: carTypeData){
			if(cartype.getBrandId() == brand.getBrandId()){
				cartypeInBrand.add(cartype);
			}
		}
		return cartypeInBrand;
	}

	/**
	 * 根据carTypeId返回carTypeName
	 */
	@Override
	public String findCarTypeNameByCarTypeId(int cartypeId) {
		for(CarType cartype: carTypeData){
			if(cartype.getTypeId() == cartypeId){
				return cartype.getTypeName();
			}
		}
		return null;
	}

	/**
	 * 删除某车型
	 */
	@Override
	public void delCarType(CarType carType) {
		int index = carTypeData.indexOf(carType);
		if(index != -1){
			carTypeData.remove(index);
		}
	}

	@Override
	public ArrayList<CarType> findBrandCarType(int brandId) {
		ArrayList<CarType> cartypeInBrand =new ArrayList<CarType>();
		for(CarType cartype: carTypeData){
			if(cartype.getBrandId() == brandId){
				cartypeInBrand.add(cartype);
			}
		}
		return cartypeInBrand;
	}
	
	

}
