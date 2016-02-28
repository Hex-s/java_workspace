package com.niit.ui.stu;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Course;
import com.niit.entiry.Score;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class ScoreFrame extends JInternalFrame{
	
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private ScoreDao scoreDao;
	private TestDao testDao;
	private CourseDao courseDao;
	private StuMainFrame stuFrm;
	
	public ScoreFrame(StuMainFrame stuFrm){
		courseDao = new CourseDao();
		testDao = new TestDao();
		scoreDao = new ScoreDao();
		this.stuFrm = stuFrm;
		this.setBounds(320, 100, 700, 550);
		this.setTitle("查询学生成绩");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setClosable(true);
		//初始化组件
		initComponent();
		//加载数据
		loadData(stuFrm.getStu().getStuId());
	}
	

	/**
	 * 加载数据
	 */
	private void loadData(int stuId) {
		//获取该学生的所有成绩
		ArrayList<Score> list = scoreDao.findScoreByStuId(stuId) ;
		if(list != null){
			Object[][] objScore = new Object[list.size()][];
			//循环获取每个科目的信息
			for(int i = 0; i< list.size(); i++){
				//获取每个科目对象
				Score s = list.get(i);
				Test t = testDao.findTestByTestId(s.getTestId());
				Course c = courseDao.findCourseById(t.getCourseId());
				objScore[i] = new Object[]{c.getCourseName(),t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),s.gettScore()};
			}
			//重新绑定表格数据
			model.setDataVector(objScore, columnName);
		}
	}
	

	/**
	 * 初始化组件
	 */
	private void initComponent() {
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
		this.add(scl);
		
	}

}
