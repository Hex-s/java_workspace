package com.niit.exam10;
/**
 * ��ɫ��ӡ��
 * @author Administrator
 *
 */
public class ColorPrinter implements IPrinter {

	@Override
	public String print(IInfo info) {
		// TODO Auto-generated method stub
		return "��ɫ��ӡ��"+info.getData();
	}

}
