package com.niit.exam8.impl;

import com.niit.exam8.iface.IBox;
import com.niit.exam8.iface.IComputer;
import com.niit.exam8.iface.IDisplay;

/**
 * 电脑类
 * @author Administrator
 *
 */
public class Computer implements IComputer {
	//显示器
	private IDisplay display;
	//机箱
	private IBox box;
	public IDisplay getDisplay() {
		return display;
	}
	public void setDisplay(IDisplay display) {
		this.display = display;
	}
	public IBox getBox() {
		return box;
	}
	public void setBox(IBox box) {
		this.box = box;
	}
	
}
