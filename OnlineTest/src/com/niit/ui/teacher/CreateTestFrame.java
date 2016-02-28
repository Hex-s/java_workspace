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
		this.setTitle("新建测试");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
	}

	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		//年月日下拉菜单监听器
		CboDaysListener cbodaysLintener = new CboDaysListener();
		cboMonth.addItemListener(cbodaysLintener);
		
		//按钮监听器
		ButtonListener btnListner = new ButtonListener();
		btnSave.addActionListener(btnListner);
		btnCancel.addActionListener(btnListner);
		
		cboYear.addItemListener(new YearCombListener());
	}
	
	/**
	 * 年份下拉列表监听器
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
			//判断选项变更情况
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(!cboYear.getSelectedItem().toString().equals(year+"")){
					//清除月
					cboMonth.removeAllItems();
					for(int i = 1; i <= 12 ; i++){
						cboMonth.addItem(i);
					}
					//清除日
					cboDay.removeAllItems();
					for(int i = 1; i <= 31 ; i++){
						cboDay.addItem(i);
					}
				}
				else{
					//清除月
					cboMonth.removeAllItems();
					//添加月份
					for(int i = month; i <= 12; i++){
						cboMonth.addItem(i);
					}
					//清除日
					cboDay.removeAllItems();
					//添加日期
					for(int i = day; i <= days; i++){
						cboDay.addItem(i);
					}
				}
			}
			
		}
		
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//保存
			if(btn == btnSave){
				//获取科目名
				String courseName = cboCourse.getSelectedItem().toString();
				//获取考试班级
				String className = cboClass.getSelectedItem().toString();
				//获取单选题量
				String sgCount = txtSgCount.getText().trim();
				//获取单选题分值
				String sgSc = txtSgSc.getText().trim();
				//获取多选题量
				String mlCount = txtMlCount.getText().trim();
				//获取多选题分值
				String mlSc = txtMlSc.getText().trim();
				//获取开始年
				int year = Integer.parseInt(cboYear.getSelectedItem().toString());
				//获取开始月
				int month = Integer.parseInt(cboMonth.getSelectedItem().toString());
				//获取开始日
				int day = Integer.parseInt(cboDay.getSelectedItem().toString());
				//获取开始时
				int h = Integer.parseInt(cboH.getSelectedItem().toString());
				//获取开始分
				int m = Integer.parseInt(cboM.getSelectedItem().toString());
				//获取考试时间
				String time = txtTime.getText().trim();
				
				//判断单选题量是否填写
				if(sgCount.equals("")){
					JOptionPane.showMessageDialog(null, "请填写单选题数量");
					txtSgCount.requestFocus();
					return;
				}
				//判断单选题分值是否填写
				if(sgSc.equals("")){
					JOptionPane.showMessageDialog(null, "请填写单选题分值");
					txtSgSc.requestFocus();
					return;
				}
				//判断多选题量是否填写
				if(mlCount.equals("")){
					JOptionPane.showMessageDialog(null, "请填写多选题数量");
					txtMlCount.requestFocus();
					return;
				}
				//判断多选题分值是否填写
				if(mlSc.equals("")){
					JOptionPane.showMessageDialog(null, "请填写多选题分值");
					txtMlSc.requestFocus();
					return;
				}
				//判断考试时间是否填写
				if(time.equals("")){
					JOptionPane.showMessageDialog(null, "请填写考试时间");
					txtTime.requestFocus();
					return;
				}
				//判断单选数是否是int的整数
				if(!isInt(sgCount)){
					JOptionPane.showMessageDialog(null, "单选题数：请填写大于等于0的正整数");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//判断多选数是否是int的整数
				if(!isInt(mlCount)){
					JOptionPane.showMessageDialog(null, "多选题数：请填写大于等于0的正整数");
					txtMlCount.requestFocus();
					txtMlCount.selectAll();
					return;
				}
				//判断单选分值是否是int的整数
				if(!isInt(sgSc)){
					JOptionPane.showMessageDialog(null, "单选题分值：请填写大于等于0的正整数");
					txtSgSc.requestFocus();
					txtSgSc.selectAll();
					return;
				}
				//判断多选分值是否是int的整数
				if(!isInt(mlSc)){
					JOptionPane.showMessageDialog(null, "多选题分值：请填写大于等于0的正整数");
					txtMlSc.requestFocus();
					txtMlSc.selectAll();
					return;
				}
				//判断考试时间是否是int形的整数
				if(!isInt(time)){
					JOptionPane.showMessageDialog(null, "考试时间：请填写大于等于0的正整数");
					txtTime.requestFocus();
					txtTime.selectAll();
					return;
				}
				
				//判断测试开始时间是否在于系统时间
				//测试开始时间
				Calendar cal = CommonUtil.getCalendar(year, month, day, h, m, 0);
				//测试考试时间早于系统时间
				Date date = new Date();
				if(cal.getTimeInMillis() < date.getTime()){
					JOptionPane.showMessageDialog(null, "测试考试时间不能早于当前时间！");
					return;
				}
				
				
				//科目编号
				int courseId = courseDao.findCourseByCourseName(courseName).getCourseId();
				//该科目下的单选题数量
				int singleCount = questionDao.findQuestionsByCourseId(courseId, 0).size();
				//该科目下的多选题数量
				int multiCount = questionDao.findQuestionsByCourseId(courseId, 1).size();
				//单选
				int sgC = Integer.parseInt(sgCount);
				int scS = Integer.parseInt(sgSc);
				//多选
				int mlC = Integer.parseInt(mlCount);
				int mlS = Integer.parseInt(mlSc);
				//判断单选数量是否小于题库中单选题的数量
				if(sgC > singleCount){
					JOptionPane.showMessageDialog(null, "单选题数：题库中单选题数不足！");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//判断多选数量是否小于题库中单选题的数量
				if(mlC > singleCount){
					JOptionPane.showMessageDialog(null, "多选题数：题库中多选题数不足！");
					txtMlCount.requestFocus();
					txtMlCount.selectAll();
					return;
				}
				//判断题量是否大于0
				if((sgC + mlC) <= 0){
					JOptionPane.showMessageDialog(null, "题量不足！");
					txtSgCount.requestFocus();
					txtSgCount.selectAll();
					return;
				}
				//判断单选题分值与多选题分值相加是否大于0
				if((mlS + scS) != 100){
					JOptionPane.showMessageDialog(null, "试卷分值不为100！");
					txtSgSc.requestFocus();
					txtSgSc.selectAll();
					return;
				}
				//判断考试时间是否大于0
				//考试总时间
				int t = Integer.parseInt(time);
				if( t <= 0){
					JOptionPane.showMessageDialog(null, "考试时间不能小于等于0！");
					txtTime.requestFocus();
					txtTime.selectAll();
					return;
				}
				
				//创建试卷
				Test test = new Test();
				//获取班级编号
				int classId = classDao.findClassByName(className).getClassId();
				//考试开始时间
				Timestamp ts = new Timestamp(cal.getTimeInMillis());
				//测试名称
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
				
				
				int choice = JOptionPane.showConfirmDialog(null, "确认添加试题编号为"+testName+"的试题？","添加试题",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//添加试题
					testDao.addTest(test);
					//关闭当前窗口
					CreateTestFrame.this.dispose();
					//重新加载表格数据
					testFrm.loadData();
				}
			}
			//取消
			else{
				CreateTestFrame.this.dispose();
			}
			
		}
		
	}
	
	/**
	 * 判断一个字符串是否是整数
	 * @return
	 */
	private boolean isInt(String str){
		//是否含有字符和小数点
		for(int i = 0; i < str.length(); i++ ){
			char c = str.charAt(i);
			if(c > '9' || c < '0'){
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * 下拉列表中的day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选中项
			if(e.getStateChange() == ItemEvent.SELECTED){
				//将日中的数据清空
				cboDay.removeAllItems();
				//获取选中的年
				int year =(Integer) cboYear.getSelectedItem();
				//获取选中的月
				int month =(Integer)cboMonth.getSelectedItem();
				//添加日期
				int days = daysInMonth(year, month);
				for(int i = 1; i <= days; i++){
					cboDay.addItem(i);
				}
			}
		}
		
	}
	

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//列
		text = new String[]{"考试科目","考试班级","单选题量","单选题分值","多选题量","多选题分值","开始时间","考试时间（分）"};
		lblText = new JLabel[text.length];
		for(int i = 0 ,y = 20; i < text.length; i++ , y += 60){
			lblText[i] = new JLabel(text[i]);
			lblText[i].setBounds(60, y, 100, 20);
			this.add(lblText[i]);
		}
		//获取所有科目
		ArrayList<Course> courseList = courseDao.findAllCourse();
		cboCourse = new JComboBox();
		//科目下拉列表添加选项
		for(Course c : courseList){
			cboCourse.addItem(c.getCourseName());
		}
		//获取所有的班级
		ArrayList<Classes> classList = classDao.findAllClasses();
		cboClass = new JComboBox();
		//班级下拉列表添加选项
		for(Classes c : classList){
			cboClass.addItem(c.getClassName());
		}
		//试题
		txtSgCount = new JTextField();
		txtSgSc = new JTextField();
		txtMlCount = new JTextField();
		txtMlSc = new JTextField();
		txtTime = new JTextField();
		//下拉列表框
		cboYear = new JComboBox();
		cboMonth = new JComboBox();
		cboDay = new JComboBox();
		cboH = new JComboBox();
		cboM = new JComboBox();
		//当前年份
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int days = daysInMonth(year, month);
		//添加年份
		for(int i = year; i <=year+1 ; i++){
			cboYear.addItem(i);
		}
		//添加月份
		for(int i = month; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//添加日期
		for(int i = day; i <= days; i++){
			cboDay.addItem(i);
		}
		//添加时
		for(int i = 7; i <= 17; i++){
			cboH.addItem(i);
		}
		//添加分
		for(int i = 0; i < 60; i++){
			cboM.addItem(i);
		}
		//按钮
		btnSave = new JButton("保存");
		btnCancel = new JButton("取消");
		
		cboCourse.setBounds(180, 20, 100, 20);
		cboClass.setBounds(180, 80, 100, 20);
		txtSgCount.setBounds(180, 140, 100, 20);
		txtSgSc.setBounds(180, 200, 100, 20);
		txtMlCount.setBounds(180, 260, 100, 20);
		txtMlSc.setBounds(180, 320, 100, 20);
		//设置年月日的大小和位置
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
	 * 获取当年当月的天数
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
