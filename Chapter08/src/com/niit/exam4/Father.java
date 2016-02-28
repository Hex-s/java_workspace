package com.niit.exam4;
/**
 * 父类 继承自祖父类
 * @author Administrator
 *
 */
public class Father extends GrandFather {
	//头发的颜色
	private String hairColor;
	//眼睛的颜色
	private String eyeColor;
	
	/**
	 * 通过构造方法初始化父亲的特征
	 */
	public Father(){
		hairColor = "金黄色";
		eyeColor = "褐色";
	}
	
	/**
	 * 父亲的习惯动作
	 */
	public void habit(){
		System.out.println("习惯吃饭时唠叨");
	}
	/**
	 * 抽烟的方法
	 */
	public void smoking(){
		System.out.println("喜欢抽烟时吐出很大的圆圈");
	}
	
	
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
}
