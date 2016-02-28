package com.niit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * ������
 */
public class ParentFrame extends JFrame {
	private JDesktopPane deskPnl;
	private JMenuBar menuBar;
	private JMenu menuManage;
	private JMenuItem itemTest;
	public ParentFrame(){
		//��󻯴���
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		menuManage = new JMenu("���Թ���");
		itemTest = new JMenuItem("���߿���");
		menuManage.add(itemTest);
		menuBar.add(menuManage);
		
		this.setJMenuBar(menuBar);
		
		//ʵ��������������
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
		
		itemTest.addActionListener(new ItemListener());
		
	}
	private class ItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TestFrame frm = new TestFrame();
			//���Ӵ���������������
			deskPnl.add(frm);
			frm.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		ParentFrame frm = new ParentFrame();
		frm.setVisible(true);
	}
	
}
