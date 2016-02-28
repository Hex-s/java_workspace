package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;
import com.niit.bean.CarType;

public interface ICarTypeDao {
	/**
	 * 添加车型
	 */
	public void add(CarType carType);

	/**
	 * 查询某品牌下的所有车型
	 * @param brand
	 * @return
	 */
	public ArrayList<CarType> findBrandCarType(Brand brand);
	
	/**
	 * 查询某品牌下的所有车型
	 * @param brand
	 * @return
	 */
	public ArrayList<CarType> findBrandCarType(int brandId);
	/**
	 * 根据carTypeId返回carTypeName
	 * @param cartypeId
	 * @return
	 */
	public String findCarTypeNameByCarTypeId(int cartypeId);
	
	/**
	 * 删除某车型
	 * @param carType
	 */
	public void delCarType(CarType carType);
}
