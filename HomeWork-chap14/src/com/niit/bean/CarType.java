package com.niit.bean;

import com.niit.util.CommonUtil;

/**
 * ������
 * @author Administrator
 *
 */
public class CarType {
	//���ͱ��
	private int typeId;
	//��������
	private String typeName;
	//Ʒ�Ʊ��
	private int brandId;
	/**
	 * ���췽��
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
	 * ��дequals����
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
