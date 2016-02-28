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
	private void bindListener() {
		ItemListener itemListener = new ItemListener();
		itemEditCourse.addActionListener(itemListener);
		itemEditQt.addActionListener(itemListener);
		itemEditTest.addActionListener(itemListener);
		itemAvgScore.addActionListener(itemListener);
		itemStuScore.addActionListener(itemListener);
		
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
			//�༭��Ŀ
			if(item == itemEditCourse){
				//������
				deskPnl.removeAll();
				EditCourseFrame frm = new EditCourseFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//���»���
				TeaMainFrame.this.repaint();
				
			}
			//�༭����
			else if(item == itemEditQt){
				//������
				deskPnl.removeAll();
				EditQuestionsFrame frm = new EditQuestionsFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//���»���
				TeaMainFrame.this.repaint();
			}
			//���Թ���
			else if(item == itemEditTest){
				//������
				deskPnl.removeAll();
//				CreateTestFrame frm = new CreateTestFrame();
				EditTestFrame frm = new EditTestFrame();
				deskPnl.add(frm);
				frm.setVisible(true);
				//���»���
				TeaMainFrame.this.repaint();
			}
			//ƽ���ɼ�
			else if(item == itemAvgScore){
				//������
				deskPnl.removeAll();
				AvgScore frm = new AvgScore();
				deskPnl.add(frm);
				frm.setVisible(true);
				//���»���
				TeaMainFrame.this.repaint();
			}
			//ѧ���ɼ�
			else if(item == itemStuScore){
				//������
				deskPnl.removeAll();
				StudentScore frm = new StudentScore();
				deskPnl.add(frm);
				frm.setVisible(true);
				//���»���
				TeaMainFrame.this.repaint();
			}
		}
		
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		menuBar = new JMenuBar();
		
		courseManager = new JMenu("��Ŀ����");
		QuestionsManage = new JMenu("�������");
		startTestManager = new JMenu("���Թ���");
		ScoreManager = new JMenu("�鿴�ɼ�");
		//��Ŀ����
		itemEditCourse = new JMenuItem("�༭��Ŀ");
		courseManager.add(itemEditCourse);
		//�������
		itemEditQt = new JMenuItem("�༭����");
		QuestionsManage.add(itemEditQt);
		//���Թ���
		itemEditTest = new JMenuItem("�༭����");
		startTestManager.add(itemEditTest);
		//�鿴�ɼ�
		itemAvgScore = new JMenuItem("��ѯƽ���ɼ�");
		itemStuScore = new JMenuItem("��ѯѧ���ɼ�");
		ScoreManager.add(itemAvgScore);
		ScoreManager.add(itemStuScore);
		menuBar.add(courseManager);
		menuBar.add(QuestionsManage);
		menuBar.add(startTestManager);
		menuBar.add(ScoreManager);
		this.setJMenuBar(menuBar);
		
		//ʵ��������������
		deskPnl = new JDesktopPane();
		this.add(deskPnl);
		
	}

	/**
	 * ��ʼ������
	 */
	private void initFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("��ӭ "+tea.gettName()+" �������߿��Ժ�̨����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JDesktopPane getDeskPnl() {
		return deskPnl;
	}
	
	

}
