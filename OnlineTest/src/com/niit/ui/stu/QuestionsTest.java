package com.niit.ui.stu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.QuestionsDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Question;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class QuestionsTest extends JFrame{
	
	private JScrollPane sclBtn;
	private JPanel pnlBtn;
	private JPanel pnlQt;
	private JPanel pnlTime;
	private JButton[] btnChoices;
	private JButton btnNext;
	private JButton btnBack;
	private JButton btnView;
	private JButton btnSubmit;
	private JButton btnMark;
	private JLabel lblTitle;
	private JLabel lblTime;
	private JLabel lblLimitTime;
	private QuestionsDao questionDao;
	private JRadioButton[] rdoChoices;
	private JCheckBox[] chkChoices;
	private ButtonGroup group;
	private JPanel pnlRight;
	private JPanel pnlLeft;
	private JSplitPane spl;
	private JLabel lblS;
	private JLabel lblScore;
	private JLabel lblPic;
	private JLabel[] lblStuInfo;
	private String[] info;
	private JButton btnStart;
	private JLabel lblType;
	private JLabel lblqTitle;
	private JLabel[] lblChoices;
	private JLabel lblSel;
	private JLabel lblc;
	private JLabel lblt;
	private JLabel lbla;
	private JLabel lblty;
	private JLabel lbltestInfo;
	private JLabel lblContest;
	
	private TimeThread timeThread;
	private ClassDao classDao;
	private ScoreDao scoreDao;
	private Test test;
	private Student stu;
	private TestsFrame testFrm;
	//当前测试的所有试题
	private ArrayList<Question> questions;
	//当前的试题编号
	private int index = 0;
	//多选题数量
	private int multiCount = 0;
	//多选题分值
	private double multiScore = 0;
	//每个多选题的分值
	private double mulS = 0;
	//单选题数量
	private int singleCount = 0;
	//单选题分值
	private double signleScore = 0;
	//每个单选题的分值
	private double sigS = 0;
	//记录当前所做的试卷情况  所选答案+是否标记 10001 表示所选答案为A，并标记
	int[][] state;
	
	
	public QuestionsTest(Test test,TestsFrame testFrm){
		
		this.testFrm = testFrm;
		this.stu = testFrm.getStu();
		this.test = test;
		classDao = new ClassDao();
		scoreDao = new ScoreDao();
		questions = new ArrayList<Question>();
		questionDao = new QuestionsDao();
		multiCount = test.getMultiCount();
		multiScore = test.getMultiScore();
		singleCount = test.getSingleCount();
		signleScore = test.getSingleScore();
		state = new int[multiCount+singleCount][5];
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
		ButtonListener btnListener = new ButtonListener();
		btnBack.addActionListener(btnListener);
		btnNext.addActionListener(btnListener);
		btnView.addActionListener(btnListener);
		btnSubmit.addActionListener(btnListener);
		btnMark.addActionListener(btnListener);
		btnStart.addActionListener(btnListener);
		//绑定监听器
		int count = multiCount + singleCount;
		for(int i = 0; i < count; i++){
			btnChoices[i].addActionListener(new ButtonListener());
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
			//开始考试
			if(btn == btnStart){
				//取消除上一题以外的所有按钮的灰化
				btnNext.setEnabled(true);
				btnView.setEnabled(true);
				btnSubmit.setEnabled(true);
				btnMark.setEnabled(true);
				//下载试题
				loadQuestions();
				//显示第一题
				showQuestion(index);
				//启动线程
				timeThread.start();
				btnStart.setEnabled(false);
			}
			//下一题
			else if(btn == btnNext){
				//将“上一张”按钮取消灰化
				btnBack.setEnabled(true);
				//记录当前试题的答案
				loadAnswer();
				//试题标题加1
				index++;
				//判断当前试题是否是最后一题
				if(index <= questions.size()-1){
					//显示下一题
					showQuestion(index);
					//显示下一试题的选择情况
					showAnswer(index);
					//判断当前试题是否是最后一题
					if(index == questions.size()-1){
						btnNext.setEnabled(false);
					}
				}
				//预览试卷状态
				if(btnView.getText().equals("取消预览")){
					viewTest();
				}
			}
			//上一题
			else if(btn == btnBack){
				//将下一张按钮取消灰化
				btnNext.setEnabled(true);
				//记录当前试题的答案
				loadAnswer();
				//试题标题加1
				index--;
				//判断当前试题是否是第一题
				if(index >= 0){
					//显示上一题
					showQuestion(index);
					//显示上一题试题的选择情况
					showAnswer(index);
					//判断当前试题是否是第一题
					if(index == 0){
						btnBack.setEnabled(false);
					}
				}
				//预览试卷状态
				if(btnView.getText().equals("取消预览")){
					viewTest();
				}
			}
			//标记
			else if(btn == btnMark){
				//记录状态
				//将为标记的变成标记
				if(state[index][4] == 0){
					state[index][4] = 1;
					btnMark.setText("取消标记");
				}
				else{
					state[index][4] = 0;
					btnMark.setText("标记");
				}
				//预览试卷状态
				if(btnView.getText().equals("取消预览")){
					viewTest();
				}
			}
			//预览试卷
			else if(btn == btnView){
				//记录当前题目的答案
				loadAnswer();
				//获取当前预览状态
				String nowState = btnView.getText();
				//预览试卷
				if(nowState.equals("预览试卷")){
					btnView.setText("取消预览");
					viewTest();
				}
				//取消预览
				else{
					//清除组件
					pnlBtn.removeAll();
					btnView.setText("预览试卷");
					//重绘
					QuestionsTest.this.repaint();
				}
				
			}
			//提交试卷
			else if(btn == btnSubmit){
				//记录当前题目的答案
				loadAnswer();
				//判断试卷是否完成
				if(!isTestFinished()){
					JOptionPane.showMessageDialog(null, "请全部完成试题后再进行提交！");
				}
				else{
					int choice = JOptionPane.showConfirmDialog(null, "确认提交测试？","提交",JOptionPane.YES_NO_OPTION);
					//确认提交
					if(choice == JOptionPane.YES_OPTION){
						loadAnswer();
						//显示考试结果
						showScore();		
						//重新加载测试表格数据
						testFrm.loadData();
						//关闭线程
						timeThread.stop();
					}
				}
				
				
			}
			else{
				//记录当前题目的答案
				loadAnswer();
				btnBack.setEnabled(true);
				btnNext.setEnabled(true);
				//获取按钮的数字
				int loc = Integer.parseInt(btn.getText().toString());
				index = loc - 1;
				if(index >= 0 || index < questions.size()-1){
					//显示题目
					showQuestion(index);
					showAnswer(index);
					if(index == 0){
						btnBack.setEnabled(false);
					}
					if(index == questions.size()-1){
						btnNext.setEnabled(false);
					}
				}
				viewTest();
			}
		}
	}
	
	
	/**
	 * 判断试卷是否处于完成状态
	 * @return
	 */
	private boolean isTestFinished(){
		
		String str = "";
		for(int i = 0 ; i < questions.size(); i++){
			str = getSelectedAnswer(i);
			if(str.equals("")){
				return false;
			}
		}
		return true;
	}
	/**
	 * 预览试卷
	 */
	private void viewTest(){
		//清除组件
		pnlBtn.removeAll();
		//设置选项按钮
		int count = singleCount + multiCount;
		//设置每个按钮
		for(int i = 0; i < count; i++){
			pnlBtn.add(btnChoices[i]);
			//已被标记
			if(state[i][4] == 1){
				btnChoices[i].setBackground(Color.BLUE);
			}
			else{
				//未被标记
				//判断是否已选答案
				String str = getSelectedAnswer(i);
				if(str.equals("")){
					btnChoices[i].setBackground(Color.WHITE);
				}
				else{
					btnChoices[i].setBackground(Color.YELLOW);
				}
			}
		}
		//重绘
		QuestionsTest.this.repaint();
	}
	
	/**
	 * 计算分值
	 */
	private int calculScore(){
		double score = 0;
		//获取每道题的答案
		for(int i = 0; i < questions.size(); i++){
			//当前试题
			Question qt = questions.get(i);
			//获取正确答案
			String correct = qt.getqAnswer();
			//获取选择答案
			String selected = getSelectedAnswer(i);
			//判断答案是否一致,一致则加分
			if(selected.equals(correct)){
				//判断该题题型
				int type = qt.getqType();
				if(type == 0){
					score += sigS;
				}
				else{
					score += mulS;
				}
			}
		}
		return (int)score;
	}
	
	
	/**
	 * 获取某一题的答案
	 * @param i
	 * @return
	 */
	private String getSelectedAnswer(int i){
		//获取选择答案
		String selected = "";
		for(int j = 0; j < 4; j++){
			if(state[i][j] == 1){
				selected += (char)(65+j)+"#";
			}
		}
		return selected;
	}
	
	/**
	 * 显示考试结果
	 */
	private void showScore(){
		//计算分值
		int score = calculScore();
		//清除所有组件
		pnlRight.removeAll();
		lblS = new JLabel("此次考试成绩为：");
		lblScore = new JLabel(score+"分");
		//评价
		String contest = "";
		double rate = score / (signleScore + multiScore);
		if(rate < 0.6){
			contest = "经过本系统测定：你为学渣！";
		}
		else if(rate < 0.8){
			contest = "经过本系统测定：你为伪学霸！";
		}
		else{
			contest = "经过本系统测定：你为学霸中的学霸！";
		}
		lblContest = new JLabel(contest);
		//设置字体、位置、颜色
		lblS.setFont(new Font("宋体", Font.PLAIN, 20));
		lblS.setHorizontalAlignment(JLabel.CENTER);
		lblScore.setFont(new Font("宋体", Font.PLAIN, 30));
		lblScore.setHorizontalAlignment(JLabel.CENTER);
		lblScore.setForeground(Color.red);
		//设置位置
		lblS.setBounds(200, 200, 200, 30);
		lblScore.setBounds(240, 300, 100, 30);
		lblContest.setBounds(200, 350, 400, 20);
		pnlRight.add(lblS);
		pnlRight.add(lblScore);
		pnlRight.add(lblContest);
		//重绘
		QuestionsTest.this.repaint();
		//插入成绩
		Score s = new Score();
		s.setStuId(stu.getStuId());
		s.setTestId(test.getTestId());
		s.settScore(score);
		scoreDao.addScore(s);
	}
	
	/**
	 * 显示当前试题的答案
	 */
	private void showAnswer(int loc){
		//获取当前试题的题型
		Question q = questions.get(index);
		int type = q.getqType();
		//单选
		if(type == 0){
			for(int i = 0; i < 4; i++){
				if(state[index][i] == 1){
					rdoChoices[i].setSelected(true);
					break;
				}
			}
		}
		//多选
		else{
			for(int i = 0; i < 4; i++){
				if(state[index][i] == 1){
					chkChoices[i].setSelected(true);
				}
			}
		}
		//标记按钮
		if(state[index][4] == 1){
			btnMark.setText("取消标记");
		}
		else{
			btnMark.setText("标记");
		}	
			
	}
	
	/**
	 * 记录当前试题的答案
	 */
	private void loadAnswer(){
		//获取当前试题的题型
		Question q = questions.get(index);
		int type = q.getqType();
		//单选题
		if(type == 0){
			for(int i = 0; i < rdoChoices.length; i++){
				if(rdoChoices[i].isSelected()){
					state[index][i] = 1;
				}
				else{
					state[index][i] = 0;
				}
			}
		}
		//多选题
		else{
			for(int i = 0; i < chkChoices.length; i++){
				if(chkChoices[i].isSelected()){
					state[index][i] = 1;
				}
				else{
					state[index][i] = 0;
				}
			}
		}
		
	}
	
	/**
	 * 选项监听器
	 * @author Administrator
	 *
	 */
	private class ChoiceListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			loadAnswer();
			//预览试卷状态
			if(btnView.getText().equals("取消预览")){
				viewTest();
			}
			
		}
		
	}
	
	/**
	 * 下载试题
	 */
	private void loadQuestions(){
		//获取单选题
		if(singleCount > 0){
			//每个单选题的分值
			sigS = signleScore/singleCount;
			//试题库中所有的单选试题
			ArrayList<Question> allSingleQt = questionDao.findQuestionsByCourseId(test.getCourseId(), 0);
			//单选的编号
			if(allSingleQt != null){
				//在单选题题库中随机产生要求的单选题数的索引
				int[] single = randomArray(singleCount,allSingleQt.size());
				if(single != null){
					for(int i = 0; i < single.length; i++){
						questions.add(allSingleQt.get(single[i]));
					}
				}
			}
		}
		//获取多选题
		if(multiCount > 0){
			//每个多选题的分值
			mulS = multiScore/multiCount;
			//试题库中所有的多选试题
			ArrayList<Question> allMultiQt = questionDao.findQuestionsByCourseId(test.getCourseId(), 1);
			//多选的编号
			if(allMultiQt != null){
				//在多选题题库中随机产生要求的多选题数的索引
				int[] multi = randomArray(multiCount,allMultiQt.size());
				if(multi != null){
					for(int i = 0; i < multi.length; i++){
						questions.add(allMultiQt.get(multi[i]));
					}
				}
			}
		}
		
		
	}

	/**
	 * 编写方法产生值是0-任意数不重复的数组
	 */
	private int[] randomArray(int length,int max){
		int[] array = new int[length];
		//产生第一个随机数
		array[0] = (int)(Math.random() * max);
		int temp;
		//产生剩余的随机数
		//从第二个随机数开始产生
		for(int i = 1; i < array.length; i++){
			//产生一个随机数，与已经产生的随机数进行比较，如果重复，则重新产生一个随机数
			temp =  (int)(Math.random() * max);
			//与已经产生的随机数进行比较
			for(int j = 0; j < i; j++){
				if(temp == array[j]){
					//如果重复，则重新产生一个随机数
					temp = (int)(Math.random() * max);
					j = -1;
				}
			}
			array[i] = temp;
		}
		return array;
	}
	
	
	/**
	 * 显示试题信息
	 */
	private void showQuestion(int loc){
		ChoiceListener choiceListener = new ChoiceListener();
		//清除组件
		pnlQt.removeAll();
		//获取试题
		Question q = questions.get(loc);
		//题干
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 20, 560, 30);
		lblTitle.setText((loc+1)+"."+q.getqTitle());
		pnlQt.add(lblTitle);
		//获取答案
		String[] answers = q.getqChoices().split("#");
		//获取题型
		int type = q.getqType();
		//单选
		if(type == 0){
			group = new ButtonGroup();
			rdoChoices = new JRadioButton[answers.length];
			for(int i = 0,y = 100; i < rdoChoices.length; i++, y += 70){
				rdoChoices[i] = new JRadioButton(answers[i]);
				rdoChoices[i].setBounds(50, y, 560, 20);
				group.add(rdoChoices[i]);
				pnlQt.add(rdoChoices[i]);
				rdoChoices[i].addItemListener(choiceListener);
			}

		}
		//多选
		else{
			chkChoices = new JCheckBox[answers.length];
			for(int i = 0,y = 100; i < chkChoices.length; i++, y += 70){
				chkChoices[i] = new JCheckBox(answers[i]);
				chkChoices[i].setBounds(50, y, 560, 20);
				pnlQt.add(chkChoices[i]);
				chkChoices[i].addItemListener(choiceListener);
			}
		}
		//重绘	
		QuestionsTest.this.repaint();
	}
	
	
	private class TimeThread extends Thread{
		

		@Override
		public void run() {
			//获取考试时间
			int testTime = test.getTotalTime();
			//获取考试开始时间
			Timestamp t = test.getStartTime();
			//考试结束时间
			long endTime = t.getTime()+testTime*60*1000;
			//获取系统时间
			Timestamp sysTime = new Timestamp(new Date().getTime());
			//考试剩余时间
			long time = endTime - sysTime.getTime();
			String ss = time%1000+"";
			String s = time/1000%60+"";
			String min = time/1000/60%60+"";
			String hour = time/1000/60/60+"";
			if(Integer.parseInt(hour)<10){
				hour="0"+hour;
			}
			if(Integer.parseInt(min)<10){
				min = "0"+min;
			}
			if(Integer.parseInt(s)<10){
				s = "0" + s;
			}
			String str = hour+":"+min+":"+s;
			lblLimitTime.setText(str);
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				time = time-1000;
				 ss = time%1000+"";
				 s = time/1000%60+"";
				 min = time/1000/60%60+"";
				 hour = time/1000/60/60+"";
				 if(Integer.parseInt(hour)<10){
						hour="0"+hour;
					}
				if(Integer.parseInt(min)<10){
						min = "0"+min;
				}
				if(Integer.parseInt(s)<10){
						s = "0" + s;
				}
				 str = hour+":"+min+":"+s;
				 lblLimitTime.setText(str);
				if(time<=0){
					//显示考试成绩
					showScore();
					//重新加载测试表格数据
					testFrm.loadData();
					//关闭线程
					timeThread.stop();
				}
			}	
		}
		
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//分割面板
		pnlLeft = new JPanel();
		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlLeft.setLayout(null);
		spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft,pnlRight);
		//分隔线位置
		spl.setDividerLocation(200);
		//设置分隔线不可动
		spl.setEnabled(false);
		//设置分隔线粗细
		spl.setDividerSize(1);
		//左边面板
		//照片
		lblPic = new JLabel();
		//居中
		lblPic.setHorizontalAlignment(JLabel.CENTER);
		//凹陷
		lblPic.setBorder(BorderFactory.createLoweredBevelBorder());
		lblPic.setBounds(40, 50, 120, 150);
		//学生信息
		String className = classDao.findClassById(stu.getClassId()).getClassName();
		info = new String[]{"学号："+stu.getStuId(),"姓名："+stu.getStuName(),"班级："+className};
		lblStuInfo = new JLabel[info.length];
		for(int i = 0,y = 220; i < lblStuInfo.length; i++ , y += 30){
			lblStuInfo[i] = new JLabel(info[i]);
			lblStuInfo[i].setBounds(70, y, 100, 20);
			pnlLeft.add(lblStuInfo[i]);
		}
		
		btnStart = new JButton("开始考试");
		btnStart.setBounds(40, 570, 100, 30);
		pnlLeft.add(lblPic);
		pnlLeft.add(btnStart);
		
		//按钮
		//设置选项按钮
		int count = singleCount + multiCount;
		btnChoices = new JButton[count];
		for(int i = 1; i <= count; i++){
			btnChoices[i-1] = new JButton(i+"");
		}	
		
		//右边面板
		pnlBtn = new JPanel();
		pnlBtn.setLayout(new FlowLayout());
		sclBtn = new JScrollPane(pnlBtn);
		pnlQt = new JPanel();
		pnlQt.setLayout(null);
		pnlTime = new JPanel();
		pnlTime.setLayout(null);
		//时间
		String info = "单选题"+singleCount+"道，分值"+signleScore+"分，单选题"+multiCount+"道，分值"+multiScore+"分，总分："+(signleScore+multiScore)+"分";
		lbltestInfo = new JLabel(info);
		lblTime = new JLabel("距考试结束还有：");
		lblLimitTime = new JLabel();
		lbltestInfo.setBounds(10, 5, 550, 15);
		lblTime.setBounds(350, 25, 150, 20);
		lblLimitTime.setBounds(450, 25, 250, 20);
		lblLimitTime.setBorder(BorderFactory.createLoweredBevelBorder());
		lblLimitTime.setForeground(Color.RED);
		pnlTime.add(lblTime);
		pnlTime.add(lblLimitTime);
		pnlTime.add(lbltestInfo);
		
		//设置选项按钮
		btnBack = new JButton("上一题");
		btnNext = new JButton("下一题");
		btnView = new JButton("预览试卷");
		btnSubmit = new JButton("提交");
		btnMark = new JButton("标记");
		
		
		//初始 灰化
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnView.setEnabled(false);
		btnSubmit.setEnabled(false);
		btnMark.setEnabled(false);
		
		//组件位置
		sclBtn.setBounds(10, 10, 560, 45);
		pnlQt.setBounds(10, 150, 560, 400);
		pnlTime.setBounds(10, 60, 560, 50);
		btnBack.setBounds(10, 580, 90, 30);
		btnNext.setBounds(110, 580, 90, 30);
		btnView.setBounds(210, 580, 90, 30);
		btnSubmit.setBounds(310, 580, 90, 30);
		btnMark.setBounds(410, 580, 90, 30);
		pnlRight.add(sclBtn);
		pnlRight.add(pnlQt);
		pnlRight.add(pnlTime);
		pnlRight.add(btnBack);
		pnlRight.add(btnNext);
		pnlRight.add(btnView);
		pnlRight.add(btnSubmit);
		pnlRight.add(btnMark);
		this.add(spl);
		
		//实例化线程
		timeThread = new TimeThread();
	}

	/**
	 * 初始化窗体
	 */
	private void initFrame() {
		this.setBounds(250, 100, 800, 800);
		this.setTitle(test.getTestName());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	

}
