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
	//�ı���
	private JTextArea txtMsg;
	private JPanel pnlSend;
	private JButton btnSend;
	private JTextField txtSendMsg;
	private JLabel lblInfo;
	
	public ChatFram(){
		//�����ʼ������
		this.setBounds(200, 200, 500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ʵ�������
		pnlLeft = new JPanel();
		pnlInfo = new JPanel();
		txtMsg = new JTextArea();
		pnlSend = new JPanel();
		txtSendMsg = new JTextField();
		txtSendMsg.setColumns(20);
		btnSend = new JButton("send");
		lblInfo = new JLabel(new ImageIcon("image/ya1.gif"));
		
		//�����ߵ������䴰������
		this.add(pnlLeft);
		//����Ϣ���������ұ�
		this.add(pnlInfo,BorderLayout.EAST);
		//��������Ĳ��ַ�ʽ����Ϊ�߿򲼾֣�����Ĭ�ϲ�����FlowLayout
		pnlLeft.setLayout(new BorderLayout());
		//��������Ϣ�ı��������������
		pnlLeft.add(txtMsg);
		//����Ϣ��������������������·�
		pnlLeft.add(pnlSend, BorderLayout.SOUTH);
		//���ı���Ͱ�ť�������Ϣ�������
		pnlSend.add(txtSendMsg);
		pnlSend.add(btnSend);
		//��������ϢͼƬ�������Ϣ���
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
