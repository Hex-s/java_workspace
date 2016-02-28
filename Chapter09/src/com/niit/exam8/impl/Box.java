package com.niit.exam8.impl;

import com.niit.exam8.iface.IBox;
import com.niit.exam8.iface.IDisplay;
import com.niit.exam8.iface.IHardDisk;
import com.niit.exam8.iface.IMainBoard;
import com.niit.exam8.iface.IPower;

/**
 * ������
 * @author Administrator
 *
 */
public class Box implements IBox{
	//����
	private IMainBoard mainBoard;
	//��Դ
	private IPower power;
	//Ӳ��
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
