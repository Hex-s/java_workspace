package com.niit.textnum;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextLimitExam extends JFrame{
	
	private JTextField txtMsg;
	int length = 0;
	int count = 0;
	
	public TextLimitExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		txtMsg = new JTextField();
		txtMsg.setColumns(30);
		txtMsg.addKeyListener(new TextListener());
		this.add(txtMsg);
		
	}

	public class TextListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
//			//��ȡ������ַ�
//			char ch = e.getKeyChar();
//			//��ȡС������������ַ����е�����
//			int index = txtMsg.getText().indexOf(".");
//			
//			System.out.println(index + " ,"+ txtMsg.getText().length());
//			//��С�����λ�ý����ж�
//			if(ch == '.'){
//				//.���ܳ����ڵ�һλ
//				if(txtMsg.getText().length() == 0){
//					e.setKeyChar('\0');
//				}
//				//���ܳ�������С����
//				else if(index != -1){
//					e.setKeyChar('\0');
//				}
//			}
//			else{
//				if(ch < '0'|| ch > '9'){
//					//ֻ����������
//					e.setKeyChar('\0');
//				}
//			}


			char c = e.getKeyChar();
			//�ж�����ֵ�Ƿ�Ϸ�
			if(c >= '0' && c <= '9' || c == '.'){
				//�ڼ���ֵ����֮ǰ���ַ����� . ��λ��
				int index = txtMsg.getText().indexOf('.'); 
				//������ַ���Ϊ .
				if(c == '.'){
					//�ж� . ��λ�úͳ��ֵĴ���
					if(txtMsg.getText().length() == 0 || index != -1){
						e.setKeyChar('\0');
					}
				}
			}
			//�Ƿ�ֵ��ֹ����
			else{
				e.setKeyChar('\0');
			}
		}	
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextLimitExam frm = new TextLimitExam();
		frm.setVisible(true);
	}

}
