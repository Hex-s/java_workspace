package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Classes;
import com.niit.entiry.Course;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;


public class StudentScore extends JInternalFrame{
	
	private ButtonGroup group;
	private JRadioButton[] rdoSearch;
	private String[] search;
	private JTextField txtSearch;
	private JButton btnSearch;
	private StudentDao stuDao;
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private ClassDao classDao;
	private TestDao testDao;
	private ScoreDao scoreDao;
	private CourseDao courseDao;
	
	public StudentScore(){
		courseDao = new CourseDao();
		scoreDao = new ScoreDao();
		testDao = new TestDao();
		classDao = new ClassDao();
		stuDao = new StudentDao();
		this.setBounds(320, 100, 700, 500);
		this.setTitle("查询学生成绩");
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
		ButtonListener btnListener = new ButtonListener();
		btnSearch.addActionListener(btnListener);
		
	}
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Student stu = null;
			int index = -1;
			String values = txtSearch.getText().trim();
			//判断搜索的标准
			for(int i = 0 ; i < rdoSearch.length; i++){
				if(rdoSearch[i].isSelected()){
					index = i;
					break;
				}
			}
			//没有选择搜索标准
			if(index < 0){
				JOptionPane.showMessageDialog(null, "请选择搜索的要求!");
				return;
			}
			//判断是否写入搜索内容
			if(values.equals("")){
				JOptionPane.showMessageDialog(null, "请选择搜索的内容!");
				return;
			}
			//按姓名搜索
			if(index == 0){
				stu = stuDao.findStuByStuName(values);
			}
			else if(index == 1){
				//判断输入的是否是int
				if(isInt(values)){
					//获取学生编号
					int stuId = Integer.parseInt(values);
					stu = stuDao.findStuByStuid(stuId);
				}
				else{
					JOptionPane.showMessageDialog(null, "请输入整数");
					txtSearch.requestFocus();
					txtSearch.selectAll();
					return;
				}
			}
			//搜索不到查询的学生信息
			if(stu == null){
				JOptionPane.showMessageDialog(null, "没有您要查找的学生成绩信息！");
				return;
			}
			//加载表格数据
			loadData(stu);
			
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
	 * 加载数据
	 */
	private void loadData(Student stu) {
		//获取该学生的所有成绩
		ArrayList<Score> list = scoreDao.findScoreByStuId(stu.getStuId()) ;
		if(list != null){
			Object[][] objScore = new Object[list.size()][];
			//循环获取每个科目的信息
			for(int i = 0; i< list.size(); i++){
				//获取每个科目对象
				Score s = list.get(i);
				Test t = testDao.findTestByTestId(s.getTestId());
				Course c = courseDao.findCourseById(t.getCourseId());
				String className = classDao.findClassById(stu.getClassId()).getClassName();
				objScore[i] = new Object[]{stu.getStuName(),c.getCourseName(),t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),s.gettScore(),className};
			}
			//重新绑定表格数据
			model.setDataVector(objScore, columnName);
		}
	}
	

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//单选按钮
		group = new ButtonGroup();
		search = new String[]{"按姓名查找","按学号查找"};
		rdoSearch = new JRadioButton[search.length];
		for(int i = 0,x = 200; i < rdoSearch.length; i++,x += 110){
			rdoSearch[i] = new JRadioButton(search[i]);
			rdoSearch[i].setBounds(x, 20, 100, 20);
			group.add(rdoSearch[i]);
			this.add(rdoSearch[i]);
		}
		//搜索
		txtSearch = new JTextField();
		btnSearch = new JButton("搜索");
		//表格
		columnName = new String[]{"姓名","考试科目","考试试题","考试时间","成绩","班级"};
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
	
		//组件位置
		txtSearch.setBounds(200, 60, 100, 20);
		btnSearch.setBounds(330, 60, 60, 20);
		
		scl.setBounds(10, 100, 670, 320);
		this.add(txtSearch);
		this.add(btnSearch);
		this.add(scl);
	}
	
	public static void main(String[] args) {
		StudentScore frm = new StudentScore();
		frm.setVisible(true);
	}
}
