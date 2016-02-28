package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KeyListenerExam extends JFrame{

	private JTextField txtMsg;
	
	public KeyListenerExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		txtMsg = new JTextField();
		txtMsg.setColumns(20);
		this.add(txtMsg);
		//Ϊ�ı���󶨼�����
		txtMsg.addKeyListener(new TextListener());
	}
	/**
	 * ���̼�����                            
	 * @author Administrator
	 *
	 */
	private class TextListener implements KeyListener{

		/**
		 * ���̰����¼�
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed");
			System.out.println("���¼����ַ��ǣ�"+e.getKeyChar()+",��Ӧ��ASCII�ǣ�"+e.getKeyCode());
			System.out.println("��ǰ�ı����ֵ�ǣ�"+txtMsg.getText()+" ,"+"�ı��򳤶�Ϊ��"+txtMsg.getText().length());
			
		}
		/**
		 * ���̰��º��ɿ��¼�
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
			System.out.println("���¼����ַ��ǣ�"+e.getKeyChar()+",��Ӧ��ASCII�ǣ�"+e.getKeyCode());
			System.out.println("��ǰ�ı����ֵ�ǣ�"+txtMsg.getText()+" ,"+"�ı��򳤶�Ϊ��"+txtMsg.getText().length());
		}

		/**
		 * typed�¼������ڻ�ȡ�����ַ��󴥷����ڸ��¼�ֻ�ܻ�ȡ���¼����ַ������ܻ��ASCIIֵ
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped");
			System.out.println("���¼����ַ��ǣ�"+e.getKeyChar()+",��Ӧ��ASCII�ǣ�"+e.getKeyCode());
			System.out.println("��ǰ�ı����ֵ�ǣ�"+txtMsg.getText()+" ,"+"�ı��򳤶�Ϊ��"+txtMsg.getText().length());
			
			//setKeyChar���ڱ����ǰ�������ַ�
			e.setKeyChar('a');
			
//			//�жϵ�ǰ�ı�����ַ�����
//			if(txtMsg.getText().length() == 5){
//				//��ֹ���̽���
//				e.setKeyChar('\0');
//			}
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyListenerExam frm = new KeyListenerExam();
		frm.setVisible(true);

	}

}
