package com.niit.exam10;
/**
 * ����
 * @author Administrator
 *
 */
public class Human {

	/**
	 * �߱�ʹ�ø��ִ�ӡ���ķ���
	 * @param printer
	 */
	public void usePrinter(IPrinter printer, IInfo info){
		//ʹ�ô�ӡ����ӡ��Ϣ
		System.out.println(printer.print(info));
	}
}
