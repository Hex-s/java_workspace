package com.niit.shoppingsys;
/**
 * 其他商品类
 * @author Administrator
 *
 */
public class Others {
	//其他商品的品牌
	private String othersBrand;
	//其他商品的价格
	private double othersPrice;
	/**
	 * 其他商品类的构造方法
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
