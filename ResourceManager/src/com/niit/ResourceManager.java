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
		
		rootNode = new DefaultMutableTreeNode("�ҵĵ���");
		rootNode.add(new DefaultMutableTreeNode("D:/"));
		rootNode.add(new DefaultMutableTreeNode("E:/"));
		((DefaultMutableTreeNode)rootNode.getFirstChild()).add(new DefaultMutableTreeNode("�ҵ��ĵ�"));
		//����tree
		treeResource = new JTree(rootNode);
		//�����������
		scrollPnlTree = new JScrollPane(treeResource);
		//����tree����Ⱦ��
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
		    //���ýڵ��ͳһͼ��
		    //setIcon(new ImageIcon("image/�ļ���.gif"));
		    //���ýڵ�չ�����ͼ��
		    //setOpenIcon(new ImageIcon("image/�ļ�������.gif"));
		    //���ýڵ�պϺ��ͼ��
		    //setClosedIcon(new ImageIcon("image/�ļ���.gif"));
		    
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
	public static void main(String[] args) {
		ResourceManager manager = new ResourceManager();
		manager.setVisible(true);
	}
}
