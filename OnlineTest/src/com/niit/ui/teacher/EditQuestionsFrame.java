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
		this.setTitle("�������");
		this.setLayout(null);
		this.setClosable(true);
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
			//����
			if(btn == btnLoad){
				//���ر������
				loadData();
			}
			//���
			else if(btn == btnAdd){
				AddQuestion frm = new AddQuestion(EditQuestionsFrame.this);
				frm.setVisible(true);
			}
			//�޸�
			else if(btn == btnModify){
				ArrayList<Integer> list = selectedCourseId();
				if(list != null){
					//û��ѡ��Ҫ�޸ĵĿ�Ŀ
					if(list.size() == 0){
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�����");
					}
					else if(list.size() > 1){
						JOptionPane.showMessageDialog(null, "���ν����޸�һ���������Ϣ");
					}
					else{
						int qId =Integer.parseInt(tabQuestions.getValueAt(tabQuestions.getSelectedRow(), 0).toString());
						Question q = questionDao.findQtByQtId(qId);
						ModifyQuestion frm = new ModifyQuestion(q,EditQuestionsFrame.this);
						frm.setVisible(true);
					}
				}
			}
			//ɾ��
			else{
				deleteQuestions();
				//���¼��ر������
				loadData();
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
		for(int i = 0; i< tabQuestions.getRowCount(); i++){
			if((Boolean)tabQuestions.getValueAt(i, 6)){
				int qtId = Integer.parseInt(tabQuestions.getValueAt(i, 0).toString());
				list.add(qtId);
			}
		}
		return list;
	}
	
	/**
	 *����ɾ������
	 */
	private void deleteQuestions(){
		ArrayList<Integer> deleQtId = selectedCourseId();
		if(deleQtId != null){
			//�ж��Ƿ���ѡ�е���
			if(deleQtId.size() == 0){
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�������⣡");
			}
			else{
				int choice = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��ѡ���"+deleQtId.size()+"�����⣡","ɾ������",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION){
					//ѭ��
					for(int i = 0; i < deleQtId.size(); i++){
						//ɾ������
						questionDao.deleteQuestions(deleQtId.get(i));
					}
				}
			}
		}
		
	}

	/**
	 * ��������
	 */
	public void loadData() {
		//��ȡ���п�Ŀ
		ArrayList<Question> list = questionDao.findAllQuestions();
		if(list != null){
			Object[][] objQt = new Object[list.size()][];
			//ѭ����ȡÿ���������Ϣ
			for(int i = 0; i< list.size(); i++){
				//��ȡÿ���������
				Question q = list.get(i);
				String type = "";
				if(q.getqType() == 0){
					type = "��ѡ";
				}
				else{
					type = "��ѡ";
				}
				//��ȡ���������γ�
				Course c = couseDao.findCourseById(q.getCourseId());
				//��ȡ��
				String a = q.getqAnswer().replace('#', ' ');
				//��ȡѡ��
				String ch = q.getqChoices().replace('#', ' ');
				objQt[i] = new Object[]{q.getQid()+"",c.getCourseName(),type,q.getqTitle(),ch,a,false};
			}
			//���°󶨱������
			tabModel.setDataVector(objQt, columnName);
			//���ص�һ��
			hiddenFirstColumn();
			//�����п�
			setWidth();
		}
		
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//������
		columnName = new String[]{"������","��Ŀ","��Ŀ����","���","ѡ��","��","ѡ��"};
		//���ģ��
		tabModel = new DefaultTableModel(columnName,0);
		//ʵ�������
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
		//����в�������
		tabQuestions.getTableHeader().setReorderingAllowed(false);
		//������ݾ���
		((DefaultTableCellRenderer)tabQuestions.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//��ѡģʽ
		tabQuestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		hiddenFirstColumn();
		//�����п�
		setWidth();
		//������
		sclPane = new JScrollPane(tabQuestions);
		//��ť
		btnAdd = new JButton("���");
		btnModify = new JButton("�޸�");
		btnDelete = new JButton("����ɾ��");
		btnLoad = new JButton("��������");
		
		//�������λ��
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
	 * �����п�
	 */
	private void setWidth(){
		TableColumnModel columnModel = tabQuestions.getColumnModel();
		TableColumn column = columnModel.getColumn(4);
		column.setPreferredWidth(300);
	}
	/**
	 * ���ص�һ��
	 */
	private void hiddenFirstColumn(){
		TableColumn firstColumn = tabQuestions.getColumnModel().getColumn(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setMinWidth(0);
		firstColumn.setPreferredWidth(0);
	}
}
