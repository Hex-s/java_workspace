package com.niit;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * 滚动面板
 * @author Administrator
 *
 */
public class Exam3 extends JFrame {
	//滚动面板也是容器，当滚动面板中的组件超出容器范围时将会出现滚动条
	private JScrollPane pnlScroll;
	private JButton btnPress;
	
	public Exam3(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//创建按钮
		btnPress = new JButton("press");
		
//		//创建滚动面板
//		pnlScroll = new JScrollPane();
//		pnlScroll.setBounds(20, 20, 400, 200);
//		
//		
//		//添加组件至滚动面板, 滚动面板的默认布局是BorderLayout布局
//		pnlScroll.getViewport().add(btnPress);
		
		//直接通过构造传入组件,第二和第三个参数分别表示设置垂直滚动条和水平滚动的显示策略
		pnlScroll = new JScrollPane(btnPress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnlScroll.setBounds(20, 20, 400, 200);
		//设置边框线
		pnlScroll.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(pnlScroll);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam3 frm = new Exam3();
		frm.setVisible(true);

	}

}
