package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.niit.dao.impl.CourseDao;
import com.niit.dao.impl.QuestionsDao;
import com.niit.entiry.Course;
import com.niit.entiry.Question;

public class EditQuestionsFrame extends JInternalFrame{
	
	private JScrollPane sclPane;
	private JTable tabQuestions;
	private DefaultTableModel tabModel;
	private String[] columnName;
	private JButton btnAdd;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnLoad;
	
	private CourseDao couseDao;
	private QuestionsDao questionDao;
	private TeaMainFrame teaFrm;
	
	public EditQuestionsFrame(){
		couseDao = new CourseDao();
		questionDao = new QuestionsDao();
		this.setBounds(100, 100, 1000, 600);
		this.setTitle("试题管理");
		this.setLayout(null);
		this.setClosable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
		
	}

	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		ButtonListener btnListener = new ButtonListener();
		btnAdd.addActionListener(btnListener);
		btnModify.addActionListener(btnListener);
		btnDelete.addActionListener(btnListener);
		btnLoad.addActionListener(btnListener);
	}
	
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//加载
			if(btn == btnLoad){
				//加载表格数据
				loadData();
			}
			//添加
			else if(btn == btnAdd){
				AddQuestion frm = new AddQuestion(EditQuestionsFrame.this);
				frm.setVisible(true);
			}
			//修改
			else if(btn == btnModify){
				ArrayList<Integer> list = selectedCourseId();
				if(list != null){
					//没有选择要修改的科目
					if(list.size() == 0){
						JOptionPane.showMessageDialog(null, "请选择要修改的试题");
					}
					else if(list.size() > 1){
						JOptionPane.showMessageDialog(null, "单次仅能修改一门试题的信息");
					}
					else{
						int qId =Integer.parseInt(tabQuestions.getValueAt(tabQuestions.getSelectedRow(), 0).toString());
						Question q = questionDao.findQtByQtId(qId);
						ModifyQuestion frm = new ModifyQuestion(q,EditQuestionsFrame.this);
						frm.setVisible(true);
					}
				}
			}
			//删除
			else{
				deleteQuestions();
				//重新加载表格数据
				loadData();
			}
			
			
		}
		
	}
	
	/**
	 * 选择的行
	 * @return
	 */
	private ArrayList<Integer> selectedCourseId(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//遍历表格中的所有行，查找出被选中的行
		for(int i = 0; i< tabQuestions.getRowCount(); i++){
			if((Boolean)tabQuestions.getValueAt(i, 6)){
				int qtId = Integer.parseInt(tabQuestions.getValueAt(i, 0).toString());
				list.add(qtId);
			}
		}
		return list;
	}
	
	/**
	 *批量删除试题
	 */
	private void deleteQuestions(){
		ArrayList<Integer> deleQtId = selectedCourseId();
		if(deleQtId != null){
			//判断是否有选中的行
			if(deleQtId.size() == 0){
				JOptionPane.showMessageDialog(null, "请选择要删除的试题！");
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "确认删除选择的"+deleQtId.size()+"道试题！","删除试题",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//循环
					for(int i = 0; i < deleQtId.size(); i++){
						//删除数据
						questionDao.deleteQuestions(deleQtId.get(i));
					}
				}
			}
		}
		
	}

	/**
	 * 加载数据
	 */
	public void loadData() {
		//获取所有科目
		ArrayList<Question> list = questionDao.findAllQuestions();
		if(list != null){
			Object[][] objQt = new Object[list.size()][];
			//循环获取每个试题的信息
			for(int i = 0; i< list.size(); i++){
				//获取每个试题对象
				Question q = list.get(i);
				String type = "";
				if(q.getqType() == 0){
					type = "单选";
				}
				else{
					type = "多选";
				}
				//获取试题所属课程
				Course c = couseDao.findCourseById(q.getCourseId());
				//获取答案
				String a = q.getqAnswer().replace('#', ' ');
				//获取选项
				String ch = q.getqChoices().replace('#', ' ');
				objQt[i] = new Object[]{q.getQid()+"",c.getCourseName(),type,q.getqTitle(),ch,a,false};
			}
			//重新绑定表格数据
			tabModel.setDataVector(objQt, columnName);
			//隐藏第一列
			hiddenFirstColumn();
			//设置列宽
			setWidth();
		}
		
	}

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//表格标题
		columnName = new String[]{"试题编号","科目","题目类型","题干","选项","答案","选择"};
		//表格模型
		tabModel = new DefaultTableModel(columnName,0);
		//实例化表格
		tabQuestions = new JTable(tabModel){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 6){
					return false;
				}
				return true;
			}
			
			@Override
			public Class<?> getColumnClass(int column) {
				
				return tabQuestions.getValueAt(0, column).getClass();
			}
		};
		//表格列不可拖拉
		tabQuestions.getTableHeader().setReorderingAllowed(false);
		//表格内容居中
		((DefaultTableCellRenderer)tabQuestions.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//单选模式
		tabQuestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//隐藏第一列
		hiddenFirstColumn();
		//设置列宽
		setWidth();
		//添加组件
		sclPane = new JScrollPane(tabQuestions);
		//按钮
		btnAdd = new JButton("添加");
		btnModify = new JButton("修改");
		btnDelete = new JButton("批量删除");
		btnLoad = new JButton("加载试题");
		
		//设置组件位置
		sclPane.setBounds(10, 10, 800, 550);
		btnAdd.setBounds(850, 20, 100, 30);
		btnModify.setBounds(850, 70, 100, 30);
		btnDelete.setBounds(850, 120, 100, 30);
		btnLoad.setBounds(850, 170, 100, 30);
		
		this.add(sclPane);
		this.add(btnAdd);
		this.add(btnModify);
		this.add(btnDelete);
		this.add(btnLoad);
	}

	/**
	 * 设置列宽
	 */
	private void setWidth(){
		TableColumnModel columnModel = tabQuestions.getColumnModel();
		TableColumn column = columnModel.getColumn(4);
		column.setPreferredWidth(300);
	}
	/**
	 * 隐藏第一列
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabQuestions.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
}
