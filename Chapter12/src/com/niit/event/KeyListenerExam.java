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
		//为文本框绑定监听器
		txtMsg.addKeyListener(new TextListener());
	}
	/**
	 * 键盘监听器                            
	 * @author Administrator
	 *
	 */
	private class TextListener implements KeyListener{

		/**
		 * 键盘按下事件
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed");
			System.out.println("按下键的字符是："+e.getKeyChar()+",对应的ASCII是："+e.getKeyCode());
			System.out.println("当前文本框的值是："+txtMsg.getText()+" ,"+"文本框长度为："+txtMsg.getText().length());
			
		}
		/**
		 * 键盘按下后松开事件
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
			System.out.println("按下键的字符是："+e.getKeyChar()+",对应的ASCII是："+e.getKeyCode());
			System.out.println("当前文本框的值是："+txtMsg.getText()+" ,"+"文本框长度为："+txtMsg.getText().length());
		}

		/**
		 * typed事件用于在获取按键字符后触发，在该事件只能获取按下键的字符，不能获得ASCII值
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped");
			System.out.println("按下键的字符是："+e.getKeyChar()+",对应的ASCII是："+e.getKeyCode());
			System.out.println("当前文本框的值是："+txtMsg.getText()+" ,"+"文本框长度为："+txtMsg.getText().length());
			
			//setKeyChar用于变更当前按键的字符
			e.setKeyChar('a');
			
//			//判断当前文本框的字符长度
//			if(txtMsg.getText().length() == 5){
//				//阻止键盘接受
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
