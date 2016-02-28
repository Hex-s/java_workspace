package com.niit;

import java.awt.Component;

import javax.swing.Icon;

public class MyOptionPane {

	public static int showOptionDialog(Component parentComponent,Object message,String title,int optionType, int messageType, Icon icon,Object[] options, Object initalValue){
		MyDialog dialog = new MyDialog(parentComponent, message, title, optionType, messageType, icon, options, initalValue);
		dialog.setVisible(true);
		return dialog.getResultOption();
	}
}
