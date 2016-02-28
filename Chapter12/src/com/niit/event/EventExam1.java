package com.niit.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventExam1 extends JFrame {

	public EventExam1(){
		System.out.println(this.hashCode());
		this.setBounds(200, 200, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�󶨼������ķ��������󶨼������Ķ����Ϊ�¼�Դ
		//�÷����Ĳ�����Ϊ���������󣬼������ӿ��л��и�ʽ�����ķ�������д������Ϊ�¼�������
		//�¼�������ʾ�����������Ķ�����һ���¼�Դִ�����¼�������ᴥ���÷����еĴ���
		this.addMouseMotionListener(new MouseMotionListener() {	
			/**
			 * ����ƶ��¼�
			 * ������ʾ�¼�����������¼�������װ���¼�Դ���󣬰����͵�ǰ�¼��йص�������Ϣ
			 */
			@Override
			public void mouseMoved(MouseEvent e) {
				//���¼��п��Ի�ȡ�¼�Դ����
				Object obj = e.getSource();
				//���¼�Դ�������ɾ���Ķ���
				EventExam1 frm = (EventExam1)obj;
				System.out.println(frm.hashCode());
				
				EventExam1.this.setTitle(e.getX()+","+e.getY());
			}
			/**
			 *  �����ק�¼�
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventExam1 frm = new EventExam1();
		frm.setVisible(true);
	}

}
