package com.niit.ui.stu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.ScoreDao;
import com.niit.dao.impl.TestDao;
import com.niit.entiry.Score;
import com.niit.entiry.Student;
import com.niit.entiry.Test;
import com.niit.util.CommonUtil;

/**
 * �̳����ڲ�������
 * @author Administrator
 *
 */
public class TestsFrame extends JInternalFrame {
	
	private TestDao testDao;
	private JScrollPane sclPane;
	private JTable tabTest;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private ScoreDao scoreDao;
	private CourseDao courseDao;
	private Student stu;
	
	public TestsFrame(StuMainFrame frm){

		this.stu = frm.getStu();
		scoreDao = new ScoreDao();
		testDao = new TestDao();
		courseDao = new CourseDao();
		this.setTitle("���߿���");
		this.setBounds(230, 100, 800, 700);
		this.setClosable(true);
		//��ʼ�����
		initComponent();
		//��������
		loadData();
		//�󶨼�����
		bindListener();
	}
	
	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		tabTest.addMouseListener(new TableListener());
		
	}

	/**
	 * ��������
	 * @author Administrator
	 *
	 */
	private class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//˫��
			if(e.getClickCount() == 2){
				//��ȡ���Ա��
				int testId = Integer.parseInt(tabTest.getValueAt(tabTest.getSelectedRow(), 0).toString());
				//���ݲ��Ա�Ų��Ҳ���
				Test test = testDao.findTestByTestId(testId);
				if(test != null){
					//��ȡ���Կ�ʼʱ��
					java.sql.Timestamp ts = test.getStartTime();
					//��ȡ��ǰϵͳʱ��
					Date date = new Date();
					//�жϵ�ǰʱ���Ƿ���ڵ���ָ������ʱ��
					//��ǰʱ��С�ڿ���ʱ��
					if(ts.after(date)){
						JOptionPane.showMessageDialog(null, "���Ի�δ��ʼ��");
						return;
					}
					//��ǰʱ����ڿ���ʱ��
					if(ts.after(date)){
						JOptionPane.showMessageDialog(null, "�����Ѿ�������");
						return;
					}
					//�ٵ���Сʱ
					if((ts.getTime()+30*60000) < (date.getTime())){
						int stuId = stu.getStuId();
						JOptionPane.showMessageDialog(null, "����Կ�ʼ�ѳ���30���ӣ��˴β��Է���Ϊ0��");
						//��ȡ�ɼ�����
						Score s = new Score();
						s.setStuId(stuId);
						s.setTestId(testId);
						s.settScore(0);
						//�ж��Ƿ��Ѿ�����óɼ�
						Score sc = scoreDao.findScoreByTidSid(testId, stuId);
						if(sc == null){
							//����˴γɼ�
							scoreDao.addScore(s);
						}
						return;
					}
					//�������ʱ�䷶Χ�ڲμӿ���
					QuestionsTest frm = new QuestionsTest(test,TestsFrame.this);
					frm.setVisible(true);
				}
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * ���ر������
	 */
	public void loadData(){
		//��ȡ��ѧ�����Բμӵ����п���
		ArrayList<Test> list = testDao.findTestByStu(stu.getClassId(),stu.getStuId());
		if(list != null){
			Object[][] objTests = new Object[list.size()][];
			//ѭ����ȡÿ�ݿ������Ϣ
			for(int i = 0; i < list.size(); i++){
				//��ȡ�����µ�ÿ��Ա������
				Test t = list.get(i);
				String courseName = courseDao.findCourseById(t.getCourseId()).getCourseName();
				objTests[i] = new Object[]{t.getTestId(),courseName,CommonUtil.formatTImestamp(t.getStartTime()),t.getTotalTime()+""};
			}
			//���°󶨱������
			tabModel.setDataVector(objTests, columnName);
			//���ص�һ��
			hiddenFirstColumn();
		}
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		//������
		columnName = new String[]{"���Ա��","���Կ�Ŀ","��ʼʱ��","����ʱ��"};
		//���ģ��
		tabModel = new DefaultTableModel(columnName,0);
		//ʵ�������
		tabTest = new JTable(tabModel){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//����в�������
		tabTest.getTableHeader().setReorderingAllowed(false);
		//������ݾ���
		((DefaultTableCellRenderer)tabTest.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//��ѡģʽ
		tabTest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		hiddenFirstColumn();
		
		sclPane = new JScrollPane(tabTest);
		this.add(sclPane);
	}

	@Override
	public void doDefaultCloseAction() {
		// TODO Auto-generated method stub
		//super.doDefaultCloseAction();
		this.dispose();
	}
	
	/**
	 * ���ص�һ��
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabTest.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	public Student getStu() {
		return stu;
	}

}
