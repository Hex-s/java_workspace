package com.niit.exam5;
/**
 * �ƶ��绰
 * @author Administrator
 *
 */
public class Mobile implements IUsb {

	private String data = "�洢��24���˵���ϵ�绰";
	
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("�ƶ��绰����USB�ӿ�����");
	}

	@Override
	public void stop() {
		System.out.println("�ƶ��绰��USB�ӿ��аγ�");
	}
	
}
