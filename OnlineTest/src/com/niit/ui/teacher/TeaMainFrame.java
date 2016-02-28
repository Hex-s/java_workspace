package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.niit.entiry.Student;
import com.niit.entiry.Teacher;
import com.niit.ui.stu.LoginFrame;

public class TeaMainFrame extends JFrame{
	
	private JDesktopPane deskPnl;
	private JMenuBar menuBar;
	private JMenu courseManager;
	private JMenu QuestionsManage;
	private JMenu startTestManager;
	private JMenu ScoreManager;
	private JMenuItem itemEditCourse;
	private JMenuItem itemEditQt;
	private JMenuItem itemEditTest;
	private JMenuItem itemAvgScore;
	private JMenuItem itemStuScore;
	private LoginFrame logFrm;
	private Teacher tea;;
	
	public TeaMainFrame(){
		
	}
	public TeaMainFrame(LoginFrame logFrm){
		this.logFrm = logFrm;
		tea = logFrm.getLoginTea();
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
	private void bindListener() {
		ItemListener itemListener = new ItemListener();
		itemEditCourse.addActionListener(itemListener);
		itemEditQt.addActionListener(itemListener);
		itemEditTest.addActionListener(itemListener);
		itemAvgScore.addActionListener(itemListener);
		itemStuScore.addActionListener(itemListener);
		
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
			//编辑科目
			if(item == itemEditCourse){
				//清除组件
				deskPnl.removeAll();
				EditCourseFrame frm = new EditCourseFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//重新绘制
				TeaMainFrame.this.repaint();
				
			}
			//编辑试题
			else if(item == itemEditQt){
				//清除组件
				deskPnl.removeAll();
				EditQuestionsFrame frm = new EditQuestionsFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//重新绘制
				TeaMainFrame.this.repaint();
			}
			//测试管理
			else if(item == itemEditTest){
				//清除组件
				deskPnl.removeAll();
//				CreateTestFrame frm = new CreateTestFrame();
				EditTestFrame frm = new EditTestFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//重新绘制
				TeaMainFrame.this.repaint();
			}
			//平均成绩
			else if(item == itemAvgScore){
				//清除组件
				deskPnl.removeAll();
				AvgScore frm = new AvgScore();
				deskPnl.add(frm);
				frm.setVisible(true);
				//重新绘制
				TeaMainFrame.this.repaint();
			}
			//学生成绩
			else if(item == itemStuScore){
				//清除组件
				deskPnl.removeAll();
				StudentScore frm = new StudentScore();
				deskPnl.add(frm);
				frm.setVisible(true);
				//重新绘制
				TeaMainFrame.this.repaint();
			}
		}
		
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		menuBar = new JMenuBar();
		
		courseManager = new JMenu("科目管理");
		QuestionsManage = new JMenu("试题管理");
		startTestManager = new JMenu("测试管理");
		ScoreManager = new JMenu("查看成绩");
		//科目管理
		itemEditCourse = new JMenuItem("编辑科目");
		courseManager.add(itemEditCourse);
		//试题管理
		itemEditQt = new JMenuItem("编辑试题");
		QuestionsManage.add(itemEditQt);
		//测试管理
		itemEditTest = new JMenuItem("编辑测试");
		startTestManager.add(itemEditTest);
		//查看成绩
		itemAvgScore = new JMenuItem("查询平均成绩");
		itemStuScore = new JMenuItem("查询学生成绩");
		ScoreManager.add(itemAvgScore);
		ScoreManager.add(itemStuScore);
		menuBar.add(courseManager);
		menuBar.add(QuestionsManage);
		menuBar.add(startTestManager);
		menuBar.add(ScoreManager);
		this.setJMenuBar(menuBar);
		
		//实例化桌面面板对象
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
		
	}

	/**
	 * 初始化窗体
	 */
	private void initFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("欢迎 "+tea.gettName()+" 进入在线考试后台管理！");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JDesktopPane getDeskPnl() {
		return deskPnl;
	}
	
	

}
