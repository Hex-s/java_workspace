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
			
//			//获取输入的字符
//			char ch = e.getKeyChar();
//			//获取小数点在输入的字符串中的索引
//			int index = txtMsg.getText().indexOf(".");
//			
//			System.out.println(index + " ,"+ txtMsg.getText().length());
//			//对小数点的位置进行判断
//			if(ch == '.'){
//				//.不能出现在第一位
//				if(txtMsg.getText().length() == 0){
//					e.setKeyChar('\0');
//				}
//				//不能出现两个小数点
//				else if(index != -1){
//					e.setKeyChar('\0');
//				}
//			}
//			else{
//				if(ch < '0'|| ch > '9'){
//					//只能输入数字
//					e.setKeyChar('\0');
//				}
//			}


			char c = e.getKeyChar();
			//判断输入值是否合法
			if(c >= '0' && c <= '9' || c == '.'){
				//在键入值加入之前的字符串中 . 的位置
				int index = txtMsg.getText().indexOf('.'); 
				//输入的字符串为 .
				if(c == '.'){
					//判断 . 的位置和出现的次数
					if(txtMsg.getText().length() == 0 || index != -1){
						e.setKeyChar('\0');
					}
				}
			}
			//非法值阻止键入
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
