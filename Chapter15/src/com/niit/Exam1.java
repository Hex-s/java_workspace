package com.niit;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * ���̳߳���ı׶ˣ�ͬһʱ��ֻ����һ������
 * @author Administrator
 *
 */
public class Exam1 extends JFrame{

	private JButton btn1;
	private JButton btn2;
	
	public Exam1(){
		this.setBounds(200, 200, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					//�ж�5�뵱ǰ�߳�
					MyThread2.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�޸ĵ�ǰ����ı���ɫ
				Exam1.this.getContentPane().setBackground(Color.orange);
			}
		});
		
		this.add(btn1);
		this.add(btn2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 frm = new Exam1();
		frm.setVisible(true);

	}

}
