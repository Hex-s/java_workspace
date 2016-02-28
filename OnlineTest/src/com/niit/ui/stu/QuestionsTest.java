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
	//��ǰ���Ե���������
	private ArrayList<Question> questions;
	//��ǰ��������
	private int index = 0;
	//��ѡ������
	private int multiCount = 0;
	//��ѡ���ֵ
	private double multiScore = 0;
	//ÿ����ѡ��ķ�ֵ
	private double mulS = 0;
	//��ѡ������
	private int singleCount = 0;
	//��ѡ���ֵ
	private double signleScore = 0;
	//ÿ����ѡ��ķ�ֵ
	private double sigS = 0;
	//��¼��ǰ�������Ծ����  ��ѡ��+�Ƿ��� 10001 ��ʾ��ѡ��ΪA�������
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
		ButtonListener btnListener = new ButtonListener();
		btnBack.addActionListener(btnListener);
		btnNext.addActionListener(btnListener);
		btnView.addActionListener(btnListener);
		btnSubmit.addActionListener(btnListener);
		btnMark.addActionListener(btnListener);
		btnStart.addActionListener(btnListener);
		//�󶨼�����
		int count = multiCount + singleCount;
		for(int i = 0; i < count; i++){
			btnChoices[i].addActionListener(new ButtonListener());
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
			//��ʼ����
			if(btn == btnStart){
				//ȡ������һ����������а�ť�Ļһ�
				btnNext.setEnabled(true);
				btnView.setEnabled(true);
				btnSubmit.setEnabled(true);
				btnMark.setEnabled(true);
				//��������
				loadQuestions();
				//��ʾ��һ��
				showQuestion(index);
				//�����߳�
				timeThread.start();
				btnStart.setEnabled(false);
			}
			//��һ��
			else if(btn == btnNext){
				//������һ�š���ťȡ���һ�
				btnBack.setEnabled(true);
				//��¼��ǰ����Ĵ�
				loadAnswer();
				//��������1
				index++;
				//�жϵ�ǰ�����Ƿ������һ��
				if(index <= questions.size()-1){
					//��ʾ��һ��
					showQuestion(index);
					//��ʾ��һ�����ѡ�����
					showAnswer(index);
					//�жϵ�ǰ�����Ƿ������һ��
					if(index == questions.size()-1){
						btnNext.setEnabled(false);
					}
				}
				//Ԥ���Ծ�״̬
				if(btnView.getText().equals("ȡ��Ԥ��")){
					viewTest();
				}
			}
			//��һ��
			else if(btn == btnBack){
				//����һ�Ű�ťȡ���һ�
				btnNext.setEnabled(true);
				//��¼��ǰ����Ĵ�
				loadAnswer();
				//��������1
				index--;
				//�жϵ�ǰ�����Ƿ��ǵ�һ��
				if(index >= 0){
					//��ʾ��һ��
					showQuestion(index);
					//��ʾ��һ�������ѡ�����
					showAnswer(index);
					//�жϵ�ǰ�����Ƿ��ǵ�һ��
					if(index == 0){
						btnBack.setEnabled(false);
					}
				}
				//Ԥ���Ծ�״̬
				if(btnView.getText().equals("ȡ��Ԥ��")){
					viewTest();
				}
			}
			//���
			else if(btn == btnMark){
				//��¼״̬
				//��Ϊ��ǵı�ɱ��
				if(state[index][4] == 0){
					state[index][4] = 1;
					btnMark.setText("ȡ�����");
				}
				else{
					state[index][4] = 0;
					btnMark.setText("���");
				}
				//Ԥ���Ծ�״̬
				if(btnView.getText().equals("ȡ��Ԥ��")){
					viewTest();
				}
			}
			//Ԥ���Ծ�
			else if(btn == btnView){
				//��¼��ǰ��Ŀ�Ĵ�
				loadAnswer();
				//��ȡ��ǰԤ��״̬
				String nowState = btnView.getText();
				//Ԥ���Ծ�
				if(nowState.equals("Ԥ���Ծ�")){
					btnView.setText("ȡ��Ԥ��");
					viewTest();
				}
				//ȡ��Ԥ��
				else{
					//������
					pnlBtn.removeAll();
					btnView.setText("Ԥ���Ծ�");
					//�ػ�
					QuestionsTest.this.repaint();
				}
				
			}
			//�ύ�Ծ�
			else if(btn == btnSubmit){
				//��¼��ǰ��Ŀ�Ĵ�
				loadAnswer();
				//�ж��Ծ��Ƿ����
				if(!isTestFinished()){
					JOptionPane.showMessageDialog(null, "��ȫ�����������ٽ����ύ��");
				}
				else{
					int choice = JOptionPane.showConfirmDialog(null, "ȷ���ύ���ԣ�","�ύ",JOptionPane.YES_NO_OPTION);
					//ȷ���ύ
					if(choice == JOptionPane.YES_OPTION){
						loadAnswer();
						//��ʾ���Խ��
						showScore();		
						//���¼��ز��Ա������
						testFrm.loadData();
						//�ر��߳�
						timeThread.stop();
					}
				}
				
				
			}
			else{
				//��¼��ǰ��Ŀ�Ĵ�
				loadAnswer();
				btnBack.setEnabled(true);
				btnNext.setEnabled(true);
				//��ȡ��ť������
				int loc = Integer.parseInt(btn.getText().toString());
				index = loc - 1;
				if(index >= 0 || index < questions.size()-1){
					//��ʾ��Ŀ
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
	 * �ж��Ծ��Ƿ������״̬
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
	 * Ԥ���Ծ�
	 */
	private void viewTest(){
		//������
		pnlBtn.removeAll();
		//����ѡ�ť
		int count = singleCount + multiCount;
		//����ÿ����ť
		for(int i = 0; i < count; i++){
			pnlBtn.add(btnChoices[i]);
			//�ѱ����
			if(state[i][4] == 1){
				btnChoices[i].setBackground(Color.BLUE);
			}
			else{
				//δ�����
				//�ж��Ƿ���ѡ��
				String str = getSelectedAnswer(i);
				if(str.equals("")){
					btnChoices[i].setBackground(Color.WHITE);
				}
				else{
					btnChoices[i].setBackground(Color.YELLOW);
				}
			}
		}
		//�ػ�
		QuestionsTest.this.repaint();
	}
	
	/**
	 * �����ֵ
	 */
	private int calculScore(){
		double score = 0;
		//��ȡÿ����Ĵ�
		for(int i = 0; i < questions.size(); i++){
			//��ǰ����
			Question qt = questions.get(i);
			//��ȡ��ȷ��
			String correct = qt.getqAnswer();
			//��ȡѡ���
			String selected = getSelectedAnswer(i);
			//�жϴ��Ƿ�һ��,һ����ӷ�
			if(selected.equals(correct)){
				//�жϸ�������
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
	 * ��ȡĳһ��Ĵ�
	 * @param i
	 * @return
	 */
	private String getSelectedAnswer(int i){
		//��ȡѡ���
		String selected = "";
		for(int j = 0; j < 4; j++){
			if(state[i][j] == 1){
				selected += (char)(65+j)+"#";
			}
		}
		return selected;
	}
	
	/**
	 * ��ʾ���Խ��
	 */
	private void showScore(){
		//�����ֵ
		int score = calculScore();
		//����������
		pnlRight.removeAll();
		lblS = new JLabel("�˴ο��Գɼ�Ϊ��");
		lblScore = new JLabel(score+"��");
		//����
		String contest = "";
		double rate = score / (signleScore + multiScore);
		if(rate < 0.6){
			contest = "������ϵͳ�ⶨ����Ϊѧ����";
		}
		else if(rate < 0.8){
			contest = "������ϵͳ�ⶨ����Ϊαѧ�ԣ�";
		}
		else{
			contest = "������ϵͳ�ⶨ����Ϊѧ���е�ѧ�ԣ�";
		}
		lblContest = new JLabel(contest);
		//�������塢λ�á���ɫ
		lblS.setFont(new Font("����", Font.PLAIN, 20));
		lblS.setHorizontalAlignment(JLabel.CENTER);
		lblScore.setFont(new Font("����", Font.PLAIN, 30));
		lblScore.setHorizontalAlignment(JLabel.CENTER);
		lblScore.setForeground(Color.red);
		//����λ��
		lblS.setBounds(200, 200, 200, 30);
		lblScore.setBounds(240, 300, 100, 30);
		lblContest.setBounds(200, 350, 400, 20);
		pnlRight.add(lblS);
		pnlRight.add(lblScore);
		pnlRight.add(lblContest);
		//�ػ�
		QuestionsTest.this.repaint();
		//����ɼ�
		Score s = new Score();
		s.setStuId(stu.getStuId());
		s.setTestId(test.getTestId());
		s.settScore(score);
		scoreDao.addScore(s);
	}
	
	/**
	 * ��ʾ��ǰ����Ĵ�
	 */
	private void showAnswer(int loc){
		//��ȡ��ǰ���������
		Question q = questions.get(index);
		int type = q.getqType();
		//��ѡ
		if(type == 0){
			for(int i = 0; i < 4; i++){
				if(state[index][i] == 1){
					rdoChoices[i].setSelected(true);
					break;
				}
			}
		}
		//��ѡ
		else{
			for(int i = 0; i < 4; i++){
				if(state[index][i] == 1){
					chkChoices[i].setSelected(true);
				}
			}
		}
		//��ǰ�ť
		if(state[index][4] == 1){
			btnMark.setText("ȡ�����");
		}
		else{
			btnMark.setText("���");
		}	
			
	}
	
	/**
	 * ��¼��ǰ����Ĵ�
	 */
	private void loadAnswer(){
		//��ȡ��ǰ���������
		Question q = questions.get(index);
		int type = q.getqType();
		//��ѡ��
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
		//��ѡ��
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
	 * ѡ�������
	 * @author Administrator
	 *
	 */
	private class ChoiceListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			loadAnswer();
			//Ԥ���Ծ�״̬
			if(btnView.getText().equals("ȡ��Ԥ��")){
				viewTest();
			}
			
		}
		
	}
	
	/**
	 * ��������
	 */
	private void loadQuestions(){
		//��ȡ��ѡ��
		if(singleCount > 0){
			//ÿ����ѡ��ķ�ֵ
			sigS = signleScore/singleCount;
			//����������еĵ�ѡ����
			ArrayList<Question> allSingleQt = questionDao.findQuestionsByCourseId(test.getCourseId(), 0);
			//��ѡ�ı��
			if(allSingleQt != null){
				//�ڵ�ѡ��������������Ҫ��ĵ�ѡ����������
				int[] single = randomArray(singleCount,allSingleQt.size());
				if(single != null){
					for(int i = 0; i < single.length; i++){
						questions.add(allSingleQt.get(single[i]));
					}
				}
			}
		}
		//��ȡ��ѡ��
		if(multiCount > 0){
			//ÿ����ѡ��ķ�ֵ
			mulS = multiScore/multiCount;
			//����������еĶ�ѡ����
			ArrayList<Question> allMultiQt = questionDao.findQuestionsByCourseId(test.getCourseId(), 1);
			//��ѡ�ı��
			if(allMultiQt != null){
				//�ڶ�ѡ��������������Ҫ��Ķ�ѡ����������
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
	 * ��д��������ֵ��0-���������ظ�������
	 */
	private int[] randomArray(int length,int max){
		int[] array = new int[length];
		//������һ�������
		array[0] = (int)(Math.random() * max);
		int temp;
		//����ʣ��������
		//�ӵڶ����������ʼ����
		for(int i = 1; i < array.length; i++){
			//����һ������������Ѿ���������������бȽϣ�����ظ��������²���һ�������
			temp =  (int)(Math.random() * max);
			//���Ѿ���������������бȽ�
			for(int j = 0; j < i; j++){
				if(temp == array[j]){
					//����ظ��������²���һ�������
					temp = (int)(Math.random() * max);
					j = -1;
				}
			}
			array[i] = temp;
		}
		return array;
	}
	
	
	/**
	 * ��ʾ������Ϣ
	 */
	private void showQuestion(int loc){
		ChoiceListener choiceListener = new ChoiceListener();
		//������
		pnlQt.removeAll();
		//��ȡ����
		Question q = questions.get(loc);
		//���
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 20, 560, 30);
		lblTitle.setText((loc+1)+"."+q.getqTitle());
		pnlQt.add(lblTitle);
		//��ȡ��
		String[] answers = q.getqChoices().split("#");
		//��ȡ����
		int type = q.getqType();
		//��ѡ
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
		//��ѡ
		else{
			chkChoices = new JCheckBox[answers.length];
			for(int i = 0,y = 100; i < chkChoices.length; i++, y += 70){
				chkChoices[i] = new JCheckBox(answers[i]);
				chkChoices[i].setBounds(50, y, 560, 20);
				pnlQt.add(chkChoices[i]);
				chkChoices[i].addItemListener(choiceListener);
			}
		}
		//�ػ�	
		QuestionsTest.this.repaint();
	}
	
	
	private class TimeThread extends Thread{
		

		@Override
		public void run() {
			//��ȡ����ʱ��
			int testTime = test.getTotalTime();
			//��ȡ���Կ�ʼʱ��
			Timestamp t = test.getStartTime();
			//���Խ���ʱ��
			long endTime = t.getTime()+testTime*60*1000;
			//��ȡϵͳʱ��
			Timestamp sysTime = new Timestamp(new Date().getTime());
			//����ʣ��ʱ��
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
					//��ʾ���Գɼ�
					showScore();
					//���¼��ز��Ա������
					testFrm.loadData();
					//�ر��߳�
					timeThread.stop();
				}
			}	
		}
		
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//�ָ����
		pnlLeft = new JPanel();
		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		pnlLeft.setLayout(null);
		spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlLeft,pnlRight);
		//�ָ���λ��
		spl.setDividerLocation(200);
		//���÷ָ��߲��ɶ�
		spl.setEnabled(false);
		//���÷ָ��ߴ�ϸ
		spl.setDividerSize(1);
		//������
		//��Ƭ
		lblPic = new JLabel();
		//����
		lblPic.setHorizontalAlignment(JLabel.CENTER);
		//����
		lblPic.setBorder(BorderFactory.createLoweredBevelBorder());
		lblPic.setBounds(40, 50, 120, 150);
		//ѧ����Ϣ
		String className = classDao.findClassById(stu.getClassId()).getClassName();
		info = new String[]{"ѧ�ţ�"+stu.getStuId(),"������"+stu.getStuName(),"�༶��"+className};
		lblStuInfo = new JLabel[info.length];
		for(int i = 0,y = 220; i < lblStuInfo.length; i++ , y += 30){
			lblStuInfo[i] = new JLabel(info[i]);
			lblStuInfo[i].setBounds(70, y, 100, 20);
			pnlLeft.add(lblStuInfo[i]);
		}
		
		btnStart = new JButton("��ʼ����");
		btnStart.setBounds(40, 570, 100, 30);
		pnlLeft.add(lblPic);
		pnlLeft.add(btnStart);
		
		//��ť
		//����ѡ�ť
		int count = singleCount + multiCount;
		btnChoices = new JButton[count];
		for(int i = 1; i <= count; i++){
			btnChoices[i-1] = new JButton(i+"");
		}	
		
		//�ұ����
		pnlBtn = new JPanel();
		pnlBtn.setLayout(new FlowLayout());
		sclBtn = new JScrollPane(pnlBtn);
		pnlQt = new JPanel();
		pnlQt.setLayout(null);
		pnlTime = new JPanel();
		pnlTime.setLayout(null);
		//ʱ��
		String info = "��ѡ��"+singleCount+"������ֵ"+signleScore+"�֣���ѡ��"+multiCount+"������ֵ"+multiScore+"�֣��ܷ֣�"+(signleScore+multiScore)+"��";
		lbltestInfo = new JLabel(info);
		lblTime = new JLabel("�࿼�Խ������У�");
		lblLimitTime = new JLabel();
		lbltestInfo.setBounds(10, 5, 550, 15);
		lblTime.setBounds(350, 25, 150, 20);
		lblLimitTime.setBounds(450, 25, 250, 20);
		lblLimitTime.setBorder(BorderFactory.createLoweredBevelBorder());
		lblLimitTime.setForeground(Color.RED);
		pnlTime.add(lblTime);
		pnlTime.add(lblLimitTime);
		pnlTime.add(lbltestInfo);
		
		//����ѡ�ť
		btnBack = new JButton("��һ��");
		btnNext = new JButton("��һ��");
		btnView = new JButton("Ԥ���Ծ�");
		btnSubmit = new JButton("�ύ");
		btnMark = new JButton("���");
		
		
		//��ʼ �һ�
		btnBack.setEnabled(false);
		btnNext.setEnabled(false);
		btnView.setEnabled(false);
		btnSubmit.setEnabled(false);
		btnMark.setEnabled(false);
		
		//���λ��
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
		
		//ʵ�����߳�
		timeThread = new TimeThread();
	}

	/**
	 * ��ʼ������
	 */
	private void initFrame() {
		this.setBounds(250, 100, 800, 800);
		this.setTitle(test.getTestName());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	

}
