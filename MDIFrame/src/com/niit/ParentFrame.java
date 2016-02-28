package com.niit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 父窗体
 */
public class ParentFrame extends JFrame {
	private JDesktopPane deskPnl;
	private JMenuBar menuBar;
	private JMenu menuManage;
	private JMenuItem itemTest;
	public ParentFrame(){
		//最大化窗体
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		menuManage = new JMenu("考试管理");
		itemTest = new JMenuItem("在线考试");
		menuManage.add(itemTest);
		menuBar.add(menuManage);
		
		this.setJMenuBar(menuBar);
		
		//实例化桌面面板对象
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
		
		itemTest.addActionListener(new ItemListener());
		
	}
	private class ItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TestFrame frm = new TestFrame();
			//将子窗体添加至桌面面板
			deskPnl.add(frm);
			frm.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		ParentFrame frm = new ParentFrame();
		frm.setVisible(true);
	}
	
}
