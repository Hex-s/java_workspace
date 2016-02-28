package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.QuestionsDao;
import com.niit.entiry.Course;
import com.niit.entiry.Question;

public class ModifyQuestion extends JFrame{

	private JLabel lblCourse;
	private JLabel lblType;
	private JLabel lblTitle;
	private JLabel lblChoice;
	private JComboBox cboCourse;
	private ButtonGroup group;
	private JRadioButton[] rdoType;
	private String[] type;
	private JTextArea txtTitle;
	private JScrollPane scl;
	private JCheckBox[] chk;
	private JTextArea[] txtChoice;
	private JScrollPane[] sclChoice;
	private JButton btnSave;
	private JButton btnCancel;
	
	private CourseDao courseDao;
	private QuestionsDao questionDao;
	private Question qt;
	
	private EditQuestionsFrame qFrm;
	
	public ModifyQuestion(Question q,EditQuestionsFrame qFrm){
		this.qt = q;
		this.qFrm = qFrm;
		courseDao = new CourseDao();
		questionDao = new QuestionsDao();
		this.setBounds(300, 100, 500, 550);
		this.setTitle("修改试题");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
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
		btnCancel.addActionListener(btnListener);
		btnSave.addActionListener(btnListener);
		
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
				Question q = new Question();
				//获取课程编号
				String name = cboCourse.getSelectedItem().toString();
				int courseId = courseDao.findCourseByCourseName(name).getCourseId();
				q.setCourseId(courseId);
				q.setQid(qt.getQid());
				//获取试题类型
				int type = -1;
				for(int i = 0; i < rdoType.length; i++){
					if(rdoType[i].isSelected()){
						type = i;
						break;
					}
				}
				if(type == -1){
					JOptionPane.showMessageDialog(null, "请选择题型");
				}
				else{
					q.setqType(type);
				}
				//获取题干
				String s = txtTitle.getText().trim();
				if(s.equals("")){
					JOptionPane.showMessageDialog(null, "请填写题干信息！");
					txtTitle.requestFocus();
					return;
				}
				q.setqTitle(s);
				//判断是否填写选项
				for(int i = 0; i < txtChoice.length; i++){
					String str = txtChoice[i].getText().trim();
					if(str.equals("")){
						JOptionPane.showMessageDialog(null, "请完整填写选项内容！");
						txtChoice[i].requestFocus();
						return;
					}
				}
				//判断选项是否重复
				for(int i = 0; i < txtChoice.length - 1; i++){
					String str1 = txtChoice[i].getText().trim();
					for(int j = i+1; j < txtChoice.length; j++){
						String str2 = txtChoice[j].getText().trim();
						if(str1.equals(str2)){
							JOptionPane.showMessageDialog(null, "请不要填写重复的选项！");
							txtChoice[j].requestFocus();
							txtChoice[j].selectAll();
							return;
						}
					}
				}
				//获取选项
				String choice = "";
				for(int i = 0,x = 65; i < txtChoice.length;i++){
					String ch = txtChoice[i].getText().trim();
					choice += chk[i].getText()+"."+txtChoice[i].getText()+"#";
				}
				q.setqChoices(choice);
				//获取答案
				ArrayList<Integer> ch = new ArrayList<Integer>();
				String answer = "";
				for(int i = 0; i< chk.length; i++){
					if(chk[i].isSelected()){
						ch.add(i);
					}
				}
				//没有选择答案
				if(ch.size() == 0){
					JOptionPane.showMessageDialog(null, "请选择答案！");
					return;
				}
				//答案数目与题型不符合
				if(type == 0 && ch.size() >1){
					JOptionPane.showMessageDialog(null, "单选选项只能有一个！");
				}
				else{
					for(int i = 0; i< chk.length; i++){
						if(chk[i].isSelected()){
							answer += chk[i].getText().trim()+"#";
						}
					}
					answer = answer.substring(0,answer.length());
					q.setqAnswer(answer);
					
					int cho = JOptionPane.showConfirmDialog(null, "确认修改该试题？","修改试题",JOptionPane.YES_NO_OPTION);
					if(cho == JOptionPane.YES_OPTION){
						//添加试题
						questionDao.modifyQuestions(q);
						//关闭当前窗口
						ModifyQuestion.this.dispose();
						qFrm.loadData();
					}
				}
				
			}
			else{
				ModifyQuestion.this.dispose();
			}
			
		}
		
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		lblCourse = new JLabel("科目");
		lblType = new JLabel("类型");
		lblTitle = new JLabel("题干");
		lblChoice = new JLabel("选项");
		txtTitle = new JTextArea();
		scl = new JScrollPane(txtTitle);
		chk = new JCheckBox[4];
		sclChoice = new JScrollPane[4];
		txtChoice = new JTextArea[4];
		btnCancel = new JButton("取消");
		btnSave = new JButton("修改");
		
		//自动换行
		txtTitle.setLineWrap(true);
		//设置题干
		txtTitle.setText(qt.getqTitle());
		//获取所有课程
		ArrayList<Course> courseList = courseDao.findAllCourse();
		cboCourse = new JComboBox();
		//课程名称
		String courseName = courseDao.findCourseById(qt.getCourseId()).getCourseName();
		//下拉列表添加选项
		for(Course c : courseList){
			cboCourse.addItem(c.getCourseName());
			if(courseName.equals(c.getCourseName())){
				cboCourse.setSelectedItem(courseName);
			}
		}
		
		//设置题型单选按钮
		group = new ButtonGroup();
		type = new String[]{"单选","多选"};
		rdoType = new JRadioButton[type.length];
		for(int i = 0,x = 180 ;i < type.length; i++,x +=80){
			rdoType[i] = new JRadioButton(type[i]);
			rdoType[i].setBounds(x, 50, 80, 20);
			group.add(rdoType[i]);
			this.add(rdoType[i]);	
		}
		int type = qt.getqType();
		rdoType[type].setSelected(true);
		//设置选项
		//获取选项
		String[] choices = qt.getqChoices().split("#");
		for(int i = 0; i < choices.length; i++){
			choices[i] = choices[i].substring(2); 
		}
		//获取答案
		String[] answer = qt.getqAnswer().split("#");
		for(int i = 0,y = 230,x = 65; i < chk.length; i++,y += 40,x++){
			chk[i] = new JCheckBox((char)x+"");
			txtChoice[i] = new JTextArea(choices[i]);
			chk[i].setBounds(180, y, 40, 20);
			//自动换行
			txtChoice[i].setLineWrap(true);
			sclChoice[i] = new JScrollPane(txtChoice[i]);
			sclChoice[i].setBounds(220, y, 150, 25);
			
			for(int j = 0; j < answer.length; j++){
				if(chk[i].getText().equals(answer[j])){
					chk[i].setSelected(true);
					break;
				}
			}
			this.add(chk[i]);
			this.add(sclChoice[i]);
		}
	
		
		//设置组件位置
		lblCourse.setBounds(100, 10, 80, 20);
		cboCourse.setBounds(180, 10, 100, 20);
		lblType.setBounds(100, 50, 80, 20);
		lblTitle.setBounds(100, 90, 80, 20);
		scl.setBounds(180, 90, 200, 100);
		lblChoice.setBounds(100, 230, 80, 20);
		btnSave.setBounds(120, 450, 80, 20);
		btnCancel.setBounds(260, 450, 80, 20);
		//添加组件
		this.add(lblCourse);
		this.add(cboCourse);
		this.add(lblType);
		this.add(lblTitle);
		this.add(scl);
		this.add(lblChoice);
		this.add(btnSave);
		this.add(btnCancel);
	}
	
}
