package com.niit.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayExam extends JFrame{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	public FlowLayExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		
		//JPanel的默认布局是FlowLayout
		//将窗体的布局方式改为流布局
		//可以带参构造，一个参数表示流布局的对齐方式，默认居中对齐
		this.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		//添加组件
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		//pack用来根据容器中组件的大小自动调整窗体大小的方法
		this.pack();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayExam frm = new FlowLayExam();
		frm.setVisible(true);

	}

}
