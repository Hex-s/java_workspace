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
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//���ر������
		loadData();
		//�󶨼�����
		bindListener();
	}
	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		MenuListener menuListener = new MenuListener();
		itemDelete.addActionListener(menuListener);
		itemModify.addActionListener(menuListener);
		
		
	}
	
	/**
	 * �Ҽ��˵�������
	 */
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//ɾ��
			if(item == itemDelete){
				deleteEmps();
			}
			//�޸�
			else{
				modiFyEmpInfo();
			}
			//���ر������
			loadData();
			
		}
		
	}
	
	/**
	 * �޸�Ա����Ϣ
	 */
	private void modiFyEmpInfo() {
		//��ȡҪ�޸ĵ�Ա��id
		int empId = Integer.parseInt(tabinfo.getValueAt(tabinfo.getSelectedRow(), 0).toString());
		//ʵ�����޸Ĵ���
		ModifyEmp frm = new ModifyEmp(empId,MainFrame.this);
		frm.setVisible(true);
		
	}
	
	/**
	 * ����ɾ��Ա��
	 */
	private void deleteEmps(){
		//�洢Ҫɾ��������
		ArrayList<Integer> deleEmps = new ArrayList<Integer>();
		//��������е�������
		for(int i = 0; i < tabinfo.getRowCount(); i++){
			if((Boolean)tabinfo.getValueAt(i, 7)){
				int empId = Integer.parseInt(tabinfo.getValueAt(i, 0).toString());
				deleEmps.add(empId);
			}
		}
		//�ж��Ƿ���ѡ����
		if(deleEmps.size() == 0){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ����Ա����");
		}
		else{
			int choice =  JOptionPane.showConfirmDialog(null,"ȷ��ɾ��ѡ�е�"+deleEmps.size()+"��Ա��", "ɾ��",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				for(Integer delId : deleEmps){
					System.out.println(delId);
					empDao.deleteEmp(delId);
				}
			}
			
		}
		
	}
	
	/**
	 * ���ر������
	 */
	public void loadData(){
		//��ȡȫ��Ա���ļ���
		ArrayList<Employee> emps = empDao.findAll();
		Object[][] empObj = new Object[emps.size()][]; 
		//��ȡÿ��Ա������Ϣ
		for(int i = 0; i< emps.size(); i++){
			//��ȡ�����µ�ÿ��Ա������
			Employee emp = emps.get(i);
//			//���ݸ�λ��Ż�ø�λ����
//			String jobName = jobDao.findJobNameByJobId(emp.getJobId());
//			//���ݲ��ű�Ż�ò�������
//			String depName = depDao.findDepNameByDepId(emp.getDepId());
//			//���ݾ����Ż�þ�������
//			String magName = empDao.findEmpNameByManagerId(emp.getManagerId());
			//�����Ա��������
			//empObj[i] = new Object[]{emp.getEmpId(),emp.getEmpName(),emp.getSalary()+"",emp.getHireDate()+"",emp.getJobName(),emp.getDepName(),emp.getMagName(),false};
			empObj[i] = new Object[]{emp.getEmpId(),emp.getEmpName(),emp.getSalary()+"",emp.getHireDate()+"",emp.getJobName(),emp.getDepName(),emp.getMagName(),false};
		}
		//���°󶨱������
		tabModel.setDataVector(empObj, columnName);
		//���ص�һ��
		hiddenFirstColumn();
	}
	
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//������
		columnName = new String[]{"���","����","����","��ְʱ��","��λ","����","���ž���","ɾ��"};
		//���ģ��
		tabModel = new DefaultTableModel(columnName,0);
		//ʵ�������
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
		
		//������ݾ���
		((DefaultTableCellRenderer)tabinfo.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//����в�������
		tabinfo.getTableHeader().setReorderingAllowed(false);
		//��ѡģʽ
		tabinfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		hiddenFirstColumn();
		
		sclInfo = new JScrollPane();
		sclInfo.setBounds(0, 0, 1000, 500);
		sclInfo.getViewport().add(tabinfo);
		
		/*************************�Ҽ��˵���ʹ��****************************/
		//�Ҽ��˵�ʵ����
		popMenu = new JPopupMenu();
		//ʵ�����˵���
		itemDelete = new JMenuItem("ɾ��");
		itemModify = new JMenuItem("�޸�");
		
		//��Ӳ˵���Ҽ��˵�
		popMenu.add(itemDelete);
		popMenu.add(itemModify);
		//���Ҽ�����ָ���������
		tabinfo.setComponentPopupMenu(popMenu);
		
		this.add(sclInfo);
		
	}
	
	/**
	 * ��ʼ������
	 */
	private void initFrame() {
		this.setSize(1000,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ա����Ϣ");
		this.setResizable(false);
		this.setLayout(null);
	}
	
	/**
	 * ���ص�һ��
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabinfo.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	

}
