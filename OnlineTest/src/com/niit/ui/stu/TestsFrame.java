package com.niit.ui.stu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

/**
 * 继承自内部窗体类
 * @author Administrator
 *
 */
public class TestsFrame extends JInternalFrame {
	
	private TestDao testDao;
	private JScrollPane sclPane;
	private JTable tabTest;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private ScoreDao scoreDao;
	private CourseDao courseDao;
	private Student stu;
	
	public TestsFrame(StuMainFrame frm){

		this.stu = frm.getStu();
		scoreDao = new ScoreDao();
		testDao = new TestDao();
		courseDao = new CourseDao();
		this.setTitle("在线考试");
		this.setBounds(230, 100, 800, 700);
		this.setClosable(true);
		//初始化组件
		initComponent();
		//加载数据
		loadData();
		//绑定监听器
		bindListener();
	}
	
	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		tabTest.addMouseListener(new TableListener());
		
	}

	/**
	 * 表格监听器
	 * @author Administrator
	 *
	 */
	private class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//双击
			if(e.getClickCount() == 2){
				//获取测试编号
				int testId = Integer.parseInt(tabTest.getValueAt(tabTest.getSelectedRow(), 0).toString());
				//根据测试编号查找测试
				Test test = testDao.findTestByTestId(testId);
				if(test != null){
					//获取测试开始时间
					java.sql.Timestamp ts = test.getStartTime();
					//获取当前系统时间
					Date date = new Date();
					//判断当前时间是否大于等于指定考试时间
					//当前时间小于考试时间
					if(ts.after(date)){
						JOptionPane.showMessageDialog(null, "测试还未开始！");
						return;
					}
					//当前时间大于考试时间
					if(ts.after(date)){
						JOptionPane.showMessageDialog(null, "测试已经结束！");
						return;
					}
					//迟到半小时
					if((ts.getTime()+30*60000) < (date.getTime())){
						int stuId = stu.getStuId();
						JOptionPane.showMessageDialog(null, "距测试开始已超过30分钟，此次测试分数为0！");
						//获取成绩对象
						Score s = new Score();
						s.setStuId(stuId);
						s.setTestId(testId);
						s.settScore(0);
						//判断是否已经存入该成绩
						Score sc = scoreDao.findScoreByTidSid(testId, stuId);
						if(sc == null){
							//插入此次成绩
							scoreDao.addScore(s);
						}
						return;
					}
					//在允许的时间范围内参加考试
					QuestionsTest frm = new QuestionsTest(test,TestsFrame.this);
					frm.setVisible(true);
				}
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 加载表格数据
	 */
	public void loadData(){
		//获取该学生可以参加的所有考试
		ArrayList<Test> list = testDao.findTestByStu(stu.getClassId(),stu.getStuId());
		if(list != null){
			Object[][] objTests = new Object[list.size()][];
			//循环获取每份考卷的信息
			for(int i = 0; i < list.size(); i++){
				//获取集合下的每个员工对象
				Test t = list.get(i);
				String courseName = courseDao.findCourseById(t.getCourseId()).getCourseName();
				objTests[i] = new Object[]{t.getTestId(),courseName,CommonUtil.formatTImestamp(t.getStartTime()),t.getTotalTime()+""};
			}
			//重新绑定表格数据
			tabModel.setDataVector(objTests, columnName);
			//隐藏第一列
			hiddenFirstColumn();
		}
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		//表格标题
		columnName = new String[]{"测试编号","考试科目","开始时间","考试时间"};
		//表格模型
		tabModel = new DefaultTableModel(columnName,0);
		//实例化表格
		tabTest = new JTable(tabModel){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//表格列不可拖拉
		tabTest.getTableHeader().setReorderingAllowed(false);
		//表格内容居中
		((DefaultTableCellRenderer)tabTest.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//单选模式
		tabTest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//隐藏第一列
		hiddenFirstColumn();
		
		sclPane = new JScrollPane(tabTest);
		this.add(sclPane);
	}

	@Override
	public void doDefaultCloseAction() {
		// TODO Auto-generated method stub
		//super.doDefaultCloseAction();
		this.dispose();
	}
	
	/**
	 * 隐藏第一列
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabTest.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	public Student getStu() {
		return stu;
	}

}
