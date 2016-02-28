package com.niit.resourcemanager;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ResourceManager extends JFrame{
	
	private JSplitPane split;
	private JScrollPane sclTree;
	private JScrollPane sclFile;
	private JTree fileTree;
	private DefaultMutableTreeNode root;
	private DefaultTableModel fileModel;
	private JTable fileTab;
	private String[] columnName;
	private DefaultMutableTreeNode selectedNode;

	
	public ResourceManager(){
		//��ʼ������
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʼ�����
		initComponent();
		//��ʼ�����ṹ
		initTree();
		
	}
	
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		sclTree = new JScrollPane();
		sclFile = new JScrollPane();
		root = new DefaultMutableTreeNode("�ҵĵ���");
		fileTree = new JTree(root);
		//����tree����Ⱦ��
		fileTree.setCellRenderer(new MyRenderer());
		//�������뵽���������
		sclTree.getViewport().add(fileTree);
		
		//ʵ�������ģ��
		//������
		columnName = new String[]{"·��","�ļ���"};
		fileModel = new DefaultTableModel(columnName,0);
		fileTab = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		fileTab.setModel(fileModel);
		//ʹ�в����ƶ�
		fileTab.getTableHeader().setReorderingAllowed(false);
		//���ñ���ѡ��ģʽ
		fileTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		hidenFirstColum();
		//Ϊ�����Ӽ�����
		fileTab.addMouseListener(new doubleClickForDetailInfo());
		
		//�������뵽���������
		sclFile.getViewport().add(fileTab);
		
		//�����������뵽�ָ������
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sclTree, sclFile);
		split.setDividerLocation(200);
		split.setDividerSize(2);
		
		fileTree.addTreeSelectionListener(new TreeListener());
		this.add(split);
		
	}

	
	/**
	 * ˫����ȡ��ϸ��Ϣ
	 * @author Administrator
	 *
	 */
	private class doubleClickForDetailInfo implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//˫��
			if(e.getClickCount() == 2){
				String filePath = fileTab.getValueAt(fileTab.getSelectedRow(), 0).toString();
				File file = new File(filePath);
				FileProperty frm = new FileProperty(file, ResourceManager.this);
				frm.setVisible(true);
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
	 * �������ṹ
	 */
	private void initTree(){
		//��ȡ���е�Ӳ���̷�
		File[] disks = File.listRoots();
		//�����̷��ļ����飬���̷����뵽��Ŀ¼��
		for(File disk : disks){
			addNode(disk,root);
		}
	}
	
	/**
	 * ��ӽڵ�
	 * @param file
	 * @param parentNode
	 */
	private void addNode(File file, DefaultMutableTreeNode parentNode){
		
		if(file.isDirectory()){
			//���ýڵ�
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
			//��ȡ�ļ��е����ļ�
			File[] childFiles = file.listFiles();
			if(childFiles != null){
				for(File chifile : childFiles){
					File cfile = new File(chifile.getAbsolutePath()){
						@Override
						public String toString() {
							// TODO Auto-generated method stub
							return this.getName();
						}
					};
					addNode(cfile,node);
				}
			}
			parentNode.add(node);
		}
		
		
	}
	
	/**
	 * ���ṹ������
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//��ȡ��ǰѡ�еĽڵ����
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			if(node.getChildCount() == 0){
				selectedNode = node;
				//��������
				loadData(node);
			}
			
			
		}
		
	}
	
	/**
	 * ��������
	 * @param node
	 */
	public void loadData(DefaultMutableTreeNode node){
		//��ȡ�ڵ��е��ļ�
		File file = (File)node.getUserObject();
		File[] childFiles = file.listFiles();
		Object[][] fileObj;
		if(childFiles != null){
			fileObj = new Object[childFiles.length][];
			for(int i = 0; i < childFiles.length; i++){
				fileObj[i] = new Object[]{childFiles[i].getPath(),childFiles[i].getName()};
			}
			//���°󶨱������
			fileModel.setDataVector(fileObj, columnName);
			hidenFirstColum();
		}
		
	}
	/**
	 * ���ṹ��Ⱦ��
	 * @author Administrator
	 *
	 */
	private class MyRenderer extends DefaultTreeCellRenderer{

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean sel, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
		    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
					row, hasFocus);
		    
		    //��ȡ�ڵ����
		    DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		    //��ȡ�ڵ�Ĳ��
		    int level = node.getLevel();
		    //�жϽڵ�Ĳ��
		    if(level == 0){
		    	setIcon(new ImageIcon("image/�ҵĵ���.gif"));
		    }
		    else if(level == 1){
		    	setIcon(new ImageIcon("image/Ӳ��.gif"));
		    }
		    else{
		    	setIcon(new ImageIcon("image/�ļ���.gif"));
		    }
		    
		    return this;
		}
		
	}
	/**
	 * ���ص�һ��
	 */
	public  void hidenFirstColum(){
		//���ص�һ��
		TableColumn firstColumn = fileTab.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	
	
	
	public DefaultMutableTreeNode getSelectedNode() {
		return selectedNode;
	}
	
	
}
