package com.niit;

import javax.swing.JDialog;
/**
 * �Ի���
 * @author Administrator
 *
 */
public class MyDialog extends JDialog {
	
	
	public MyDialog(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyDialog dialog = new MyDialog();
		dialog.setVisible(true);
	}
}
