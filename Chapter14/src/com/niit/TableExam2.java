package com.niit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.bean.Student;
import com.niit.dao.StudentDao;
import com.niit.data.Data;

public class TableExam2 extends JFrame {

	private JScrollPane scrollPnl;
	private JTable tabStuInfo;
	private DefaultTableModel model;
	private JButton btnDelete;
	private StudentDao stuDao;
	private JButton btnShow;
	private String[] columnName;
	//�Ҽ��˵�
	private JPopupMenu popMenu;
	private JMenuItem itemNew;
	private JMenuItem itemDel;
	private JMenu menuModify;
	private JMenuItem itemMale;
	private JMenuItem itemFemale;
	private Data data;
	
	public TableExam2(Data data){
		this.data = data;
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//����dao
		stuDao = new StudentDao(data);
		initComponent();
		bindListener();
		//��������
		loadData();
	}
	private void initComponent(){
		//�����������
		scrollPnl = new JScrollPane();
		scrollPnl.setBounds(50, 20, 300, 250);
		//�������
		tabStuInfo = new JTable(){
			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				//System.out.println(tabStuInfo.getValueAt(0, 4));
				return tabStuInfo.getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				//ǰ���н�ֹ�༭
				if(column < 4){
					return false;
				}
				//����пɱ༭
				else{
					return true;
				}
			}
			
		};
		//�����б�������
		columnName = new String[]{"���","����","����","�Ա�","ɾ��"};
		//����ģ��
		model = new DefaultTableModel(columnName,0);
		//Ϊ�������ģ��
		tabStuInfo.setModel(model);
		//��ֹ�б�����ק
		tabStuInfo.getTableHeader().setReorderingAllowed(false);
		//�������ڵ�����
		((DefaultTableCellRenderer)tabStuInfo.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//���ص�һ��
		hidenFirstColum();
		//���ñ���ѡ��ģʽ
		tabStuInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//������ť
		btnDelete = new JButton("ɾ��");
		btnDelete.setBounds(50, 310, 80, 25);
		btnShow = new JButton("����");
		btnShow.setBounds(150, 310, 80, 25);
		//��ӱ�����������
		scrollPnl.getViewport().add(tabStuInfo);
		
		/*************************�Ҽ��˵���ʹ��****************************/
		//ʵ�����Ҽ��˵�
		popMenu = new JPopupMenu();
		//ʵ�����˵���
		itemDel = new JMenuItem("ɾ��");
		itemNew = new JMenuItem("����");
		itemMale = new JMenuItem("��");
		itemFemale = new JMenuItem("Ů");
		menuModify = new JMenu("�޸�");
		//��Ӳ˵���
		popMenu.add(itemNew);
		popMenu.add(itemDel);
		popMenu.add(menuModify);
		menuModify.add(itemMale);
		menuModify.add(itemFemale);
		
		//���Ҽ�����ָ���������
		tabStuInfo.setComponentPopupMenu(popMenu);
		
		this.add(scrollPnl);
		this.add(btnDelete);
		this.add(btnShow);
	}
	/**
	 * ���ر�����ݵķ���
	 */
	public void loadData(){
		//��ȡ���е�ѧ����Ϣ
		ArrayList<Student> list = stuDao.findAll();
		//��ѧ����Ϣ����ת���ɶ�ά����
		Object[][] stuArray = new Object[list.size()][];
		//��������
		for(int i = 0; i < list.size(); i++){
			Student stu = list.get(i);
			//��ÿ��ѧ������Ϣ����д���ά����
			stuArray[i] = new Object[]{stu.getStuId(),stu.getStuName(),stu.getAge()+"",stu.getSex(),false};
		}
		//ͨ��ģ�Ͷ�����������Դ
		model.setDataVector(stuArray, columnName);
		hidenFirstColum();
	}
	/**
	 * �Ҽ��˵���ť�ļ�����
	 * @author Administrator
	 *
	 */
	private class MenuClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//�жϵ���İ�ť
			if(item == itemDel){
				delete();
			}
			else if(item == itemNew){
				//ʵ��������
				AddStudentFrame frm = new AddStudentFrame(data, TableExam2.this);
				frm.setVisible(true);
			}
			else if(item == itemMale){
				modify("��");
			}
			else if(item == itemFemale){
				modify("Ů");
			}
		}
		
	}
	private class PopMenuListener implements PopupMenuListener{

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * �����˵�����ǰ���¼�
		 */
		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			//�ж��Ƿ���ѡ����
			if(tabStuInfo.getSelectedRow() != -1){
				//�жϵ�ǰѡ���е��Ա�
				String sex = tabStuInfo.getValueAt(tabStuInfo.getSelectedRow(), 3).toString();
				if(sex.equals("��")){
					itemMale.setVisible(false);
					itemFemale.setVisible(true);
				}
				else{
					itemFemale.setVisible(false);
					itemMale.setVisible(true);
				}
			}
			
			
		}
		
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
			//��ʾ��ť
			if(btn == btnShow){
				loadData();
			}
			//ɾ����ť
			else{
//				//�ж��Ƿ�ѡ����
//				if(tabStuInfo.getSelectedRow() != -1){
//					//��ȡѡ����ı��
//					int stuId = (Integer)model.getValueAt(tabStuInfo.getSelectedRow(), 0);
//					//JOptionPane.showMessageDialog(null, stuId);
//					//ɾ��data�е�����
//					stuDao.delete(stuId);
//					//�޸ı����ͼ�еĳ���
//					model.removeRow(tabStuInfo.getSelectedRow());
//					//loadData();
//				}
//				else{
//					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
//				}
				
				delete();
			}
		}
		
	}
	/**
	 * �޸��Ա�
	 * @param sex
	 */
	private void modify(String sex){
		//�ж��Ƿ���ѡ����
		int rowIndex = tabStuInfo.getSelectedRow();
		if(rowIndex != -1){
			//��ȡѡ���е�ѧ��
			int stuId = (Integer)tabStuInfo.getValueAt(rowIndex, 0);
			//����ѧ�Ų�ѯѧ������
			Student stu = stuDao.findById(stuId);
			if(stu != null){
				//�޸Ķ�����Ա�
				stu.setSex(sex);
				//�������޸�Ϊ���ݿ�
				stuDao.modify(stu);
				//ˢ������
				loadData();
			}
		}
		
	}
	/**
	 * ɾ��ѡ������
	 */
	private void delete(){
		String stuIds = "";
		//����ѡ����ѡ�е���ͳһɾ��
		//��������е�������
		for(int i = 0; i < tabStuInfo.getRowCount(); i++){
			//�ж�ÿһ���е�ɾ�����Ƿ�ѡ
			if((Boolean)tabStuInfo.getValueAt(i, 4)){
				//ƴ�����й�ѡ�е�ѧ��
				stuIds+=tabStuInfo.getValueAt(i, 0)+" ";
			}
		}
		//�ж��Ƿ����б�ѡ��
		if(stuIds != ""){	
			//ȥ���ո�
			stuIds = stuIds.trim();	
			int choice = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ��ѧ��Ϊ"+stuIds+"����Ϣɾ����");
			//�ж�ѡ����
			if(choice == JOptionPane.YES_OPTION){
				//������ѧ���ַ����ָ������
				String[] stuIdArray = stuIds.split(" ");
				//ѭ��ɾ��
				for(String stuId : stuIdArray){
					int id = Integer.parseInt(stuId);
					stuDao.delete(id);
				}
			}
			//���¼�������
			loadData();
		}
		else{
			JOptionPane.showMessageDialog(null, "û��Ҫɾ�����У�");
		}
	}
	/**
	 * ���ص�һ��
	 */
	private void hidenFirstColum(){
		//���ص�һ��
		TableColumn firstColumn = tabStuInfo.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	/**
	 * �󶨼�����
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnDelete.addActionListener(btnListener);
		btnShow.addActionListener(btnListener);
		
		MenuClickListener popListener = new MenuClickListener();
		itemDel.addActionListener(popListener);
		itemNew.addActionListener(popListener);
		itemMale.addActionListener(popListener);
		itemFemale.addActionListener(popListener);
		popMenu.addPopupMenuListener(new PopMenuListener());
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data data = new Data();
		TableExam2 frm = new TableExam2(data);
		frm.setVisible(true);
	}

}
