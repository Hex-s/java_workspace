package com.niit.exam8.impl;

import com.niit.exam8.iface.IAmdCpu;
import com.niit.exam8.iface.IMainBoard;
import com.niit.exam8.iface.IMemory;
import com.niit.exam8.iface.IPcie;
import com.niit.exam8.iface.IUsb;

/**
 * 技嘉主板
 * @author Administrator
 *
 */
public class GigaMainBoard implements IMainBoard{
	//2个USB接口
	private IUsb[] usb;
	//2个PCIE接口
	private IPcie[] pcie;
	//2个内存条
	private IMemory[] memory;
	//只能使用AMD的CPU
	private IAmdCpu cpu;
	
	public GigaMainBoard(){
		usb = new IUsb[2];
		pcie = new IPcie[2];
		memory = new IMemory[2];
	}

	public IUsb[] getUsb() {
		return usb;
	}
	/**
	 * 接入USB设备的方法
	 * @param usb 接入的外部设备
	 * @param index USB接口的索引
	 */
	public void setUsb(IUsb usb,int index){
		if(this.usb[index-1] != null){
			System.out.println("该USB接口中已有设备");
		}
		else{
			this.usb[index-1] = usb;
		}	
	}
	
	/**
	 * 接入PCIE设备的方法
	 * @param pcie
	 * @param index
	 */
	public void setPcie(IPcie pcie, int index){
		if(this.pcie[index-1] != null){
			System.out.println("该PCIE接口中也有设备");
		}
		else{
			this.pcie[index-1] = pcie;
		}
	}
	

	public IPcie[] getPcie() {
		return pcie;
	}

	

	public IMemory[] getMemory() {
		return memory;
	}

	public void setMemory(IMemory memory, int index) {
		this.memory[index-1] = memory;
	}

	public IAmdCpu getCpu() {
		return cpu;
	}

	public void setCpu(IAmdCpu cpu) {
		this.cpu = cpu;
	}
	
}
