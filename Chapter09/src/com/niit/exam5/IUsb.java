package com.niit.exam5;
/**
 * USB�ӿڣ��ӿ��ǲ�ͬ�����һ����������
 * �ӿڿ��Զ��������ͽ���ͳһ��
 * �ӿ��ж���Ĺ淶���ǳ��󷽷������󷽷�û�з�����
 * �ӿڲ��ܽ���ʵ����
 * 
 * @author Administrator
 *
 */
public interface IUsb {
	/**
	 * �ӿ��еĳ��󷽷�Ĭ�����public abstract�������η����ҷ��ʼ��������public
	 * ����USB�ķ���
	 */
	public abstract void start();
	
	/**
	 * ֹͣUSB�ķ���
	 */
	void stop();
	
	/**
	 * USB��ȡ���ݵķ���
	 * @return ��ȡ��������
	 */
	public String loadData(IUsb usb);
}
