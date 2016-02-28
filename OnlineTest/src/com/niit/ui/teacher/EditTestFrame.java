package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class EditTestFrame extends JInternalFrame {
	
	private JScrollPane sclPane;
	private JTable tabCourse;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnLoad;
	
	private TestDao testDao;
	private ClassDao classDao;
	private CourseDao courseDao;
	
	public EditTestFrame(){
		classDao = new ClassDao();
		courseDao = new CourseDao();
		testDao = new TestDao();
		this.setBounds(100, 100, 1100, 600);
		this.setTitle("测试管理");
		this.setClosable(true);
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
		ButtonListener btnListener = new ButtonListener();
		btnAdd.addActionListener(btnListener);
		btnDelete.addActionListener(btnListener);
		btnLoad.addActionListener(btnListener);
		
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
			//加载
			if(btn == btnLoad){
				loadData();
			}
			//添加
			else if(btn == btnAdd){
				CreateTestFrame frm = new CreateTestFrame(EditTestFrame.this);
				frm.setVisible(true);
			}
			else if(btn == btnDelete){
				//删除测试
				deleteTest();
				//重新加载数据
				loadData();
			}
		}
		
	}
	
	/**
	 * 批量删除科目
	 */
	private void deleteTest(){
		ArrayList<Integer> deleTestId = selectedCourseId();
		if(deleTestId != null){
			//判断是否有选中的行
			if(deleTestId.size() == 0){
				JOptionPane.showMessageDialog(null, "请选择要删除的测试！");
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "确认删除选择的"+deleTestId.size()+"份测试！","删除科目",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//循环
					for(int i = 0; i < deleTestId.size(); i++){
						//删除数据
						testDao.deleteTestByTestId(deleTestId.get(0));
					}
				}
			}
		}
	}
	
	/**
	 * 选择的行
	 * @return
	 */
	private ArrayList<Integer> selectedCourseId(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//遍历表格中的所有行，查找出被选中的行
		for(int i = 0; i< tabCourse.getRowCount(); i++){
			if((Boolean)tabCourse.getValueAt(i, 5)){
				int courseId = Integer.parseInt(tabCourse.getValueAt(i, 0).toString());
				list.add(courseId);
			}
		}
		return list;
	}
	/**
	 * 加载数据
	 */
	public void loadData() {
		//获取所有科目
		ArrayList<Test> list = testDao.findAllTests();
		if(list != null){
			Object[][] objTest = new Object[list.size()][];
			//循环获取每个科目的信息
			for(int i = 0; i< list.size(); i++){
				//获取每个科目对象
				Test t = list.get(i);
				//获取测试科目
				String courseName = courseDao.findCourseById(t.getCourseId()).getCourseName();
				//获取测试班级
				String className = classDao.findClassById(t.getClassId()).getClassName();
				
				objTest[i] = new Object[]{t.getTestId()+"",courseName,t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),className,false};
			}
			//重新绑定表格数据
			tabModel.setDataVector(objTest, columnName);
			//隐藏第一列
			hiddenFirstColumn();
		}
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//表格标题
		columnName = new String[]{"测试编号","测试科目","测试名称","测试时间","测试班级","选择"};
		//表格模型
		tabModel = new DefaultTableModel(columnName,0);
		//实例化表格
		tabCourse = new JTable(tabModel){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 5){
					return false;
				}
				return true;
			}
			
			@Override
			public Class<?> getColumnClass(int column) {
				
				return tabCourse.getValueAt(0, column).getClass();
			}
		};
		//表格列不可拖拉
		tabCourse.getTableHeader().setReorderingAllowed(false);
		//表格内容居中
		((DefaultTableCellRenderer)tabCourse.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//单选模式
		tabCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//隐藏第一列
		hiddenFirstColumn();
		//添加组件
		sclPane = new JScrollPane(tabCourse);
		btnAdd = new JButton("添加");
		btnDelete = new JButton("批量删除");
		btnLoad = new JButton("加载测试");
		//组件位置
		sclPane.setBounds(20, 10, 900, 550);
		btnAdd.setBounds(950, 20, 100, 30);
		btnDelete.setBounds(950, 70, 100, 30);
		btnLoad.setBounds(950, 120, 100, 30);
		this.add(sclPane);
		this.add(btnAdd);
		this.add(btnDelete);
		this.add(btnLoad);
	}
	
	/**
	 * 隐藏第一列
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabCourse.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}

}
