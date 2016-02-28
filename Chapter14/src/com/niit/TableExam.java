package com.niit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class TableExam extends JFrame{

	private JTable tabStu;
	private JScrollPane scrollPnl;
	private DefaultTableModel model;
	
	public TableExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�����������
		scrollPnl = new JScrollPane();
		
		//�������
		//��ʽһ  ָ������������
		//tabStu = new JTable(5, 4);
		
		//��ʽ�� ָ���������ݺ��б�����й���
		//�����б�������
		Object[] columnNames = new Object[]{"stuId","name","age","sex"};
		//���������ݶ�ά����
		Object[][] rowData = new Object[3][];
		//Ϊ��ά���鸳ֵ
		rowData[0] = new Object[]{"1001","tom",20,"male"};
		rowData[1] = new Object[]{"1002","tony",23,"male"};
		rowData[2] = new Object[]{"1003","marry",22,"female"};
//		tabStu = new JTable(rowData, columnNames);
		
		//��ʽ�� ͨ��ģ�͹���
		//����ģ��
		model = new DefaultTableModel(rowData, columnNames);
		//ͨ������������д������õ�Ԫ���Ƿ�ɱ༭�ķ���
		tabStu = new JTable(model){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				//return super.isCellEditable(row, column);
				//���õ�Ԫ�༭����
				return false;
			}
			
		};
		//����ģ��
		//tabStu.setModel(model);
		//ֻ�н�����������������У��б���Ż����
		scrollPnl.getViewport().add(tabStu);
		
		//���ñ�������
		tabStu.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
		//���ñ���Ƿ�������
		tabStu.setShowGrid(true);
		//���������ߵ���ɫ
		//tabStu.setGridColor(Color.red);
		//�������ֵ���ɫ
		//tabStu.setForeground(Color.blue);
		//����ѡ���е���ɫ
		tabStu.setSelectionBackground(Color.orange);
		//tabStu.setFont(new Font("����", Font.BOLD, 13));
		//�������ݶ���
		((DefaultTableCellRenderer)tabStu.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//�����б���Ķ��뷽ʽ
		((DefaultTableCellRenderer)tabStu.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		//�����и�
		tabStu.setRowHeight(30);
		//ָ�������ø߶�
		//tabStu.setRowHeight(1, 30);
		//��ȡ����е�����
		//System.out.println(tabStu.getRowCount());
		//��ȡ����
		//System.out.println(tabStu.getColumnCount());
		//��ȡ��ģ��
		TableColumnModel columnModel = tabStu.getColumnModel();
		//ͨ����ģ�ͻ�ȡָ�����ж���
		TableColumn column = columnModel.getColumn(0);
		//�����п�
		column.setPreferredWidth(200);
		//���ص�һ��
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setPreferredWidth(0);
		
		//ͨ����ģ�ͻ�ȡ���е��ж���
		Enumeration<TableColumn> cols = columnModel.getColumns();
		//�������е��ж���
		while(cols.hasMoreElements()){
			//��ȡ������ÿһ������
			TableColumn col = cols.nextElement();
			//��ȡÿһ���е��б���
			System.out.println(col.getHeaderValue());
		}
		//��ֹ��ͷ��ק
		tabStu.getTableHeader().setReorderingAllowed(false);
		
		//�����
		//model.addRow(new Object[]{1004,"lucy",22,"female"});
		//������
		//model.insertRow(1, new Object[]{1004,"lucy",22,"female"});
		//ɾ����
		//model.removeRow(0);
		//�޸�ָ����Ԫ���ֵ
		//model.setValueAt("jerry", 0, 1);
		
		//��ӱ��
		this.add(scrollPnl);
		//�󶨼�����
		tabStu.addMouseListener(new TableListener());
	}
	
	/**
	 * �����������
	 * @author Administrator
	 *
	 */
	private class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//��ȡѡ�е�������
			int rowIndex = tabStu.getSelectedRow();
			int columnIndex = tabStu.getSelectedColumn();
			//��ȡѡ�е�������
			//ͨ��ģ�ͻ�ȡѡ���е�ֵ
			//JOptionPane.showMessageDialog(null, model.getValueAt(rowIndex, 0));
			
			//˫����ʾѡ���е���Ϣ
			if(e.getClickCount() == 2){
				JOptionPane.showMessageDialog(null, model.getValueAt(rowIndex, 0));
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableExam frm = new TableExam();
		frm.setVisible(true);
	}

}
