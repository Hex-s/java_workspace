package com.niit.exam5;
/**
 * �����
 * @author Administrator
 *
 */
public class Camera implements IUsb {

	private String data = "����д洢��100����Ƭ";
	
	@Override
	public String loadData(IUsb usb) {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void start() {
		System.out.println("���ͨ��USB�ӿ�����");
	}

	@Override
	public void stop() {
		System.out.println("�����USB�ӿڰγ�");
	}
	
}
