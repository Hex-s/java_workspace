package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JButton btnPress;
	private JTextField txtMsg;
	
	public MainFrame(){
		this.setBounds(200, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btnPress = new JButton("���´���");
		txtMsg = new JTextField(15);
		
		this.add(txtMsg);
		this.add(btnPress);
		
		//��ť�󶨼�����
		btnPress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���´���ʵ����
				ChildFrame frm = new ChildFrame(MainFrame.this);
				//���ִ���
				frm.setVisible(true);
			}
		});
		
	}
	/**
	 * �����ı����ֵ
	 * @param msg
	 */
	public void setMsg(String msg){
		this.txtMsg.setText(msg);
	}


	public static void main(String[] args) {
		MainFrame frm = new MainFrame();
		frm.setVisible(true);
	}
}
