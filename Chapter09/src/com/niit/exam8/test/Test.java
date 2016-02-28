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
		
		//ʵ����һ̨�տ��ӵĵ���
		Computer computer = new Computer();
		//���һ̨��ʾ��
		QingHuaDisplay display = new QingHuaDisplay();
		//����ʾ��װ�����
		computer.setDisplay(display);
		
		//���һ������
		Box box = new Box();
		//���һ��Ӳ��
		WestDataHardDisk hardDisk = new WestDataHardDisk();
		//��ȡһ������
		GigaMainBoard mainBoard = new GigaMainBoard();
		//��ȡһ����Դ
		Power power = new Power();
		//��Ӳ��װ�����
		box.setHardDisk(hardDisk);
		//������װ�����
		box.setMainBoard(mainBoard);
		//����Դװ�����
		box.setPower(power);
		
		//������ת�����
		computer.setBox(box);
		
		//��ȡ�Կ�
		VidoCard vidoCard = new VidoCard();
		//��ȡ����
		AudioCard soundCard = new AudioCard();
		//��ȡCPU
		Inteli7_747Cpu intelCpu = new Inteli7_747Cpu();
		Amd7950Cpu amdCpu = new Amd7950Cpu();
		//��ȡ����
		LogicKeyBoard keyBoard = new LogicKeyBoard();
		//��ȡ���
		RarzerMouse mouse = new RarzerMouse();
		//��ȡ�ڴ�
		KingStomMemory memory1 = new KingStomMemory();
		KingStomMemory memory2 = new KingStomMemory();
		
		//���Կ�����PCIE�ӿ�
		mainBoard.setPcie(vidoCard, 1);
		//����������PCIE�ӿ�
		mainBoard.setPcie(soundCard, 2);
		//��CPU��������
		mainBoard.setCpu(amdCpu);
		//����2���ڴ�
		mainBoard.setMemory(memory1, 1);
		mainBoard.setMemory(memory2, 2);
		//�������
		mainBoard.setUsb(keyBoard, 1);
		//�������
		mainBoard.setUsb(mouse, 2);
		
		
	}

}
