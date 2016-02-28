package com.niit.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayExam extends JFrame{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	public FlowLayExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		
		//JPanel��Ĭ�ϲ�����FlowLayout
		//������Ĳ��ַ�ʽ��Ϊ������
		//���Դ��ι��죬һ��������ʾ�����ֵĶ��뷽ʽ��Ĭ�Ͼ��ж���
		this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		//������
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		//pack������������������Ĵ�С�Զ����������С�ķ���
		this.pack();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayExam frm = new FlowLayExam();
		frm.setVisible(true);

	}

}
