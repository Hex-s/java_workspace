package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerExam extends JFrame {

	private JButton btnPress;
	private JButton btnBack;
	
	public ActionListenerExam(){
		this.setBounds(200, 200, 400, 200);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnPress = new JButton("press");
		btnBack = new JButton("back");
		this.add(btnPress);
		this.add(btnBack);
		//ΪbtnPress�󶨼�����
//		btnPress.addActionListener(new ActionListener() {
//			
//			/**
//			 * ��ť������¼�
//			 */
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				//�����Ի���
//				JOptionPane.showMessageDialog(null, "�����press");
//			}
//		});
//		
//		//ΪbtnBack�󶨼�����
//		btnBack.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "�����back");
//			}
//		});
		
		//ʵ����������
		ButtonListener btnListener = new ButtonListener();
		//�󶨼�����
		btnPress.addActionListener(btnListener);
		btnBack.addActionListener(btnListener);
		
	}
	
	/**
	 * ʹ���ڲ���ʵ�ּ�����
	 * �ڲ�����Է����ⲿ������Ժͷ���
	 * �ڲ�����Ҫ���ڵ�ǰ����Ч����Ҫ��ε���ʱ���¹����Ķ���
	 * �ڲ�����Ը��õضԳ���ṹ���л���
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			//��ȡ�¼�Դ
//			Object obj = e.getSource();
//			//���¼�Դ�����JButton����
//			JButton btn = (JButton)obj;
//			JOptionPane.showMessageDialog(null, "�����"+btn.getText()+"��ť");
			
			//�ڲ����п���ͨ���¼�Դ�ж��¼�Դ�����ͣ����ݲ�ͬ���¼�Դ����ʵ�ֲ�ͬ����Ӧ
			//��ȡ�¼�Դ
			Object obj = e.getSource();
			//���¼�Դ�����JButton����
			JButton btn = (JButton)obj;
			if(btn == btnPress){
				JOptionPane.showMessageDialog(null, "�����"+btn.getText()+"��ť");
			}
			else if(btn == btnBack){
				JOptionPane.showMessageDialog(null, "�����"+btn.getText()+"��ť");
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListenerExam frm = new ActionListenerExam();
		frm.setVisible(true);

	}

}
