package com.niit.layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * null布局容器添加的组件是无法撑开容器的面积
 * 因此在布局时如果窗体是非null布局，则窗体内的容器也应使用非null布局
 * 如果窗体是null布局，只要设定好窗体内容器的大小和定位后，任何布局都可以使用
 * @author Administrator
 *
 */
public class NullLayoutExam2 extends JFrame {

	private JPanel pnlLeft;
	private JPanel pnlCenter;
	private JButton btnLeft;
	private JButton btnCenter;
	
	public NullLayoutExam2(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//实例化组件
		pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.green);
		pnlLeft.setBounds(5, 5, 50, 390);
		//将pnlLeft设为null布局
		pnlLeft.setLayout(null);
		pnlCenter = new JPanel();
		pnlCenter.setBounds(60, 5, 335, 390);
		pnlCenter.setBackground(Color.yellow);
		btnLeft = new JButton("left");
		btnLeft.setBounds(20, 20, 80, 25);
		btnCenter = new JButton("center");
		pnlLeft.add(btnLeft);
		pnlCenter.add(btnCenter);
		
		//添加组件至窗体
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullLayoutExam2 frm = new NullLayoutExam2();
		frm.setVisible(true);

	}

}
