package com.niit.exam5;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʵ��������
		Computer cpu = new Computer();
		//ʵ����U��
		Udisk uDisk = new Udisk();
		//ʵ�������
		Camera camera = new Camera();
		//ʵ�����ƶ��绰
		Mobile mobile = new Mobile();
		//��U�̽�����Ե�USB�ӿ�
		cpu.setUsb(camera);
//		//��USB�ӿ��е��豸��������
//		cpu.getUsb().start();
//		//ֹͣUSB�ӿ��е��豸ʹ��
//		cpu.getUsb().stop();
		//��ȡ����USB�ӿ��е�����
		System.out.println(cpu.getUsb().loadData(null));
	}

}
