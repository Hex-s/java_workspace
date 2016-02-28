package com.niit.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowListenerExam extends JFrame {
	public WindowListenerExam(){
		
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Ϊ������Ӵ���״̬������
		this.addWindowListener(new WindowListener() {
			/**
			 * ������¼�
			 */
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("�����");
				
			}
			/**
			 * ������С���¼�
			 */
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("������С��");
			}
			/**
			 * �������С���¼�
			 */
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����δ��С��");
			}
			/**
			 * ����δ�����¼�
			 */
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ǽ�����");
			}
			/**
			 * ����ر�ʱ�¼�
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����ر���");
			}
			/**
			 * �´���رպ��¼�
			 */
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����رպ�");
			}
			/**
			 * ���弤���¼�
			 */
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���弤����");
			}
		});
	}
	public static void main(String[] args) {
		WindowListenerExam frm = new WindowListenerExam();
		frm.setVisible(true);
	}
}
