package com.niit;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class ResourceManager extends JFrame {
	
	private JTree treeResource;
	private JScrollPane scrollPnlTree;
	private DefaultMutableTreeNode rootNode;
	
	public ResourceManager(){
		
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rootNode = new DefaultMutableTreeNode("我的电脑");
		rootNode.add(new DefaultMutableTreeNode("D:/"));
		rootNode.add(new DefaultMutableTreeNode("E:/"));
		((DefaultMutableTreeNode)rootNode.getFirstChild()).add(new DefaultMutableTreeNode("我的文档"));
		//创建tree
		treeResource = new JTree(rootNode);
		//创建滚动面板
		scrollPnlTree = new JScrollPane(treeResource);
		//设置tree的渲染器
		treeResource.setCellRenderer(new MyRenderer());
		this.add(scrollPnlTree);
	}
	
	private class MyRenderer extends DefaultTreeCellRenderer{

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean sel, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {
			// TODO Auto-generated method stub
		    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
					row, hasFocus);
		    //设置节点的统一图标
		    //setIcon(new ImageIcon("image/文件夹.gif"));
		    //设置节点展开后的图标
		    //setOpenIcon(new ImageIcon("image/文件夹属性.gif"));
		    //设置节点闭合后的图标
		    //setClosedIcon(new ImageIcon("image/文件夹.gif"));
		    
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
	public static void main(String[] args) {
		ResourceManager manager = new ResourceManager();
		manager.setVisible(true);
	}
}
