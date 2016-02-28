package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * 品牌类
 * @author Administrator
 *
 */
public class Brand {
	//品牌编号
	private int brandId;
	//品牌名称
	private String brandName;
	/**
	 * 构造方法
	 * @param brandId
	 * @param brandName
	 */
	public Brand(String brandName){
		this.brandId = CommonUtil.getBrandId();
		this.brandName = brandName;
	}
	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Brand){
				Brand brand = (Brand)obj;
				if(this.brandName.equals(brand.getBrandName())){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public int getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}
	
}
