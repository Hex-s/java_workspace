package com.niit.exam4;
/**
 * �����ɸ���������
 * �����ܻ�ȡ���������е����Ժͷ���
 * ����ʵ�ּ̳�ʱӦ�ȸ�������壬1)�ȸ���ӵ�и�������� 2)�ȸ���ӵ�и���ķ��� 3)��д����ԭ�еķ���
 * @author Administrator
 *
 */
public class Child extends Father{
	//��ӵ�����
	private String name;
	
	/**
	 * ��ӵķ���
	 */
	public void play(){
		System.out.println("ϲ����ˣ");
	}
	/**
	 * ������ԶԸ����ԭ�з���������д
	 * ��дֻ���������д��ڣ�ͬʱҪ����д�����ķ���ֵ���ͣ��������Լ������б����Ҫ�͸���ı���д�ķ�������һ�£����ҷ������η����ܵ��ڸ��෽���ķ��ʼ���
	 * 
	 */
	public void smoking(){
		System.out.println("ϲ������ʱ���������");
		//���ø����ͬ������
		super.smoking();
	}
	
	public String getName() {
		return name;
	}

	/**
	 * ʹ��Overrideע��ķ���������һ����д����
	 */
//	@Override
//	public void smoking() {
//		// TODO Auto-generated method stub
//		super.smoking();
//	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
