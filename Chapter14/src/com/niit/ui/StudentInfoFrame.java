package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.niit.bean.Class;
import com.niit.bean.Grade;
import com.niit.bean.Student;
import com.niit.dao.ClassDao;
import com.niit.dao.GradeDao;
import com.niit.dao.StudentDao;
import com.niit.data.Data;

public class StudentInfoFrame extends JFrame {

	private JSplitPane splPnl;
	private JScrollPane scrollPnlTree;
	private JScrollPane scrollPnlTab;
	private JTable tabStudent;
	private DefaultTableModel modelTab;
	private JTree treeStudent;
	private DefaultMutableTreeNode root;
	private String[] columnNames;
	private Data data;
	private StudentDao stuDao;
	private ClassDao classDao;
	private GradeDao gradeDao;
	
	public StudentInfoFrame(Data data){
		this.setBounds(200, 200, 700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.data = data;
		//ʵ����DAO����
		stuDao = new StudentDao(data);
		classDao = new ClassDao(data);
		gradeDao = new GradeDao(data);
		//��ʼ�����
		initComponent();
		//��ʼ������
		initData();
		//�󶨼�����
		bindListener();
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		//ʵ�����������
		scrollPnlTab = new JScrollPane();
		scrollPnlTree = new JScrollPane();
		//ʵ�����ָ����
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPnlTree, scrollPnlTab);
		splPnl.setDividerSize(5);
		splPnl.setDividerLocation(200);
		splPnl.setEnabled(false);
		//ʵ�������ڵ�
		root = new DefaultMutableTreeNode("ѧУ��Ϣ");
		//�������ṹ
		treeStudent = new JTree(root);
		//ʵ�������ģ��
		columnNames = new String[]{"ѧ��","����","����","�Ա�","���ڰ༶"};
		modelTab = new DefaultTableModel(columnNames, 0);
		//ʵ�������
		tabStudent = new JTable(modelTab);
		//���������ṹ������������
		scrollPnlTab.getViewport().add(tabStudent);
		scrollPnlTree.getViewport().add(treeStudent);
		
		this.add(splPnl);
	}
	/**
	 * ��ʼ����������
	 */
	private void initData(){
		//�������е��꼶��Ϣ
		ArrayList<Grade> grades = gradeDao.findAllGrade();
		//��������
		for(Grade grade : grades){
			//�����꼶�ڵ�
			DefaultMutableTreeNode gradeNode = new DefaultMutableTreeNode(grade.getGradeName());
			//�����꼶��Ų��Ұ༶
			ArrayList<Class> classies = classDao.findClassByGradeId(grade.getGradeId());
			//�����༶
			for(Class clazz : classies){
				//�����༶�ڵ�  ���༶����д��
				DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(clazz);
				//���༶�ڵ�������꼶�ڵ���
				gradeNode.add(classNode);
			}
			//���꼶�ڵ���������ڵ���
			root.add(gradeNode);
		}
	}
	/**
	 * ���ṹ��ѡ�������
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//��ȡ��ǰѡ�еĽڵ����
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			//�ж�ѡ�еĽڵ��Ƿ��ǰ༶�ڵ�
			//if(node.isLeaf()){
			if(node.getLevel() == 2){
				//��ȡ�ڵ���д��Ķ���
				Class classObj = (Class)node.getUserObject();
				//JOptionPane.showMessageDialog(null, classObj.getClassId()+","+classObj.getClassName());
				//��ȡ�༶�ڵ��еİ༶���
				int classId = classObj.getClassId();
				//���ݰ༶��Ų��Ҷ�Ӧ��ѧ��
				ArrayList<Student> stuList = stuDao.findStudentByClassId(classId);
				//��ѧ������ת���ɶ�ά����
				Object[][] tabData = new Object[stuList.size()][];
				//��������
				for(int i = 0; i < stuList.size(); i++){
					Student stu = stuList.get(i);
					//���ݰ༶��Ų��Ұ༶
					Class clazz = classDao.findClassById(stu.getClassId());
					//��ѧ����Ϣ�Ͳ��ҵ��İ༶���Ʒ�װ��������
					tabData[i] = new Object[]{stu.getStuId(),stu.getStuName(),stu.getAge(),stu.getSex(),clazz.getClassName()};
				}
				//���°󶨱�������
				modelTab.setDataVector(tabData, columnNames);
			}
		}
		
	}
	private void bindListener(){
		treeStudent.addTreeSelectionListener(new TreeListener());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		StudentInfoFrame frm = new StudentInfoFrame(data);
		frm.setVisible(true);
	}

}
