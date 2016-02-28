package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.QuestionsDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Classes;
import com.niit.entiry.Course;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class CreateTestFrame extends JFrame{
	
	private JLabel[] lblText;
	private String[] text;
	private JComboBox cboCourse;
	private JComboBox cboClass;
	private JTextField txtSgCount;
	private JTextField txtMlCount;
	private JTextField txtSgSc;
	private JTextField txtMlSc;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JComboBox cboDay;
	private JComboBox cboH;
	private JComboBox cboM;
	private JTextField txtTime;
	private JButton btnSave;
	private JButton btnCancel;
	
	private CourseDao courseDao;
	private ClassDao classDao;
	private TestDao testDao;
	private QuestionsDao questionDao;
	private EditTestFrame testFrm;
	
	public CreateTestFrame(EditTestFrame testFrm){
		testDao = new TestDao();
		courseDao = new CourseDao();
		classDao = new ClassDao();
		questionDao = new QuestionsDao();
		this.testFrm = testFrm;
		this.setBounds(350, 100, 500, 700);
		this.setTitle("�½�����");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bindListener();
	}

	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		//�����������˵�������
		CboDaysListener cbodaysLintener = new CboDaysListener();
		cboMonth.addItemListener(cbodaysLintener);
		
		//��ť������
		ButtonListener btnListner = new ButtonListener();
		btnSave.addActionListener(btnListner);
		btnCancel.addActionListener(btnListner);
		
		cboYear.addItemListener(new YearCombListener());
	}
	
	/**
	 * ��������б������
	 * @author Administrator
	 *
	 */
	private class YearCombListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int days = daysInMonth(year, month);
			//�ж�ѡ�������
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(!cboYear.getSelectedItem().toString().equals(year+"")){
					//�����
					cboMonth.removeAllItems();
					for(int i = 1; i <= 12 ; i++){
						cboMonth.addItem(i);
					}
					//�����
					cboDay.removeAllItems();
					for(int i = 1; i <= 31 ; i++){
						cboDay.addItem(i);
					}
				}
				else{
					//�����
					cboMonth.removeAllItems();
					//����·�
					for(int i = month; i <= 12; i++){
						cboMonth.addItem(i);
					}
					//�����
					cboDay.removeAllItems();
					//�������
					for(int i = day; i <= days; i++){
						cboDay.addItem(i);
					}
				}
			}
			
		}
		
	}
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//����
			if(btn == btnSave){
				//��ȡ��Ŀ��
				String courseName = cboCourse.getSelectedItem().toString();
				//��ȡ���԰༶
				String className = cboClass.getSelectedItem().toString();
				//��ȡ��ѡ����
				String sgCount = txtSgCount.getText().trim();
				//��ȡ��ѡ���ֵ
				String sgSc = txtSgSc.getText().trim();
				//��ȡ��ѡ����
				String mlCount = txtMlCount.getText().trim();
				//��ȡ��ѡ���ֵ
				String mlSc = txtMlSc.getText().trim();
				//��ȡ��ʼ��
				int year = Integer.parseInt(cboYear.getSelectedItem().toString());
				//��ȡ��ʼ��
				int month = Integer.parseInt(cboMonth.getSelectedItem().toString());
				//��ȡ��ʼ��
				int day = Integer.parseInt(cboDay.getSelectedItem().toString());
				//��ȡ��ʼʱ
				int h = Integer.parseInt(cboH.getSelectedItem().toString());
				//��ȡ��ʼ��
				int m = Integer.parseInt(cboM.getSelectedItem().toString());
				//��ȡ����ʱ��
				String time = txtTime.getText().trim();
				
				//�жϵ�ѡ�����Ƿ���д
				if(sgCount.equals("")){
					JOptionPane.showMessageDialog(null, "����д��ѡ������");
					txtSgCount.requestFocus();
					return;
				}
				//�жϵ�ѡ���ֵ�Ƿ���д
				if(sgSc.equals("")){
					JOptionPane.showMessageDialog(null, "����д��ѡ���ֵ");
					txtSgSc.requestFocus();
					return;
				}
				//�ж϶�ѡ�����Ƿ���д
				if(mlCount.equals("")){
					JOptionPane.showMessageDialog(null, "����д��ѡ������");
					txtMlCount.requestFocus();
					return;
				}
				//�ж϶�ѡ���ֵ�Ƿ���д
				if(mlSc.equals("")){
					JOptionPane.showMessageDialog(null, "����д��ѡ���ֵ");
					txtMlSc.requestFocus();
					return;
				}
				//�жϿ���ʱ���Ƿ���д
				if(time.equals("")){
					JOptionPane.showMessageDialog(null, "����д����ʱ��");
					txtTime.requestFocus();
					return;
				}
				//�жϵ�ѡ���Ƿ���int������
				if(!isInt(sgCount)){
					JOptionPane.showMessageDialog(null, "��ѡ����������д���ڵ���0��������");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//�ж϶�ѡ���Ƿ���int������
				if(!isInt(mlCount)){
					JOptionPane.showMessageDialog(null, "��ѡ����������д���ڵ���0��������");
					txtMlCount.requestFocus();
					txtMlCount.selectAll();
					return;
				}
				//�жϵ�ѡ��ֵ�Ƿ���int������
				if(!isInt(sgSc)){
					JOptionPane.showMessageDialog(null, "��ѡ���ֵ������д���ڵ���0��������");
					txtSgSc.requestFocus();
					txtSgSc.selectAll();
					return;
				}
				//�ж϶�ѡ��ֵ�Ƿ���int������
				if(!isInt(mlSc)){
					JOptionPane.showMessageDialog(null, "��ѡ���ֵ������д���ڵ���0��������");
					txtMlSc.requestFocus();
					txtMlSc.selectAll();
					return;
				}
				//�жϿ���ʱ���Ƿ���int�ε�����
				if(!isInt(time)){
					JOptionPane.showMessageDialog(null, "����ʱ�䣺����д���ڵ���0��������");
					txtTime.requestFocus();
					txtTime.selectAll();
					return;
				}
				
				//�жϲ��Կ�ʼʱ���Ƿ�����ϵͳʱ��
				//���Կ�ʼʱ��
				Calendar cal = CommonUtil.getCalendar(year, month, day, h, m, 0);
				//���Կ���ʱ������ϵͳʱ��
				Date date = new Date();
				if(cal.getTimeInMillis() < date.getTime()){
					JOptionPane.showMessageDialog(null, "���Կ���ʱ�䲻�����ڵ�ǰʱ�䣡");
					return;
				}
				
				
				//��Ŀ���
				int courseId = courseDao.findCourseByCourseName(courseName).getCourseId();
				//�ÿ�Ŀ�µĵ�ѡ������
				int singleCount = questionDao.findQuestionsByCourseId(courseId, 0).size();
				//�ÿ�Ŀ�µĶ�ѡ������
				int multiCount = questionDao.findQuestionsByCourseId(courseId, 1).size();
				//��ѡ
				int sgC = Integer.parseInt(sgCount);
				int scS = Integer.parseInt(sgSc);
				//��ѡ
				int mlC = Integer.parseInt(mlCount);
				int mlS = Integer.parseInt(mlSc);
				//�жϵ�ѡ�����Ƿ�С������е�ѡ�������
				if(sgC > singleCount){
					JOptionPane.showMessageDialog(null, "��ѡ����������е�ѡ�������㣡");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//�ж϶�ѡ�����Ƿ�С������е�ѡ�������
				if(mlC > singleCount){
					JOptionPane.showMessageDialog(null, "��ѡ����������ж�ѡ�������㣡");
					txtMlCount.requestFocus();
					txtMlCount.selectAll();
					return;
				}
				//�ж������Ƿ����0
				if((sgC + mlC) <= 0){
					JOptionPane.showMessageDialog(null, "�������㣡");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//�жϵ�ѡ���ֵ���ѡ���ֵ����Ƿ����0
				if((mlS + scS) != 100){
					JOptionPane.showMessageDialog(null, "�Ծ��ֵ��Ϊ100��");
					txtSgSc.requestFocus();
					txtSgSc.selectAll();
					return;
				}
				//�жϿ���ʱ���Ƿ����0
				//������ʱ��
				int t = Integer.parseInt(time);
				if( t <= 0){
					JOptionPane.showMessageDialog(null, "����ʱ�䲻��С�ڵ���0��");
					txtTime.requestFocus();
					txtTime.selectAll();
					return;
				}
				
				//�����Ծ�
				Test test = new Test();
				//��ȡ�༶���
				int classId = classDao.findClassByName(className).getClassId();
				//���Կ�ʼʱ��
				Timestamp ts = new Timestamp(cal.getTimeInMillis());
				//��������
				String testName = courseName+CommonUtil.formatDate(cal);
				
				test.setCourseId(courseId);
				test.setClassId(classId);
				test.setMultiCount(mlC);
				test.setMultiScore(mlS);
				test.setSingleCount(sgC);
				test.setSingleScore(sgC);
				test.setTotalTime(t);
				test.setTestName(testName);
				test.setStartTime(ts);
				
				
				int choice = JOptionPane.showConfirmDialog(null, "ȷ�����������Ϊ"+testName+"�����⣿","�������",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//�������
					testDao.addTest(test);
					//�رյ�ǰ����
					CreateTestFrame.this.dispose();
					//���¼��ر������
					testFrm.loadData();
				}
			}
			//ȡ��
			else{
				CreateTestFrame.this.dispose();
			}
			
		}
		
	}
	
	/**
	 * �ж�һ���ַ����Ƿ�������
	 * @return
	 */
	private boolean isInt(String str){
		//�Ƿ����ַ���С����
		for(int i = 0; i < str.length(); i++ ){
			char c = str.charAt(i);
			if(c > '9' || c < '0'){
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * �����б��е�day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//�ж�ѡ����
			if(e.getStateChange() == ItemEvent.SELECTED){
				//�����е��������
				cboDay.removeAllItems();
				//��ȡѡ�е���
				int year =(Integer) cboYear.getSelectedItem();
				//��ȡѡ�е���
				int month =(Integer)cboMonth.getSelectedItem();
				//�������
				int days = daysInMonth(year, month);
				for(int i = 1; i <= days; i++){
					cboDay.addItem(i);
				}
			}
		}
		
	}
	

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//��
		text = new String[]{"���Կ�Ŀ","���԰༶","��ѡ����","��ѡ���ֵ","��ѡ����","��ѡ���ֵ","��ʼʱ��","����ʱ�䣨�֣�"};
		lblText = new JLabel[text.length];
		for(int i = 0 ,y = 20; i < text.length; i++ , y += 60){
			lblText[i] = new JLabel(text[i]);
			lblText[i].setBounds(60, y, 100, 20);
			this.add(lblText[i]);
		}
		//��ȡ���п�Ŀ
		ArrayList<Course> courseList = courseDao.findAllCourse();
		cboCourse = new JComboBox();
		//��Ŀ�����б����ѡ��
		for(Course c : courseList){
			cboCourse.addItem(c.getCourseName());
		}
		//��ȡ���еİ༶
		ArrayList<Classes> classList = classDao.findAllClasses();
		cboClass = new JComboBox();
		//�༶�����б����ѡ��
		for(Classes c : classList){
			cboClass.addItem(c.getClassName());
		}
		//����
		txtSgCount = new JTextField();
		txtSgSc = new JTextField();
		txtMlCount = new JTextField();
		txtMlSc = new JTextField();
		txtTime = new JTextField();
		//�����б��
		cboYear = new JComboBox();
		cboMonth = new JComboBox();
		cboDay = new JComboBox();
		cboH = new JComboBox();
		cboM = new JComboBox();
		//��ǰ���
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int days = daysInMonth(year, month);
		//������
		for(int i = year; i <=year+1 ; i++){
			cboYear.addItem(i);
		}
		//����·�
		for(int i = month; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//�������
		for(int i = day; i <= days; i++){
			cboDay.addItem(i);
		}
		//���ʱ
		for(int i = 7; i <= 17; i++){
			cboH.addItem(i);
		}
		//��ӷ�
		for(int i = 0; i < 60; i++){
			cboM.addItem(i);
		}
		//��ť
		btnSave = new JButton("����");
		btnCancel = new JButton("ȡ��");
		
		cboCourse.setBounds(180, 20, 100, 20);
		cboClass.setBounds(180, 80, 100, 20);
		txtSgCount.setBounds(180, 140, 100, 20);
		txtSgSc.setBounds(180, 200, 100, 20);
		txtMlCount.setBounds(180, 260, 100, 20);
		txtMlSc.setBounds(180, 320, 100, 20);
		//���������յĴ�С��λ��
		cboYear.setBounds(180, 380, 60, 20);
		cboMonth.setBounds(250, 380, 40, 20);
		cboDay.setBounds(300, 380, 40, 20);
		cboH.setBounds(350, 380, 40, 20);
		cboM.setBounds(400, 380, 40, 20);
		txtTime.setBounds(180, 440, 100, 20);
		btnSave.setBounds(100, 520, 80, 30);
		btnCancel.setBounds(250, 520, 80, 30);
		this.add(cboCourse);
		this.add(cboClass);
		this.add(txtSgCount);
		this.add(txtSgSc);
		this.add(txtMlCount);
		this.add(txtMlSc);
		this.add(cboYear);
		this.add(cboMonth);
		this.add(cboDay);
		this.add(cboH);
		this.add(cboM);
		this.add(txtTime);
		this.add(btnSave);
		this.add(btnCancel);
		
	}
	
	/**
	 * ��ȡ���굱�µ�����
	 * @param year
	 * @param month
	 * @return
	 */
	private int daysInMonth(int year,int month){
		int days = 0;
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		default:
			days = 31;	
		}
		return days;
	}
	
	

}
