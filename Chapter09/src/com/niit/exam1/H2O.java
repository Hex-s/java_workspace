package com.niit.exam1;
/**
 * 水元素 可以在不同的环境中演变成水，水蒸气和冰
 * @author Administrator
 *
 */
public class H2O {
	//温度
	private int temp;

	/**
	 * 构造方法 
	 * @param temp 温度
	 */
	public H2O(int temp){
		this.temp = temp;
	}
	public H2O(){
		
	}
	
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	public void details(){
		System.out.println("这是水元素");
	}
}
