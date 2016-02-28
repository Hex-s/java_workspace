package com.niit.layout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NullLayoutExam extends JFrame {

	private JTextField txt;
	private JButton btnPress;
	private JPanel pnl;
	private JButton btn;
	
	public NullLayoutExam(){
		
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//修改布局为空布局，又称为绝对定位布局
		this.setLayout(null);
		//实例化文本框
		txt = new JTextField();
		//空布局中添加的组件必须要设置组件的大小和位置
		txt.setSize(100, 25);
		txt.setLocation(20, 10);
		
		//实例化按钮
		btnPress = new JButton("press");
		btnPress.setSize(80, 25);
		btnPress.setLocation(140, 10);
		
		//实例化面板
		pnl = new JPanel();
		pnl.setBackground(Color.yellow);
		pnl.setSize(200, 200);
		pnl.setLocation(20, 45);
		//将面板的布局设为空布局
		pnl.setLayout(null);
		btn = new JButton("Button");
		//设置定位时，坐标位置是相对于当前容器的
		btn.setBounds(20, 10, 80, 25);
		//添加按钮至面板
		pnl.add(btn);
		
		
		//添加文本框至窗体
		this.add(txt);
		//添加按钮
		this.add(btnPress);
		//添加面板
		this.add(pnl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullLayoutExam frm = new NullLayoutExam();
		frm.setVisible(true);
	}

}
