package com.niit.exam5;
/**
 * U��
 * �ܹ�����USB�ӿڵ�U�̱���ʵ��USB�ӿ��ṩ�����й淶
 * ͨ��implementsʵ�ֽӿ�
 * implements�ӿڵ����Ϊ�ӿڵ�ʵ����
 * @author Administrator
 *
 */
public class Udisk implements IUsb {
	
	private String data = "�洢��1-9�µ�JAVA�μ�";
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("U��ͨ��USB�ӿ�������");
	}

	@Override
	public void stop() {
		System.out.println("U�̴�USB�ӿ��аγ���");
	}

	
	
}
