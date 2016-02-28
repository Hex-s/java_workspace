package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * Ʒ����
 * @author Administrator
 *
 */
public class Brand {
	//Ʒ�Ʊ��
	private int brandId;
	//Ʒ������
	private String brandName;
	/**
	 * ���췽��
	 * @param brandId
	 * @param brandName
	 */
	public Brand(String brandName){
		this.brandId = CommonUtil.getBrandId();
		this.brandName = brandName;
	}
	/**
	 * ��дequals����
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
