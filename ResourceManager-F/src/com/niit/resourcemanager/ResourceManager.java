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
		//初始化窗体
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//初始化组件
		initComponent();
		//初始化树结构
		initTree();
		
	}
	
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		sclTree = new JScrollPane();
		sclFile = new JScrollPane();
		root = new DefaultMutableTreeNode("我的电脑");
		fileTree = new JTree(root);
		//设置tree的渲染器
		fileTree.setCellRenderer(new MyRenderer());
		//将树加入到滚动面板中
		sclTree.getViewport().add(fileTree);
		
		//实例化表格模型
		//表格标题
		columnName = new String[]{"路径","文件名"};
		fileModel = new DefaultTableModel(columnName,0);
		fileTab = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		fileTab.setModel(fileModel);
		//使列不能移动
		fileTab.getTableHeader().setReorderingAllowed(false);
		//设置表格的选择模式
		fileTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//隐藏第一列
		hidenFirstColum();
		//为表格添加监听器
		fileTab.addMouseListener(new doubleClickForDetailInfo());
		
		//将表格加入到滚动面板中
		sclFile.getViewport().add(fileTab);
		
		//将滚动面板加入到分隔面板中
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sclTree, sclFile);
		split.setDividerLocation(200);
		split.setDividerSize(2);
		
		fileTree.addTreeSelectionListener(new TreeListener());
		this.add(split);
		
	}

	
	/**
	 * 双击获取详细信息
	 * @author Administrator
	 *
	 */
	private class doubleClickForDetailInfo implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//双击
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
	 * 构建树结构
	 */
	private void initTree(){
		//获取所有的硬盘盘符
		File[] disks = File.listRoots();
		//遍历盘符文件数组，将盘符加入到根目录中
		for(File disk : disks){
			addNode(disk,root);
		}
	}
	
	/**
	 * 添加节点
	 * @param file
	 * @param parentNode
	 */
	private void addNode(File file, DefaultMutableTreeNode parentNode){
		
		if(file.isDirectory()){
			//设置节点
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
			//获取文件夹的子文件
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
	 * 树结构监听器
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//获取当前选中的节点对象
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			if(node.getChildCount() == 0){
				selectedNode = node;
				//加载数据
				loadData(node);
			}
			
			
		}
		
	}
	
	/**
	 * 加载数据
	 * @param node
	 */
	public void loadData(DefaultMutableTreeNode node){
		//获取节点中的文件
		File file = (File)node.getUserObject();
		File[] childFiles = file.listFiles();
		Object[][] fileObj;
		if(childFiles != null){
			fileObj = new Object[childFiles.length][];
			for(int i = 0; i < childFiles.length; i++){
				fileObj[i] = new Object[]{childFiles[i].getPath(),childFiles[i].getName()};
			}
			//重新绑定表格数据
			fileModel.setDataVector(fileObj, columnName);
			hidenFirstColum();
		}
		
	}
	/**
	 * 树结构渲染器
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
		    
		    //获取节点对象
		    DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		    //获取节点的层次
		    int level = node.getLevel();
		    //判断节点的层次
		    if(level == 0){
		    	setIcon(new ImageIcon("image/我的电脑.gif"));
		    }
		    else if(level == 1){
		    	setIcon(new ImageIcon("image/硬盘.gif"));
		    }
		    else{
		    	setIcon(new ImageIcon("image/文件夹.gif"));
		    }
		    
		    return this;
		}
		
	}
	/**
	 * 隐藏第一列
	 */
	public  void hidenFirstColum(){
		//隐藏第一列
		TableColumn firstColumn = fileTab.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	
	
	
	public DefaultMutableTreeNode getSelectedNode() {
		return selectedNode;
	}
	
	
}
