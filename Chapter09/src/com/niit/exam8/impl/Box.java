package com.niit.exam8.impl;

import com.niit.exam8.iface.IBox;
import com.niit.exam8.iface.IDisplay;
import com.niit.exam8.iface.IHardDisk;
import com.niit.exam8.iface.IMainBoard;
import com.niit.exam8.iface.IPower;

/**
 * 机箱类
 * @author Administrator
 *
 */
public class Box implements IBox{
	//主板
	private IMainBoard mainBoard;
	//电源
	private IPower power;
	//硬盘
	private IHardDisk hardDisk;
	
	public IMainBoard getMainBoard() {
		return mainBoard;
	}
	public void setMainBoard(IMainBoard mainBoard) {
		this.mainBoard = mainBoard;
	}
	public IPower getPower() {
		return power;
	}
	public void setPower(IPower power) {
		this.power = power;
	}
	public IHardDisk getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(IHardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	
}
