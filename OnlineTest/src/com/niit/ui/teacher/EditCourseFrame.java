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
		this.setTitle("��Ŀ����");
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
		btnModify.addActionListener(btnListener);
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
			//��������
			if(btn == btnLoad){
				loadData();
			}
			//���
			else if(btn == btnAdd){
//				addCourse();
				AddCourse frm = new AddCourse(EditCourseFrame.this);
				frm.setVisible(true);
			}
			//�޸�
			else if(btn == btnModify){
				modifyCourse();
				
			}
			//ɾ��
			else{
				//ɾ���γ�
				deleteCourse();
				//���¼��ر������
				loadData();
			}
			
		}
		
	}
	
	/**
	 * �޸Ŀ�Ŀ��Ϣ
	 */
	private void modifyCourse(){
		ArrayList<Integer> list = selectedCourseId();
		if(list != null){
			//û��ѡ��Ҫ�޸ĵĿ�Ŀ
			if(list.size() == 0){
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵĿ�Ŀ");
			}
			else if(list.size() > 1){
				JOptionPane.showMessageDialog(null, "���ν����޸�һ�ſ�Ŀ����Ϣ");
			}
			else{
				Course c = courseDao.findCourseById(list.get(0));
				ModifyCourse frm = new ModifyCourse(EditCourseFrame.this,c);
				frm.setVisible(true);
			}
		}
	}
	
	/**
	 * ����ɾ����Ŀ
	 */
	private void deleteCourse(){
		ArrayList<Integer> deleCourseId = selectedCourseId();
		if(deleCourseId != null){
			//�ж��Ƿ���ѡ�е���
			if(deleCourseId.size() == 0){
				JOptionPane.showConfirmDialog(null, "��ѡ��ɾ���Ŀ�Ŀ��","�޸Ŀ�Ŀ",JOptionPane.YES_NO_OPTION);
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ���"+deleCourseId.size()+"�ſ�Ŀ��","ɾ����Ŀ",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//ѭ��
					for(int i = 0; i < deleCourseId.size(); i++){
						//ɾ������
						courseDao.deleteCourse(deleCourseId.get(i));
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
			if((Boolean)tabCourse.getValueAt(i, 2)){
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
		ArrayList<Course> list = courseDao.findAllCourse();
		if(list != null){
			Object[][] objCourse = new Object[list.size()][];
			//ѭ����ȡÿ����Ŀ����Ϣ
			for(int i = 0; i< list.size(); i++){
				//��ȡÿ����Ŀ����
				Course c = list.get(i);
				objCourse[i] = new Object[]{c.getCourseId()+"",c.getCourseName(),false};
			}
			//���°󶨱������
			tabModel.setDataVector(objCourse, columnName);
		}
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//������
		columnName = new String[]{"��Ŀ���","��Ŀ����","ѡ��"};
		//���ģ��
		tabModel = new DefaultTableModel(columnName,0);
		//ʵ�������
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
		//����в�������
		tabCourse.getTableHeader().setReorderingAllowed(false);
		//������ݾ���
		((DefaultTableCellRenderer)tabCourse.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//��ѡģʽ
		tabCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//������
		sclPane = new JScrollPane(tabCourse);
		btnLoad = new JButton("���ؿ�Ŀ");
		btnAdd = new JButton("���");
		btnModify = new JButton("�޸�");
		btnDelete = new JButton("����ɾ��");
		//���λ��
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
