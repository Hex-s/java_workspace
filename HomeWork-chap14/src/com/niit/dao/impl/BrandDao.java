package com.niit.dao.impl;

import java.util.ArrayList;

import com.niit.bean.Brand;
import com.niit.dao.iface.IBrandDao;
import com.niit.data.Data;

public class BrandDao implements IBrandDao{
	
	private ArrayList<Brand> brandData = new ArrayList<Brand>();

	public BrandDao(Data data){
		brandData = data.getBrandData();
	}
	/**
	 * ���Ʒ��
	 */
	@Override
	public void add(Brand brand) {
		brandData.add(brand);
	}

	/**
	 * �������е�Ʒ��
	 */
	@Override
	public ArrayList<Brand> findAllBrand() {
		return brandData;
	}
	/**
	 * ����Ʒ��Id����Ʒ������
	 * @return
	 */
	@Override
	public String findBrandNameByBrandId(int brandId) {
		for(Brand brand: brandData){
			if(brand.getBrandId() == brandId){
				return brand.getBrandName();
			}
		}
		return null;
	}

}
