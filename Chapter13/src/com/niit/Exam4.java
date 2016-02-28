package com.niit;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Exam4 extends JFrame{
	//分割面板
	private JSplitPane splpnl;
	private JPanel pnl1;
	private JPanel pnl2;
	
	public Exam4(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//实例化面板
		pnl1 = new JPanel();
		pnl1.setBackground(Color.red);
		pnl2 = new JPanel();
		pnl2.setBackground(Color.orange);
		//实例化分割面板  分割面板用来将页面划分成2块内容，主要用于界面的宏观布局
		//第一个参数表示划分的方向，第二和第三个参数代表面板分割后填充的其他容器
		splpnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnl1, pnl2);
		//设置分割线的位置
		splpnl.setDividerLocation(300);
		//设置分割线的粗细
		splpnl.setDividerSize(10);
		//禁止分割线的位置调整
		splpnl.setEnabled(false);
		this.add(splpnl);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam4 frm = new Exam4();
		frm.setVisible(true);

	}

}
