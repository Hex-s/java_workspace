package com.niit;

import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeExam extends JFrame{

	private JTree tree;
	private JScrollPane scrollPnl;
	//根节点
	private DefaultMutableTreeNode root;
	//子节点内容数组
	private String[] array;
	//模型
	private DefaultTreeModel model;
	
	public TreeExam(){
		this.setBounds(200, 200, 300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//创建滚动面板
		scrollPnl = new JScrollPane();
		//构建树结构
		//使用数组构建
//		Object[] array = new Object[]{"节点A","节点B","节点C"};
//		tree = new JTree(array);
		
		//使用根节点进行构建
		//创建根节点
		root = new DefaultMutableTreeNode("根节点");
		tree = new JTree(root);
		array = new String[]{"节点A","节点B","节点C"};
		//为根节点添加子节点
		for(String str : array){
			//创建节点
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(str);
			//添加至根节点中
			root.add(node);
			for(int i = 1; i <= 4; i++){
				//创建节点
				DefaultMutableTreeNode childNode = new DefaultMutableTreeNode("子节点"+i);
				//将子节点添加至节点中
				node.add(childNode);
			}
		}
		root.add(new DefaultMutableTreeNode("根节点D"));
		
		//使用模型构建
		//创建根节点
//		root = new DefaultMutableTreeNode("根节点");
//		//创建模型
//		model = new DefaultTreeModel(root);
//		tree = new JTree(model);
		
		
		//模型对象可以获取根节点对象,树结构的方法都依赖于TreeNode节点对象
		//System.out.println(model.getRoot());
		//当前节点发生改变时需要调用该方法重绘树结构
		//model.reload();
		//tree.repaint();
		
		/***********节点对象的重用方法****************/
		//获取子节点的数量
		//System.out.println(root.getChildCount());
		//获取所有子节点
//		Enumeration<DefaultMutableTreeNode> childrenNode = root.children();
//		while(childrenNode.hasMoreElements()){
//			DefaultMutableTreeNode node = childrenNode.nextElement();
//			System.out.println(node);
//		}
		//根据索引位置获取某个子节点
		//System.out.println(root.getChildAt(0));
		//获取根节点中第二个子节点中第一个子节点
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(1)).getChildAt(0));
		//判断节点所在的层级
		//System.out.println(root.getLevel());
		//获取根节点中第一个子节点的层级
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(0)).getLevel());
		//判断是否是一个叶节点，叶节点即没有子节点的节点对象
		//System.out.println(root.getChildAt(0).getChildAt(0).isLeaf());
		//获取叶节点的数量
		//System.out.println(root.getLeafCount());
		//获取下一级的子节点对象
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(0)).getNextNode());
		//获取该节点的父节点对象
		//System.out.println(root.getChildAt(0).getParent());
		//获取指定子节点的前一个节点对象
//		System.out.println(root.getChildBefore(root.getChildAt(1)));
		//获取指定子节点的后一个节点对象
		//System.out.println(root.getChildAfter(root.getChildAt(0)));
		//获取某个节点的分支结构中包括的所有节点对象
//		TreeNode[] nodes = ((DefaultMutableTreeNode)root.getChildAt(0).getChildAt(0)).getPath();
//		for(TreeNode node : nodes){
//			System.out.println(node);
//		}
		//判断是否是一个根节点对象
		//System.out.println(root.isRoot());
		//根据索引移除子节点
		//root.remove(0);
		//根据节点对象进行移除
		//root.remove((DefaultMutableTreeNode)root.getChildAt(0));
		
		//打印树结构的所有节点
//		System.out.println(root);
//		showTreeInfo(root);
		
		
		//将树结构添加至滚动面板
		scrollPnl.getViewport().add(tree);
		//绑定监听器
		tree.addTreeSelectionListener(new TreeSelectListener());
		tree.addTreeExpansionListener(new ExpansionListener());
		this.add(scrollPnl);
	}

	private class ExpansionListener implements TreeExpansionListener{

		@Override
		public void treeCollapsed(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("节点被折叠");
			
		}

		@Override
		public void treeExpanded(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("节点被展开");
			
		}
		
	}
	/**
	 * 树结构选项变更的监听器
	 * @author Administrator
	 *
	 */
	private class TreeSelectListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			//获取当前选择节点对应的分支节点集合对象
//			TreePath path = e.getPath();
//			//获取选中节点的分支节点数组
//			Object[] nodes = path.getPath();
//			for(int i = 0; i < nodes.length; i++){
//				//拆箱成节点对象
//				DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodes[i];
//				System.out.print(node+"---");
//			}
//			System.out.println();
			
			//获取点击的节点,即获取分支线路中的最后的节点对象
			System.out.println(e.getPath().getLastPathComponent());
		}
		
	}
	/**
	 * 显示节点内容
	 */
	public void showTreeInfo(DefaultMutableTreeNode node){
		//判断节点中是否包含了子节点
		if(node.getChildCount() > 0){
			//获取所有的子节点
			Enumeration<DefaultMutableTreeNode> nodes = node.children();
			//迭代
			while(nodes.hasMoreElements()){
				DefaultMutableTreeNode childNode = nodes.nextElement();
				//判断子节点的level
				int level = childNode.getLevel();
				for(int i = 1; i <= level; i++ ){
					System.out.print("\t");
				}
				System.out.println(childNode);
				//判断遍历出的子节点是否还包含子节点需要使用递归
				showTreeInfo(childNode);
			}
		}
	}
	public static void main(String[] args) {
		TreeExam frm = new TreeExam();
		frm.setVisible(true);
	}
}
