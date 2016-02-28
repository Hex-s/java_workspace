package com.niit.exam1;
/**
 * 商品类
 * @author Administrator
 *
 */
public class Product {
	//对属性进行私有化
	//商品编号
	private int productId;
	//品名
	private String productName;
	//价格
	private double price;
	
	/**
	 * 类的构造方法，在类进行实例化时自动调用
	 * 由于构造方法是在类new的时候自动调用，因此可以将该类初始必须的数据操作写入构造方法
	 */
	public Product(int productId, String productName, double price){
		System.out.println("product类正在进行实例化");
		//在构造方法中对属性进行赋值
		this.productId = productId;
		this.productName = productName;
//		if(price > 0){
//			this.price = price;
//		}
//		else{
//			this.price = 10;
//		}
		//构造方法也可以回调其他方法
		setPrice(price);
		
	}
	
	/**
	 * 如果类没有写构造方法，JVM会为每个类添加一个默认的隐式构造方法
	 * 一旦程序员自定义了类的构造方法，将会覆盖掉原有的隐式构造
	 */
//	public Product(){
//		
//	}
	
	/***********************对私有属性进行读写的getter和setter方法************************/
	public void setProductId(int productId){
		this.productId = productId;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}
	public void setPrice(double price){
		if(price > 0){
			this.price = price;
		}
	}
	public double getPrice(){
		return price;
	}
	
	
	public void details(){
		System.out.println("商品编号是："+productId+",商品名称："+productName+",价格："+price);
	}



	
	
}
