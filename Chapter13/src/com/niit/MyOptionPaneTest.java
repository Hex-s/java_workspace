package com.niit;

import javax.swing.ImageIcon;

public class MyOptionPaneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] options = new String[]{"����","����","ȡ��"};
		int choice = MyOptionPane.showOptionDialog(null, "��Ϣ����", "������Ϣ", 0, 0, new ImageIcon("image/edit.gif"),options , options[0]);
		System.out.println("�����ť�ǣ�"+options[choice]);
		System.exit(0);
	}

}
