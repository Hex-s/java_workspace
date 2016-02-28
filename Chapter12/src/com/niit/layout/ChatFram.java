package com.niit.layout;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFram extends JFrame {
	
	private JPanel pnlLeft;
	private JPanel pnlInfo;
	//文本域
	private JTextArea txtMsg;
	private JPanel pnlSend;
	private JButton btnSend;
	private JTextField txtSendMsg;
	private JLabel lblInfo;
	
	public ChatFram(){
		//窗体初始化设置
		this.setBounds(200, 200, 500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//实例化组件
		pnlLeft = new JPanel();
		pnlInfo = new JPanel();
		txtMsg = new JTextArea();
		pnlSend = new JPanel();
		txtSendMsg = new JTextField();
		txtSendMsg.setColumns(20);
		btnSend = new JButton("send");
		lblInfo = new JLabel(new ImageIcon("image/ya1.gif"));
		
		//添加左边的面板填充窗体区域
		this.add(pnlLeft);
		//将信息面板添加至右边
		this.add(pnlInfo,BorderLayout.EAST);
		//将左边面板的布局方式设置为边框布局，面板的默认布局是FlowLayout
		pnlLeft.setLayout(new BorderLayout());
		//将聊天信息文本域填充至左边面板
		pnlLeft.add(txtMsg);
		//将信息发送面板添加至左边面板的下方
		pnlLeft.add(pnlSend, BorderLayout.SOUTH);
		//将文本框和按钮添加至信息发送面板
		pnlSend.add(txtSendMsg);
		pnlSend.add(btnSend);
		//将个人信息图片添加至信息面板
		pnlInfo.add(lblInfo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatFram frm = new ChatFram();
		frm.setVisible(true);

	}

}
