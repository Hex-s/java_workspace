package com.niit.exam1;
/**
 * ��Ʒ��
 * @author Administrator
 *
 */
public class Product {
	//�����Խ���˽�л�
	//��Ʒ���
	private int productId;
	//Ʒ��
	private String productName;
	//�۸�
	private double price;
	
	/**
	 * ��Ĺ��췽�����������ʵ����ʱ�Զ�����
	 * ���ڹ��췽��������new��ʱ���Զ����ã���˿��Խ������ʼ��������ݲ���д�빹�췽��
	 */
	public Product(int productId, String productName, double price){
		System.out.println("product�����ڽ���ʵ����");
		//�ڹ��췽���ж����Խ��и�ֵ
		this.productId = productId;
		this.productName = productName;
//		if(price > 0){
//			this.price = price;
//		}
//		else{
//			this.price = 10;
//		}
		//���췽��Ҳ���Իص���������
		setPrice(price);
		
	}
	
	/**
	 * �����û��д���췽����JVM��Ϊÿ�������һ��Ĭ�ϵ���ʽ���췽��
	 * һ������Ա�Զ�������Ĺ��췽�������Ḳ�ǵ�ԭ�е���ʽ����
	 */
//	public Product(){
//		
//	}
	
	/***********************��˽�����Խ��ж�д��getter��setter����************************/
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
		System.out.println("��Ʒ����ǣ�"+productId+",��Ʒ���ƣ�"+productName+",�۸�"+price);
	}



	
	
}
