package com.niit.resourcemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileProperty  extends JFrame{
	
	private JTabbedPane tabpnl;
	private JPanel pnlPro;
	private JLabel lblPic;
	private JTextField txtFileName;
	private JLabel lblFileType;
	private JLabel lblFilePath;
	private JLabel lblFileLength;
	private JLabel lblModifyTime;
	private String[] array;
	private JLabel[] lblArray;
	private JCheckBox chkReadOnly;
	private JCheckBox chkHidden;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnApply;
	private DefaultMutableTreeNode selectedNode;
	private File file;
	private ResourceManager resFrm;
	
	
	public FileProperty(File file,ResourceManager resFrm){
		this.resFrm = resFrm;
		this.selectedNode = resFrm.getSelectedNode();
		this.file = file;
		this.setSize(400,500);
		this.setLocationRelativeTo(resFrm);
		this.setTitle(file.getName()+"  "+"属性");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent();
		//设置窗体的默认回车按钮
		this.getRootPane().setDefaultButton(btnConfirm);
		
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		
		pnlPro = new JPanel();
		pnlPro.setLayout(null);
		tabpnl = new JTabbedPane();
		lblPic = new JLabel();
		txtFileName = new JTextField();
		chkHidden = new JCheckBox("隐藏");
		chkReadOnly = new JCheckBox("只读");
		btnConfirm = new JButton("确认");
		btnCancel = new JButton("取消");
		btnApply = new JButton("应用");
		
		//图标
		lblPic.setIcon(new ImageIcon("image/资源管理器.gif"));
		//文件名
		txtFileName.setText(file.getName());
		
		
		
		array = new String[]{"文件类型：","位置：","大小：","修改时间：","属性："};
		lblArray = new JLabel[array.length];
		for(int i = 0 , y = 50; i < lblArray.length; i++ , y+=50){
			lblArray[i] = new JLabel(array[i]);
			lblArray[i].setBounds(10, y, 80, 20);
			pnlPro.add(lblArray[i]);
		}
		
		String name = file.getName();
		String type = "";
		int index = name.lastIndexOf(".");
		name = name.substring(index+1);
		System.out.println(name);
		if(name.equalsIgnoreCase("txt")){
			type = "文本文档";
		}
		else if(name.equalsIgnoreCase("doc") || name.equalsIgnoreCase("docx")){
			type = "word文档";
		}
		else if(name.equalsIgnoreCase("excel")){
			type = "excel文件";
		}
		else if(name.equalsIgnoreCase("gif") || name.equalsIgnoreCase("bmp") || name.equalsIgnoreCase("jpg")){
			type = "图片文件";
		}
		else{
			type = "其他文件";
		}
		lblFileType = new JLabel(type);
		lblFilePath = new JLabel(file.getParent());
		lblFileLength = new JLabel(file.length()/1024+"KB ("+file.length()+"字节)");
		long time = file.lastModified();
		Date date = new Date(time);
		lblModifyTime = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		
		//组件位置
		lblPic.setBounds(10, 10, 80, 30);
		txtFileName.setBounds(100, 15, 250, 20);
		lblFileType.setBounds(100, 50, 250, 20);
		lblFilePath.setBounds(100, 100, 250, 20);
		lblFileLength.setBounds(100, 150, 250, 20);
		lblModifyTime.setBounds(100, 200, 250, 20);
		chkReadOnly.setBounds(100, 250, 100, 20);
		chkHidden.setBounds(220, 250, 100, 20);
		btnConfirm.setBounds(100, 300, 70 , 20);
		btnCancel.setBounds(180, 300, 70, 20);
		btnApply.setBounds(260, 300, 70, 20);
		btnApply.setEnabled(false);
		if(!file.canWrite()){
			chkReadOnly.setSelected(true);
		}
		//绑定监听器
		ButtonListener btnLintener = new ButtonListener();
		btnCancel.addActionListener(btnLintener);
		btnConfirm.addActionListener(btnLintener);
		btnApply.addActionListener(btnLintener);
		//添加组件
		tabpnl.add("常规", pnlPro);
		pnlPro.add(lblPic);
		pnlPro.add(txtFileName);
		pnlPro.add(lblFileType);
		pnlPro.add(lblFilePath);
		pnlPro.add(lblFileLength);
		pnlPro.add(lblModifyTime);
		pnlPro.add(chkReadOnly);
		pnlPro.add(chkHidden);
		pnlPro.add(btnApply);
		pnlPro.add(btnCancel);
		pnlPro.add(btnConfirm);
		this.add(tabpnl);
		
	}
	
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnConfirm){
				//重命名
				String fileName = txtFileName.getText();
				if(!fileName.equals(file.getName())){
					rename(file,fileName);
				}
				//只读
				if(chkReadOnly.isSelected()){
					file.setReadable(true);
					file.setWritable(false);
				}
				else{
					file.setReadable(true);
					file.setWritable(true);
				}
				//隐藏
				if(chkHidden.isSelected()){
					
				}
				FileProperty.this.dispose();
				//重新表格加载数据
				resFrm.loadData(selectedNode);
			}
			else if(btn == btnCancel){
				FileProperty.this.dispose();
			}
			else{
				
			}
		}
		
	}
	
	/**
	 * 重命名
	 * @param file 需要重命名的文件
	 * @param newFileName 文件的新名称
	 */
	public void rename(File file, String newFileName){
		//判断文件是否存在
		if(file.exists()){
			//如果文件存在
			//创建更名后的文件对象
			File newFile = new File(file.getParent(), newFileName);
			//判断改名后的文件是否存在
			if(!newFile.exists()){
				//如果改名后的文件不存在的
				//重命名
				file.renameTo(newFile);
			}
			else{
				JOptionPane.showMessageDialog(null, "该文件名已经存在！");
			}
		}
		
	}

}
