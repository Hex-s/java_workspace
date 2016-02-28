package com.niit.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowListenerExam extends JFrame {
	public WindowListenerExam(){
		
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//为窗体添加窗体状态监听器
		this.addWindowListener(new WindowListener() {
			/**
			 * 窗体打开事件
			 */
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("窗体打开");
				
			}
			/**
			 * 窗体最小化事件
			 */
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体最小化");
			}
			/**
			 * 窗体非最小化事件
			 */
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体未最小化");
			}
			/**
			 * 窗体未激活事件
			 */
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体非激活中");
			}
			/**
			 * 窗体关闭时事件
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体关闭中");
			}
			/**
			 * 事窗体关闭后事件
			 */
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体关闭后");
			}
			/**
			 * 窗体激活事件
			 */
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("窗体激活中");
			}
		});
	}
	public static void main(String[] args) {
		WindowListenerExam frm = new WindowListenerExam();
		frm.setVisible(true);
	}
}
