package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.dao.impl.DepartmentDao;
import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.JobDao;
import com.niit.entity.Employee;

public class MainFrame extends JFrame {
	
	private JScrollPane sclInfo;
	private JTable tabinfo;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private Login logFrm;
	private JPopupMenu popMenu;
	private JMenuItem itemModify;
	private JMenuItem itemDelete;
	private EmployeeDao empDao;
	private JobDao jobDao;
	private DepartmentDao depDao;
	
	public MainFrame(Login logFrm){
		this.logFrm = logFrm;
		empDao = new EmployeeDao();
		jobDao = new JobDao();
		depDao = new DepartmentDao();
		//初始化窗体
		initFrame();
		//初始化组件
		initComponent();
		//加载表格数据
		loadData();
		//绑定监听器
		bindListener();
	}
	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		MenuListener menuListener = new MenuListener();
		itemDelete.addActionListener(menuListener);
		itemModify.addActionListener(menuListener);
		
		
	}
	
	/**
	 * 右键菜单监听器
	 */
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//删除
			if(item == itemDelete){
				deleteEmps();
			}
			//修改
			else{
				modiFyEmpInfo();
			}
			//加载表格数据
			loadData();
			
		}
		
	}
	
	/**
	 * 修改员工信息
	 */
	private void modiFyEmpInfo() {
		//获取要修改的员工id
		int empId = Integer.parseInt(tabinfo.getValueAt(tabinfo.getSelectedRow(), 0).toString());
		//实例化修改窗口
		ModifyEmp frm = new ModifyEmp(empId,MainFrame.this);
		frm.setVisible(true);
		
	}
	
	/**
	 * 批量删除员工
	 */
	private void deleteEmps(){
		//存储要删除的汽车
		ArrayList<Integer> deleEmps = new ArrayList<Integer>();
		//遍历表格中的所有行
		for(int i = 0; i < tabinfo.getRowCount(); i++){
			if((Boolean)tabinfo.getValueAt(i, 7)){
				int empId = Integer.parseInt(tabinfo.getValueAt(i, 0).toString());
				deleEmps.add(empId);
			}
		}
		//判断是否有选中行
		if(deleEmps.size() == 0){
			JOptionPane.showMessageDialog(null, "请选择要删除的员工！");
		}
		else{
			int choice =  JOptionPane.showConfirmDialog(null,"确认删除选中的"+deleEmps.size()+"名员工", "删除",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				for(Integer delId : deleEmps){
					System.out.println(delId);
					empDao.deleteEmp(delId);
				}
			}
			
		}
		
	}
	
	/**
	 * 加载表格数据
	 */
	public void loadData(){
		//获取全部员工的集合
		ArrayList<Employee> emps = empDao.findAll();
		Object[][] empObj = new Object[emps.size()][]; 
		//获取每个员工的信息
		for(int i = 0; i< emps.size(); i++){
			//获取集合下的每个员工对象
			Employee emp = emps.get(i);
//			//根据岗位编号获得岗位名称
//			String jobName = jobDao.findJobNameByJobId(emp.getJobId());
//			//根据部门编号获得部门名称
//			String depName = depDao.findDepNameByDepId(emp.getDepId());
//			//根据经理编号获得经理名称
//			String magName = empDao.findEmpNameByManagerId(emp.getManagerId());
			//构造该员工的数组
			//empObj[i] = new Object[]{emp.getEmpId(),emp.getEmpName(),emp.getSalary()+"",emp.getHireDate()+"",emp.getJobName(),emp.getDepName(),emp.getMagName(),false};
			empObj[i] = new Object[]{emp.getEmpId(),emp.getEmpName(),emp.getSalary()+"",emp.getHireDate()+"",emp.getJobName(),emp.getDepName(),emp.getMagName(),false};
		}
		//重新绑定表格数据
		tabModel.setDataVector(empObj, columnName);
		//隐藏第一列
		hiddenFirstColumn();
	}
	
	
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//表格标题
		columnName = new String[]{"编号","姓名","工资","入职时间","岗位","部门","部门经理","删除"};
		//表格模型
		tabModel = new DefaultTableModel(columnName,0);
		//实例化表格
		tabinfo = new JTable(tabModel){

			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 7){
					return false;
				}
				return true;
			}

			@Override
			public Class<?> getColumnClass(int column) {
				
				return tabinfo.getValueAt(0, column).getClass();
			}
		};
		
		//表格内容居中
		((DefaultTableCellRenderer)tabinfo.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//表格列不可拖拉
		tabinfo.getTableHeader().setReorderingAllowed(false);
		//单选模式
		tabinfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//隐藏第一列
		hiddenFirstColumn();
		
		sclInfo = new JScrollPane();
		sclInfo.setBounds(0, 0, 1000, 500);
		sclInfo.getViewport().add(tabinfo);
		
		/*************************右键菜单的使用****************************/
		//右键菜单实例化
		popMenu = new JPopupMenu();
		//实例化菜单项
		itemDelete = new JMenuItem("删除");
		itemModify = new JMenuItem("修改");
		
		//添加菜单项到右键菜单
		popMenu.add(itemDelete);
		popMenu.add(itemModify);
		//将右键绑定在指定的组件上
		tabinfo.setComponentPopupMenu(popMenu);
		
		this.add(sclInfo);
		
	}
	
	/**
	 * 初始化窗体
	 */
	private void initFrame() {
		this.setSize(1000,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("员工信息");
		this.setResizable(false);
		this.setLayout(null);
	}
	
	/**
	 * 隐藏第一列
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabinfo.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	

}
