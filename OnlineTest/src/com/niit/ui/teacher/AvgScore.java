package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.ClassDao;
import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Classes;
import com.niit.entiry.Score;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class AvgScore extends JInternalFrame{
	
	private JComboBox cboClass;
	private JButton btnSearch;
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private JLabel lblClass;
	
	private CourseDao courseDao;
	private ClassDao classDao;
	private ScoreDao scoreDao;
	private TestDao testDao;
	
	public AvgScore(){
		testDao = new TestDao();
		scoreDao = new ScoreDao();
		classDao = new ClassDao();
		courseDao = new CourseDao();
		this.setBounds(330, 100, 700, 550);
		this.setTitle("��ѯ�༶ƽ���ɼ�");
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
		btnSearch.addActionListener(new ButtonListener());
		
	}
	
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ�༶����
			String className = cboClass.getSelectedItem().toString();
			//��ȡ�༶���
			int classId = classDao.findClassByName(className).getClassId();
			//��������
			loadData(classId);

		}
		
	}
	
	/**
	 * ��������
	 */
	private void loadData(int classId) {
		//��ȡ�ð༶��ƽ����
		ArrayList<Score> list = scoreDao.findAvgScore(classId);
		System.out.println(list.size());
		if(list!= null){
			Object[][] objScore = new Object[list.size()][];
			//ѭ����ȡÿ�����Ե�ƽ���ɼ�
			for(int i = 0; i< list.size(); i++){
				//���Ա��
				int testId = list.get(i).getTestId();
				//ƽ���ɼ�
				int avgScore = list.get(i).gettScore();
				//���ݲ��Ա�Ų��Ҳ�����Ϣ
				Test test = testDao.findTestByTestId(testId);
				//���Կ�Ŀ
				String courseName = courseDao.findCourseById(test.getCourseId()).getCourseName();
				
				objScore[i] = new Object[]{courseName,test.getTestName(),CommonUtil.formatTImestamp(test.getStartTime()),avgScore};
			}
			//���°󶨱������
			model.setDataVector(objScore, columnName);
		}
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		lblClass = new JLabel("�༶���ƣ�");
		//��ȡ���еİ༶
		ArrayList<Classes> classList = classDao.findAllClasses();
		cboClass = new JComboBox();
		//�༶�����б����ѡ��
		for(Classes c : classList){
			cboClass.addItem(c.getClassName());
		}
		//���
		columnName = new String[]{"���Կ�Ŀ","��������","����ʱ��","�ɼ�"};
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
		
		//������ť
		btnSearch = new JButton("����");
		lblClass.setBounds(10, 20, 80, 20);
		cboClass.setBounds(100, 20, 80, 20);
		btnSearch.setBounds(200, 20, 60, 20);
		scl.setBounds(10, 70, 670, 350);
		//������
		this.add(cboClass);
		this.add(btnSearch);
		this.add(scl);
		this.add(lblClass);
	}


}
