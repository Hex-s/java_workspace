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
	 * 添加品牌
	 */
	@Override
	public void add(Brand brand) {
		brandData.add(brand);
	}

	/**
	 * 查找所有的品牌
	 */
	@Override
	public ArrayList<Brand> findAllBrand() {
		return brandData;
	}
	/**
	 * 根据品牌Id查找品牌名称
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
