package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Classes;
import com.niit.entiry.Score;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class AvgScore extends JInternalFrame{
	
	private JComboBox cboClass;
	private JButton btnSearch;
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private JLabel lblClass;
	
	private CourseDao courseDao;
	private ClassDao classDao;
	private ScoreDao scoreDao;
	private TestDao testDao;
	
	public AvgScore(){
		testDao = new TestDao();
		scoreDao = new ScoreDao();
		classDao = new ClassDao();
		courseDao = new CourseDao();
		this.setBounds(330, 100, 700, 550);
		this.setTitle("查询班级平均成绩");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setClosable(true);
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
	}


	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		btnSearch.addActionListener(new ButtonListener());
		
	}
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取班级名称
			String className = cboClass.getSelectedItem().toString();
			//获取班级编号
			int classId = classDao.findClassByName(className).getClassId();
			//加载数据
			loadData(classId);

		}
		
	}
	
	/**
	 * 加载数据
	 */
	private void loadData(int classId) {
		//获取该班级的平均分
		ArrayList<Score> list = scoreDao.findAvgScore(classId);
		System.out.println(list.size());
		if(list!= null){
			Object[][] objScore = new Object[list.size()][];
			//循环获取每个测试的平均成绩
			for(int i = 0; i< list.size(); i++){
				//测试编号
				int testId = list.get(i).getTestId();
				//平均成绩
				int avgScore = list.get(i).gettScore();
				//根据测试编号查找测试信息
				Test test = testDao.findTestByTestId(testId);
				//测试科目
				String courseName = courseDao.findCourseById(test.getCourseId()).getCourseName();
				
				objScore[i] = new Object[]{courseName,test.getTestName(),CommonUtil.formatTImestamp(test.getStartTime()),avgScore};
			}
			//重新绑定表格数据
			model.setDataVector(objScore, columnName);
		}
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		lblClass = new JLabel("班级名称：");
		//获取所有的班级
		ArrayList<Classes> classList = classDao.findAllClasses();
		cboClass = new JComboBox();
		//班级下拉列表添加选项
		for(Classes c : classList){
			cboClass.addItem(c.getClassName());
		}
		//表格
		columnName = new String[]{"考试科目","考试试题","考试时间","成绩"};
		model = new DefaultTableModel(columnName,0);
		tab = new JTable(model){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		//表格列不可拖拉
		tab.getTableHeader().setReorderingAllowed(false);
		//表格内容居中
		((DefaultTableCellRenderer)tab.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//单选模式
		tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//添加组件
		scl = new JScrollPane(tab);
		
		//搜索按钮
		btnSearch = new JButton("搜索");
		lblClass.setBounds(10, 20, 80, 20);
		cboClass.setBounds(100, 20, 80, 20);
		btnSearch.setBounds(200, 20, 60, 20);
		scl.setBounds(10, 70, 670, 350);
		//添加组件
		this.add(cboClass);
		this.add(btnSearch);
		this.add(scl);
		this.add(lblClass);
	}


}
