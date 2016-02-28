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
		this.setTitle("���Թ���");
		this.setClosable(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bindListener();
	}
	
	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		ButtonListener btnListener = new ButtonListener();
		btnAdd.addActionListener(btnListener);
		btnDelete.addActionListener(btnListener);
		btnLoad.addActionListener(btnListener);
		
	}
	
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//����
			if(btn == btnLoad){
				loadData();
			}
			//���
			else if(btn == btnAdd){
				CreateTestFrame frm = new CreateTestFrame(EditTestFrame.this);
				frm.setVisible(true);
			}
			else if(btn == btnDelete){
				//ɾ������
				deleteTest();
				//���¼�������
				loadData();
			}
		}
		
	}
	
	/**
	 * ����ɾ����Ŀ
	 */
	private void deleteTest(){
		ArrayList<Integer> deleTestId = selectedCourseId();
		if(deleTestId != null){
			//�ж��Ƿ���ѡ�е���
			if(deleTestId.size() == 0){
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���Ĳ��ԣ�");
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ���"+deleTestId.size()+"�ݲ��ԣ�","ɾ����Ŀ",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//ѭ��
					for(int i = 0; i < deleTestId.size(); i++){
						//ɾ������
						testDao.deleteTestByTestId(deleTestId.get(0));
					}
				}
			}
		}
	}
	
	/**
	 * ѡ�����
	 * @return
	 */
	private ArrayList<Integer> selectedCourseId(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//��������е������У����ҳ���ѡ�е���
		for(int i = 0; i< tabCourse.getRowCount(); i++){
			if((Boolean)tabCourse.getValueAt(i, 5)){
				int courseId = Integer.parseInt(tabCourse.getValueAt(i, 0).toString());
				list.add(courseId);
			}
		}
		return list;
	}
	/**
	 * ��������
	 */
	public void loadData() {
		//��ȡ���п�Ŀ
		ArrayList<Test> list = testDao.findAllTests();
		if(list != null){
			Object[][] objTest = new Object[list.size()][];
			//ѭ����ȡÿ����Ŀ����Ϣ
			for(int i = 0; i< list.size(); i++){
				//��ȡÿ����Ŀ����
				Test t = list.get(i);
				//��ȡ���Կ�Ŀ
				String courseName = courseDao.findCourseById(t.getCourseId()).getCourseName();
				//��ȡ���԰༶
				String className = classDao.findClassById(t.getClassId()).getClassName();
				
				objTest[i] = new Object[]{t.getTestId()+"",courseName,t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),className,false};
			}
			//���°󶨱������
			tabModel.setDataVector(objTest, columnName);
			//���ص�һ��
			hiddenFirstColumn();
		}
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//������
		columnName = new String[]{"���Ա��","���Կ�Ŀ","��������","����ʱ��","���԰༶","ѡ��"};
		//���ģ��
		tabModel = new DefaultTableModel(columnName,0);
		//ʵ�������
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
		//����в�������
		tabCourse.getTableHeader().setReorderingAllowed(false);
		//������ݾ���
		((DefaultTableCellRenderer)tabCourse.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//��ѡģʽ
		tabCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		hiddenFirstColumn();
		//������
		sclPane = new JScrollPane(tabCourse);
		btnAdd = new JButton("���");
		btnDelete = new JButton("����ɾ��");
		btnLoad = new JButton("���ز���");
		//���λ��
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
	 * ���ص�һ��
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabCourse.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}

}
