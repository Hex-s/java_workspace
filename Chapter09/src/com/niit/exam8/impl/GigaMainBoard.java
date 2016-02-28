package com.niit.exam8.impl;

import com.niit.exam8.iface.IAmdCpu;
import com.niit.exam8.iface.IMainBoard;
import com.niit.exam8.iface.IMemory;
import com.niit.exam8.iface.IPcie;
import com.niit.exam8.iface.IUsb;

/**
 * ��������
 * @author Administrator
 *
 */
public class GigaMainBoard implements IMainBoard{
	//2��USB�ӿ�
	private IUsb[] usb;
	//2��PCIE�ӿ�
	private IPcie[] pcie;
	//2���ڴ���
	private IMemory[] memory;
	//ֻ��ʹ��AMD��CPU
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
	 * ����USB�豸�ķ���
	 * @param usb ������ⲿ�豸
	 * @param index USB�ӿڵ�����
	 */
	public void setUsb(IUsb usb,int index){
		if(this.usb[index-1] != null){
			System.out.println("��USB�ӿ��������豸");
		}
		else{
			this.usb[index-1] = usb;
		}	
	}
	
	/**
	 * ����PCIE�豸�ķ���
	 * @param pcie
	 * @param index
	 */
	public void setPcie(IPcie pcie, int index){
		if(this.pcie[index-1] != null){
			System.out.println("��PCIE�ӿ���Ҳ���豸");
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
