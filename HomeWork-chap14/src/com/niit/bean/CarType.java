package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * 车型类
 * @author Administrator
 *
 */
public class CarType {
	//车型编号
	private int typeId;
	//车型名称
	private String typeName;
	//品牌编号
	private int brandId;
	/**
	 * 构造方法
	 * @param typeId
	 * @param typeName
	 * @param brandId
	 */
	public CarType(String typeName, int brandId){
		this.typeId = CommonUtil.getTypeId();
		this.brandId = brandId;
		this.typeName = typeName;
	}

	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof CarType){
				CarType cartype = (CarType)obj;
				if(this.typeName.equals(cartype.getTypeName())){
					return true;
				}
			}
		}
		return false;
	}
	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public int getBrandId() {
		return brandId;
	}
}
