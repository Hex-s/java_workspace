package com.niit.component;

import java.awt.Color;

import javax.swing.JComboBox;
/**
 * 自定义下拉列表框
 * @author Administrator
 *
 */
public class MyComboBox extends JComboBox {
	
	/**
	 * 自定义的添加选项的方法
	 * 
	 * @param item
	 */
	public void addMyItem(MyItem item) {
		// TODO Auto-generated method stub
		super.addItem(item);
	}

	/**
	 * 获取选中项的颜色
	 * @return
	 */
	public Color getSelectedColor(){
		MyItem item = (MyItem)this.getSelectedItem();
		return item.getColor();
	}
}
