package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.bean.Brand;

public interface IBrandDao {
	/**
	 * 添加品牌
	 * @param brand
	 */
	public void add(Brand brand);
	
	/**
	 * 查找所有品牌信息
	 * @return
	 */
	public ArrayList<Brand> findAllBrand();
	
	/**
	 * 根据品牌Id查找品牌名称
	 * @return
	 */
	public String findBrandNameByBrandId(int brandId);
}

