package com.niit.ui.stu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.niit.entiry.Student;

/**
 * 父窗体
 */
public class StuMainFrame extends JFrame {
	private JDesktopPane deskPnl;
	private JMenuBar menuBar;
	private JMenu testManage;
	private JMenu scoreManager;
	private JMenuItem itemTest;
	private JMenuItem itemScore;
	private LoginFrame logFrm;
	private Student stu;
	
	public StuMainFrame(LoginFrame logFrm){
		this.logFrm = logFrm;
		stu = logFrm.getLoginStu();
		//初始化窗体
		initFrame();
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
		
	}
	
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		ItemListener itemListener = new ItemListener();
		itemTest.addActionListener(itemListener);
		itemScore.addActionListener(itemListener);
	}
	
	/**
	 * 选项监听器
	 * @author Administrator
	 *
	 */
	private class ItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//在线考试
			if(item == itemTest){
				//清除组件
				deskPnl.removeAll();
				TestsFrame frm = new TestsFrame(StuMainFrame.this);
				//将子窗体添加至桌面面板
				deskPnl.add(frm);
				frm.setVisible(true);
				//重绘
				StuMainFrame.this.repaint();
			}
			//成绩查询
			else if(item == itemScore){
				//清除组件
				deskPnl.removeAll();
				ScoreFrame frm = new ScoreFrame(StuMainFrame.this);
				deskPnl.add(frm);
				frm.setVisible(true);
				//重绘
				StuMainFrame.this.repaint();
			}
		}
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		menuBar = new JMenuBar();
		testManage = new JMenu("考试管理");
		scoreManager = new JMenu("成绩管理");
		itemTest = new JMenuItem("在线考试");
		itemScore = new JMenuItem("成绩查询");
		testManage.add(itemTest);
		scoreManager.add(itemScore);
		menuBar.add(testManage);
		menuBar.add(scoreManager);
		this.setJMenuBar(menuBar);
		
		//实例化桌面面板对象
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
	}
	
	/**
	 * 初始化窗体
	 */
	private void initFrame(){
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("欢迎 "+stu.getStuName()+" 进入在线考试系统！");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Student getStu() {
		return stu;
	}
	

	
}
