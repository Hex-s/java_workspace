package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ChildFrame extends JFrame {
	private JTextField txtMsg;
	//主窗体中的文本框
	//private JTextField txtMain;
	private MainFrame frm;
	
	/**
	 * 通过构造方法传入主窗体对象
	 * 由于窗体是引用数据类型，因此子窗体访问到的主窗体就是其对象本身
	 */
	public ChildFrame(MainFrame frm){
		this.setBounds(200, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		//this.txtMain = txtMain;
		this.frm = frm;
		txtMsg = new JTextField(20);
		this.add(txtMsg);
		txtMsg.addKeyListener(new TextListener());
		
	}
	/**
	 * 文本框的键盘监听器
	 * @author Administrator
	 *
	 */
	private class TextListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//将主窗体中的文本框内容设为当前文本框的值
			frm.setMsg(txtMsg.getText());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
