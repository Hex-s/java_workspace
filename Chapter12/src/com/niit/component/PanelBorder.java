package com.niit.component;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 实现面板分组框的效果
 * @author Administrator
 *
 */
public class PanelBorder extends JFrame {
	private JPanel pnl;
	
	public PanelBorder(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		pnl = new JPanel();
		pnl.setBounds(50, 50, 300, 300);
		//设置面板的边框
		pnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "我的标题"));
		this.add(pnl);
	}
	
	public static void main(String[] args) {
		PanelBorder frm = new PanelBorder();
		frm.setVisible(true);
	}

}
