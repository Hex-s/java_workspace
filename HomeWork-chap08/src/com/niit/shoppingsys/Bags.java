package com.niit.shoppingsys;
/**
 * ����
 * @author Administrator
 *
 */
public class Bags {

	// ����Ʒ��
	private String bagBrand;
	// ���ļ۸�
	private double bagPrice;

	/**
	 * ����Ĺ��췽��
	 * @param bagBrand
	 * @param bagprice
	 */
	public Bags(String bagBrand, double bagprice) {
		this.bagBrand = bagBrand;
		setBagPrice(bagprice);
	}

	public String getBagBrand() {
		return bagBrand;
	}

	public void setBagBrand(String bagBrand) {
		this.bagBrand = bagBrand;
	}

	public double getBagPrice() {
		return bagPrice;
	}

	public void setBagPrice(double bagPrice) {
		if(bagPrice > 0){
			this.bagPrice = bagPrice;
		}
		else{
			this.bagPrice = 300;
		}
		
	}
}
