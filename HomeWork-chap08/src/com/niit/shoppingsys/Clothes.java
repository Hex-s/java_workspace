package com.niit.shoppingsys;
/**
 * ��װ��
 * @author Administrator
 *
 */
public class Clothes {
	
	//�·���Ʒ��
	private String clothesBrand;
	//�·��ļ۸�
	private double clothesPrice;
	
	/**
	 * �·���Ĺ��췽��
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
