package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Classes;
import com.niit.entiry.Course;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;


public class StudentScore extends JInternalFrame{
	
	private ButtonGroup group;
	private JRadioButton[] rdoSearch;
	private String[] search;
	private JTextField txtSearch;
	private JButton btnSearch;
	private StudentDao stuDao;
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private ClassDao classDao;
	private TestDao testDao;
	private ScoreDao scoreDao;
	private CourseDao courseDao;
	
	public StudentScore(){
		courseDao = new CourseDao();
		scoreDao = new ScoreDao();
		testDao = new TestDao();
		classDao = new ClassDao();
		stuDao = new StudentDao();
		this.setBounds(320, 100, 700, 500);
		this.setTitle("��ѯѧ���ɼ�");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setClosable(true);
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
		btnSearch.addActionListener(btnListener);
		
	}
	
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Student stu = null;
			int index = -1;
			String values = txtSearch.getText().trim();
			//�ж������ı�׼
			for(int i = 0 ; i < rdoSearch.length; i++){
				if(rdoSearch[i].isSelected()){
					index = i;
					break;
				}
			}
			//û��ѡ��������׼
			if(index < 0){
				JOptionPane.showMessageDialog(null, "��ѡ��������Ҫ��!");
				return;
			}
			//�ж��Ƿ�д����������
			if(values.equals("")){
				JOptionPane.showMessageDialog(null, "��ѡ������������!");
				return;
			}
			//����������
			if(index == 0){
				stu = stuDao.findStuByStuName(values);
			}
			else if(index == 1){
				//�ж�������Ƿ���int
				if(isInt(values)){
					//��ȡѧ�����
					int stuId = Integer.parseInt(values);
					stu = stuDao.findStuByStuid(stuId);
				}
				else{
					JOptionPane.showMessageDialog(null, "����������");
					txtSearch.requestFocus();
					txtSearch.selectAll();
					return;
				}
			}
			//����������ѯ��ѧ����Ϣ
			if(stu == null){
				JOptionPane.showMessageDialog(null, "û����Ҫ���ҵ�ѧ���ɼ���Ϣ��");
				return;
			}
			//���ر������
			loadData(stu);
			
		}
		
	}
	
	/**
	 * �ж�һ���ַ����Ƿ�������
	 * @return
	 */
	private boolean isInt(String str){
		//�Ƿ����ַ���С����
		for(int i = 0; i < str.length(); i++ ){
			char c = str.charAt(i);
			if(c > '9' || c < '0'){
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * ��������
	 */
	private void loadData(Student stu) {
		//��ȡ��ѧ�������гɼ�
		ArrayList<Score> list = scoreDao.findScoreByStuId(stu.getStuId()) ;
		if(list != null){
			Object[][] objScore = new Object[list.size()][];
			//ѭ����ȡÿ����Ŀ����Ϣ
			for(int i = 0; i< list.size(); i++){
				//��ȡÿ����Ŀ����
				Score s = list.get(i);
				Test t = testDao.findTestByTestId(s.getTestId());
				Course c = courseDao.findCourseById(t.getCourseId());
				String className = classDao.findClassById(stu.getClassId()).getClassName();
				objScore[i] = new Object[]{stu.getStuName(),c.getCourseName(),t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),s.gettScore(),className};
			}
			//���°󶨱������
			model.setDataVector(objScore, columnName);
		}
	}
	

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//��ѡ��ť
		group = new ButtonGroup();
		search = new String[]{"����������","��ѧ�Ų���"};
		rdoSearch = new JRadioButton[search.length];
		for(int i = 0,x = 200; i < rdoSearch.length; i++,x += 110){
			rdoSearch[i] = new JRadioButton(search[i]);
			rdoSearch[i].setBounds(x, 20, 100, 20);
			group.add(rdoSearch[i]);
			this.add(rdoSearch[i]);
		}
		//����
		txtSearch = new JTextField();
		btnSearch = new JButton("����");
		//���
		columnName = new String[]{"����","���Կ�Ŀ","��������","����ʱ��","�ɼ�","�༶"};
		model = new DefaultTableModel(columnName,0);
		tab = new JTable(model){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		//����в�������
		tab.getTableHeader().setReorderingAllowed(false);
		//������ݾ���
		((DefaultTableCellRenderer)tab.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//��ѡģʽ
		tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//������
		scl = new JScrollPane(tab);
	
		//���λ��
		txtSearch.setBounds(200, 60, 100, 20);
		btnSearch.setBounds(330, 60, 60, 20);
		
		scl.setBounds(10, 100, 670, 320);
		this.add(txtSearch);
		this.add(btnSearch);
		this.add(scl);
	}
	
	public static void main(String[] args) {
		StudentScore frm = new StudentScore();
		frm.setVisible(true);
	}
}
