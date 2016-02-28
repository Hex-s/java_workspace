package com.niit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ModelDialog extends JFrame {
	
	private JDialog dialog;
	
	public ModelDialog(){
		
		this.setBounds(200, 200, 400, 400);
		
		//实例化对话框
		//第一个参数表示对话框是呈现在哪个窗体中的，第二个参数表示是否设置该对话框为模式对话框
		//模式对话框的特点：始终激活对话框，并且不能对其他组件和窗体进行访问，直至对话框被关闭
		dialog = new JDialog(this,true);
		dialog.setBounds(220, 220, 200, 200);
		//呈现对话框
		dialog.setVisible(true);
	}
	public static void main(String[] args) {
		ModelDialog frm = new ModelDialog();
		frm.setVisible(true);
	}

}
