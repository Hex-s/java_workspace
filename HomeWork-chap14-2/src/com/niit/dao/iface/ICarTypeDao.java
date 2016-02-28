package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;
import com.niit.bean.CarType;

public interface ICarTypeDao {
	/**
	 * ��ӳ���
	 */
	public void add(CarType carType);

	/**
	 * ��ѯĳƷ���µ����г���
	 * @param brand
	 * @return
	 */
	public ArrayList<CarType> findBrandCarType(Brand brand);
	
	/**
	 * ��ѯĳƷ���µ����г���
	 * @param brand
	 * @return
	 */
	public ArrayList<CarType> findBrandCarType(int brandId);
	/**
	 * ����carTypeId����carTypeName
	 * @param cartypeId
	 * @return
	 */
	public String findCarTypeNameByCarTypeId(int cartypeId);
	
	/**
	 * ɾ��ĳ����
	 * @param carType
	 */
	public void delCarType(CarType carType);
}
