package com.niit.exam4;
/**
 * ���� �̳����游��
 * @author Administrator
 *
 */
public class Father extends GrandFather {
	//ͷ������ɫ
	private String hairColor;
	//�۾�����ɫ
	private String eyeColor;
	
	/**
	 * ͨ�����췽����ʼ�����׵�����
	 */
	public Father(){
		hairColor = "���ɫ";
		eyeColor = "��ɫ";
	}
	
	/**
	 * ���׵�ϰ�߶���
	 */
	public void habit(){
		System.out.println("ϰ�߳Է�ʱ��߶");
	}
	/**
	 * ���̵ķ���
	 */
	public void smoking(){
		System.out.println("ϲ������ʱ�³��ܴ��ԲȦ");
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
