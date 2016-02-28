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
		//实例化DAO对象
		stuDao = new StudentDao(data);
		classDao = new ClassDao(data);
		gradeDao = new GradeDao(data);
		//初始化组件
		initComponent();
		//初始化数据
		initData();
		//绑定监听器
		bindListener();
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		//实例化滚动面板
		scrollPnlTab = new JScrollPane();
		scrollPnlTree = new JScrollPane();
		//实例化分割面板
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPnlTree, scrollPnlTab);
		splPnl.setDividerSize(5);
		splPnl.setDividerLocation(200);
		splPnl.setEnabled(false);
		//实例化根节点
		root = new DefaultMutableTreeNode("学校信息");
		//构建树结构
		treeStudent = new JTree(root);
		//实例化表格模型
		columnNames = new String[]{"学号","姓名","年龄","性别","所在班级"};
		modelTab = new DefaultTableModel(columnNames, 0);
		//实例化表格
		tabStudent = new JTable(modelTab);
		//将表格和树结构添加至滚动面板
		scrollPnlTab.getViewport().add(tabStudent);
		scrollPnlTree.getViewport().add(treeStudent);
		
		this.add(splPnl);
	}
	/**
	 * 初始化界面数据
	 */
	private void initData(){
		//查找所有的年级信息
		ArrayList<Grade> grades = gradeDao.findAllGrade();
		//遍历集合
		for(Grade grade : grades){
			//创建年级节点
			DefaultMutableTreeNode gradeNode = new DefaultMutableTreeNode(grade.getGradeName());
			//根据年级编号查找班级
			ArrayList<Class> classies = classDao.findClassByGradeId(grade.getGradeId());
			//遍历班级
			for(Class clazz : classies){
				//创建班级节点  将班级对象写入
				DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(clazz);
				//将班级节点添加至年级节点中
				gradeNode.add(classNode);
			}
			//将年级节点添加至根节点中
			root.add(gradeNode);
		}
	}
	/**
	 * 树结构的选择监听器
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//获取当前选中的节点对象
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			//判断选中的节点是否是班级节点
			//if(node.isLeaf()){
			if(node.getLevel() == 2){
				//获取节点中写入的对象
				Class classObj = (Class)node.getUserObject();
				//JOptionPane.showMessageDialog(null, classObj.getClassId()+","+classObj.getClassName());
				//获取班级节点中的班级编号
				int classId = classObj.getClassId();
				//根据班级编号查找对应的学生
				ArrayList<Student> stuList = stuDao.findStudentByClassId(classId);
				//将学生集合转换成二维数组
				Object[][] tabData = new Object[stuList.size()][];
				//遍历集合
				for(int i = 0; i < stuList.size(); i++){
					Student stu = stuList.get(i);
					//根据班级编号查找班级
					Class clazz = classDao.findClassById(stu.getClassId());
					//将学生信息和查找到的班级名称封装至数组中
					tabData[i] = new Object[]{stu.getStuId(),stu.getStuName(),stu.getAge(),stu.getSex(),clazz.getClassName()};
				}
				//重新绑定表格的数据
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
