package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.niit.dao.impl.DepartmentDao;
import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.JobDao;
import com.niit.entity.Employee;
import com.niit.entity.Job;

public class ModifyEmp extends JFrame {

	private JLabel[] lblList;
	private JLabel lblEmpId;
	private JLabel lblEmpName;
	private JTextField txtsalary;
	private JLabel lblEmpHireDate;
	private JComboBox cboJob;
	private JLabel lblEmpDep;
	private JLabel lblEmpMag;
	private JButton btnConfirm;
	private JButton btnCancle;
	private String[] nameForLbl;
	private Employee emp;
	private EmployeeDao empDao;
	private DepartmentDao depDao;
	private JobDao jobDao;
	private MainFrame mainFrm;
	
	
	public ModifyEmp(int empId,MainFrame mainFrm){
		empDao = new EmployeeDao();
		depDao = new DepartmentDao();
		emp = empDao.findEmpByEmpId(empId);
		jobDao = new JobDao();
		this.mainFrm = mainFrm;
		//初始化窗体
		initFrame();
		//初始化组件
		inintComponent();
		//绑定监听器
		bindListener();
	}
	
	//绑定监听器
	private void bindListener() {
		ButtonListener btnListener = new ButtonListener();
		btnCancle.addActionListener(btnListener);
		btnConfirm.addActionListener(btnListener);
		
	}
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn =(JButton)e.getSource();
			if(btn == btnCancle){
				ModifyEmp.this.dispose();
			}
			else{
				double salary = Double.parseDouble(txtsalary.getText().trim());
				String jobName = cboJob.getSelectedItem().toString();
				//String jobId = jobDao.findJobIdByJobName(jobName);
				emp.setSalary(salary);
				emp.setJobName(jobName);
				empDao.modifyEmp(emp);
				mainFrm.loadData();
				ModifyEmp.this.dispose();
				
			}
			
		}
		
	}
	//初始化组件
	private void inintComponent() {
		nameForLbl = new String[]{"编号","姓名","薪水","入职时间","岗位","部门","部门经理"};
		lblList = new JLabel[nameForLbl.length];
		for(int i = 0,y = 10; i< lblList.length; i++, y+=50 ){
			lblList[i] = new JLabel(nameForLbl[i]);
			lblList[i].setBounds(40,y , 80, 20);
			this.add(lblList[i]);
		}
		
		lblEmpId = new JLabel(emp.getEmpId()+"");
		lblEmpName = new JLabel(emp.getEmpName());
		txtsalary = new JTextField(emp.getSalary()+"");
		lblEmpHireDate = new JLabel(emp.getHireDate()+"");
		//String depName = depDao.findDepNameByDepId(emp.getDepId());
		//String magName = empDao.findEmpNameByEmpId(emp.getMagId());
		lblEmpMag = new JLabel(emp.getMagName());
		lblEmpDep = new JLabel(emp.getDepName());
		
		//构建岗位下拉列表
		cboJob = new JComboBox();
		ArrayList<Job> allJbos = jobDao.findAllJob();
		for(int i = 0; i < allJbos.size(); i++){
			cboJob.addItem(allJbos.get(i).getJobName());
//			if(emp.getJobId() == allJbos.get(i).getJobId()){
//				cboJob.setSelectedIndex(i);
//			}
		}
		
		btnConfirm = new JButton("确认");
		btnCancle = new JButton("取消");
		
		lblEmpId.setBounds(150, 10, 80, 20);
		lblEmpName.setBounds(150,60 , 80, 20);
		txtsalary.setBounds(150, 110, 80, 20);
		lblEmpHireDate.setBounds(150, 160, 80, 20);
		cboJob.setBounds(150, 210, 120, 20);
		lblEmpDep.setBounds(150, 260, 100, 20);
		lblEmpMag.setBounds(150, 310, 100, 20);
		btnConfirm.setBounds(80, 370, 70, 20);
		btnCancle.setBounds(230, 370, 70, 20);
		
		this.add(lblEmpId);
		this.add(lblEmpName);
		this.add(txtsalary);
		this.add(lblEmpHireDate);
		this.add(cboJob);
		this.add(lblEmpDep);
		this.add(lblEmpMag);
		this.add(btnConfirm);
		this.add(btnCancle);
		
		
		
	}
	//初始化窗体
	private void initFrame() {
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("修改员工信息");
		this.setAlwaysOnTop(true);
		
	}
	
}
