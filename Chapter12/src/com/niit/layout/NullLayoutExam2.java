package com.niit.layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * null����������ӵ�������޷��ſ����������
 * ����ڲ���ʱ��������Ƿ�null���֣������ڵ�����ҲӦʹ�÷�null����
 * ���������null���֣�ֻҪ�趨�ô����������Ĵ�С�Ͷ�λ���κβ��ֶ�����ʹ��
 * @author Administrator
 *
 */
public class NullLayoutExam2 extends JFrame {

	private JPanel pnlLeft;
	private JPanel pnlCenter;
	private JButton btnLeft;
	private JButton btnCenter;
	
	public NullLayoutExam2(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//ʵ�������
		pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.green);
		pnlLeft.setBounds(5, 5, 50, 390);
		//��pnlLeft��Ϊnull����
		pnlLeft.setLayout(null);
		pnlCenter = new JPanel();
		pnlCenter.setBounds(60, 5, 335, 390);
		pnlCenter.setBackground(Color.yellow);
		btnLeft = new JButton("left");
		btnLeft.setBounds(20, 20, 80, 25);
		btnCenter = new JButton("center");
		pnlLeft.add(btnLeft);
		pnlCenter.add(btnCenter);
		
		//������������
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullLayoutExam2 frm = new NullLayoutExam2();
		frm.setVisible(true);

	}

}
