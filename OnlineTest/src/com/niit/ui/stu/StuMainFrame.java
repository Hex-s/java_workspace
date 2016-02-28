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
 * ������
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
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bindListener();
		
	}
	
	/**
	 * �󶨼�����
	 */
	private void bindListener(){
		ItemListener itemListener = new ItemListener();
		itemTest.addActionListener(itemListener);
		itemScore.addActionListener(itemListener);
	}
	
	/**
	 * ѡ�������
	 * @author Administrator
	 *
	 */
	private class ItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//���߿���
			if(item == itemTest){
				//������
				deskPnl.removeAll();
				TestsFrame frm = new TestsFrame(StuMainFrame.this);
				//���Ӵ���������������
				deskPnl.add(frm);
				frm.setVisible(true);
				//�ػ�
				StuMainFrame.this.repaint();
			}
			//�ɼ���ѯ
			else if(item == itemScore){
				//������
				deskPnl.removeAll();
				ScoreFrame frm = new ScoreFrame(StuMainFrame.this);
				deskPnl.add(frm);
				frm.setVisible(true);
				//�ػ�
				StuMainFrame.this.repaint();
			}
		}
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		menuBar = new JMenuBar();
		testManage = new JMenu("���Թ���");
		scoreManager = new JMenu("�ɼ�����");
		itemTest = new JMenuItem("���߿���");
		itemScore = new JMenuItem("�ɼ���ѯ");
		testManage.add(itemTest);
		scoreManager.add(itemScore);
		menuBar.add(testManage);
		menuBar.add(scoreManager);
		this.setJMenuBar(menuBar);
		
		//ʵ��������������
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
	}
	
	/**
	 * ��ʼ������
	 */
	private void initFrame(){
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("��ӭ "+stu.getStuName()+" �������߿���ϵͳ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Student getStu() {
		return stu;
	}
	

	
}
