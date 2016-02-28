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

import com.niit.dao.impl.CourseDao;
import com.niit.entiry.Course;

public class EditCourseFrame extends JInternalFrame{
	
	private JScrollPane sclPane;
	private JTable tabCourse;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private JButton btnAdd;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnLoad;
	
	private CourseDao courseDao;
	
	public EditCourseFrame(){
		
		courseDao = new CourseDao();
		this.setBounds(250, 100, 700, 500);
		this.setTitle("科目管理");
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
		btnModify.addActionListener(btnListener);
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
			//加载数据
			if(btn == btnLoad){
				loadData();
			}
			//添加
			else if(btn == btnAdd){
//				addCourse();
				AddCourse frm = new AddCourse(EditCourseFrame.this);
				frm.setVisible(true);
			}
			//修改
			else if(btn == btnModify){
				modifyCourse();
				
			}
			//删除
			else{
				//删除课程
				deleteCourse();
				//重新加载表格数据
				loadData();
			}
			
		}
		
	}
	
	/**
	 * 修改科目信息
	 */
	private void modifyCourse(){
		ArrayList<Integer> list = selectedCourseId();
		if(list != null){
			//没有选择要修改的科目
			if(list.size() == 0){
				JOptionPane.showMessageDialog(null, "请选择要修改的科目");
			}
			else if(list.size() > 1){
				JOptionPane.showMessageDialog(null, "单次仅能修改一门科目的信息");
			}
			else{
				Course c = courseDao.findCourseById(list.get(0));
				ModifyCourse frm = new ModifyCourse(EditCourseFrame.this,c);
				frm.setVisible(true);
			}
		}
	}
	
	/**
	 * 批量删除科目
	 */
	private void deleteCourse(){
		ArrayList<Integer> deleCourseId = selectedCourseId();
		if(deleCourseId != null){
			//判断是否有选中的行
			if(deleCourseId.size() == 0){
				JOptionPane.showConfirmDialog(null, "请选择删除的科目！","修改科目",JOptionPane.YES_NO_OPTION);
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "确认删除选择的"+deleCourseId.size()+"门科目！","删除科目",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//循环
					for(int i = 0; i < deleCourseId.size(); i++){
						//删除数据
						courseDao.deleteCourse(deleCourseId.get(i));
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
			if((Boolean)tabCourse.getValueAt(i, 2)){
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
		ArrayList<Course> list = courseDao.findAllCourse();
		if(list != null){
			Object[][] objCourse = new Object[list.size()][];
			//循环获取每个科目的信息
			for(int i = 0; i< list.size(); i++){
				//获取每个科目对象
				Course c = list.get(i);
				objCourse[i] = new Object[]{c.getCourseId()+"",c.getCourseName(),false};
			}
			//重新绑定表格数据
			tabModel.setDataVector(objCourse, columnName);
		}
	}

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//表格标题
		columnName = new String[]{"科目编号","科目名称","选择"};
		//表格模型
		tabModel = new DefaultTableModel(columnName,0);
		//实例化表格
		tabCourse = new JTable(tabModel){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 2){
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
		//添加组件
		sclPane = new JScrollPane(tabCourse);
		btnLoad = new JButton("加载科目");
		btnAdd = new JButton("添加");
		btnModify = new JButton("修改");
		btnDelete = new JButton("批量删除");
		//组件位置
		sclPane.setBounds(20, 10, 500, 450);
		btnAdd.setBounds(550, 20, 100, 30);
		btnModify.setBounds(550, 70, 100, 30);
		btnDelete.setBounds(550, 120, 100, 30);
		btnLoad.setBounds(550, 170, 100, 30);
		this.add(sclPane);
		this.add(btnAdd);
		this.add(btnModify);
		this.add(btnDelete);
		this.add(btnLoad);
	}
}
