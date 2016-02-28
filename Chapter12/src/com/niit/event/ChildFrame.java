package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ChildFrame extends JFrame {
	private JTextField txtMsg;
	//�������е��ı���
	//private JTextField txtMain;
	private MainFrame frm;
	
	/**
	 * ͨ�����췽���������������
	 * ���ڴ����������������ͣ�����Ӵ�����ʵ�������������������
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
	 * �ı���ļ��̼�����
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
			//���������е��ı���������Ϊ��ǰ�ı����ֵ
			frm.setMsg(txtMsg.getText());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
