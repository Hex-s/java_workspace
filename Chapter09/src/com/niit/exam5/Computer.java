package com.niit.exam5;
/**
 * ����
 * @author Administrator
 *
 */
public class Computer {
	//�����д���һ��USB�ӿ�
	private IUsb usb;

	/**
	 * ���豸����USB�ӿڵķ���
	 * @param usb
	 */
	public void setUsb(IUsb usb) {
		//�ӿڿ��Խ���ʵ����
		this.usb = usb;
	}

	public IUsb getUsb() {
		return usb;
	}
	
}
