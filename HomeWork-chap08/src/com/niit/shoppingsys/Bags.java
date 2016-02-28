package com.niit.shoppingsys;
/**
 * 包类
 * @author Administrator
 *
 */
public class Bags {

	// 包的品牌
	private String bagBrand;
	// 包的价格
	private double bagPrice;

	/**
	 * 包类的构造方法
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
