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
	 * ��ӳ���
	 */
	@Override
	public void add(CarType carType) {
		carTypeData.add(carType);
	}

	/**
	 * ����Ʒ�Ʋ��Ҹ�Ʒ���µ����г���
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
	 * ����carTypeId����carTypeName
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
	 * ɾ��ĳ����
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
