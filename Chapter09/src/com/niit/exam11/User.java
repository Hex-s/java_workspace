package com.niit.exam11;
/**
 * �����࣬�����಻�ܽ���ʵ������ֻ��ͨ���̳���ʹ��
 * ����������ͽӿڵĽ����
 * @author Administrator
 *
 */
public abstract class User {
	private String name;
	
	/**
	 * �������п�����ʵ�巽��
	 */
	public void details(){
		System.out.println("�û���������Ϣ");
	}
	/**
	 * ��������Ҳ�����г��󷽷�
	 */
	public abstract void method();
}
