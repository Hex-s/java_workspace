package com.niit;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Exam4 extends JFrame{
	//�ָ����
	private JSplitPane splpnl;
	private JPanel pnl1;
	private JPanel pnl2;
	
	public Exam4(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ʵ�������
		pnl1 = new JPanel();
		pnl1.setBackground(Color.red);
		pnl2 = new JPanel();
		pnl2.setBackground(Color.orange);
		//ʵ�����ָ����  �ָ����������ҳ�滮�ֳ�2�����ݣ���Ҫ���ڽ���ĺ�۲���
		//��һ��������ʾ���ֵķ��򣬵ڶ��͵����������������ָ��������������
		splpnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnl1, pnl2);
		//���÷ָ��ߵ�λ��
		splpnl.setDividerLocation(300);
		//���÷ָ��ߵĴ�ϸ
		splpnl.setDividerSize(10);
		//��ֹ�ָ��ߵ�λ�õ���
		splpnl.setEnabled(false);
		this.add(splpnl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam4 frm = new Exam4();
		frm.setVisible(true);

	}

}
