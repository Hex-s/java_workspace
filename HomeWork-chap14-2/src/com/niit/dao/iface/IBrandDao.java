package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;

public interface IBrandDao {
	/**
	 * ���Ʒ��
	 * @param brand
	 */
	public void add(Brand brand);
	
	/**
	 * ��������Ʒ����Ϣ
	 * @return
	 */
	public ArrayList<Brand> findAllBrand();
	
	/**
	 * ����Ʒ��Id����Ʒ������
	 * @return
	 */
	public String findBrandNameByBrandId(int brandId);
}

