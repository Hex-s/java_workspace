package com.niit.component;

import java.awt.Color;

import javax.swing.JComboBox;
/**
 * �Զ��������б��
 * @author Administrator
 *
 */
public class MyComboBox extends JComboBox {
	
	/**
	 * �Զ�������ѡ��ķ���
	 * 
	 * @param item
	 */
	public void addMyItem(MyItem item) {
		// TODO Auto-generated method stub
		super.addItem(item);
	}

	/**
	 * ��ȡѡ�������ɫ
	 * @return
	 */
	public Color getSelectedColor(){
		MyItem item = (MyItem)this.getSelectedItem();
		return item.getColor();
	}
}
