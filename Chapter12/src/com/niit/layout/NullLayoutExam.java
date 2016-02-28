package com.niit.layout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NullLayoutExam extends JFrame {

	private JTextField txt;
	private JButton btnPress;
	private JPanel pnl;
	private JButton btn;
	
	public NullLayoutExam(){
		
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�޸Ĳ���Ϊ�ղ��֣��ֳ�Ϊ���Զ�λ����
		this.setLayout(null);
		//ʵ�����ı���
		txt = new JTextField();
		//�ղ�������ӵ��������Ҫ��������Ĵ�С��λ��
		txt.setSize(100, 25);
		txt.setLocation(20, 10);
		
		//ʵ������ť
		btnPress = new JButton("press");
		btnPress.setSize(80, 25);
		btnPress.setLocation(140, 10);
		
		//ʵ�������
		pnl = new JPanel();
		pnl.setBackground(Color.yellow);
		pnl.setSize(200, 200);
		pnl.setLocation(20, 45);
		//�����Ĳ�����Ϊ�ղ���
		pnl.setLayout(null);
		btn = new JButton("Button");
		//���ö�λʱ������λ��������ڵ�ǰ������
		btn.setBounds(20, 10, 80, 25);
		//��Ӱ�ť�����
		pnl.add(btn);
		
		
		//����ı���������
		this.add(txt);
		//��Ӱ�ť
		this.add(btnPress);
		//������
		this.add(pnl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullLayoutExam frm = new NullLayoutExam();
		frm.setVisible(true);
	}

}
