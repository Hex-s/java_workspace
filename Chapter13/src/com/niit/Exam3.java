package com.niit;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * �������
 * @author Administrator
 *
 */
public class Exam3 extends JFrame {
	//�������Ҳ������������������е��������������Χʱ������ֹ�����
	private JScrollPane pnlScroll;
	private JButton btnPress;
	
	public Exam3(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//������ť
		btnPress = new JButton("press");
		
//		//�����������
//		pnlScroll = new JScrollPane();
//		pnlScroll.setBounds(20, 20, 400, 200);
//		
//		
//		//���������������, ��������Ĭ�ϲ�����BorderLayout����
//		pnlScroll.getViewport().add(btnPress);
		
		//ֱ��ͨ�����촫�����,�ڶ��͵����������ֱ��ʾ���ô�ֱ��������ˮƽ��������ʾ����
		pnlScroll = new JScrollPane(btnPress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnlScroll.setBounds(20, 20, 400, 200);
		//���ñ߿���
		pnlScroll.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(pnlScroll);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam3 frm = new Exam3();
		frm.setVisible(true);

	}

}
