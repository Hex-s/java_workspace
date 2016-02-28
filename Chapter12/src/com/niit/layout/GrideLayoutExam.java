package com.niit.layout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GrideLayoutExam extends JFrame {

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	
	public GrideLayoutExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʼ�����
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		btn4 = new JButton("btn4");
		btn5 = new JButton("btn5");
		btn6 = new JButton("btn6");
		//��������е�������ɫ
		btn1.setForeground(Color.red);
		
		//������Ĳ��ַ�ʽ��ΪGrideLayout����
		//ǰ����������ʾ������������������������ʾ���ü��
		this.setLayout(new GridLayout(3, 2, 10, 10));
		//������
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrideLayoutExam frm = new GrideLayoutExam();
		frm.setVisible(true);
	}

}
