package com.niit.ui.stu;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Course;
import com.niit.entiry.Score;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

public class ScoreFrame extends JInternalFrame{
	
	private JScrollPane scl;
	private JTable tab;
	private DefaultTableModel model;
	private String[] columnName;
	private ScoreDao scoreDao;
	private TestDao testDao;
	private CourseDao courseDao;
	private StuMainFrame stuFrm;
	
	public ScoreFrame(StuMainFrame stuFrm){
		courseDao = new CourseDao();
		testDao = new TestDao();
		scoreDao = new ScoreDao();
		this.stuFrm = stuFrm;
		this.setBounds(320, 100, 700, 550);
		this.setTitle("��ѯѧ���ɼ�");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setClosable(true);
		//��ʼ�����
		initComponent();
		//��������
		loadData(stuFrm.getStu().getStuId());
	}
	

	/**
	 * ��������
	 */
	private void loadData(int stuId) {
		//��ȡ��ѧ�������гɼ�
		ArrayList<Score> list = scoreDao.findScoreByStuId(stuId) ;
		if(list != null){
			Object[][] objScore = new Object[list.size()][];
			//ѭ����ȡÿ����Ŀ����Ϣ
			for(int i = 0; i< list.size(); i++){
				//��ȡÿ����Ŀ����
				Score s = list.get(i);
				Test t = testDao.findTestByTestId(s.getTestId());
				Course c = courseDao.findCourseById(t.getCourseId());
				objScore[i] = new Object[]{c.getCourseName(),t.getTestName(),CommonUtil.formatTImestamp(t.getStartTime()),s.gettScore()};
			}
			//���°󶨱������
			model.setDataVector(objScore, columnName);
		}
	}
	

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
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
		this.add(scl);
		
	}

}
