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
	//���ڵ�
	private DefaultMutableTreeNode root;
	//�ӽڵ���������
	private String[] array;
	//ģ��
	private DefaultTreeModel model;
	
	public TreeExam(){
		this.setBounds(200, 200, 300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//�����������
		scrollPnl = new JScrollPane();
		//�������ṹ
		//ʹ�����鹹��
//		Object[] array = new Object[]{"�ڵ�A","�ڵ�B","�ڵ�C"};
//		tree = new JTree(array);
		
		//ʹ�ø��ڵ���й���
		//�������ڵ�
		root = new DefaultMutableTreeNode("���ڵ�");
		tree = new JTree(root);
		array = new String[]{"�ڵ�A","�ڵ�B","�ڵ�C"};
		//Ϊ���ڵ�����ӽڵ�
		for(String str : array){
			//�����ڵ�
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(str);
			//��������ڵ���
			root.add(node);
			for(int i = 1; i <= 4; i++){
				//�����ڵ�
				DefaultMutableTreeNode childNode = new DefaultMutableTreeNode("�ӽڵ�"+i);
				//���ӽڵ�������ڵ���
				node.add(childNode);
			}
		}
		root.add(new DefaultMutableTreeNode("���ڵ�D"));
		
		//ʹ��ģ�͹���
		//�������ڵ�
//		root = new DefaultMutableTreeNode("���ڵ�");
//		//����ģ��
//		model = new DefaultTreeModel(root);
//		tree = new JTree(model);
		
		
		//ģ�Ͷ�����Ի�ȡ���ڵ����,���ṹ�ķ�����������TreeNode�ڵ����
		//System.out.println(model.getRoot());
		//��ǰ�ڵ㷢���ı�ʱ��Ҫ���ø÷����ػ����ṹ
		//model.reload();
		//tree.repaint();
		
		/***********�ڵ��������÷���****************/
		//��ȡ�ӽڵ������
		//System.out.println(root.getChildCount());
		//��ȡ�����ӽڵ�
//		Enumeration<DefaultMutableTreeNode> childrenNode = root.children();
//		while(childrenNode.hasMoreElements()){
//			DefaultMutableTreeNode node = childrenNode.nextElement();
//			System.out.println(node);
//		}
		//��������λ�û�ȡĳ���ӽڵ�
		//System.out.println(root.getChildAt(0));
		//��ȡ���ڵ��еڶ����ӽڵ��е�һ���ӽڵ�
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(1)).getChildAt(0));
		//�жϽڵ����ڵĲ㼶
		//System.out.println(root.getLevel());
		//��ȡ���ڵ��е�һ���ӽڵ�Ĳ㼶
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(0)).getLevel());
		//�ж��Ƿ���һ��Ҷ�ڵ㣬Ҷ�ڵ㼴û���ӽڵ�Ľڵ����
		//System.out.println(root.getChildAt(0).getChildAt(0).isLeaf());
		//��ȡҶ�ڵ������
		//System.out.println(root.getLeafCount());
		//��ȡ��һ�����ӽڵ����
		//System.out.println(((DefaultMutableTreeNode)root.getChildAt(0)).getNextNode());
		//��ȡ�ýڵ�ĸ��ڵ����
		//System.out.println(root.getChildAt(0).getParent());
		//��ȡָ���ӽڵ��ǰһ���ڵ����
//		System.out.println(root.getChildBefore(root.getChildAt(1)));
		//��ȡָ���ӽڵ�ĺ�һ���ڵ����
		//System.out.println(root.getChildAfter(root.getChildAt(0)));
		//��ȡĳ���ڵ�ķ�֧�ṹ�а��������нڵ����
//		TreeNode[] nodes = ((DefaultMutableTreeNode)root.getChildAt(0).getChildAt(0)).getPath();
//		for(TreeNode node : nodes){
//			System.out.println(node);
//		}
		//�ж��Ƿ���һ�����ڵ����
		//System.out.println(root.isRoot());
		//���������Ƴ��ӽڵ�
		//root.remove(0);
		//���ݽڵ��������Ƴ�
		//root.remove((DefaultMutableTreeNode)root.getChildAt(0));
		
		//��ӡ���ṹ�����нڵ�
//		System.out.println(root);
//		showTreeInfo(root);
		
		
		//�����ṹ������������
		scrollPnl.getViewport().add(tree);
		//�󶨼�����
		tree.addTreeSelectionListener(new TreeSelectListener());
		tree.addTreeExpansionListener(new ExpansionListener());
		this.add(scrollPnl);
	}

	private class ExpansionListener implements TreeExpansionListener{

		@Override
		public void treeCollapsed(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("�ڵ㱻�۵�");
			
		}

		@Override
		public void treeExpanded(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("�ڵ㱻չ��");
			
		}
		
	}
	/**
	 * ���ṹѡ�����ļ�����
	 * @author Administrator
	 *
	 */
	private class TreeSelectListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			//��ȡ��ǰѡ��ڵ��Ӧ�ķ�֧�ڵ㼯�϶���
//			TreePath path = e.getPath();
//			//��ȡѡ�нڵ�ķ�֧�ڵ�����
//			Object[] nodes = path.getPath();
//			for(int i = 0; i < nodes.length; i++){
//				//����ɽڵ����
//				DefaultMutableTreeNode node = (DefaultMutableTreeNode)nodes[i];
//				System.out.print(node+"---");
//			}
//			System.out.println();
			
			//��ȡ����Ľڵ�,����ȡ��֧��·�е����Ľڵ����
			System.out.println(e.getPath().getLastPathComponent());
		}
		
	}
	/**
	 * ��ʾ�ڵ�����
	 */
	public void showTreeInfo(DefaultMutableTreeNode node){
		//�жϽڵ����Ƿ�������ӽڵ�
		if(node.getChildCount() > 0){
			//��ȡ���е��ӽڵ�
			Enumeration<DefaultMutableTreeNode> nodes = node.children();
			//����
			while(nodes.hasMoreElements()){
				DefaultMutableTreeNode childNode = nodes.nextElement();
				//�ж��ӽڵ��level
				int level = childNode.getLevel();
				for(int i = 1; i <= level; i++ ){
					System.out.print("\t");
				}
				System.out.println(childNode);
				//�жϱ��������ӽڵ��Ƿ񻹰����ӽڵ���Ҫʹ�õݹ�
				showTreeInfo(childNode);
			}
		}
	}
	public static void main(String[] args) {
		TreeExam frm = new TreeExam();
		frm.setVisible(true);
	}
}
