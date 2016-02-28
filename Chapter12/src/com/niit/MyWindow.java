package com.niit;

import javax.swing.JWindow;

/**
 * ×Ô¶¨ÒåWindow
 * @author Administrator
 *
 */
public class MyWindow extends JWindow {
	public MyWindow(){
		setBounds(200, 200, 400, 400);
	}
	
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.setVisible(true);
	}
}
