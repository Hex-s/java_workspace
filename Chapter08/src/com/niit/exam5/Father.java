package com.niit.exam5;

public class Father {
	
	private String name;
	/**
	 * ����Ĵ��ι���
	 * @param name
	 */
	public Father(String name){
		this.name = name;
		System.out.println("�������ڽ���ʵ����");
	}
	/**
	 * ���ظ���Ĺ��췽��
	 */
	public Father(){
		System.out.println("�������ڽ����޲εĹ���");
	}
	public void show(){
		System.out.println("����ķ���");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
