package com.niit.exam5;

public class Child extends Father {

	/**
	 * �����ڽ���ʵ����ǰ���ȶԸ������ʵ����
	 */
	public Child(String name){
		//JVM����ʽ�������´���
		//�Ը������ʵ����������ʵ�����ĵ��ñ���д�����๹��ĵ�һ��
		//JVMֻ�ܶԸ���Ŀղν�����ʽ���ã����������ֻ��һ�����ι���ʱ�������Ҫ�ֶ����ø���Ĺ��췽��
		super(name);
		//super();
		System.out.println("�������ڽ���ʵ����");
	}
	
	
	public void childMethod(){
		System.out.println(super.getName());
	}
	
}
