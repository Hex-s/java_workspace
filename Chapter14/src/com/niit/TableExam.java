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
		
		//创建滚动面板
		scrollPnl = new JScrollPane();
		
		//创建表格
		//方式一  指定行列数构建
		//tabStu = new JTable(5, 4);
		
		//方式二 指定表格的数据和列标题进行构建
		//定义列标题数组
		Object[] columnNames = new Object[]{"stuId","name","age","sex"};
		//定义表格内容二维数组
		Object[][] rowData = new Object[3][];
		//为二维数组赋值
		rowData[0] = new Object[]{"1001","tom",20,"male"};
		rowData[1] = new Object[]{"1002","tony",23,"male"};
		rowData[2] = new Object[]{"1003","marry",22,"female"};
//		tabStu = new JTable(rowData, columnNames);
		
		//方式三 通过模型构建
		//创建模型
		model = new DefaultTableModel(rowData, columnNames);
		//通过匿名构造重写表格设置单元格是否可编辑的方法
		tabStu = new JTable(model){

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				//return super.isCellEditable(row, column);
				//禁用单元编辑功能
				return false;
			}
			
		};
		//设置模型
		//tabStu.setModel(model);
		//只有将表格添加至滚动面板中，列标题才会呈现
		scrollPnl.getViewport().add(tabStu);
		
		//设置表格的排序
		tabStu.setRowSorter(new TableRowSorter<DefaultTableModel>(model));
		//设置表格是否有网格
		tabStu.setShowGrid(true);
		//设置网格线的颜色
		//tabStu.setGridColor(Color.red);
		//设置文字的颜色
		//tabStu.setForeground(Color.blue);
		//设置选中行的颜色
		tabStu.setSelectionBackground(Color.orange);
		//tabStu.setFont(new Font("宋体", Font.BOLD, 13));
		//设置内容对齐
		((DefaultTableCellRenderer)tabStu.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//设置列标题的对齐方式
		((DefaultTableCellRenderer)tabStu.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		//设置行高
		tabStu.setRowHeight(30);
		//指定行设置高度
		//tabStu.setRowHeight(1, 30);
		//获取表格中的行数
		//System.out.println(tabStu.getRowCount());
		//获取列数
		//System.out.println(tabStu.getColumnCount());
		//获取列模型
		TableColumnModel columnModel = tabStu.getColumnModel();
		//通过列模型获取指定的列对象
		TableColumn column = columnModel.getColumn(0);
		//设置列宽
		column.setPreferredWidth(200);
		//隐藏第一列
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setPreferredWidth(0);
		
		//通过列模型获取所有的列对象
		Enumeration<TableColumn> cols = columnModel.getColumns();
		//迭代所有的列对象
		while(cols.hasMoreElements()){
			//获取迭代的每一个对象
			TableColumn col = cols.nextElement();
			//获取每一个列的列标题
			System.out.println(col.getHeaderValue());
		}
		//禁止表头拖拽
		tabStu.getTableHeader().setReorderingAllowed(false);
		
		//添加行
		//model.addRow(new Object[]{1004,"lucy",22,"female"});
		//插入行
		//model.insertRow(1, new Object[]{1004,"lucy",22,"female"});
		//删除行
		//model.removeRow(0);
		//修改指定单元格的值
		//model.setValueAt("jerry", 0, 1);
		
		//添加表格
		this.add(scrollPnl);
		//绑定监听器
		tabStu.addMouseListener(new TableListener());
	}
	
	/**
	 * 表格点击监听器
	 * @author Administrator
	 *
	 */
	private class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//获取选中的行索引
			int rowIndex = tabStu.getSelectedRow();
			int columnIndex = tabStu.getSelectedColumn();
			//获取选中的列索引
			//通过模型获取选中行的值
			//JOptionPane.showMessageDialog(null, model.getValueAt(rowIndex, 0));
			
			//双击显示选中行的信息
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
