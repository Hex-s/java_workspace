package com.niit;

import javax.swing.ImageIcon;

public class MyOptionPaneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] options = new String[]{"忽略","重试","取消"};
		int choice = MyOptionPane.showOptionDialog(null, "消息内容", "标题信息", 0, 0, new ImageIcon("image/edit.gif"),options , options[0]);
		System.out.println("点击按钮是："+options[choice]);
		System.exit(0);
	}

}
