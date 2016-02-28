package com.niit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.bean.Student;
import com.niit.dao.StudentDao;
import com.niit.data.Data;

public class TableExam2 extends JFrame {

	private JScrollPane scrollPnl;
	private JTable tabStuInfo;
	private DefaultTableModel model;
	private JButton btnDelete;
	private StudentDao stuDao;
	private JButton btnShow;
	private String[] columnName;
	//右键菜单
	private JPopupMenu popMenu;
	private JMenuItem itemNew;
	private JMenuItem itemDel;
	private JMenu menuModify;
	private JMenuItem itemMale;
	private JMenuItem itemFemale;
	private Data data;
	
	public TableExam2(Data data){
		this.data = data;
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//创建dao
		stuDao = new StudentDao(data);
		initComponent();
		bindListener();
		//加载数据
		loadData();
	}
	private void initComponent(){
		//构建滚动面板
		scrollPnl = new JScrollPane();
		scrollPnl.setBounds(50, 20, 300, 250);
		//构建表格
		tabStuInfo = new JTable(){
			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				//System.out.println(tabStuInfo.getValueAt(0, 4));
				return tabStuInfo.getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				//前四列禁止编辑
				if(column < 4){
					return false;
				}
				//最后列可编辑
				else{
					return true;
				}
			}
			
		};
		//创建列标题数组
		columnName = new String[]{"编号","姓名","年龄","性别","删除"};
		//构建模型
		model = new DefaultTableModel(columnName,0);
		//为表格设置模型
		tabStuInfo.setModel(model);
		//禁止列标题拖拽
		tabStuInfo.getTableHeader().setReorderingAllowed(false);
		//对齐表格内的数据
		((DefaultTableCellRenderer)tabStuInfo.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//隐藏第一列
		hidenFirstColum();
		//设置表格的选择模式
		tabStuInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//构建按钮
		btnDelete = new JButton("删除");
		btnDelete.setBounds(50, 310, 80, 25);
		btnShow = new JButton("加载");
		btnShow.setBounds(150, 310, 80, 25);
		//添加表格至滚动面板
		scrollPnl.getViewport().add(tabStuInfo);
		
		/*************************右键菜单的使用****************************/
		//实例化右键菜单
		popMenu = new JPopupMenu();
		//实例化菜单项
		itemDel = new JMenuItem("删除");
		itemNew = new JMenuItem("新增");
		itemMale = new JMenuItem("男");
		itemFemale = new JMenuItem("女");
		menuModify = new JMenu("修改");
		//添加菜单项
		popMenu.add(itemNew);
		popMenu.add(itemDel);
		popMenu.add(menuModify);
		menuModify.add(itemMale);
		menuModify.add(itemFemale);
		
		//将右键绑定在指定的组件上
		tabStuInfo.setComponentPopupMenu(popMenu);
		
		this.add(scrollPnl);
		this.add(btnDelete);
		this.add(btnShow);
	}
	/**
	 * 加载表格数据的方法
	 */
	public void loadData(){
		//获取所有的学生信息
		ArrayList<Student> list = stuDao.findAll();
		//将学生信息集合转换成二维数组
		Object[][] stuArray = new Object[list.size()][];
		//遍历集合
		for(int i = 0; i < list.size(); i++){
			Student stu = list.get(i);
			//将每个学生的信息依次写入二维数组
			stuArray[i] = new Object[]{stu.getStuId(),stu.getStuName(),stu.getAge()+"",stu.getSex(),false};
		}
		//通过模型对象重载数据源
		model.setDataVector(stuArray, columnName);
		hidenFirstColum();
	}
	/**
	 * 右键菜单按钮的监听器
	 * @author Administrator
	 *
	 */
	private class MenuClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//判断点击的按钮
			if(item == itemDel){
				delete();
			}
			else if(item == itemNew){
				//实例化窗体
				AddStudentFrame frm = new AddStudentFrame(data, TableExam2.this);
				frm.setVisible(true);
			}
			else if(item == itemMale){
				modify("男");
			}
			else if(item == itemFemale){
				modify("女");
			}
		}
		
	}
	private class PopMenuListener implements PopupMenuListener{

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * 弹出菜单呈现前的事件
		 */
		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			//判断是否有选中行
			if(tabStuInfo.getSelectedRow() != -1){
				//判断当前选择行的性别
				String sex = tabStuInfo.getValueAt(tabStuInfo.getSelectedRow(), 3).toString();
				if(sex.equals("男")){
					itemMale.setVisible(false);
					itemFemale.setVisible(true);
				}
				else{
					itemFemale.setVisible(false);
					itemMale.setVisible(true);
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
			//显示按钮
			if(btn == btnShow){
				loadData();
			}
			//删除按钮
			else{
//				//判断是否选中行
//				if(tabStuInfo.getSelectedRow() != -1){
//					//获取选中项的编号
//					int stuId = (Integer)model.getValueAt(tabStuInfo.getSelectedRow(), 0);
//					//JOptionPane.showMessageDialog(null, stuId);
//					//删除data中的数据
//					stuDao.delete(stuId);
//					//修改表格视图中的呈现
//					model.removeRow(tabStuInfo.getSelectedRow());
//					//loadData();
//				}
//				else{
//					JOptionPane.showMessageDialog(null, "请选择要删除的行！");
//				}
				
				delete();
			}
		}
		
	}
	/**
	 * 修改性别
	 * @param sex
	 */
	private void modify(String sex){
		//判断是否有选中行
		int rowIndex = tabStuInfo.getSelectedRow();
		if(rowIndex != -1){
			//获取选中行的学号
			int stuId = (Integer)tabStuInfo.getValueAt(rowIndex, 0);
			//根据学号查询学生对象
			Student stu = stuDao.findById(stuId);
			if(stu != null){
				//修改对象的性别
				stu.setSex(sex);
				//将对象修改为数据库
				stuDao.modify(stu);
				//刷新数据
				loadData();
			}
		}
		
	}
	/**
	 * 删除选中数据
	 */
	private void delete(){
		String stuIds = "";
		//将复选框内选中的行统一删除
		//遍历表格中的所有行
		for(int i = 0; i < tabStuInfo.getRowCount(); i++){
			//判断每一行中的删除列是否勾选
			if((Boolean)tabStuInfo.getValueAt(i, 4)){
				//拼接所有勾选行的学号
				stuIds+=tabStuInfo.getValueAt(i, 0)+" ";
			}
		}
		//判断是否有行被选中
		if(stuIds != ""){	
			//去除空格
			stuIds = stuIds.trim();	
			int choice = JOptionPane.showConfirmDialog(null, "是否确定要将学号为"+stuIds+"的信息删除？");
			//判断选择结果
			if(choice == JOptionPane.YES_OPTION){
				//将所有学号字符串分割成数组
				String[] stuIdArray = stuIds.split(" ");
				//循环删除
				for(String stuId : stuIdArray){
					int id = Integer.parseInt(stuId);
					stuDao.delete(id);
				}
			}
			//重新加载数据
			loadData();
		}
		else{
			JOptionPane.showMessageDialog(null, "没有要删除的行！");
		}
	}
	/**
	 * 隐藏第一列
	 */
	private void hidenFirstColum(){
		//隐藏第一列
		TableColumn firstColumn = tabStuInfo.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnDelete.addActionListener(btnListener);
		btnShow.addActionListener(btnListener);
		
		MenuClickListener popListener = new MenuClickListener();
		itemDel.addActionListener(popListener);
		itemNew.addActionListener(popListener);
		itemMale.addActionListener(popListener);
		itemFemale.addActionListener(popListener);
		popMenu.addPopupMenuListener(new PopMenuListener());
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data data = new Data();
		TableExam2 frm = new TableExam2(data);
		frm.setVisible(true);
	}

}
