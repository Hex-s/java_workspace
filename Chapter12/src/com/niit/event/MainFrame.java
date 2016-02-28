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
		
		btnPress = new JButton("打开新窗体");
		txtMsg = new JTextField(15);
		
		this.add(txtMsg);
		this.add(btnPress);
		
		//按钮绑定监听器
		btnPress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//将新窗体实例化
				ChildFrame frm = new ChildFrame(MainFrame.this);
				//呈现窗体
				frm.setVisible(true);
			}
		});
		
	}
	/**
	 * 设置文本框的值
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
