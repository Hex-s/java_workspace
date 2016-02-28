package com.niit.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutExam extends JFrame {

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	
	public BorderLayoutExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//JFrame的默认布局就是BorderLayout，可以通过setLayout方法修改容器的布局方式
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		btn4 = new JButton("btn4");
		btn5 = new JButton("btn5");
		
//		//直接添加组件，将填充整个窗体
//		this.add(btn1);
//		//多次添加组件，只能呈现出最后次添加的组件
//		this.add(btn2);
//		System.out.println(this.getContentPane().getComponentCount());
		
		//BorderLayout布局中默认添加组件以center的方式添加
		this.add(btn1,BorderLayout.CENTER);
		this.add(btn2,BorderLayout.NORTH);
		this.add(btn3,BorderLayout.SOUTH);
		this.add(btn4,BorderLayout.WEST);
		this.add(btn5,BorderLayout.EAST);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorderLayoutExam frm = new BorderLayoutExam();
		frm.setVisible(true);

	}

}
