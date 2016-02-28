package com.niit.shoppingsys;
/**
 * 服装类
 * @author Administrator
 *
 */
public class Clothes {
	
	//衣服的品牌
	private String clothesBrand;
	//衣服的价格
	private double clothesPrice;
	
	/**
	 * 衣服类的构造方法
	 * @param clothesBrand
	 * @param clothesPrice
	 */
	public Clothes(String clothesBrand,double clothesPrice){
		this.clothesBrand = clothesBrand;
		setClothesPrice(clothesPrice);
	}
	
	public String getClothesBrand() {
		return clothesBrand;
	}
	public void setClothesBrand(String clothesBrand) {
		this.clothesBrand = clothesBrand;
	}
	public double getClothesPrice() {
		return clothesPrice;
	}
	public void setClothesPrice(double clothesPrice) {
		if(clothesPrice > 0){
			this.clothesPrice = clothesPrice;
		}
		else{
			this.clothesPrice = 300;
		}
	}
	
}
