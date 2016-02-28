package com.niit.exam8.test;

import com.niit.exam8.impl.Amd7950Cpu;
import com.niit.exam8.impl.AudioCard;
import com.niit.exam8.impl.Box;
import com.niit.exam8.impl.Computer;
import com.niit.exam8.impl.GigaMainBoard;
import com.niit.exam8.impl.Inteli7_747Cpu;
import com.niit.exam8.impl.KingStomMemory;
import com.niit.exam8.impl.LogicKeyBoard;
import com.niit.exam8.impl.Power;
import com.niit.exam8.impl.QingHuaDisplay;
import com.niit.exam8.impl.RarzerMouse;
import com.niit.exam8.impl.VidoCard;
import com.niit.exam8.impl.WestDataHardDisk;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//实例化一台空壳子的电脑
		Computer computer = new Computer();
		//获得一台显示器
		QingHuaDisplay display = new QingHuaDisplay();
		//将显示器装入电脑
		computer.setDisplay(display);
		
		//获得一个机箱
		Box box = new Box();
		//获得一个硬盘
		WestDataHardDisk hardDisk = new WestDataHardDisk();
		//获取一个主板
		GigaMainBoard mainBoard = new GigaMainBoard();
		//获取一个电源
		Power power = new Power();
		//将硬盘装入机箱
		box.setHardDisk(hardDisk);
		//将主板装入机箱
		box.setMainBoard(mainBoard);
		//将电源装入机箱
		box.setPower(power);
		
		//将机箱转入电脑
		computer.setBox(box);
		
		//获取显卡
		VidoCard vidoCard = new VidoCard();
		//获取声卡
		AudioCard soundCard = new AudioCard();
		//获取CPU
		Inteli7_747Cpu intelCpu = new Inteli7_747Cpu();
		Amd7950Cpu amdCpu = new Amd7950Cpu();
		//获取键盘
		LogicKeyBoard keyBoard = new LogicKeyBoard();
		//获取鼠标
		RarzerMouse mouse = new RarzerMouse();
		//获取内存
		KingStomMemory memory1 = new KingStomMemory();
		KingStomMemory memory2 = new KingStomMemory();
		
		//将显卡插入PCIE接口
		mainBoard.setPcie(vidoCard, 1);
		//将声卡插入PCIE接口
		mainBoard.setPcie(soundCard, 2);
		//将CPU插入主板
		mainBoard.setCpu(amdCpu);
		//插入2条内存
		mainBoard.setMemory(memory1, 1);
		mainBoard.setMemory(memory2, 2);
		//接入键盘
		mainBoard.setUsb(keyBoard, 1);
		//接入鼠标
		mainBoard.setUsb(mouse, 2);
		
		
	}

}
