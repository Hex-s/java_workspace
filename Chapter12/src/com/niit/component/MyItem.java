package com.niit.component;

import java.awt.Color;

/**
 * 自定义下拉列表框的选项
 * @author Administrator
 *
 */
public class MyItem {
	private String name;
	private Color color;
	
	public MyItem(String name, Color color){
		this.name = name;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
