package com.niit.shoppingsys;
/**
 * ������Ʒ��
 * @author Administrator
 *
 */
public class Others {
	//������Ʒ��Ʒ��
	private String othersBrand;
	//������Ʒ�ļ۸�
	private double othersPrice;
	/**
	 * ������Ʒ��Ĺ��췽��
	 * @param othersBrand
	 * @param othersPrice
	 */
	public Others(String othersBrand,double othersPrice){
		this.othersBrand = othersBrand;
		setOthersPrice(othersPrice);
	}

	public String getOthersBrand() {
		return othersBrand;
	}

	public void setOthersBrand(String othersBrand) {
		this.othersBrand = othersBrand;
	}

	public double getOthersPrice() {
		return othersPrice;
	}

	public void setOthersPrice(double othersPrice) {
		if(othersPrice > 0){
			this.othersPrice = othersPrice;
		}
		else{
			this.othersPrice = 300;
		}
	}
	
	
}
